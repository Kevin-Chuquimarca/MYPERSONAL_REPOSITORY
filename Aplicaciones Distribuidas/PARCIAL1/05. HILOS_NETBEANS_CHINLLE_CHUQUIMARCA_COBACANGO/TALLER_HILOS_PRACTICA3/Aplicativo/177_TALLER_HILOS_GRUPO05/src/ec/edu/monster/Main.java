package ec.edu.monster;

import ec.edu.monster.controlador.BancoControlador;
import ec.edu.monster.controlador.TransferenciasControlador;
import ec.edu.monster.modelo.BancoModelo;

/**
 *
 * @author Grupo5
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoModelo banco = new BancoModelo();
        BancoControlador controller = new BancoControlador();

        controller.acreditarSaldoCuentas(banco, 2000);

        for (int i = 0; i < 10; i++) {
            TransferenciasControlador transferencias 
                    = new TransferenciasControlador(banco, controller, i, 2000);
            new Thread(transferencias).start();
        }
    }
}
