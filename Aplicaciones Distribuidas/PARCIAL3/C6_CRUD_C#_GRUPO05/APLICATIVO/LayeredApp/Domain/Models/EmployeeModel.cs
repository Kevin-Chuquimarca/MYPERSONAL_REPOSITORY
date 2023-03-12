using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataAccess.Entities;
using DataAccess.Contracts;
using DataAccess.Repositories;
using Domain.ValueObjects;
using System.ComponentModel.DataAnnotations;

namespace Domain.Models
{
    public class EmployeeModel : IDisposable
    {
        private int idPk;
        private string idNumber;
        private string name;
        private string mail;
        private DateTime birthday;
        private int age;

        private IEmployeeRepository employeeRepository;
        public EntityState State { private get; set; }
        private List<EmployeeModel> listEmployees;

        public int IdPk { get => idPk; set => idPk = value; }
        [Required(ErrorMessage = "El campo IdNumber es requerido")]
        [RegularExpression("([0-9]+)", ErrorMessage = "El campo IdNumber solo acepta números")]
        [StringLength(maximumLength: 10, MinimumLength = 10, ErrorMessage = "El campo IdNumber debe tener 10 digitos")]
        public string IdNumber { get => idNumber; set => idNumber = value; }
        [Required]
        [RegularExpression("^[a-zA-Z ]+$", ErrorMessage = "El campo Name solo acepta letras")]
        [StringLength(maximumLength: 100, MinimumLength = 3, ErrorMessage = "El campo Name debe tener entre 3 y 50 caracteres")]
        public string Name { get => name; set => name = value; }
        [Required]
        [EmailAddress]
        public string Mail { get => mail; set => mail = value; }
        public DateTime Birthday { get => birthday; set => birthday = value; }
        public int Age { get => age; private set => age = value; }
        
        public EmployeeModel()
        {
            employeeRepository = new EmployeeRepository();
        }
        public string SaveChanges()
        {
            string message = null;
            try
            {
                var employeeDataModel = new Employee();
                employeeDataModel.idPk = idPk;
                employeeDataModel.idNumber = idNumber;
                employeeDataModel.name = name;
                employeeDataModel.mail = mail;
                employeeDataModel.birthday = birthday;

                switch (State)
                {
                    case EntityState.Added:
                    employeeRepository.Add(employeeDataModel);
                        message = "Registro agregado";
                        break;
                     case EntityState.Deleted:
                        employeeRepository.Remove(idPk);
                        message = "Registro eliminado";
                        break;
                     case EntityState.Modified:
                        employeeRepository.Adit(employeeDataModel);
                        message = "Registro modificado";
                        break;
                     default:
                        message = "No se realizo ninguna accion";
                        break;
                }
            } 
            catch (Exception ex) 
            {
                System.Data.SqlClient.SqlException sqlEx = ex as System.Data.SqlClient.SqlException;
                if(sqlEx != null && sqlEx.Number == 2627) 
                {
                    message = "El IdNumber ya existe";
                } else
                {
                    message = ex.ToString();
                }
            }
            return message;
        }
        public List<EmployeeModel> GetAll()
        {
            var employeeDataModel = employeeRepository.GetAll();
            listEmployees = new List<EmployeeModel>();
            foreach(Employee item in employeeDataModel)
            {
                var birthDate = item.birthday;
                listEmployees.Add(new EmployeeModel
                {
                    idPk = item.idPk,
                    idNumber = item.idNumber,
                    name = item.name,
                    mail = item.mail,
                    birthday = item.birthday,
                    age = CalculateAge(birthDate)
                });
            }
            return listEmployees;
        }

        public IEnumerable<EmployeeModel> FindById(string filter)
        {
            return listEmployees.FindAll(e => e.idNumber.Contains(filter) || e.name.Contains(filter));
        }

        private int CalculateAge(DateTime date)
        {
            DateTime dateNow = DateTime.Now;
            return dateNow.Year - date.Year;
        }

        public void Dispose()
        {

        }
    }
}
