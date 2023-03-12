using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Servidor.Vista
{
    public class ViewServer
    {
        private string message { get; set; }

        public ViewServer()
        {
            this.message = message;
        }
        public void showMessage()
        {
            this.message = "Servidor esperando usuarios.....";
            Console.WriteLine(message);
        }
    }
}
