namespace _171_TALLER_HILOS_GRUPO05.controlador
{
    internal class Hilo2Controlador
    {
        public Thread hilo;
        public Thread hiloInterno;

        public Hilo2Controlador(String hiloNombre, Thread hiloInterno)
        {
            this.hilo = new Thread(this.ejecutar);
            this.hilo.Name = hiloNombre;
            this.hiloInterno = hiloInterno;
        }

        public void ejecutar()
        {
            try
            {
                this.hiloInterno.Join();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
            
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
