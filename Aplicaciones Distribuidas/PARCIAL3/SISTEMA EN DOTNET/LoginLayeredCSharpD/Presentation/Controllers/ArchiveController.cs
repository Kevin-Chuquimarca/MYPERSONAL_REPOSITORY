﻿using Microsoft.AspNetCore.Mvc;
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
    public class ArchiveController : Controller
    {
        private readonly ILogger<ArchiveController> _logger;

        public ArchiveController(ILogger<ArchiveController> logger)
        {
            _logger = logger;
        }

        public ActionResult Index()
        {
            return View();
        }


    }
}