package ec.edu.monster.controlador;

import ec.edu.monster.modelo.BancoModelo;

public class TransferenciasControlador implements Runnable {
    private BancoModelo _banco;
    private BancoControlador _controller;
    private int _cuentaOrigen;
    private double _valorMaximo;

    public TransferenciasControlador(BancoModelo banco, BancoControlador controller, int cuentaOrigen, double valorMaximo) {
        this._banco = banco;
        this._controller = controller;
        this._cuentaOrigen = cuentaOrigen;
        this._valorMaximo = valorMaximo;
    }

    @Override
    public void run() {
        while (true) {
            int cuentaDestino = (int) (100 * Math.random());
            double cantidad = this._valorMaximo * Math.random();
            try {
                this._controller.transferirEntreCuentas(
                    this._banco,
                    this._cuentaOrigen, 
                    cuentaDestino,
                    cantidad
                );
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
