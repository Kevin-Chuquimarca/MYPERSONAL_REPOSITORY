package ec.edu.monster.controlador;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ec.edu.monster.modelo.BancoModelo;
import ec.edu.monster.vista.BancoVista;

public class BancoControlador {
    private Condition tieneSaldoSuficiente;
    private Lock cierreBanco = new ReentrantLock();
    private BancoVista bancoView = new BancoVista();

    public void acreditarSaldoCuentas(BancoModelo banco, double saldo) {
        double[] cuentasAcreditadas = new double[100];
        for (int i = 0; i < cuentasAcreditadas.length; i++) {
            cuentasAcreditadas[i] = saldo;
        }

        banco.cuentas = cuentasAcreditadas;
        tieneSaldoSuficiente = cierreBanco.newCondition();
    }

    public void transferirEntreCuentas(BancoModelo banco, int cuentaOrigen, int cuentaDestino, double cantidad)
        throws InterruptedException {

        cierreBanco.lock();
        try {
            while (banco.cuentas[cuentaOrigen] < cantidad) {
                tieneSaldoSuficiente.await();
            }

            bancoView.imprimirTranserenciaExito(cuentaOrigen);
            banco.cuentas[cuentaOrigen] -= cantidad;
            banco.cuentas[cuentaDestino] += cantidad;

            bancoView.imprimirDetallesTransferencia(banco, cuentaOrigen, cuentaDestino, cantidad,
                    obtenerSaldoTotal(banco));
            
            tieneSaldoSuficiente.signalAll();
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
