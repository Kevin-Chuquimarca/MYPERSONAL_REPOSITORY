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
public class Horse extends FarmAnimalReproductor{
    
    private boolean tamed;

    public Horse(int id, String breed, Date bornOn, String sexOfTheAnimal, float
            priceOfProduct, boolean tamed) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct);
        this.tamed = tamed;
    }

    @Override
    public float calculatePriceOftTheProduct(float totalProduct, float 
            priceOfProduct){
        return totalProduct * priceOfProduct;
    }
    
    @Override
    public Date defineLightingDate(Date pregnancyDate){
       return new Date(pregnancyDate.getYear(), pregnancyDate.getMonth() + 11, 
                pregnancyDate.getDay());
    }

    @Override
    public String toString() {
        return "Horse{" + super.toString() + "tamed=" + tamed + '}';
    }

    public boolean isTamed() {
        return tamed;
    }

    public void setTamed(boolean tamed) {
        this.tamed = tamed;
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
