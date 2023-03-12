using System.Text;
using System.Data;
using System.Data.SqlClient;
using Common.Cache;
using System.Text.Json.Nodes;

namespace DataAccess
{
    public class UserDao : ConnectionToSql
    {
        public bool Login(string user, string password)
        {
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM PEEMP_EMPLE " +
                                    "INNER JOIN XEUSU_USUAR XU on PEEMP_EMPLE.PEEMP_CODIGO = XU.PEEMP_CODIGO " +
                                    "INNER JOIN XEUXP_USUPE X on XU.XEUSU_PASWD = X.XEUSU_PASWD " +
                                    "INNER JOIN XEPER_PERFI XP on X.XEPER_CODIGO = XP.XEPER_CODIGO " +
                                    "INNER JOIN XEEST_ESTAD XE on XE.XEEST_CODIGO = XU.XEEST_CODIGO " +
                                    "WHERE PEEMP_EMAIL = @user AND X.XEUSU_PASWD = @pass", connection))
                {
                    command.Parameters.AddWithValue("@user", user);
                    command.Parameters.AddWithValue("@pass", password);
                    command.CommandType = CommandType.Text;

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            UserLoginCache.Id = Convert.ToChar(reader["PEEMP_CODIGO"].ToString()?.FirstOrDefault());
                            UserLoginCache.Rol = Convert.ToChar(reader["XEPER_CODIGO"].ToString()?.FirstOrDefault());
                            UserLoginCache.DescriptionRol = reader["XEPER_DESCRI"].ToString();
                            UserLoginCache.Email = user;
                            UserLoginCache.Lastname = reader["PEEMP_APELLI"].ToString();
                            UserLoginCache.Name = reader["PEEMP_NOMBRE"].ToString();
                            UserLoginCache.Photo = reader["PEEMP_FOTO"].ToString();
                            UserLoginCache.Phone = reader["PEEMP_TELEF"].ToString();
                            UserLoginCache.IdentificationCard = reader["PEEMP_CEDULA"].ToString();
                            UserLoginCache.Password = password;
                            UserLoginCache.State = Convert.ToChar(reader["XEEST_CODIGO"].ToString()?.FirstOrDefault());

                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
        }
        public bool RegisterUser(JsonObject dataUser)
        {
            using (var connection = GetConnection())
            {
                connection.Open();
                var command = new SqlCommand("SELECT COUNT(*) FROM PEEMP_EMPLE", connection);
                var count = (int)command.ExecuteScalar();

                string id = (count + 1).ToString();
                string lastname = dataUser["lastname"].ToString();
                string name = dataUser["name"].ToString();
                DateTime birthday = (DateTime)dataUser["birthday"];
                DateTime departureDate = (DateTime)dataUser["departureDate"];
                string address = dataUser["address"].ToString();
                string phoneNumber = dataUser["phoneNumber"].ToString();
                string email = dataUser["email"].ToString();
                string identificationCard = dataUser["identificationCard"].ToString();
                string photo = dataUser["photo"].ToString();
                string passport = dataUser["passport"].ToString();
                string role = "N";
                string password = Utils.Utils.GeneratePassword();
                string passwordEncrypt = Utils.Utils.EncryptPassword(password);
                DateTime creationDate = DateTime.Now;
                DateTime modificationDate = DateTime.Now;
                string piefir = "Ninguna";
                int familyBurden = 0;
                byte[] disability = Encoding.UTF8.GetBytes("-");

                SqlTransaction sqlTransaction = connection.BeginTransaction();
                try
                {
                    SqlCommand query1 = new SqlCommand("INSERT INTO PEEMP_EMPLE " +
                        "(PEEMP_CODIGO, PEEMP_APELLI, PEEMP_NOMBRE, PEEMP_FECNAC, PEEMP_FECSAL, PEEMP_DIREC, PEEMP_TELEF, PEEMP_EMAIL, PEEMP_CEDULA, " +
                        "PEEMP_FOTO, PEEMP_CARFAM, PEEMP_PASAPO, DISCAPA) " +
                        "VALUES (@idUser, @lastname, @name, @birthday, @departureDate, @address, @phoneNumber, " +
                        "@email, @identificationCard, @photo, @familyBurden, @passport, @disability)", connection, sqlTransaction);

                    query1.Parameters.AddWithValue("@idUser", id);
                    query1.Parameters.AddWithValue("@lastname", lastname);
                    query1.Parameters.AddWithValue("@name", name);
                    query1.Parameters.AddWithValue("@birthday", birthday);
                    query1.Parameters.AddWithValue("@departureDate", departureDate);
                    query1.Parameters.AddWithValue("@address", address);
                    query1.Parameters.AddWithValue("@phoneNumber", phoneNumber);
                    query1.Parameters.AddWithValue("@email", email);
                    query1.Parameters.AddWithValue("@identificationCard", identificationCard);
                    query1.Parameters.AddWithValue("@photo", photo);
                    query1.Parameters.AddWithValue("@familyBurden", familyBurden);
                    query1.Parameters.AddWithValue("@passport", passport);
                    query1.Parameters.AddWithValue("@disability", disability);
                    query1.ExecuteNonQuery();

                    SqlCommand query2 = new SqlCommand("INSERT INTO XEUSU_USUAR " +
                       "(XEUSU_PASWD, XEEST_CODIGO, PEEMP_CODIGO, XEUSU_FECCRE, XEUSU_FECMOD, XEUSU_PIEFIR) " +
                       "VALUES (@password, @code, @peempCode, @creationDate, @modificationDate, @piefir)", connection, sqlTransaction);
                    query2.Parameters.AddWithValue("@password", passwordEncrypt);
                    query2.Parameters.AddWithValue("@code", "2");
                    query2.Parameters.AddWithValue("@peempCode", id);
                    query2.Parameters.AddWithValue("@creationDate", creationDate);
                    query2.Parameters.AddWithValue("@modificationDate", modificationDate);
                    query2.Parameters.AddWithValue("@piefir", piefir);
                    query2.ExecuteNonQuery();

                    SqlCommand query3 = new SqlCommand("INSERT INTO XEUXP_USUPE " +
                       "(XEUSU_PASWD, XEPER_CODIGO, XEUXP_FECASI, XEUXP_FECRET) " +
                       "VALUES (@password, @role, @creationDate, @modificationDate)", connection, sqlTransaction);
                    query3.Parameters.AddWithValue("@password", passwordEncrypt);
                    query3.Parameters.AddWithValue("@role", role);
                    query3.Parameters.AddWithValue("@creationDate", creationDate);
                    query3.Parameters.AddWithValue("@modificationDate", modificationDate);
                    query3.ExecuteNonQuery();

                    sqlTransaction.Commit();

                    sendPasswordByEmail(email, password);

                    return true;
                }
                catch (Exception ex)
                {
                    sqlTransaction.Rollback();
                    return false;
                }
            }
        }
        public bool ChangePassword(JsonObject passwords)
        {
            string currentPassword = passwords["currentPassword"].ToString();
            string password = Utils.Utils.EncryptPassword(passwords["password"].ToString());

            using (var connection = GetConnection())
            {
                connection.Open();

                var sql = "IF EXISTS (SELECT 1 FROM sys.sysreferences r JOIN sys.sysobjects o ON (o.id = r.constid AND o.type = 'F')" +

                    "WHERE r.fkeyid = OBJECT_ID('XEUXP_USUPE') AND o.name = 'FK_XEUXP_US_XR_XEUSU__XEUSU_US') " +
                    "BEGIN " +
                    "ALTER TABLE XEUXP_USUPE DROP CONSTRAINT FK_XEUXP_US_XR_XEUSU__XEUSU_US; " +
                    "END; " +
                    "IF NOT EXISTS(SELECT 1 FROM dbo.XEUXP_USUPE " +
                    "WHERE XEUSU_PASWD = @new_value) " +
                    "BEGIN " +
                    "UPDATE dbo.XEUXP_USUPE SET XEUSU_PASWD = @new_value " +
                    "WHERE XEUSU_PASWD = @old_value; " +
                    "UPDATE dbo.XEUSU_USUAR SET XEUSU_PASWD = @new_value, XEEST_CODIGO = @state " +
                    "WHERE XEUSU_PASWD = @old_value; " +
                    "ALTER TABLE XEUXP_USUPE ADD CONSTRAINT FK_XEUXP_US_XR_XEUSU__XEUSU_US FOREIGN KEY(XEUSU_PASWD) REFERENCES XEUSU_USUAR(XEUSU_PASWD); " +
                    "END; ";
                var newValue = password;
                var oldValue = currentPassword;

                using (var command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("@new_value", newValue);
                    command.Parameters.AddWithValue("@old_value", oldValue);
                    command.Parameters.AddWithValue("@state", "1");
                    command.ExecuteNonQuery();
                }
            }
            return true;
        }
        public bool UpdateUser(JsonObject user)
        {
            string id = UserLoginCache.Id.ToString();
            string name = user["name"].ToString();
            string lastname = user["lastname"].ToString();
            string identificationCard = user["identificationCard"].ToString();
            string phoneNumber = user["phoneNumber"].ToString();
            string email = user["email"].ToString();


            using (var connection = GetConnection())
            {
                connection.Open();
                string updateSql = "UPDATE PEEMP_EMPLE SET PEEMP_APELLI=@lastname, PEEMP_NOMBRE=@name, PEEMP_CEDULA=@identificationCard, " +
                    "PEEMP_TELEF=@phoneNumber, PEEMP_EMAIL=@email WHERE PEEMP_CODIGO=@id";
                using (SqlCommand command = new SqlCommand(updateSql, connection))
                {
                    command.Parameters.AddWithValue("@id", id);
                    command.Parameters.AddWithValue("@name", name);
                    command.Parameters.AddWithValue("@lastname", lastname);
                    command.Parameters.AddWithValue("@identificationCard", identificationCard);
                    command.Parameters.AddWithValue("@phoneNumber", phoneNumber);
                    command.Parameters.AddWithValue("@email", email);

                    int rowsAffected = command.ExecuteNonQuery();

                    return rowsAffected > 0;
                }
            }
        }
        public bool recoverPassword(string userRequesting)
        {
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandText = "SELECT PEEMP_EMAIL, PEEMP_NOMBRE, PEEMP_APELLI, XEUSU_PASWD FROM PEEMP_EMPLE " +
                        "INNER JOIN XEUSU_USUAR XU ON PEEMP_EMPLE.PEEMP_CODIGO = XU.PEEMP_CODIGO " +
                        "WHERE PEEMP_EMAIL = @mail";

                    command.Parameters.AddWithValue("@mail", userRequesting);
                    command.CommandType = CommandType.Text;
                    SqlDataReader reader = command.ExecuteReader();

                    if (reader.Read())
                    {
                        string userName = reader["PEEMP_NOMBRE"].ToString() + " " + reader["PEEMP_APELLI"].ToString();
                        string userMail = reader["PEEMP_EMAIL"].ToString();
                        string accountPassword = resetPassword(reader["XEUSU_PASWD"].ToString());

                        var mailService = new MailServices.SystemSupportMail();
                        mailService.sendMail(
                            subject: "SYSTEM MONSTER: Solicitud de recuperación de contraseña",
                            body: "Hola, " + userName + "\nSolicitó la recuperación de su contraseña." +
                            "\nSu nueva contraseña es: " + accountPassword +
                            "\nSin embargo, se recomienda cambiar la contraseña luego de acceder al sistema.",
                    recipentMail: new List<string> { userMail }
                            );
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        public string resetPassword(string currentPassword)
        {
            string passwordGenerate = Utils.Utils.GeneratePassword();
            string passwordEncrypt = Utils.Utils.EncryptPassword(passwordGenerate);

            using (var connection = GetConnection())
            {
                connection.Open();

                var sql = "IF EXISTS (SELECT 1 FROM sys.sysreferences r JOIN sys.sysobjects o ON (o.id = r.constid AND o.type = 'F')" +

                    "WHERE r.fkeyid = OBJECT_ID('XEUXP_USUPE') AND o.name = 'FK_XEUXP_US_XR_XEUSU__XEUSU_US') " +
                    "BEGIN " +
                    "ALTER TABLE XEUXP_USUPE DROP CONSTRAINT FK_XEUXP_US_XR_XEUSU__XEUSU_US; " +
                    "END; " +
                    "IF NOT EXISTS(SELECT 1 FROM dbo.XEUXP_USUPE " +
                    "WHERE XEUSU_PASWD = @new_value) " +
                    "BEGIN " +
                    "UPDATE dbo.XEUXP_USUPE SET XEUSU_PASWD = @new_value " +
                    "WHERE XEUSU_PASWD = @old_value; " +
                    "UPDATE dbo.XEUSU_USUAR SET XEUSU_PASWD = @new_value " +
                    "WHERE XEUSU_PASWD = @old_value; " +
                    "ALTER TABLE XEUXP_USUPE ADD CONSTRAINT FK_XEUXP_US_XR_XEUSU__XEUSU_US FOREIGN KEY(XEUSU_PASWD) REFERENCES XEUSU_USUAR(XEUSU_PASWD); " +
                    "END; ";
                var newValue = passwordEncrypt;
                var oldValue = currentPassword;

                using (var command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("@new_value", newValue);
                    command.Parameters.AddWithValue("@old_value", oldValue);
                    command.ExecuteNonQuery();
                }
            }
            return passwordGenerate;
        }
        public void sendPasswordByEmail(string email, string password)
        {
            var mailService = new MailServices.SystemSupportMail();
            mailService.sendMail(
                subject: "SYSTEM MONSTER: Creación de cuenta",
                body: "Hola, Bienvenido al Sistema Monsters." +
                "\nSu contraseña temporal es: " + password +
                "\nSin embargo, cuando ingrese al sistema se le pedirá cambiar la contraseña.",
        recipentMail: new List<string> { email });
        }
        public JsonArray GetPerfilUser()
        {
            JsonArray positionsArray = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT *FROM XEPER_PERFI", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject positions = new JsonObject();
                            positions.Add("Id", reader["XEPER_CODIGO"].ToString());
                            positions.Add("Description", reader["XEPER_DESCRI"].ToString());
                            positions.Add("Observation", reader["XEPER_OBSER"].ToString());
                            positionsArray.Add(positions);
                        }
                        return positionsArray;
                    }
                }
            }
        }
        public JsonArray GetUsersWithoutRole()
        {
            JsonArray usersWithoutRole = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM PEEMP_EMPLE " +
                                                    "INNER JOIN XEUSU_USUAR XU on PEEMP_EMPLE.PEEMP_CODIGO = XU.PEEMP_CODIGO " +
                                                    "INNER JOIN XEUXP_USUPE X on XU.XEUSU_PASWD = X.XEUSU_PASWD " +
                                                    "INNER JOIN XEPER_PERFI XP on X.XEPER_CODIGO = XP.XEPER_CODIGO " +
                                                    "WHERE XP.XEPER_CODIGO = 'N'", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject users = new JsonObject();
                            users.Add("Id", reader["PEEMP_CODIGO"].ToString());
                            users.Add("Lastname", reader["PEEMP_APELLI"].ToString());
                            users.Add("Name", reader["PEEMP_NOMBRE"].ToString());
                            users.Add("Email", reader["PEEMP_EMAIL"].ToString());
                            users.Add("Password", reader["XEUSU_PASWD"].ToString());
                            users.Add("IdRol", reader["XEPER_CODIGO"].ToString());
                            users.Add("Rol", reader["XEPER_DESCRI"].ToString());
                            usersWithoutRole.Add(users);
                        }
                        return usersWithoutRole;
                    }
                }
            }
        }
        public JsonArray GetUsersWithRole()
        {
            JsonArray userWithRole = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM PEEMP_EMPLE " +
                                                    "INNER JOIN XEUSU_USUAR XU on PEEMP_EMPLE.PEEMP_CODIGO = XU.PEEMP_CODIGO " +
                                                    "INNER JOIN XEUXP_USUPE X on XU.XEUSU_PASWD = X.XEUSU_PASWD " +
                                                    "INNER JOIN XEPER_PERFI XP on X.XEPER_CODIGO = XP.XEPER_CODIGO " +
                                                    "WHERE XP.XEPER_CODIGO != 'N'", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject users = new JsonObject();
                            users.Add("Id", reader["PEEMP_CODIGO"].ToString());
                            users.Add("Lastname", reader["PEEMP_APELLI"].ToString());
                            users.Add("Name", reader["PEEMP_NOMBRE"].ToString());
                            users.Add("Email", reader["PEEMP_EMAIL"].ToString());
                            users.Add("Password", reader["XEUSU_PASWD"].ToString());
                            users.Add("IdRol", reader["XEPER_CODIGO"].ToString());
                            users.Add("Rol", reader["XEPER_DESCRI"].ToString());
                            userWithRole.Add(users);
                        }
                        return userWithRole;
                    }
                }
            }
        }
        public bool AssignRole(JsonObject users)
        {
            string rol = users["rol"].ToString();
            bool allProcessedSuccessfully = true;

            foreach (JsonObject user in JsonArray.Parse(users["addUsers"].ToString()).AsArray())
            {
                string password = user["Password"].ToString();
                if (password != null)
                {
                    using (var connection = GetConnection())
                    {
                        connection.Open();
                        SqlTransaction sqlTransaction = connection.BeginTransaction();
                        try
                        {
                            string query = "IF EXISTS (SELECT 1 FROM sys.sysreferences r JOIN sys.sysobjects o ON (o.id = r.constid AND o.type = 'F') " +
                                "WHERE r.fkeyid = OBJECT_ID('XEUXP_USUPE') AND o.name = 'FK_XEUXP_US_XR_XEPER__XEPER_PE') " +
                                "BEGIN " +
                                "ALTER TABLE XEUXP_USUPE DROP CONSTRAINT FK_XEUXP_US_XR_XEPER__XEPER_PE; " +
                                "END; " +
                                "UPDATE dbo.XEUXP_USUPE SET XEPER_CODIGO = @rol " +
                                "WHERE XEUSU_PASWD = @password " +
                                "ALTER TABLE XEUXP_USUPE ADD CONSTRAINT FK_XEUXP_US_XR_XEPER__XEPER_PE FOREIGN KEY(XEPER_CODIGO) " +
                                "REFERENCES XEPER_PERFI(XEPER_CODIGO);";

                            SqlCommand sql = new SqlCommand(query, connection, sqlTransaction);
                            SqlParameter parameterRol = new SqlParameter("@rol", rol);
                            SqlParameter parameterPassword = new SqlParameter("@password", password);
                            sql.Parameters.Add(parameterRol);
                            sql.Parameters.Add(parameterPassword);
                            sql.ExecuteNonQuery();
                            sqlTransaction.Commit();
                        }
                        catch (Exception ex)
                        {
                            allProcessedSuccessfully = false;
                            sqlTransaction.Rollback();
                        }
                    }
                }
                else
                {
                    allProcessedSuccessfully = false;
                }
            }

            return allProcessedSuccessfully;
        }

    }
}

