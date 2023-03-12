using Microsoft.AspNetCore.Mvc;
using Presentation.Models;
using System.Diagnostics;
using System.Text.Json.Nodes;
using Common.Cache;

namespace Presentation.Controllers
{
    public class SharedController : Controller
    {
        private readonly ILogger<SharedController> _logger;

        public SharedController(ILogger<SharedController> logger)
        {
            _logger = logger;
        }
        
        public string GetUser()
        {
            return UserLoginCache.Rol.ToString();
        }
    }
}