using _176_TALLER_HILOS_GRUPO05.Modelo;
using _176_TALLER_HILOS_GRUPO05.Vista;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _176_TALLER_HILOS_GRUPO05.Controlador
{
    public class BancoControlador
    {
        private Object cierreBanco = new Object();
        private BancoVista bancoView = new BancoVista();

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
            lock (cierreBanco)
            {
                if (banco.cuentas[cuentaOrigen] < cantidad)
                {
                    bancoView.imprimirErrorTransferencia(banco, cuentaOrigen, cantidad);
                    return;
                }
                bancoView.imprimirTranserenciaExito(cuentaOrigen);

                banco.cuentas[cuentaOrigen] -= cantidad;
                banco.cuentas[cuentaDestino] += cantidad;
            
                bancoView.imprimirDetallesTransferencia(banco, cuentaOrigen, cuentaDestino, cantidad, obtenerSaldoTotal(banco));
            }
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
