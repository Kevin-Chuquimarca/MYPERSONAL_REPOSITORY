package ec.edu.monster.controlador;


/**
 *
 * @author santi
 */
//manejo de las excepciones provocadas por la ejecución de los hilos
public class ExepcionesPersonalizadas implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Hilo que lanzó la excepción: %s \n", t.getName());
        e.printStackTrace();         //muestra en consola el hilo que produce la exceción
    }

}
