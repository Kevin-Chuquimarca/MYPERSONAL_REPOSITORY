using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataAccess.Entities;
using DataAccess.Contracts;
using System.Data.SqlClient;
using System.Data;

namespace DataAccess.Repositories
{
    public class EmployeeRepository : MasterRepository, IEmployeeRepository
    {
        private string selectAll;
        private string insert;
        private string update;
        private string delete;

        public EmployeeRepository()
        {
            selectAll = "SELECT * FROM Employee";
            insert = "INSERT INTO Employee VALUES(@idNumber,@name,@mail,@birthday)";
            update = "UPDATE Employee SET IdNumber=@idNumber,Name=@name,Mail=@mail,Birthday=@birthday WHERE idPK=@idPK";
            delete = "DELETE FROM Employee WHERE idPk=@idPK";
        }

        public int Add(Employee entity)
        {
            parameters = new List<SqlParameter>();
            parameters.Add(new SqlParameter("@idNumber", entity.idNumber));
            parameters.Add(new SqlParameter("@name", entity.name));
            parameters.Add(new SqlParameter("@mail", entity.mail));
            parameters.Add(new SqlParameter("@birthday", entity.birthday));
            return ExecuteNonQuery(insert);
        }

        public int Adit(Employee entity)
        {
            parameters = new List<SqlParameter>();
            parameters.Add(new SqlParameter("@idPK", entity.idPk));
            parameters.Add(new SqlParameter("@idNumber", entity.idNumber));
            parameters.Add(new SqlParameter("@name", entity.name));
            parameters.Add(new SqlParameter("@mail", entity.mail));
            parameters.Add(new SqlParameter("@birthday", entity.birthday));
            return ExecuteNonQuery(update);
        }

        public IEnumerable<Employee> GetAll()
        {
            var tableResult = ExecuteReader(selectAll);
            var listEmployee = new List<Employee>();
            foreach (DataRow item in tableResult.Rows)
            {
                listEmployee.Add(new Employee
                {
                    idPk = Convert.ToInt32(item[0]),
                    idNumber = item[1].ToString(),
                    name = item[2].ToString(),
                    mail = item[3].ToString(),
                    birthday = Convert.ToDateTime(item[4])
                });
            }
            return listEmployee;
        }

        public int Remove(int idPk)
        {
            parameters = new List<SqlParameter>();
            parameters.Add(new SqlParameter("@idPK", idPk));
            return ExecuteNonQuery(delete);
        }
    }
}
