namespace _168_TALLER_HILOS_GRUPO05.modelo
{
    internal class PelotaModelo : PictureBox
    {
        private int TAMX = 735;
        private int TAMY = 381;
        private int x = 0;
        private int y = 0;
        private int dx = 1;
        private int dy = 1;
        private bool pausado = false;
        private bool terminado = false;
        private Thread hilo;
        private Graphics grafico;

        public PelotaModelo(string name, int x, int y)
        {
            this.BackColor = System.Drawing.Color.Transparent;
            this.Location = new System.Drawing.Point(x, y);
            this.Name = name;
            this.Size = new System.Drawing.Size(20, 20);
            this.ResizeRedraw = true;
            this.grafico = this.CreateGraphics();
            this.hilo = new Thread(this.moverPelota);
        }

        public void dibujarPelota(Brush color)
        {
            Image bmp = new Bitmap(20, 20);
            using (Graphics g = Graphics.FromImage(bmp))
            {
                g.FillEllipse(color, 0, 0, 20, 20);
            }
            this.Image = bmp;
        }

        public void pausar()
        {
            lock (this)
            {
                this.pausado = true;
            }
        }

        public void ejecutar()
        {
            if (this.hilo.ThreadState == ThreadState.Unstarted)
            {
                this.hilo.IsBackground = true;
                this.hilo.Start();
            }
            else
            {
                lock (this)
                {
                    this.pausado = false;
                    Monitor.PulseAll(this);
                }
            }

        }

        public void finalizar()
        {
            lock (this)
            {
                this.terminado = true;
                Monitor.PulseAll(this);
            }
        }

        public void moverPelota()
        {

            while (true)
            {
                x = this.Location.X + dx;
                y = this.Location.Y + dy;
                this.Location = new System.Drawing.Point(x, y);
                Thread.Sleep(1);
                lock (this)
                {
                    if (this.pausado) Monitor.Wait(this);
                }
                if (this.Location.X > this.TAMX - 10)
                {
                    dx = -dx;
                }
                else if (this.Location.X < 10)
                {
                    dx = -dx;
                }

                if (this.Location.Y > this.TAMY - 10)
                {

                    dy = -dy;
                }
                else if (this.Location.Y < 10)
                {

                    dy = -dy;
                }
            }
        }
    }
}
