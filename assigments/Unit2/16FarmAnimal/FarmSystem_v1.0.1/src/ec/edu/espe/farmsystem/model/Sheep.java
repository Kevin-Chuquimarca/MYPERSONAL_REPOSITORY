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
    protected String colorWool;

    public Sheep(int id, String breed, Date bornOn, String sexOfTheAnimal,
            float priceOfProduct, float weightOfAnimal, String typeOfProduct,
            boolean hasWool, String colorWool) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct, weightOfAnimal,
                typeOfProduct);
        this.hasWool = hasWool;
        this.colorWool = colorWool;
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
}
