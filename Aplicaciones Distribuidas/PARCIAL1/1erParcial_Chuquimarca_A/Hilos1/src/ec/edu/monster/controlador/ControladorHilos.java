package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Filosofo;
import ec.edu.monster.modelo.Tenedor;
import ec.edu.monster.modelo.PorteroComedor;

/**
 *
 * @author santi
 */
public class ControladorHilos {

    private int numFilosofos;

    public ControladorHilos(int numFilosofos) {
        this.numFilosofos = numFilosofos;
        Tenedor[] tenedor = new Tenedor[numFilosofos];
        Filosofo[] filosofo = new Filosofo[numFilosofos];
        PorteroComedor comensal = new PorteroComedor(numFilosofos);
        ExepcionesPersonalizadas manejador = new ExepcionesPersonalizadas();

        for (int i = 0; i < tenedor.length; i++) {
            tenedor[i] = new Tenedor(i);
        }

        for (int i = 0; i < filosofo.length; i++) {
            filosofo[i] = new Filosofo(i, tenedor[i], tenedor[(i + 1) % 5], comensal);
        }

        for (int i = 0; i < filosofo.length; i++) {
            filosofo[i].setUncaughtExceptionHandler(manejador);
            filosofo[i].start();
        }
    }

}
