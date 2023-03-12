package ec.edu.monster.controlador;

public class HilosVariosControlador extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ejecutando hilo..." + getName());
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
