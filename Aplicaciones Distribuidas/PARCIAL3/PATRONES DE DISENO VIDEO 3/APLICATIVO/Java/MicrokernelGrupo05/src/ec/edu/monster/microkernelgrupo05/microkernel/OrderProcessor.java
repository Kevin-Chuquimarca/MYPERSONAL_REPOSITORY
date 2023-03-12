/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.microkernelgrupo05.microkernel;

import ec.edu.monster.microkernelgrupo05.model.Order;
import ec.edu.monster.microkernelgrupo05.module.Module;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class OrderProcessor implements MicroKernel {

    private List<Module> modules = new ArrayList<>();

    @Override
    public void addModule(Module module) {
        modules.add(module);
        module.start();
    }

    @Override
    public void removeModule(Module module) {
        modules.remove(module);
        module.stop();
    }

    @Override
    public void processOrders(Order[] orders) {
        for (Module module : modules) {
            module.processOrders(orders);
        }
    }
}
