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
public class Cow extends FarmAnimalGeneral{

    protected boolean itProduceMilk;
    protected float litersOfMilkPerDay;

    public Cow(int id, String breed, Date bornOn, String sexOfTheAnimal, float 
            priceOfProduct, float weightOfAnimal, String typeOfProduct, boolean 
                    itProduceMilk, float litersOfMilkPerDay) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct, weightOfAnimal,
                typeOfProduct);
        this.itProduceMilk = itProduceMilk;
        this.litersOfMilkPerDay = litersOfMilkPerDay;
    }
    
    @Override
    public float calculateQuantilyOfProduct(int daysOfLife){
        if (daysOfLife > 750) {
            return (daysOfLife - 750) * 20;
        }
        return 0;
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
        return new Date(pregnancyDate.getYear(), pregnancyDate.getMonth(), 
                pregnancyDate.getDay() + 280);
    }
}
