/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public abstract class FarmAnimalReproductorAndForMeat extends FarmAnimal{
    
    protected float weightOfAnimal;

    public FarmAnimalReproductorAndForMeat(int id, String breed, Date bornOn, String 
            sexOfTheAnimal, float priceOfProduct, float weightOfAnimal) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct);
        this.weightOfAnimal = weightOfAnimal;
    }
    
    public abstract float calculatePriceOfTheMeat(float weightOfAnimal, float 
            priceOfProduct);
    
    @Override
    public abstract float calculatePriceOftTheProduct(float totalProduct,
            float priceOfProduct);

    @Override
    public abstract Date defineLightingDate(Date pregnancyDate);

    @Override
    public String toString() {
        return "FarmAnimalReproductorAndForMeat{" + super.toString() + "weightO"
                + "fAnimal=" + weightOfAnimal + '}';
    }
}
