namespace _171_TALLER_HILOS_GRUPO05.controlador
{
    internal class HiloControlador
    {
        public Thread hilo;

        public HiloControlador(String hiloNombre)
        {
            this.hilo = new Thread(this.ejecutar);
            this.hilo.Name = hiloNombre;    
        }

        public void ejecutar()
        {
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine("Ejecutando hilo..." + this.hilo.Name);
                try
                {
                    Thread.Sleep(700);
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.StackTrace);
                }
            }
        }
    }
}
