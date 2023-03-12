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
    public class EditionController : Controller
    {
        private readonly ILogger<EditionController> _logger;

        public EditionController(ILogger<EditionController> logger)
        {
            _logger = logger;
        }

        public ActionResult Index()
        {
            return View();
        }

       
    }
}