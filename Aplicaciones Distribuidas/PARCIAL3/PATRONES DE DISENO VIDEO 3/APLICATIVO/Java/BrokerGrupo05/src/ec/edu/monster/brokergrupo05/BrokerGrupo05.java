/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.brokergrupo05;

import ec.edu.monster.brokergrupo05.model.User;
import ec.edu.monster.brokergrupo05.controller.Broker;

/**
 *
 * @author santi
 */
public class BrokerGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Broker broker = new Broker();

        User juan = new User("Juan");
        User maria = new User("Maria");

        broker.addUser(juan);
        broker.addUser(maria);

        broker.sendUser("Hola Maria, ¿cómo estás?", "Juan", "Maria");
        broker.sendUser("Bien, gracias. ¿Y tú?", "Maria", "Juan");

        broker.deleteUser(juan);
        broker.deleteUser(maria);
    }

}
