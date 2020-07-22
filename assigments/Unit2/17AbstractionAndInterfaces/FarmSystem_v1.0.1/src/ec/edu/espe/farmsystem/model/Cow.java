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

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "itProduceMilk=" + itProduceMilk + 
                ", litersOfMilkPerDay=" + litersOfMilkPerDay + '}';
    }

    public boolean isItProduceMilk() {
        return itProduceMilk;
    }

    public void setItProduceMilk(boolean itProduceMilk) {
        this.itProduceMilk = itProduceMilk;
    }

    public float getLitersOfMilkPerDay() {
        return litersOfMilkPerDay;
    }

    public void setLitersOfMilkPerDay(float litersOfMilkPerDay) {
        this.litersOfMilkPerDay = litersOfMilkPerDay;
    }

    public float getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(float weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public Date getBornOn() {
        return bornOn;
    }

    @Override
    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    @Override
    public String getSexOfTheAnimal() {
        return sexOfTheAnimal;
    }

    @Override
    public void setSexOfTheAnimal(String sexOfTheAnimal) {
        this.sexOfTheAnimal = sexOfTheAnimal;
    }

    
}
