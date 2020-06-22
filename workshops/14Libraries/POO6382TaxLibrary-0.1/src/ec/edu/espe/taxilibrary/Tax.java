/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * CopyrightESPE-DECC
 */
package ec.edu.espe.taxilibrary;

/**
 * <h1>This is kevin Chuquimarca Tax class</h1>
 * Computes the different taxes that we have in Ecuador
 * 
 * @author Kevin Chuquimarca ESPE-DCCO
 * @version 0.1
 * @since 2020-06-22
 */
public class Tax {

    
    /**
     * This method is computing the IVA tax of a product based on its net value
     * and the percentage of the taxes are going to be provided by the library 
     * user
     * 
     * @param base This is the net value of any product that you want to compute 
     * the value for
     * @param ivaPercentage This is the IVA percentage according to govermment
     * @return the IVA that a product will be charge for sale
     */
    private static float ivaPercentage = 12;

    public static float computeIva(float base, float ivaPercentage) {
        float taxValue = 0.0F;
        if (base < 0) {
            taxValue = 0;
        } else {
            taxValue = base * ivaPercentage / 100;
        }
        return taxValue;
    }

    
    /**
     * 
     * @param base net value of any product that you want to compute the 
     * value for
     * @param ivaPercentage the percentage according to goverment regulations 
     * @return
     */
    public static float computeTotalIva(float base, float ivaPercentage) {
        float totalValue = 0.0F;
        if (base < 0) {
            totalValue = 0.0F;
        } else {
            totalValue = base + computeIva(base, ivaPercentage);
        }
        return totalValue;
    }

}
