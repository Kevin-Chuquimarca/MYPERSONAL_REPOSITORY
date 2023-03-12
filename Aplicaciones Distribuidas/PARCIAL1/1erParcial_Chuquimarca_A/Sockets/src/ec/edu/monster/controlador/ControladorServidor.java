/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ModeloServidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class ControladorServidor {

    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream input;
    private DataOutputStream output;
    private String messageReceived;

    Scanner scanner = new Scanner(System.in);
    ModeloServidor modeloServidor = new ModeloServidor();

    public void initServer() {
        try {
            serverSocket = new ServerSocket(modeloServidor.getPort());
            socket = new Socket();
            System.out.println("Esperando la conexion");
            socket = serverSocket.accept();
            System.out.println("Cliente conectado");
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            String message = "";
            while (!message.equals("x")) {
                messageReceived = input.readUTF();
                System.out.println("Cliente: " + messageReceived);
                output.writeUTF("" + messageReceived);
            }
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

}
