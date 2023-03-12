using _168_TALLER_HILOS_GRUPO05.modelo;
using _168_TALLER_HILOS_GRUPO05.vista;

namespace _168_TALLER_HILOS_GRUPO05.controlador
{
    internal class PelotaControlador
    {
        private PelotaModelo pelota1 = new PelotaModelo("pelota1", 10, 10);
        private PelotaVista vista;

        public PelotaControlador(PelotaVista vista)
        {
            this.vista = vista;
            this.vista.getPnlPelotas().Controls.Add(this.pelota1);
            this.pelota1.dibujarPelota(Brushes.White);
            this.vista.getBtnDale().Click += new System.EventHandler(this.btnDaleClick);
            this.vista.getBtnSalir().Click += new System.EventHandler(this.btnSalirClick);
        }

        private void btnDaleClick(object? sender, EventArgs e)
        {
            this.pelota1.ejecutar();
        }

        private void btnSalirClick(object? sender, EventArgs e)
        {
            this.pelota1.finalizar();
            this.vista.Close();
        }
    }
}
