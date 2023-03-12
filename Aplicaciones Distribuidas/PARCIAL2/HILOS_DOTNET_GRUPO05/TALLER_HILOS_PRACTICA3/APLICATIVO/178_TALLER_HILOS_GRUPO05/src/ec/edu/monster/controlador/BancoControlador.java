package ec.edu.monster.controlador;

import ec.edu.monster.modelo.BancoModelo;
import ec.edu.monster.vista.BancoVista;

public class BancoControlador {
    private BancoVista bancoView = new BancoVista();

    public void acreditarSaldoCuentas(BancoModelo banco, double saldo) {
        double[] cuentasAcreditadas = new double[100];
        for (int i = 0; i < cuentasAcreditadas.length; i++) {
            cuentasAcreditadas[i] = saldo;
        }

        banco.cuentas = cuentasAcreditadas;
    }

    public synchronized void transferirEntreCuentas(BancoModelo banco, int cuentaOrigen, int cuentaDestino, double cantidad)
        throws InterruptedException {

        while (banco.cuentas[cuentaOrigen] < cantidad) {
            wait();
        }

        bancoView.imprimirTranserenciaExito(cuentaOrigen);
        banco.cuentas[cuentaOrigen] -= cantidad;
        banco.cuentas[cuentaDestino] += cantidad;

        bancoView.imprimirDetallesTransferencia(banco, cuentaOrigen, cuentaDestino, cantidad,
                obtenerSaldoTotal(banco));

        notifyAll();
    }

    public double obtenerSaldoTotal(BancoModelo banco) {
        double saldoTotal = 0;

        for (double saldo : banco.cuentas) {
            saldoTotal += saldo;
        }

        return saldoTotal;
    }
}
