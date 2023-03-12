/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ModeloCliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class ControladorCliente {

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private String messageReceived;

    Scanner scanner = new Scanner(System.in);
    ModeloCliente modeloCliente = new ModeloCliente();

    public void initClient() {
        try {
            socket = new Socket(modeloCliente.getHost(), modeloCliente.getPort());
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            String message = "";
            while (!message.equals("x")) {
                System.out.print("Ingrese el mensaje que desea enviar: ");
                message = scanner.nextLine();
                output.writeUTF(message);
                messageReceived = input.readUTF();
                System.out.println("Mensaje recibido del servidor: " + messageReceived);
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
