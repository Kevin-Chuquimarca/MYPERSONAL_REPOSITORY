using System.Text;
using System.Data;
using System.Data.SqlClient;
using Common.Cache;
using System.Text.Json.Nodes;
using iTextSharp.text.pdf;
using iTextSharp.text;
using System.Globalization;

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

                            //Get options perfil
                            if (!Convert.ToChar(reader["XEPER_CODIGO"].ToString()?.FirstOrDefault()).Equals(""))
                            {
                                char id = UserLoginCache.Rol.Value;
                                ShowOptionsPerfil(id);
                            }
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
                DateTime departureDate = DateTime.Now;
                string address = string.IsNullOrEmpty(dataUser["address"]?.ToString()) ? "-" : dataUser["address"].ToString();
                string phoneNumber = dataUser["phoneNumber"].ToString();
                string email = dataUser["email"].ToString();
                string identificationCard = string.IsNullOrEmpty(dataUser["identificationCard"]?.ToString()) ? "-" : dataUser["identificationCard"].ToString();
                string photo = string.IsNullOrEmpty(dataUser["photo"]?.ToString()) ? "-" : dataUser["photo"].ToString();
                string passport = string.IsNullOrEmpty(dataUser["passport"]?.ToString()) ? "-" : dataUser["passport"].ToString();
                string role = "N";
                string idPosition = "N";
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
                        "(PEEMP_CODIGO, TECEM_CODIGO, PEEMP_APELLI, PEEMP_NOMBRE, PEEMP_FECNAC, PEEMP_FECSAL, PEEMP_DIREC, PEEMP_TELEF, PEEMP_EMAIL, PEEMP_CEDULA, " +
                        "PEEMP_FOTO, PEEMP_CARFAM, PEEMP_PASAPO, DISCAPA) " +
                        "VALUES (@idUser, @idPosition, @lastname, @name, @birthday, @departureDate, @address, @phoneNumber, " +
                        "@email, @identificationCard, @photo, @familyBurden, @passport, @disability)", connection, sqlTransaction);

                    query1.Parameters.AddWithValue("@idUser", id);
                    query1.Parameters.AddWithValue("@lastname", lastname);
                    query1.Parameters.AddWithValue("@name", name);
                    query1.Parameters.AddWithValue("@idPosition", idPosition);
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
            string id = user["Id"].ToString().Trim();
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
                using (var command = new SqlCommand("SELECT *FROM XEPER_PERFI WHERE XEPER_CODIGO != 'N'", connection))
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

            foreach (JsonObject user in JsonArray.Parse(users["usersAdd"].ToString()).AsArray())
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
        public bool DownloadReports(JsonObject users)
        {
            foreach (JsonObject user in JsonArray.Parse(users["users"].ToString()).AsArray())
            {
                Document doc = new Document();
                string name = user["Name"].ToString();
                string lastname = user["Lastname"].ToString();
                string email = user["Email"].ToString();
                string rol = user["Rol"].ToString();
                string date = DateTime.Now.ToString("yyyy_MM_dd_mm_ss");
                PdfWriter.GetInstance(doc, new FileStream("reports/" + date + "_" + lastname + ".pdf", FileMode.Create));
                doc.Open();
                Paragraph title = new Paragraph();
                title.Font = FontFactory.GetFont(FontFactory.TIMES, 18f, BaseColor.BLUE);
                title.Add("Reporte de Personal");
                doc.Add(title);
                doc.Add(new Paragraph("Nombre: " + name));
                doc.Add(new Paragraph("Apellido: " + lastname));
                doc.Add(new Paragraph("Email: " + email));
                doc.Add(new Paragraph("Rol: " + rol));
                doc.Close();
            }
            return true;
        }
        public JsonArray GetProjects()
        {
            JsonArray projectsArray = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM TEPRO_PROYEC INNER JOIN TETPR_TIPPRO TT on TEPRO_PROYEC.TETPR_CODIGO = TT.TETPR_CODIGO", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject project = new JsonObject();
                            project.Add("IdProject", reader["TEPRO_CODIGO"].ToString());
                            project.Add("IdTypeProject", reader["TETPR_CODIGO"].ToString());
                            project.Add("TypeProject", reader[8].ToString());
                            project.Add("Name", reader["TEPRO_NOMBR"].ToString());
                            project.Add("Description", reader["TETPR_TEPROD"].ToString());
                            project.Add("DateStart", reader["TEPRO_FECHAI"].ToString());
                            project.Add("DateFinish", reader["TEPRO_FECHAF"].ToString());
                            project.Add("Cost", reader["TEPRO_COSTO"].ToString());
                            projectsArray.Add(project);
                        }
                        return projectsArray;
                    }
                }
            }
        }
        public JsonArray GetPositions()
        {
            JsonArray positionsArray = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM TECEM_CAREMP WHERE TECEM_CODIGO != 'N'", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject position = new JsonObject();
                            position.Add("Id", reader["TECEM_CODIGO"].ToString());
                            position.Add("Name", reader["TECEM_DESCRI"].ToString());
                            positionsArray.Add(position);
                        }
                        return positionsArray;
                    }
                }
            }
        }
        public JsonArray GetTypeProject()
        {
            JsonArray typeProjectsArray = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT *FROM TETPR_TIPPRO", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject typeProject = new JsonObject();
                            typeProject.Add("Id", reader["TETPR_CODIGO"].ToString());
                            typeProject.Add("Name", reader["TETPR_TEPROD"].ToString());

                            typeProjectsArray.Add(typeProject);
                        }
                        return typeProjectsArray;
                    }
                }
            }
        }
        public bool RegisterProject(JsonObject dataProject)
        {
            using (var connection = GetConnection())
            {
                connection.Open();

                string name = dataProject["name"].ToString();
                string description = string.IsNullOrEmpty(dataProject["description"]?.ToString()) ? "-" : dataProject["description"].ToString();
                Char typeProject = Char.Parse(dataProject["type"].ToString());
                DateTime startDate = (DateTime)dataProject["startDate"];
                DateTime finishDate = DateTime.Now;
                float cost = float.Parse(dataProject["cost"].ToString());

                SqlTransaction sqlTransaction = connection.BeginTransaction();
                try
                {
                    SqlCommand query = new SqlCommand("INSERT INTO TEPRO_PROYEC " +
                       "(TETPR_CODIGO, TEPRO_NOMBR, TEPRO_FECHAI, TEPRO_FECHAF, TETPR_TEPROD, TEPRO_COSTO) " +
                       "VALUES (@typeProject, @name, @startDate, @finishDate, @description, @cost)", connection, sqlTransaction);
                    query.Parameters.AddWithValue("@typeProject", typeProject);
                    query.Parameters.AddWithValue("@name", name);
                    query.Parameters.AddWithValue("@startDate", startDate);
                    query.Parameters.AddWithValue("@finishDate", finishDate);
                    query.Parameters.AddWithValue("@description", description);
                    query.Parameters.AddWithValue("@cost", cost);
                    query.ExecuteNonQuery();

                    sqlTransaction.Commit();

                    return true;
                }
                catch (Exception ex)
                {
                    Console.Write(ex);
                    sqlTransaction.Rollback();
                    return false;
                }
            }
        }
        public JsonArray GetEmployeeWithoutProject()
        {
            JsonArray employeeWithoutProject = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM PEEMP_EMPLE " +
                                                    "INNER JOIN XEUSU_USUAR XU on PEEMP_EMPLE.PEEMP_CODIGO = XU.PEEMP_CODIGO " +
                                                    "INNER JOIN XEUXP_USUPE X on XU.XEUSU_PASWD = X.XEUSU_PASWD " +
                                                    "INNER JOIN XEPER_PERFI XP on X.XEPER_CODIGO = XP.XEPER_CODIGO " +
                                                    "WHERE XP.XEPER_CODIGO = 'E' AND TECEM_CODIGO = 'N' AND TEPRO_CODIGO IS NULL", connection))
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
                            users.Add("PositionProject", reader["TECEM_CODIGO"].ToString());
                            users.Add("IdProject", reader["TEPRO_CODIGO"].ToString());
                            employeeWithoutProject.Add(users);
                        }
                        return employeeWithoutProject;
                    }
                }
            }
        }
        public bool AssignEmployeeProject(JsonObject users)
        {
            Char position = Char.Parse(users["position"].ToString());
            int project = Int16.Parse(users["project"].ToString());
            bool allProcessedSuccessfully = true;

            foreach (JsonObject user in JsonArray.Parse(users["usersAdd"].ToString()).AsArray())
            {
                Char id = Char.Parse(user["Id"].ToString().Trim());

                if (id.ToString() != "")
                {
                    using (var connection = GetConnection())
                    {
                        connection.Open();
                        SqlTransaction sqlTransaction = connection.BeginTransaction();
                        try
                        {
                            string query = "UPDATE dbo.PEEMP_EMPLE SET TECEM_CODIGO = @position, TEPRO_CODIGO = @project WHERE PEEMP_CODIGO = @id;";

                            SqlCommand sql = new SqlCommand(query, connection, sqlTransaction);
                            SqlParameter parameterId = new SqlParameter("@id", id);
                            SqlParameter parameterPosition = new SqlParameter("@position", position);
                            SqlParameter parameterProject = new SqlParameter("@project", project);
                            sql.Parameters.Add(parameterId);
                            sql.Parameters.Add(parameterPosition);
                            sql.Parameters.Add(parameterProject);
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
        public JsonArray GetEmployees()
        {
            JsonArray userWithProject = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM PEEMP_EMPLE " +
                                                    "INNER JOIN TEPRO_PROYEC TP on PEEMP_EMPLE.TEPRO_CODIGO = TP.TEPRO_CODIGO " +
                                                    "INNER JOIN TECEM_CAREMP TC on PEEMP_EMPLE.TECEM_CODIGO = TC.TECEM_CODIGO", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject users = new JsonObject();
                            users.Add("Id", reader["PEEMP_CODIGO"].ToString());
                            users.Add("Name", reader["PEEMP_NOMBRE"].ToString() + " " + reader["PEEMP_APELLI"].ToString());
                            users.Add("Email", reader["PEEMP_EMAIL"].ToString());
                            users.Add("Project", reader["TEPRO_NOMBR"].ToString());
                            users.Add("Position", reader["TECEM_DESCRI"].ToString());
                            userWithProject.Add(users);
                        }
                        return userWithProject;
                    }
                }
            }
        }
        public JsonArray GetOptions()
        {
            JsonArray options = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM XEOPC_OPCIO", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject option = new JsonObject();
                            option.Add("Id", reader["XEOPC_CODIGO"].ToString().Trim());
                            option.Add("IdSystem", reader["XESIS_CODIGO"].ToString().Trim());
                            option.Add("Description", reader["XEOPC_DESCRI"].ToString().Trim());
                            options.Add(option);
                        }
                        return options;
                    }
                }
            }
        }
        public JsonArray GetOptionsPerfil(Char idPerfil)
        {
            JsonArray options = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM XEOXP_OPCPE WHERE XEPER_CODIGO=@id", connection))
                {
                    command.Parameters.AddWithValue("@id", idPerfil.ToString());
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject option = new JsonObject();
                            option.Add("IdOption", reader["XEOPC_CODIGO"].ToString().Trim());
                            option.Add("IdPerfil", reader["XEPER_CODIGO"].ToString().Trim());
                            option.Add("Id", reader["XEOXP_FECASI"].ToString().Trim());
                            options.Add(option);
                        }
                        return options;
                    }
                }
            }
        }
        public void ShowOptionsPerfil(Char idPerfil)
        {
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM XEOXP_OPCPE WHERE XEPER_CODIGO=@id", connection))
                {

                    command.Parameters.AddWithValue("@id", idPerfil.ToString());
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        var positions = new List<char>();
                        while (reader.Read())
                        {
                            positions.Add(Char.Parse(reader["XEOPC_CODIGO"].ToString().Trim()));
                        }
                        Positions.Id = positions;
                    }
                }

            }
        }
        public bool AssignOption(JsonObject options)
        {
            string idPerfil = options["perfil"].ToString();
            DateTime creationDate = DateTime.Now;

            bool allProcessedSuccessfully = true;
            using (var connection = GetConnection())
            {
                connection.Open();
                SqlTransaction sqlTransaction = connection.BeginTransaction();
                try
                {
                    string query = "DELETE FROM dbo.XEOXP_OPCPE WHERE XEPER_CODIGO = @idPerfil";

                    SqlCommand sql = new SqlCommand(query, connection, sqlTransaction);
                    SqlParameter parameterPerfil = new SqlParameter("@idPerfil", idPerfil);
                    sql.Parameters.Add(parameterPerfil);
                    sql.ExecuteNonQuery();

                    foreach (JsonObject option in options["options"].AsArray())
                    {
                        string idOption = option["Id"].ToString();
                        SqlCommand query2 = new SqlCommand("INSERT INTO XEOXP_OPCPE " +
                        "(XEOPC_CODIGO, XEPER_CODIGO, XEOXP_FECASI, XEOXP_FECRET) " +
                        "VALUES (@idOption, @idPerfil, @fecasi, @fecret)", connection, sqlTransaction);
                        query2.Parameters.AddWithValue("@idOption", idOption);
                        query2.Parameters.AddWithValue("@idPerfil", idPerfil);
                        query2.Parameters.AddWithValue("@fecasi", creationDate);
                        query2.Parameters.AddWithValue("@fecret", creationDate);
                        query2.ExecuteNonQuery();

                    }
                    sqlTransaction.Commit();
                }
                catch (Exception ex)
                {
                    allProcessedSuccessfully = false;
                    sqlTransaction.Rollback();
                }
            }
            return allProcessedSuccessfully;
        }
        public JsonArray GetUsers()
        {
            JsonArray userArray = new JsonArray();
            using (var connection = GetConnection())
            {
                connection.Open();
                using (var command = new SqlCommand("SELECT * FROM PEEMP_EMPLE WHERE PEEMP_NOMBRE != 'UD'", connection))
                {
                    command.CommandType = CommandType.Text;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            JsonObject users = new JsonObject();
                            users.Add("Id", reader["PEEMP_CODIGO"].ToString().Trim());
                            users.Add("Lastname", reader["PEEMP_APELLI"].ToString().Trim());
                            users.Add("Name", reader["PEEMP_NOMBRE"].ToString().Trim());
                            users.Add("Cedula", reader["PEEMP_CEDULA"].ToString().Trim());
                            users.Add("Telefono", reader["PEEMP_TELEF"].ToString().Trim());
                            users.Add("Email", reader["PEEMP_EMAIL"].ToString().Trim());
                            userArray.Add(users);
                        }
                        return userArray;
                    }
                }
            }
        }
        public bool DeleteUser(string id)
        {
            string name = "UD";

            using (var connection = GetConnection())
            {
                connection.Open();
                string updateSql = "UPDATE PEEMP_EMPLE SET PEEMP_NOMBRE=@name WHERE PEEMP_CODIGO=@id";
                using (SqlCommand command = new SqlCommand(updateSql, connection))
                {
                    command.Parameters.AddWithValue("@id", id);
                    command.Parameters.AddWithValue("@name", name);
                    int rowsAffected = command.ExecuteNonQuery();

                    return rowsAffected > 0;
                }
            }
        }
        public bool RegisterRol(JsonObject rol)
        {
            using (var connection = GetConnection())
            {
                connection.Open();
                string name = rol["name"].ToString();
                string observation = "Ninguna";
                string idRole = name.Substring(0, 3).ToUpper();
             
                SqlTransaction sqlTransaction = connection.BeginTransaction();
                try
                {
                    SqlCommand query = new SqlCommand("INSERT INTO XEPER_PERFI " +
                        "(XEPER_CODIGO, XEPER_DESCRI, XEPER_OBSER) " +
                        "VALUES (@idRole, @name, @observation)", connection, sqlTransaction);

                    query.Parameters.AddWithValue("@idRole", idRole);
                    query.Parameters.AddWithValue("@name", name);
                    query.Parameters.AddWithValue("@observation", observation);
                    query.ExecuteNonQuery();

                    sqlTransaction.Commit();

                    return true;
                }
                catch (Exception ex)
                {
                    sqlTransaction.Rollback();
                    return false;
                }
            }
        }
    }
}


