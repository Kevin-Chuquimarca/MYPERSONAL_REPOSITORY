using System.Web.Mvc;
using WebConMVCDotnetGrupo5.Models;

namespace WebConMVCDotnetGrupo5.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Salida()
        {
            DatosEncuesta datosEncuesta = new DatosEncuesta();
            datosEncuesta.setTxtNombre(Request.Form["txtNombre"]);
            datosEncuesta.setTxtApellido(Request.Form["txtApellido"]);
            datosEncuesta.setChkProgLeng(Request.Form.GetValues("chkProgLeng"));
            datosEncuesta.setImgProfile(Request.Form["imgProfile"]);
            return View(datosEncuesta);
        }
    }
}