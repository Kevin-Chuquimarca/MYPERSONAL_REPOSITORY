package ec.edu.monster.controlador;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ec.edu.monster.modelo.BancoModelo;

public class BancoControlador {
    private Lock cierreBanco = new ReentrantLock();

    public void acreditarSaldoCuentas(BancoModelo banco, double saldo) {
        double[] cuentasAcreditadas = new double[100];
        for (int i = 0; i < cuentasAcreditadas.length; i++) {
            cuentasAcreditadas[i] = saldo;
        }

        banco.cuentas = cuentasAcreditadas;
    }

    public void transferirEntreCuentas(BancoModelo banco, int cuentaOrigen, int cuentaDestino, double cantidad) {

        cierreBanco.lock();
        try {
            if (banco.cuentas[cuentaOrigen] < cantidad) {
                return;
            }

            banco.cuentas[cuentaOrigen] -= cantidad;
            banco.cuentas[cuentaDestino] += cantidad;

            System.out.println(Thread.currentThread() + "\n");
            System.out.printf("%10.2f de %d para %d\n", cantidad, cuentaOrigen, cuentaDestino);
            System.out.printf("Saldo Total: %10.2f\n", obtenerSaldoTotal(banco));
        } finally {
            cierreBanco.unlock();
        }
    }

    public double obtenerSaldoTotal(BancoModelo banco) {
        double saldoTotal = 0;

        for (double saldo : banco.cuentas) {
            saldoTotal += saldo;
        }

        return saldoTotal;
    }
}
