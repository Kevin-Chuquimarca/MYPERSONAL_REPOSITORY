using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _178_TALLER_HILOS_GRUPO05.Modelo
{
    public class BancoModelo
    {
        public double saldoTotal { get; set; }
        public int numeroCuentas { get; set; }
        public double cantMaxima { get; set; }

        public BancoModelo(double saldo, int ncuentas, double cantMaxima)
        {
            this.numeroCuentas = ncuentas;
            this.saldoTotal = saldo;
            this.cantMaxima = cantMaxima;
        }

        public string getSaldoTotal(double[] cuentas)
        {
            double suma_cuentas = 0;
            for (int i = 0; i < numeroCuentas; i++)
            {
                suma_cuentas += cuentas[i];
            }
            return "Saldo total: " + suma_cuentas + String.Format(Environment.NewLine);
        }
    }
}
