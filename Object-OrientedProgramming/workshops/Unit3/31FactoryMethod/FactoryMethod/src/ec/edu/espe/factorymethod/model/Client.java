/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.factorymethod.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Client {
    
    public static void main(String[] args) {
        System.out.println("kevin Chuquimarca --> Factory Method");
        Factory factory;
        factory = new FactoryOne();
        Connection connection = factory.createConnection("Oracle");
        System.out.println("You are connecting with " + connection.description());
    }
}
