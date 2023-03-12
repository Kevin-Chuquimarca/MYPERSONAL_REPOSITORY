using _174_TALLER_HILOS_GRUPO05.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _174_TALLER_HILOS_GRUPO05.Controlador
{
    public class TransferenciasControlador
    {
        private BancoModelo _banco;
        private BancoControlador _controller;
        private int _cuentaOrigen;
        private double _valorMaximo;

        public TransferenciasControlador(BancoModelo banco, BancoControlador controller, int cuentaOrigen, double valorMaximo)
        {
            this._banco = banco;
            this._controller = controller;
            this._cuentaOrigen = cuentaOrigen;
            this._valorMaximo = valorMaximo;
        }

        public void run()
        {
            Random random = new Random();
            while (true)
            {
                int cuentaDestino = (int)(random.Next(100));
                double cantidad = random.NextDouble() * this._valorMaximo;
                this._controller.transferirEntreCuentas(this._banco, this._cuentaOrigen, cuentaDestino, cantidad);

                try
                {
                    Thread.Sleep(random.Next(10));
                }
                catch (Exception e)
                {
                    Console.WriteLine(e);
                }
            }
        }

    }
}
