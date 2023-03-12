using _173_TALLER_HILOS_GRUPO05.Controlador;
using _173_TALLER_HILOS_GRUPO05.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _173_TALLER_HILOS_GRUPO05
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
