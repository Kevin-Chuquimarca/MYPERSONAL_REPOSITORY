/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.brokergrupo05.model;

/**
 *
 * @author santi
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getMessage(String message, String transmitter) {
        System.out.println(name + " ha recibido un mensaje de " + transmitter + ": " + message);
    }
}
