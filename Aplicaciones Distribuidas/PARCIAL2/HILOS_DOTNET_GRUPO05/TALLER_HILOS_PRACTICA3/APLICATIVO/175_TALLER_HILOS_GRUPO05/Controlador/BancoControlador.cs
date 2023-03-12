using _175_TALLER_HILOS_GRUPO05.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _175_TALLER_HILOS_GRUPO05.Controlador
{
    public class BancoControlador
    {
        public void acreditarSaldoCuentas(BancoModelo banco, double saldo)
        {
            double[] cuentasAcreditadas = new double[100];
            for (int i = 0; i < cuentasAcreditadas.Length; i++)
            {
                cuentasAcreditadas[i] = saldo;
            }
            banco.cuentas = cuentasAcreditadas;
        }

        public void transferirEntreCuentas(BancoModelo banco, int cuentaOrigen, int cuentaDestino, double cantidad)
        {
            if (banco.cuentas[cuentaOrigen] < cantidad)
            {
                return;
            }

            Console.WriteLine(Thread.CurrentThread.ManagedThreadId);
            banco.cuentas[cuentaOrigen] -= cantidad;
            Console.WriteLine(cantidad.ToString("0.##") + " de " + cuentaOrigen + " para " + cuentaDestino);
            banco.cuentas[cuentaDestino] += cantidad;
            Console.WriteLine("Saldo Total: " + obtenerSaldoTotal(banco));
        }

        public double obtenerSaldoTotal(BancoModelo banco)
        {
            double saldoTotal = 0;
            foreach (double saldo in banco.cuentas)
            {
                saldoTotal += saldo;
            }
            return saldoTotal;
        }
    }
}
