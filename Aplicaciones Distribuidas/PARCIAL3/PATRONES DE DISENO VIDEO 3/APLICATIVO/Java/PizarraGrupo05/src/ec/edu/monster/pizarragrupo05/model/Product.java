/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pizarragrupo05.model;

/**
 *
 * @author santi
 */
public class Product {

    private String name;
    private double price;

    public Product(String product, double par) {
        this.name = product;
        this.price = par;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto{" + "Nombre producto=" + name + ", precio=" + price + '}';
    }
}
