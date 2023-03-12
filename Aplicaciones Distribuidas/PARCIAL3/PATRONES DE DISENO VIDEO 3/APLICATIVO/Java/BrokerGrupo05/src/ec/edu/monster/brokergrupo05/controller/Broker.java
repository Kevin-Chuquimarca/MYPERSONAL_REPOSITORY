/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.brokergrupo05.controller;

import ec.edu.monster.brokergrupo05.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author santi
 */
public class Broker {

    private Map<String, User> usuarios;

    public Broker() {
        this.usuarios = new HashMap<>();
    }

    public void addUser(User usuario) {
        usuarios.put(usuario.getName(), usuario);
    }

    public void deleteUser(User usuario) {
        usuarios.remove(usuario.getName());
    }

    public void sendUser(String message, String transmitter, String receptor) {
        User receptorUser = usuarios.get(receptor);
        if (receptorUser != null) {
            receptorUser.getMessage(message, transmitter);
        }
    }
}
