using Common.Cache;
using Domain;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Reflection;
using System.Text.Json.Nodes;

namespace Presentation.Controllers
{
    public class ProccessController : Controller
    {
        private readonly ILogger<ProccessController> _logger;

        public ProccessController(ILogger<ProccessController> logger)
        {
            _logger = logger;
        }

        public ActionResult Personal()
        {
            return View();
        }
        public ActionResult Finance()
        {
            return View();
        }
        public ActionResult Security()
        {
            return View();
        }
        public ActionResult Project()
        {
            return View();
        }
        public JsonResult GetUser()
        {
            var userData = new
            {
                UserLoginCache.Id,
                UserLoginCache.Rol,
                UserLoginCache.DescriptionRol,
                UserLoginCache.Email,
                UserLoginCache.Lastname,
                UserLoginCache.Name,
                UserLoginCache.Photo,
                UserLoginCache.Phone,
                UserLoginCache.IdentificationCard,
                UserLoginCache.Password,
                UserLoginCache.State

            };
            var jsonResult = new JsonResult(userData);
            return jsonResult;
        }
        public JsonResult GetRoles()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetPerfilUser());
            return jsonResult;
        }
        public JsonResult GetUsers()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetUsersWithRole());
            return jsonResult;
        }
        public JsonResult GetUsersWithoutRol()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetUsersWithoutRole());
            return jsonResult;
        }
        public JsonResult GetEmployees()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetEmployees());
            return jsonResult;
        }
       
        [HttpPost]
        public Boolean AssignRole([FromBody] JsonObject users)
        {
            UserModel userModel = new UserModel();
            return userModel.AssignRole(users);
        }
        [HttpPost]
        public Boolean ChangePassword([FromBody] JsonObject passwords)
        {
            UserModel userModel = new UserModel();
            return userModel.ChangePassword(passwords);
        }

    }
}