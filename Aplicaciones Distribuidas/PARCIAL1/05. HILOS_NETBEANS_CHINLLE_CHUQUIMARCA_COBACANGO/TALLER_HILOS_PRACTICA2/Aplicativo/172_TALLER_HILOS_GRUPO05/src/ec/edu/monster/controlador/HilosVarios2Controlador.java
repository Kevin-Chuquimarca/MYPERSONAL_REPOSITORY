package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Hilo2Modelo;
import ec.edu.monster.vista.HilosVista;

public class HilosVarios2Controlador extends Thread {
    private Hilo2Modelo hiloModel;

    public HilosVarios2Controlador(Hilo2Modelo hiloModel) {
        this.hiloModel = hiloModel;
    }

    public void run() {
        HilosVista vista = new HilosVista();
        try {
            hiloModel.hilo1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            vista.imprimirInfoHilo(getName());
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
