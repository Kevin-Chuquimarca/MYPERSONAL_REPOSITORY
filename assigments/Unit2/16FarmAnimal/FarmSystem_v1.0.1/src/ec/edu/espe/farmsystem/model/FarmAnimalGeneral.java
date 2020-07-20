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
public abstract class FarmAnimalGeneral extends FarmAnimal{
    
    protected float weightOfAnimal;
    protected String typeOfProduct;

    public FarmAnimalGeneral(int id, String breed, Date bornOn, String 
            sexOfTheAnimal, float priceOfProduct, float weightOfAnimal, String 
                    typeOfProduct) {
        super(id, breed, bornOn, sexOfTheAnimal, priceOfProduct);
        this.weightOfAnimal = weightOfAnimal;
        this.typeOfProduct = typeOfProduct;
    }

    public abstract float calculateQuantilyOfProduct(int daysOfLife);

    public abstract float calculatePriceOfTheMeat(float weightOfAnimal, float 
            priceOfProduct);
    
    @Override
    public abstract float calculatePriceOftTheProduct(float totalProduct,
            float priceOfProduct);

    @Override
    public abstract Date defineLightingDate(Date pregnancyDate);
}
