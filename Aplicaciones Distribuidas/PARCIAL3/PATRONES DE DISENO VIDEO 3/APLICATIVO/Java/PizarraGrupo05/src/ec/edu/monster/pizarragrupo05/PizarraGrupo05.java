/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.pizarragrupo05;

import ec.edu.monster.pizarragrupo05.controller.OrderController;
import ec.edu.monster.pizarragrupo05.model.Customer;
import ec.edu.monster.pizarragrupo05.model.OrderModel;
import ec.edu.monster.pizarragrupo05.model.Product;
import ec.edu.monster.pizarragrupo05.view.OrderView;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class PizarraGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderModel model = new OrderModel();
        OrderView view = new OrderView(model);
        OrderController controller = new OrderController(model, view);

        controller.addProduct(new Product("Producto A", 10.0));
        controller.addProduct(new Product("Producto B", 20.0));
        controller.addProduct(new Product("Producto C", 30.0));

        controller.createOrder();
    }

}
