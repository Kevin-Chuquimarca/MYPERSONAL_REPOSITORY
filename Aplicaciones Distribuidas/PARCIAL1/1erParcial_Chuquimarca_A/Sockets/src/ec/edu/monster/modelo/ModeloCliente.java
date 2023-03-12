/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

/**
 *
 * @author santi
 */
public class ModeloCliente {

    private String ip = "10.140.185.66";
    private int port = 7;

    public ModeloCliente() {
    }

    public String getHost() {
        return ip;
    }

    public void setHost(String host) {
        this.ip = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
