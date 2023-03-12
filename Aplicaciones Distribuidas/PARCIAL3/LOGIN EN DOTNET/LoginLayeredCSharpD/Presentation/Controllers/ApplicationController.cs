using Microsoft.AspNetCore.Mvc;
using Presentation.Models;
using System.Diagnostics;
using System.Text.Json.Nodes;
using Domain;
using Common.Cache;

namespace Presentation.Controllers
{
    public class ApplicationController : Controller
    {
        private readonly ILogger<ApplicationController> _logger;

        public ApplicationController(ILogger<ApplicationController> logger)
        {
            _logger = logger;
        }

        public ActionResult Index()
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

        public JsonResult GetCaptcha()
        {
            string captcha = Utils.Utils.GenerateCaptcha();
            return Json(captcha);
        }

        public JsonResult GetPerfilUser()
        {
            UserModel userModel = new UserModel();
            JsonObject model = new JsonObject();
            
            var roles = userModel.GetPerfilUser();
            model.Add("roles", roles);
            
            var userWithoutRole = userModel.GetUsersWithoutRole();
            model.Add("usersWithoutRole", userWithoutRole);

            var userWithRole = userModel.GetUsersWithRole();
            model.Add("userWithRole", userWithRole);

            var jsonResult = new JsonResult(model);
            return jsonResult;
        }

        [HttpPost]
        public Boolean Register([FromBody] JsonObject dataUser)
        {
            UserModel userModel = new UserModel();
            return userModel.RegisterUser(dataUser);
        }

        [HttpPost]
        public Boolean ChangePassword([FromBody] JsonObject passwords)
        {
            UserModel userModel = new UserModel();
            return userModel.ChangePassword(passwords);
        }

        [HttpPost]
        public Boolean UpdateUser([FromBody] JsonObject user)
        {
            UserModel userModel = new UserModel();
            return userModel.UpdateUser(user);
        }

        [HttpPost]
        public Boolean AssignRole([FromBody] JsonObject users)
        {
            UserModel userModel = new UserModel();
            return userModel.AssignRole(users);
        }
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]

        
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}