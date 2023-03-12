package ec.edu.monster.modelo;

import java.util.Random;

/**
 *
 * @author santi
 */
public class Filosofo extends Thread {

    private Random random = new Random();
    private int id;
    private Tenedor izqda, dcha;
    private PorteroComedor comensal;
    public static boolean finalizado = false;

    public Filosofo(int id, Tenedor dcha, Tenedor izqda, PorteroComedor comensal) {
        this.id = id;
        this.dcha = dcha;
        this.izqda = izqda;
        this.comensal = comensal;
    }

    @Override
    public void run() {
        while (true) {

            try {
                comensal.cogerComensal(id);
                dcha.cogerTenedor(id);
                if (!izqda.cogerTenedorIzqdo(id)) {
                    System.out.println("El Filósofo " + (id + 1) + " tendrá que dejar el tenedor " + (id + 1) + " por exceso de tiempo y salir a pensar.");
                    dcha.soltarTenedor(id);
                    comensal.soltarComensal(id);
                    System.out.println("Filósofo " + (id + 1) + " pensando.");
                    try {
                        Filosofo.sleep(random.nextInt(1000) + 100);
                    } catch (InterruptedException ex) {
                        System.out.println("Error: " + ex.toString());
                    }
                    continue; // Se vuelve a poner en la casilla de salida y volver a obtener el comensal.
                }
                System.out.println("Filósofo " + (id + 1) + " comiendo.");
                try {
                    sleep(random.nextInt(1000) + 500);
                } catch (InterruptedException ex) {
                    System.out.println("Error: " + ex.toString());
                }
                izqda.soltarTenedor(id);
                dcha.soltarTenedor(id);
                comensal.soltarComensal(id);
                System.out.println("Filósofo " + (id + 1) + " pensando.");
                try {
                    Filosofo.sleep(random.nextInt(1000) + 100);
                } catch (InterruptedException ex) {
                    System.out.println("Error: " + ex.toString());
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.toString());
            }
            if (finalizado) {
                break;
            }
        }  
        System.out.println("La cena terminado para todos, el Filósofo " + (id + 1) + " se ha puesto a pensar.");
    }
}
