/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pizarragrupo05.view;

import ec.edu.monster.pizarragrupo05.model.OrderModel;
import ec.edu.monster.pizarragrupo05.model.Order;
import ec.edu.monster.pizarragrupo05.model.Product;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class OrderView {
    private OrderModel model;

    public OrderView(OrderModel model) {
        this.model = model;
    }

    public void displayProducts() {
        List<Product> products = model.getProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Order getNewOrderFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String customerName = scanner.nextLine();
        System.out.println("Ingrese el nombre del producto:");
        String productName = scanner.nextLine();
        System.out.println("Ingrese la cantidad:");
        int quantity = scanner.nextInt();
        return new Order(customerName, productName, quantity);
    }

    public void displayOrders() {
        List<Order> orders = model.getOrders();
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }
}

