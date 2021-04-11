/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.table.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FlashDrive {
 
    private int id;
    private String brand;
    private int storage;
    private String color;

    public FlashDrive(int id, String brand, int storage, String color) {
        this.id = id;
        this.brand = brand;
        this.storage = storage;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
