/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.shoessales.view;

import ec.edu.espe.taxilibrary.Tax;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class POO6382ShoeSales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Kevin Chuquimarca -> 14Libraries");
        float price = 0;
        float totalPrice = 0;
        float ivaPercentage = 12;
        price = -10;
        totalPrice = Tax.computeTotalIva(price, ivaPercentage);
        System.out.println("the total price of -> " + price + " <-- is " 
                + totalPrice);
    }
    
}
