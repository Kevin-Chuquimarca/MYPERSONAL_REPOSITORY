namespace _171_TALLER_HILOS_GRUPO05.controlador
{
    internal class GestionHilo
    {
        public static void gestionarHilos()
        {
            HiloControlador hiloControlador = new HiloControlador("hilo1");
            Hilo2Controlador hilo2Controlador = new Hilo2Controlador("hilo2", hiloControlador.hilo);
            hilo2Controlador.hilo.Start();
            hiloControlador.hilo.Start();
            Console.WriteLine("Terminadas las tareas...");
        }
    }
}
