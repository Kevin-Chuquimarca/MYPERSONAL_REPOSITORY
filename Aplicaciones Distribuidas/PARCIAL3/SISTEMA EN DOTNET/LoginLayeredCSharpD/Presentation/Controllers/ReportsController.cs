using Microsoft.AspNetCore.Mvc;
using Presentation.Models;
using System.Diagnostics;
using System.Text.Json.Nodes;
using Newtonsoft.Json;
using Domain;
using Common.Cache;
using Utils;
using System.Data;
using DataAccess;

namespace Presentation.Controllers
{
    public class ReportsController : Controller
    {
        private readonly ILogger<ReportsController> _logger;

        public ReportsController(ILogger<ReportsController> logger)
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
        public JsonResult GetUsers()
        {
            UserModel userModel = new UserModel();
            var jsonResult = new JsonResult(userModel.GetUsersWithRole());
            return jsonResult;
        }
        [HttpPost]
        public Boolean DownloadReports([FromBody] JsonObject users)
        {
            UserModel userModel = new UserModel();
            return userModel.DownloadReport(users);
        }


    }
}