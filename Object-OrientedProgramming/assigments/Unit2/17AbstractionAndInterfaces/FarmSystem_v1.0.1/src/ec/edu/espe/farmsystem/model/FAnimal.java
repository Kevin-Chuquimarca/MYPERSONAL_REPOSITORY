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
public class FAnimal {

    private int id;
    private String breed;
    private Date bornOn;
    private String sexOfTheAnimal;
     private float priceOfProduct;
    private float weightOfAnimal;
    private String typeOfProduct;

    public FAnimal(int id, String breed, Date bornOn, String sexOfTheAnimal, float priceOfProduct, float weightOfAnimal, String typeOfProduct) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.sexOfTheAnimal = sexOfTheAnimal;
        this.priceOfProduct = priceOfProduct;
        this.weightOfAnimal = weightOfAnimal;
        this.typeOfProduct = typeOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    public float getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(float weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
    }

    public String getSexOfTheAnimal() {
        return sexOfTheAnimal;
    }

    public void setSexOfTheAnimal(String sexOfTheAnimal) {
        this.sexOfTheAnimal = sexOfTheAnimal;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public float getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(float priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }
}
