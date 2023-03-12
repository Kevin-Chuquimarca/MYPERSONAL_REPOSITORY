package ec.edu.monster.modelo;

import java.util.Random;

/**
 *
 * @author santi
 */
public class Tenedor {
// Recurso compratido por los hilos Filósofos, Se crean 5 instancias con n-1
// comensales donde n es el número de filósofos con el total de los tenedores, 
// cada filósofo le corresponde 2 tenedores.

    private Random random = new Random();
    private int id;
    private boolean libre = true;

    public Tenedor(int id) {
        this.id = id;
    }

    public synchronized void cogerTenedor(int id_f) throws InterruptedException {
        while (!libre) {
            this.wait();
        }
        System.out.println("El Filósofo " + (id_f + 1) + " coge el tenedor " + (id + 1));
        libre = false;
    }

    public synchronized boolean cogerTenedorIzqdo(int id_f) throws InterruptedException {
        while (!libre) {
            this.wait(random.nextInt(1000) + 500); // Sólo espera aleatoriamente entre 0.5 y 1 seg y si no, retorna false
            return false;
        }
        System.out.println("El Filósofo " + (id_f + 1) + " agarra el tenedor " + (id + 1));
        libre = false;
        return true;
    }

    public synchronized void soltarTenedor(int id_f) throws InterruptedException {
        libre = true;
        System.out.println("El Filósofo " + (id_f + 1) + " deja el tenedor " + (id + 1));
        this.notify();
    }
}
