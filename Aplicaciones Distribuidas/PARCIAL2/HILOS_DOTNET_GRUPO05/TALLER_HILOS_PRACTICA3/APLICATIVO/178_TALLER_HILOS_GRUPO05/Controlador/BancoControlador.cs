using _178_TALLER_HILOS_GRUPO05.Modelo;
using _178_TALLER_HILOS_GRUPO05.Vista;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _178_TALLER_HILOS_GRUPO05.Controlador
{
    public class BancoControlador
    {

        public string campo = "";
        BancoModelo banco = new BancoModelo(200000, 100, 2000);
        double[] cuentas = new double[100];
        System.Windows.Forms.TextBox txtCampo;

        public BancoControlador(System.Windows.Forms.TextBox txtCampo)
        {
            this.txtCampo = txtCampo;
        }

        public void CrearBanco()
        {
            for (int i = 0; i < 100; i++)
            {
                cuentas[i] = 2000;
            }
        }
        public string RealizarTransaccion()
        {
            Thread t = new Thread(Transaccion);
            t.Start();
            t.Join();
            double cantidad = 0;
            Random random = new Random();
            cantidad = random.NextDouble() * (0 - (banco.cantMaxima)) + (banco.cantMaxima);
            int deCuenta = (int)random.Next(1, 100);
            int paraLaCuenta = (int)random.Next(1, 100);
            cuentas[deCuenta] -= cantidad;
            cuentas[paraLaCuenta] += cantidad;

            return "Ejecutando el hilo : " + t.ManagedThreadId + String.Format(Environment.NewLine) + cantidad.ToString("0.##") + " de: " + deCuenta + " para: " + paraLaCuenta + String.Format(Environment.NewLine) + String.Format(Environment.NewLine);
        }

        public async void Transacciones()
        {
            while (true)
            {
                string transaccion = RealizarTransaccion();
                string total = banco.getSaldoTotal(cuentas);
                this.txtCampo.Text += transaccion + total;
                await Task.Delay(50);
            }
        }

        public void Transaccion()
        {
            string total = banco.getSaldoTotal(cuentas);
        }
    }
}
