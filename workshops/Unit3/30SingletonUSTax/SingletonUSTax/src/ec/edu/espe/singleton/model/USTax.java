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
public class USTax {

    private static USTax instance;
    private float taxPercentage;

    private USTax(){
        this.taxPercentage = 12F;
    }

    public static USTax geInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }
    
    public float getSingletonData(){
        return taxPercentage;
    }

    public float salesTotal(float price) {
        return price*getSingletonData()/100 + price;
    }
}
