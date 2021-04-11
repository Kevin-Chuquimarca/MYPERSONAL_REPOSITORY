/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Horse extends FarmAnimal{
    private static boolean tamed;
    private static float priceOfHorse;

    public Horse(int id, String breed, Date bornOn, int sexOfAnimal, boolean tamed, float price) {
        super(id, breed, bornOn, sexOfAnimal);
        Horse.tamed = tamed;
        Horse.priceOfHorse = price;
    }

    public static float calculateSppedMaxOfHorse(){
        ImputValidation in = new ImputValidation();
        String distance = in.getString("Enter the distance the horse runs[m]: ");
        String time = in.getString("Enter the time it takes[seg]: ");
        return Float.parseFloat(distance)/Float.parseFloat(time);
    } 
    
    @Override
    public String toString() {
        return "Horse{" + super.toString() + ", tamed=" + tamed + ", price=" 
                + "$" + priceOfHorse + '}';
    }

    public static boolean isTamed() {
        return tamed;
    }

    public static void setTamed(boolean tamed) {
        Horse.tamed = tamed;
    }

    public static float getPrice() {
        return priceOfHorse;
    }

    public static void setPrice(float price) {
        Horse.priceOfHorse = price;
    }
}
