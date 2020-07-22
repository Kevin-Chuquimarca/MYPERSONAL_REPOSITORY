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
public class Chicken extends FarmAnimalGeneral {

    protected boolean laysEggs;
    protected int numberOfEggs;

    public Chicken(int id, String breed, Date bornOn, String sexOfTheAnimal,
            float priceOfProduct, float weightOfAnimal, String typeOfProduct,
            boolean laysEggs, int numberOfEggs) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct, weightOfAnimal,
                typeOfProduct);
        this.laysEggs = laysEggs;
        this.numberOfEggs = numberOfEggs;
    }

    @Override
    public float calculateQuantilyOfProduct(int daysOfLife) {
        if (daysOfLife > 140) {
            return (daysOfLife - 140);
        }
        return 0;
    }

    @Override
    public float calculatePriceOftTheProduct(float totalProduct, float 
            priceOfProduct) {
        return priceOfProduct * totalProduct;
    }

    @Override
    public float calculatePriceOfTheMeat(float weightOfAnimal, float 
            priceOfProduct) {
        return weightOfAnimal * priceOfProduct;
    }

    @Override
    public Date defineLightingDate(Date pregnancyDate) {
        return new Date(pregnancyDate.getYear(), pregnancyDate.getMonth(), 
                pregnancyDate.getDay() + 25);
    }

    public boolean isLaysEggs() {
        return laysEggs;
    }

    public void setLaysEggs(boolean laysEggs) {
        this.laysEggs = laysEggs;
    }

    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    public void setNumberOfEggs(int numberOfEggs) {
        this.numberOfEggs = numberOfEggs;
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

    

    @Override
    public String toString() {
        return "Chicken{" + super.toString() + "laysEggs=" + laysEggs + ", "
                + "numberOfEggs=" + numberOfEggs + '}';
    }
}
