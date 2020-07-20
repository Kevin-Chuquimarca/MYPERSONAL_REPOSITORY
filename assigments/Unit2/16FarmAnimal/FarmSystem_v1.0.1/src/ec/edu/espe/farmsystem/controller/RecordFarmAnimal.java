/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.controller;

import ec.edu.espe.farmsystem.model.Chicken;
import ec.edu.espe.farmsystem.model.Cow;
import ec.edu.espe.farmsystem.model.FAnimal;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.model.Horse;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class RecordFarmAnimal {

    FarmAnimal farmAnimal;
    ImputValidation in = new ImputValidation();
    Date date;

    public FAnimal recordFarmAnimal() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        System.out.println("Enter the day of bor on");
        date = new Date(in.getInt("Enter the year: ", 4) - 1900, in.getInt("Ent"
                + "er the month: ", 2) - 1, in.getInt("Enter the day: ", 2));
        String sexOfTheAnimal = in.getString("Enter the sex of the animal: ");
        float priceOfProduct = in.getFloat("Enter the price of the product: ");
        float wightOfAnimal = in.getFloat("Enter the weight in KG: ");
        String typeOfProduct = in.getString("Enter the type of product that "
                + "produce the animal: ");
        FAnimal fAnimal = new FAnimal(id, breed, date, sexOfTheAnimal, 
                priceOfProduct, wightOfAnimal, typeOfProduct);
        return fAnimal;
    }

    public FarmAnimal recordChicken() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean laysEggs = false;
        if ("yes".equals(in.getYesOrNo("The Chicken put eggs[yes/no]: "))) {
            laysEggs = true;
        }
        farmAnimal = new Chicken(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), laysEggs, 0);
        return farmAnimal;
    }

    public FarmAnimal recordPig() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean sterelized = false;
        if ("yes".equals(in.getYesOrNo("The Pig is sterelized[yes/no]: "))) {
            sterelized = true;
        }
        farmAnimal = new Pig(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), sterelized, 0);
        return farmAnimal;
    }

    public FarmAnimal recordCow() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean itProduceMilk = false;
        float litersOfMilk = 0F;
        if ("yes".equals(in.getYesOrNo("The Cow produce milk[yes/no]: "))) {
            itProduceMilk = true;
            litersOfMilk = in.getFloat("Enter the liters of milk that produce "
                    + "in one day: ");
        }
        farmAnimal = new Cow(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), itProduceMilk, litersOfMilk);
        return farmAnimal;
    }

    public FarmAnimal recordSheep() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean hasWoold = false;
        if ("yes".equals(in.getYesOrNo("The Sheep has wool[yes/no]: "))) {
            hasWoold = true;
        }
        String colorWool = in.getString("Enter the color of Wool: ");
        farmAnimal = new Sheep(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), hasWoold, colorWool);
        return farmAnimal;
    }

    public FarmAnimal recordHorse() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        System.out.println("Enter the day of bor on");
        date = new Date(in.getInt("Enter the year: ", 4) - 1900, in.getInt("Ent"
                + "er the month: ", 2) - 1, in.getInt("Enter the day: ", 2));
        String sexOfTheAnimal = in.getString("Enter the sex of the animal: ");
        float priceOfProduct = in.getFloat("Enter the price of the Horse: ");
        boolean tamed = false;
        if ("yes".equals(in.getYesOrNo("The Horse is tamed[yes/no]: "))) {
            tamed = true;
        }
        farmAnimal = new Horse(id, breed, date, sexOfTheAnimal, priceOfProduct,
                tamed);
        return farmAnimal;
    }
    
    public Date recordDatePregnancy(){
        ImputValidation in = new ImputValidation();
        int day = in.getInt("Enter the day of pregnancy: ", 2);
        int month = in.getInt("Enter the day of pregnancy: ", 2) - 1;
        int year = in.getInt("Enter the day of pregnancy: ", 2) - 1900;
        return new Date(year, month, day);
    }
}
