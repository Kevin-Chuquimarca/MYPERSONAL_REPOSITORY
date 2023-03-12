package ec.edu.monster.modelo;

/**
 *
 * @author santi
 */
public class PorteroComedor {

    private int comensal; 

    public PorteroComedor(int comensal) {
        this.comensal = comensal - 1; // número de comensales total de filósofos menos 1
    }
//    Monitor para coger un comensal y poder seguir el proceso de ejecución de los filósofos.

    public synchronized void cogerComensal(int id_f) throws InterruptedException {
        while (comensal == 0) {
            this.wait();
        }
        System.out.println("El Filósofo " + (id_f + 1) + " es el comensal " + comensal);
        comensal--;
    }

    public synchronized void soltarComensal(int id_f) throws InterruptedException {
        comensal++;
        System.out.println("El Filósofo " + (id_f + 1) + " ya no es el comensal " + comensal);
        this.notify(); 
    }
}
