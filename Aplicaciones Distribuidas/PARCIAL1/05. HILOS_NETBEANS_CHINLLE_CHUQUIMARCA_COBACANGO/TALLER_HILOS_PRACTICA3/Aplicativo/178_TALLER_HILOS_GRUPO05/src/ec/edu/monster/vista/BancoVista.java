package ec.edu.monster.vista;

import ec.edu.monster.modelo.BancoModelo;

public class BancoVista {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void imprimirErrorTransferencia(BancoModelo banco, int cuentaOrigen, double cantidad) {
        System.out.println(ANSI_RED + "Fondos Insuficientes!!!\n" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "\tCuenta: " + ANSI_RESET + cuentaOrigen);
        System.out.println(ANSI_BLUE + "\tSaldo: " + ANSI_RESET + banco.cuentas[cuentaOrigen]);
        System.out.println(ANSI_BLUE + "\tCantidad: " + ANSI_RESET + cantidad);
    }

    public void imprimirTranserenciaExito(int cuentaOrigen) {
        System.out.println(ANSI_GREEN + "Transferencia realizada\n" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "\tCuenta: " + ANSI_RESET + cuentaOrigen);
    }

    public void imprimirDetallesTransferencia(
            BancoModelo banco,
            int cuentaOrigen,
            int cuentaDestino,
            double cantidad,
            double saldoTotal
    ) {
        System.out.println(Thread.currentThread() + "\n");
        System.out.printf("%10.2f de %d para %d\n", cantidad, cuentaOrigen, cuentaDestino);
        System.out.printf(ANSI_BLUE + "Saldo Total:" + ANSI_RESET + "%10.2f\n", saldoTotal);
    }
}