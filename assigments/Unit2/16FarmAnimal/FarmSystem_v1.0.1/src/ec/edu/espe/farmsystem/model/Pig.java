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
public class Pig extends FarmAnimalReproductorAndForMeat {
    
    private boolean sterilized;
    private float amountOfManure;

    public Pig(int id, String breed, Date bornOn, String sexOfTheAnimal, float 
            priceOfProduct, float weightOfAnimal, String typeOfProduct,boolean 
                    sterilized, float amountOfManure) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct, weightOfAnimal,
                typeOfProduct);
        this.sterilized = sterilized;
        this.amountOfManure = amountOfManure;
    }

    @Override
    public float calculatePriceOftTheProduct(float totalProduct, float 
            priceOfProduct){    
        return totalProduct * priceOfProduct;
    }
    
    @Override
    public float calculatePriceOfTheMeat(float weightOfAnimal, float 
            priceOfProduct){
        return weightOfAnimal * priceOfProduct;
    }
    
    @Override
    public Date defineLightingDate(Date pregnancyDate){
        return new Date(pregnancyDate.getYear(), pregnancyDate.getMonth() + 3, 
                pregnancyDate.getDay() + 24);
    }
}
