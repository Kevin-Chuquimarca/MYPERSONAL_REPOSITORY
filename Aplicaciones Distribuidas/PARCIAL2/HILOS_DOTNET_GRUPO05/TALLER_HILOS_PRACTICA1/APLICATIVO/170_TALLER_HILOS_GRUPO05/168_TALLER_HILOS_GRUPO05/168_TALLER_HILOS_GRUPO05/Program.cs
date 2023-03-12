using _168_TALLER_HILOS_GRUPO05.controlador;
using _168_TALLER_HILOS_GRUPO05.vista;

namespace _168_TALLER_HILOS_GRUPO05
{
    internal static class Program
    {
        [STAThread]
        static void Main()
        {
            try
            {
                PelotaVista vista = new PelotaVista();
                PelotaControlador controlador = new PelotaControlador(vista);
                Application.Run(vista);
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine(ex.Message);
            }
        }
    }
}