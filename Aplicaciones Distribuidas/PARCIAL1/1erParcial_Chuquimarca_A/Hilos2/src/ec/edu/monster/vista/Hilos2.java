package ec.edu.monster.vista;

import ec.edu.monster.controlador.ControlLlegada;
import ec.edu.monster.modelo.Usuario;
import java.util.Scanner;

/**
 *
 * @author santi
 */
import java.util.*;

public class Hilos2 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Scanner dato = new Scanner(System.in);
        String n, d;
        double h;
        System.out.println("Ingrese el nombre del empleado :");
        n = dato.next();
        System.out.println("Ingrese el dia :");
        d = dato.next();
        System.out.println("Ingrese la hora :");
        h = dato.nextDouble();
        Usuario usuario1 = new Usuario(n, d, h);
        ControlLlegada clUsuario1 = new ControlLlegada(usuario1);
        clUsuario1.start();
        
        Thread.sleep(3000);
        
        System.out.println("Ingrese el nombre del empleado :");
        n = dato.next();
        System.out.println("Ingrese el dia :");
        d = dato.next();
        System.out.println("Ingrese la hora :");
        h = dato.nextDouble();
        Usuario usuario2 = new Usuario(n, d, h);
        ControlLlegada clUsuario2 = new ControlLlegada(usuario2);
        clUsuario2.start();
    }
}
