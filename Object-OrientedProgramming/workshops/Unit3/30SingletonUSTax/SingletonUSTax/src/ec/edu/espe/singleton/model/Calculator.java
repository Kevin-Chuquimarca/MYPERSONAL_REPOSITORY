/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.singleton.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> Singleton USTax");
        float price = 10F;
        
        USTax tax = USTax.geInstance();
        //tax.salesTotal();
        
        System.out.println("tax percentage --> " + tax.getSingletonData());
        System.out.println("price (tax) --> 1.2" + price*tax.getSingletonData()/100);
        System.out.println("total price --> 11.2" + tax.salesTotal(price));
        
       
    }
}
