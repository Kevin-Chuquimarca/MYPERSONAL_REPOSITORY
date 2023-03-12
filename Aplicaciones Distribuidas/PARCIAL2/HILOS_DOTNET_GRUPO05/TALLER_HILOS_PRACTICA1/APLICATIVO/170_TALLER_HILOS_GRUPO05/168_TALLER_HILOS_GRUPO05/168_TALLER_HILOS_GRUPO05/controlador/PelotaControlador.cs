using _168_TALLER_HILOS_GRUPO05.modelo;
using _168_TALLER_HILOS_GRUPO05.vista;

namespace _168_TALLER_HILOS_GRUPO05.controlador
{
    internal class PelotaControlador
    {
        private PelotaModelo pelota1 = new PelotaModelo("pelota1", 10, 10);
        private PelotaModelo pelota2 = new PelotaModelo("pelota2", 10, 10);
        private PelotaModelo pelota3 = new PelotaModelo("pelota3", 10, 10);
        private PelotaVista vista;

        public PelotaControlador(PelotaVista vista)
        {
            this.vista = vista;
            this.vista.getPnlPelotas().Controls.Add(this.pelota1);
            this.vista.getPnlPelotas().Controls.Add(this.pelota2);
            this.vista.getPnlPelotas().Controls.Add(this.pelota3);
            this.pelota1.dibujarPelota(Brushes.White);
            this.pelota2.dibujarPelota(Brushes.Aqua);
            this.pelota3.dibujarPelota(Brushes.Black);
            this.vista.getBtnPelota1().Click += new System.EventHandler(this.btnPelota1Click);
            this.vista.getBtnPelota2().Click += new System.EventHandler(this.btnPelota2Click);
            this.vista.getBtnPelota3().Click += new System.EventHandler(this.btnPelota3Click);
            this.vista.getBtnPausar1().Click += new System.EventHandler(this.btnPausar1Click);
            this.vista.getBtnPausar2().Click += new System.EventHandler(this.btnPausar2Click);
            this.vista.getBtnPausar3().Click += new System.EventHandler(this.btnPausar3Click);
            this.vista.getBtnSalir().Click += new System.EventHandler(this.btnSalirClick);
        }

        private void btnPelota1Click(object? sender, EventArgs e)
        {
            this.pelota1.ejecutar();
        }

        private void btnPelota2Click(object? sender, EventArgs e)
        {
            this.pelota2.ejecutar();
        }

        private void btnPelota3Click(object? sender, EventArgs e)
        {
            this.pelota3.ejecutar();
        }

        private void btnPausar1Click(object? sender, EventArgs e)
        {
            this.pelota1.pausar();
        }

        private void btnPausar2Click(object? sender, EventArgs e)
        {
            this.pelota2.pausar();
        }

        private void btnPausar3Click(object? sender, EventArgs e)
        {
            this.pelota3.pausar();
        }

        private void btnSalirClick(object? sender, EventArgs e)
        {
            this.pelota1.finalizar();
            this.vista.Close();
        }
    }
}
