/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pizarragrupo05.controller;

import ec.edu.monster.pizarragrupo05.view.OrderView;
import ec.edu.monster.pizarragrupo05.model.Customer;
import ec.edu.monster.pizarragrupo05.model.Order;
import ec.edu.monster.pizarragrupo05.model.OrderModel;
import ec.edu.monster.pizarragrupo05.model.Product;


/**
 *
 * @author santi
 */
public class OrderController {
    private OrderModel model;
    private OrderView view;

    public OrderController(OrderModel model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    public void createOrder() {
        view.displayProducts();
        Order order = view.getNewOrderFromUser();
        model.addOrder(order);
        view.displayOrders();
    }

    public void addProduct(Product product) {
        model.addProduct(product);
    }

    public void addCustomer(Customer customer) {
        model.addCustomer(customer);
    }
}
