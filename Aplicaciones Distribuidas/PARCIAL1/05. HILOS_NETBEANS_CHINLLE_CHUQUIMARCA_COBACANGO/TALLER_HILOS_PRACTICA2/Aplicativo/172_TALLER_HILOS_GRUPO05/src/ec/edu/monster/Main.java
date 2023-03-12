package ec.edu.monster;

import ec.edu.monster.controlador.HilosVarios2Controlador;
import ec.edu.monster.controlador.HilosVariosControlador;
import ec.edu.monster.modelo.Hilo2Modelo;
import ec.edu.monster.vista.HilosVista;

/**
 *
 * @author Grupo5
 */
public class Main {

    public static void main(String[] args) {
        HilosVista vista = new HilosVista();
        Hilo2Modelo modelo = new Hilo2Modelo();
        
        HilosVariosControlador hilo1 = new HilosVariosControlador();
        
        modelo.hilo1 = hilo1;
        
        HilosVarios2Controlador hilo2 = new HilosVarios2Controlador(modelo);

        hilo2.start();
        hilo1.start();

        vista.imprimirFinalizado();
    }
}
