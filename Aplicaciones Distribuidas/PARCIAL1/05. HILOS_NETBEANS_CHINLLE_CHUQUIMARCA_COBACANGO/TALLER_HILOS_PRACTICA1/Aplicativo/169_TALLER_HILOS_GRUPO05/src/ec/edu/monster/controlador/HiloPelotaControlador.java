package ec.edu.monster.controlador;

import java.awt.Component;

import ec.edu.monster.modelo.PelotaModelo;

public class HiloPelotaControlador implements Runnable {
    public PelotaModelo pelota;
    public PelotaControlador pelotaController;
    public Component componente;

    public HiloPelotaControlador(PelotaModelo pelota, PelotaControlador pelotaController, Component componente) {
        this.pelota = pelota;
        this.pelotaController = pelotaController;
        this.componente = componente;
    }

    @Override
    public void run() {
        System.out.println("El hilo está corriendo!");
        while (!Thread.currentThread().isInterrupted()) {
            pelotaController.moverPelota(componente.getBounds(), pelota);
            componente.paint(componente.getGraphics());
        }
        System.out.println("El hilo ya no está corriendo!!! :c");
    }
}
