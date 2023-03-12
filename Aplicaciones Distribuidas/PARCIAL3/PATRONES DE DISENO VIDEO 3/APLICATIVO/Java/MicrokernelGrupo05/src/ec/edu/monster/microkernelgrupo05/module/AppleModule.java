/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.microkernelgrupo05.module;

import ec.edu.monster.microkernelgrupo05.model.Order;

/**
 *
 * @author santi
 */
public class AppleModule implements Module {

    @Override
    public void start() {
        System.out.println("Iniciando modulo de tienda Apple");
    }

    @Override
    public void stop() {
        System.out.println("Deteniendo modulo de tienda Apple");
    }

    @Override
    public void processOrders(Order[] orders) {
        System.out.println("Procesando las ordenes en la tienda Apple");
    }

}
