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
public class Sheep extends FarmAnimalGeneral {

    protected boolean hasWool;
    protected float woolQuantity;

    public Sheep(int id, String breed, Date bornOn, String sexOfTheAnimal,
            float priceOfProduct, float weightOfAnimal, String typeOfProduct,
            boolean hasWool, float woolQuantity) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct, weightOfAnimal,
                typeOfProduct);
        this.hasWool = hasWool;
        this.woolQuantity = woolQuantity;
    }

    @Override
    public float calculateQuantilyOfProduct(int daysOfLife) {
        if (daysOfLife > 365){
            return 3;
        }
        return 0;
    }

    @Override
    public float calculatePriceOftTheProduct(float totalProduct, float priceOfProduct) {
        return totalProduct * priceOfProduct;
    }

    @Override
    public float calculatePriceOfTheMeat(float weightOfAnimal, float priceOfProduct) {
        return weightOfAnimal * priceOfProduct;
    }

    @Override
    public Date defineLightingDate(Date pregnancyDate) {
        return new Date(pregnancyDate.getYear(), pregnancyDate.getMonth() + 5,
                pregnancyDate.getDay());
    }

    public boolean isHasWool() {
        return hasWool;
    }

    public void setHasWool(boolean hasWool) {
        this.hasWool = hasWool;
    }

    public float getWoolQuantity() {
        return woolQuantity;
    }

    public void setWoolQuantity(float woolQuantity) {
        this.woolQuantity = woolQuantity;
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
