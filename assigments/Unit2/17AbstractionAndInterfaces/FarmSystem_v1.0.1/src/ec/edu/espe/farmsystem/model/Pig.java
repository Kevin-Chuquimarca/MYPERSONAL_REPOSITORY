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
            priceOfProduct, float weightOfAnimal,boolean sterilized, 
            float amountOfManure) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct, weightOfAnimal);
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

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "sterilized=" + sterilized + ", "
                + "amountOfManure=" + amountOfManure + '}';
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public float getAmountOfManure() {
        return amountOfManure;
    }

    public void setAmountOfManure(float amountOfManure) {
        this.amountOfManure = amountOfManure;
    }

    public float getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(float weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
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
