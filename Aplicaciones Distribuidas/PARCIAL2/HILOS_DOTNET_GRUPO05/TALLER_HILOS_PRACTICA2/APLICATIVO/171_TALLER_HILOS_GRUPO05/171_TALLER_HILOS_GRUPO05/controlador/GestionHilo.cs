namespace _171_TALLER_HILOS_GRUPO05.controlador
{
    internal class GestionHilo
    {
        public static void gestionarHilos()
        {
            HiloControlador hiloControlador = new HiloControlador("hilo1");
            HiloControlador hilo2Controlador = new HiloControlador("hilo2");
            hiloControlador.hilo.Start();
            try
            {
                hiloControlador.hilo.Join();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }

            hilo2Controlador.hilo.Start();
            try
            {
                hilo2Controlador.hilo.Join();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
            Console.WriteLine("Terminadas las tareas...");
        }
    }
}
