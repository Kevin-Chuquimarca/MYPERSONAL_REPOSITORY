using _178_TALLER_HILOS_GRUPO05.Controlador;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _178_TALLER_HILOS_GRUPO05.Vista
{
    public partial class BancoVista : Form
    {
        public BancoVista()
        {
            InitializeComponent();
        }

        private void txtPrint_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnEmpezar_Click(object sender, EventArgs e)
        {
            BancoControlador controlador = new BancoControlador(txtPrint);
            controlador.CrearBanco();
            controlador.Transacciones();
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
