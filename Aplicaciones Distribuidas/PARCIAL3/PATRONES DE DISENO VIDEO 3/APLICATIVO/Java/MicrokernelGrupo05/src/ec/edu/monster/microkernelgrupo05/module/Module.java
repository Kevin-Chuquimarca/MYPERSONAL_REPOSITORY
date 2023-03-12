/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.monster.microkernelgrupo05.module;

import ec.edu.monster.microkernelgrupo05.model.Order;

/**
 *
 * @author santi
 */
public interface Module {

    public void start();

    public void stop();

    public void processOrders(Order[] orders);
}
