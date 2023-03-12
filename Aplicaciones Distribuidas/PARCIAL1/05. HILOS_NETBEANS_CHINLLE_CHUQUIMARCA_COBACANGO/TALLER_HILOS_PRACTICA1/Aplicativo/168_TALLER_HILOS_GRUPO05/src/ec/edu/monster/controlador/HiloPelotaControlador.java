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
        for (int i = 0; i < 3000; i++) {
            pelotaController.moverPelota(componente.getBounds(), pelota);
            componente.paint(componente.getGraphics());

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
            }
        }
        
    }
}
