/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.microkernelgrupo05;

import ec.edu.monster.microkernelgrupo05.microkernel.MicroKernel;
import ec.edu.monster.microkernelgrupo05.microkernel.OrderProcessor;
import ec.edu.monster.microkernelgrupo05.model.Order;
import ec.edu.monster.microkernelgrupo05.module.AmazonModule;
import ec.edu.monster.microkernelgrupo05.module.AppleModule;

/**
 *
 * @author santi
 */
public class MicrokernelGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MicroKernel orderProcessor = new OrderProcessor();
        AmazonModule amazonModule = new AmazonModule();
        AppleModule appleModule = new AppleModule();
        Order[] orders = null;
        orderProcessor.addModule(amazonModule);
        orderProcessor.addModule(appleModule);
        orderProcessor.processOrders(orders);
        orderProcessor.removeModule(amazonModule);
        orderProcessor.removeModule(appleModule);
    }

}
