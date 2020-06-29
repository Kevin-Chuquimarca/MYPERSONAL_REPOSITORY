/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.encrypted.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class CustomerKey {
    private String nameCustomer;
    private String keyCustomer;

    public CustomerKey(String nameCustomer, String keyCustomer) {
        this.nameCustomer = nameCustomer;
        this.keyCustomer = keyCustomer;
    }

    @Override
    public String toString() {
        return nameCustomer + "," + keyCustomer;
    }
}
