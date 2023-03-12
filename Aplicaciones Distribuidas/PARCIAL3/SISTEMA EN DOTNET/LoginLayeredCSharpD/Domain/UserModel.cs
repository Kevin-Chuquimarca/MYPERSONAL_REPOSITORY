using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataAccess;
using Common.Cache;
using System.Text.Json.Nodes;

namespace Domain
{
    public class UserModel
    {
        UserDao userDao = new UserDao();
        public bool LoginUser(string username, string password)
        {
            return userDao.Login(username, password);
        }
        public bool RegisterUser(JsonObject dataUser)
        {
            return userDao.RegisterUser(dataUser);
        }
        public bool ChangePassword(JsonObject passwords)
        {
            return userDao.ChangePassword(passwords);
        }
        public JsonArray GetPerfilUser()
        {
            return userDao.GetPerfilUser();
        }
        public JsonArray GetUsersWithoutRole()
        {
            return userDao.GetUsersWithoutRole();
        }
        public JsonArray GetUsersWithRole()
        {
            return userDao.GetUsersWithRole();
        }
        public bool UpdateUser(JsonObject user)
        {
            return userDao.UpdateUser(user);
        }
        public bool AssignRole(JsonObject users)
        {
            return userDao.AssignRole(users);
        }
        public bool recoverPassword(string userRequesting)
        {
            return userDao.recoverPassword(userRequesting);
        }
        public bool DownloadReport(JsonObject users)
        {
            return userDao.DownloadReports(users);
        }
        public JsonArray GetProjects()
        {
            return userDao.GetProjects();
        }
        public JsonArray GetPositions()
        {
            return userDao.GetPositions();
        }
        public JsonArray GetTypeProject()
        {
            return userDao.GetTypeProject();
        }
        public JsonArray GetEmployeeWithoutProject()
        {
            return userDao.GetEmployeeWithoutProject();
        }
        public bool RegisterProject(JsonObject dataProject)
        {
            return userDao.RegisterProject(dataProject);
        }
        public bool AssignEmployeeProject(JsonObject users)
        {
            return userDao.AssignEmployeeProject(users);
        }
        public JsonArray GetEmployees()
        {
            return userDao.GetEmployees();
        }
        public JsonArray GetOptions()
        {
            return userDao.GetOptions();
        }
        public JsonArray GetUsers()
        {
            return userDao.GetUsers();
        }
        public JsonArray GetOptionsPerfil(Char idPerfil)
        {
            return userDao.GetOptionsPerfil(idPerfil);
        }
        public bool AssignOption(JsonObject options)
        {
            return userDao.AssignOption(options);
        }
        public bool DeleteUser(string id)
        {
            return userDao.DeleteUser(id);
        }
        public bool RegisterRol(JsonObject rol)
        {
            return userDao.RegisterRol(rol);
        }
    }
}