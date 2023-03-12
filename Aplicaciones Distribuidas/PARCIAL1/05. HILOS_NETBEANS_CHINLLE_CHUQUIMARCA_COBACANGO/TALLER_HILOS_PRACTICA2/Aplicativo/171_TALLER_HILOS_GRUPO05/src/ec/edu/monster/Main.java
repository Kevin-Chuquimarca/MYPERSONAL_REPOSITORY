package ec.edu.monster;

import ec.edu.monster.controlador.HilosVariosControlador;

/**
 *
 * @author Grupo5
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HilosVariosControlador hilo1 = new HilosVariosControlador();
        HilosVariosControlador hilo2 = new HilosVariosControlador();

        hilo1.start();

        try {
            hilo1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        hilo2.start();

        try {
            hilo2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Terminadas las tareas...");
    }
}
