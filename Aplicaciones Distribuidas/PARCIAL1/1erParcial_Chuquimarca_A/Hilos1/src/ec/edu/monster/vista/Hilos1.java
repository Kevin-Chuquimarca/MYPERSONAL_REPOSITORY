package ec.edu.monster.vista;

import ec.edu.monster.controlador.ControladorHilos;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class Hilos1 {

    public static void main(String[] args) {
        int numFilosofos = 0;
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese el numero de filósos: ");
        numFilosofos = read.nextInt();
        ControladorHilos principal = new ControladorHilos(numFilosofos);
    }

}
