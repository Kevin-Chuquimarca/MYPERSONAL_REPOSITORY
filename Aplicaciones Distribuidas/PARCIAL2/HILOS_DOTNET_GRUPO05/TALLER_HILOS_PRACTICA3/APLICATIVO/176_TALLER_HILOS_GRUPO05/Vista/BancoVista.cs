using _176_TALLER_HILOS_GRUPO05.Modelo;
using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _176_TALLER_HILOS_GRUPO05.Vista
{
    public class BancoVista
    {
        public void imprimirErrorTransferencia(BancoModelo banco, int cuentaOrigen, double cantidad)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("Fondos Insuficientes!!!\n");
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("\tCuenta: " + cuentaOrigen.ToString("0.##"));
            Console.WriteLine("\tSaldo: " + banco.cuentas[cuentaOrigen].ToString("0.##"));
            Console.WriteLine("\tCantidad: " + cantidad.ToString("0.##"));
        }

        public void imprimirTranserenciaExito(int cuentaOrigen)
        {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Transferencia realizada\n");
            Console.WriteLine("\tCuenta: " + cuentaOrigen);
        }

        public void imprimirDetallesTransferencia(
            BancoModelo banco,
            int cuentaOrigen,
            int cuentaDestino,
            double cantidad,
            double saldoTotal
        )
        {
            Console.WriteLine(Thread.CurrentThread.ManagedThreadId + "\n");
            Console.WriteLine(cantidad.ToString("0.##") + " de " + cuentaOrigen + " para " + cuentaDestino);
        }
    }
}
