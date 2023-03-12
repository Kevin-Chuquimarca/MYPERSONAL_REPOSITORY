/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.monster.microkernelgrupo05.microkernel;

import ec.edu.monster.microkernelgrupo05.model.Order;
import ec.edu.monster.microkernelgrupo05.module.Module;

/**
 *
 * @author santi
 */
public interface MicroKernel {

    void addModule(Module module);

    void removeModule(Module module);

    void processOrders(Order[] orders);
}
