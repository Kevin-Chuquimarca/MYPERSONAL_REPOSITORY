using _174_TALLER_HILOS_GRUPO05.Controlador;
using _174_TALLER_HILOS_GRUPO05.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _174_TALLER_HILOS_GRUPO05.Vista
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            BancoModelo banco = new BancoModelo();
            BancoControlador controller = new BancoControlador();

            controller.acreditarSaldoCuentas(banco, 2000);

            for (int i = 0; i < 10; i++)
            {
                Thread t = new Thread(new ThreadStart(new TransferenciasControlador(banco, controller, i, 2000).run));
                t.Start();
            }
        }
    }
}
