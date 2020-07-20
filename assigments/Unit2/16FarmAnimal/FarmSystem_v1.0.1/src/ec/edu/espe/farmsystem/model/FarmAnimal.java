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
public abstract class FarmAnimal {

    private int id;
    protected String breed;
    protected Date bornOn;
    protected String sexOfTheAnimal;
    private float priceOfProduct;

    public FarmAnimal(int id, String breed, Date bornOn, String sexOfTheAnimal, 
            float priceOfProduct) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.sexOfTheAnimal = sexOfTheAnimal;
        this.priceOfProduct = priceOfProduct;
    }
    
    public abstract float calculatePriceOftTheProduct(float totalProduct,
            float priceOfProduct);

    public abstract Date defineLightingDate(Date pregnancyDate);
    
    public int getAgeInMonths() {
        Date date = new Date();
        String[] currentsDate = date.toLocaleString().split("/");
        String[] years = currentsDate[2].split(" ");
        int year = Integer.parseInt(years[0]) - 1900 - bornOn.getYear();
        int month = Integer.parseInt(currentsDate[1]);
        int day = Integer.parseInt(currentsDate[0]) - bornOn.getDay();
        if (day <= 0) {
            return month - bornOn.getMonth() + (year * 12);
        } else {
            return month - bornOn.getMonth() + (year * 12) - 1;
        }
    }

    public int getAgeInDays() {
        Date date = new Date();
        String[] currentsDate = date.toLocaleString().split("/");
        int day = Integer.parseInt(currentsDate[0]) - bornOn.getDay();
        return (getAgeInMonths())*30 + day;
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

    public String getSexOfTheAnimal() {
        return sexOfTheAnimal;
    }

    public void setSexOfTheAnimal(String sexOfTheAnimal) {
        this.sexOfTheAnimal = sexOfTheAnimal;
    }

    public float getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(float priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }
}
