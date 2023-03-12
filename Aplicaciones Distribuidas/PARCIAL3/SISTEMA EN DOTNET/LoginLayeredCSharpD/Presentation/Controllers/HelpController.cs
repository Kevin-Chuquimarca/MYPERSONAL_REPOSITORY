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
    public class HelpController : Controller
    {
        private readonly ILogger<HelpController> _logger;

        public HelpController(ILogger<HelpController> logger)
        {
            _logger = logger;
        }

        public ActionResult Index()
        {
            return View();
        }
        public ActionResult AboutUs()
        {
            return View();
        }
        public ActionResult Help()
        {
            return View();
        }


    }
}