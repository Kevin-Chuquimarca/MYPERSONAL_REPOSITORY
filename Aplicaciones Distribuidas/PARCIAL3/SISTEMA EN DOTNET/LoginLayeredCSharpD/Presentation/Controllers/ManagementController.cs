using Microsoft.AspNetCore.Mvc;
using Domain;
using System.Text.Json.Nodes;
using System.Collections.Specialized;

namespace Presentation.Controllers
{
    public class ManagementController : Controller
    {
        private readonly ILogger<ManagementController> _logger;

        public ManagementController(ILogger<ManagementController> logger)
        {
            _logger = logger;
        }
        /*Views*/
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
        public ActionResult Roles()
        {
            return View();
        }
        public JsonResult GetProjects()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetProjects());
            return jsonResult;
        }
        public JsonResult GetTypeProject()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetTypeProject());
            return jsonResult;
        }
        public JsonResult GetEmployeeWithoutProject()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetEmployeeWithoutProject());
            return jsonResult;
        }
        public JsonResult GetPositions()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetPositions());
            return jsonResult;
        }
        public JsonResult GetCaptcha()
        {
            string captcha = Utils.Utils.GenerateCaptcha();
            return Json(captcha);
        }
        public JsonResult GetRoles()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetPerfilUser());
            return jsonResult;
        }
        public JsonResult GetOptions()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetOptions());
            return jsonResult;
        }
        public JsonResult GetOptionsPerfil(Char idPerfil)
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetOptionsPerfil(idPerfil));
            return jsonResult;
        }
        public JsonResult GetUsers()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetUsers());
            return jsonResult;
        }

        [HttpPost]
        public Boolean Register([FromBody] JsonObject dataProject)
        {
            UserModel userModel = new UserModel();
            return userModel.RegisterProject(dataProject);
        }
        [HttpPost]
        public Boolean RegisterUser([FromBody] JsonObject dataUser)
        {
            UserModel userModel = new UserModel();
            return userModel.RegisterUser(dataUser);
        }
        [HttpPost]
        public Boolean AssignEmployeeProject([FromBody] JsonObject users)
        {
            UserModel userModel = new UserModel();
            return userModel.AssignEmployeeProject(users);
        }
        [HttpPost]
        public Boolean AssignOption([FromBody] JsonObject options)
        {
            UserModel userModel = new UserModel();
            return userModel.AssignOption(options);
        }
        [HttpPost]
        public Boolean UpdateUser([FromBody] JsonObject user)
        {
            UserModel userModel = new UserModel();
            return userModel.UpdateUser(user);
        }
        [HttpPost]
        public Boolean DeleteUser([FromBody] JsonObject userDelete)
        {
            UserModel userModel = new UserModel();
            string id = userDelete["Id"].ToString();
            return userModel.DeleteUser(id);
        }
        [HttpPost]
        public Boolean RegisterRol([FromBody] JsonObject rol)
        {
            UserModel userModel = new UserModel();
            return userModel.RegisterRol(rol);
        }
    }
}