package ec.edu.monster.controlador;

import ec.edu.monster.modelo.BancoModelo;

public class BancoControlador {
    public void acreditarSaldoCuentas(BancoModelo banco, double saldo) {
        double[] cuentasAcreditadas = new double[100];
        for (int i = 0; i < cuentasAcreditadas.length; i++) {
            cuentasAcreditadas[i] = saldo;
        }

        banco.cuentas = cuentasAcreditadas;
    }

    public void transferirEntreCuentas(BancoModelo banco, int cuentaOrigen, int cuentaDestino, double cantidad) {
        if (banco.cuentas[cuentaOrigen] < cantidad) {
            return;
        }

        System.out.println(Thread.currentThread());

        banco.cuentas[cuentaOrigen] -= cantidad;

        System.out.printf("%10.2f de %d para %d\n", cantidad, cuentaOrigen, cuentaDestino);

        banco.cuentas[cuentaDestino] += cantidad;

        System.out.printf("Saldo Total: %10.2f\n", obtenerSaldoTotal(banco));
    }

    public double obtenerSaldoTotal(BancoModelo banco) {
        double saldoTotal = 0;

        for (double saldo : banco.cuentas) {
            saldoTotal += saldo;
        }

        return saldoTotal;
    }
}
