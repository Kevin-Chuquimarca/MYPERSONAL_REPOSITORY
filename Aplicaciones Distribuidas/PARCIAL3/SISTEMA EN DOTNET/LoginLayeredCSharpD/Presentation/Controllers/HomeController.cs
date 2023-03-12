using Microsoft.AspNetCore.Mvc;
using Presentation.Models;
using System.Diagnostics;
using System.Text.Json.Nodes;
using Newtonsoft.Json;
using Domain;
using Utils;

namespace Presentation.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public Boolean Login([FromBody] JsonObject dataLogin)
        {
            if (!dataLogin.ContainsKey("name") || !dataLogin.ContainsKey("password"))
            {
                return false;
            }

            string user = dataLogin["name"].ToString();
            string password = Utils.Utils.EncryptPassword(dataLogin["password"].ToString());

            if (string.IsNullOrWhiteSpace(user) || string.IsNullOrWhiteSpace(password))
            {
                return false;
            }

            UserModel userModel = new UserModel();
            return userModel.LoginUser(user, password);
        }

        [HttpPost]
        public Boolean RecoverPassword([FromBody] string email)
        {
            if (email.ToString().Trim() == "")
            {
                return false;
            }
            string userEmail = email.ToString();

            if (string.IsNullOrWhiteSpace(userEmail))
            {
                return false;
            }

            UserModel userModel = new UserModel();
            return userModel.recoverPassword(userEmail);
        }

        public IActionResult Home()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}