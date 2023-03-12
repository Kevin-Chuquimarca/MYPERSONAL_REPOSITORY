using Servidor.Controlador;
using Servidor.Vista;
using System;

namespace Servidor
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Server serverserver = new Server();
            ViewServer servidor = new ViewServer();
            servidor.showMessage();
            Console.ReadKey();
        }
    }
}
