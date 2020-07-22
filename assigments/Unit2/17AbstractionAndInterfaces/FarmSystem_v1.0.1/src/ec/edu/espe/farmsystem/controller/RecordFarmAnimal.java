/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.controller;

import ec.edu.espe.farmsystem.model.Chicken;
import ec.edu.espe.farmsystem.model.Cow;
import ec.edu.espe.farmsystem.model.FAnimal;
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

    ImputValidation in = new ImputValidation();
    Date date;

    public FAnimal recordFarmAnimal() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        System.out.println("Enter the day of bor on");
        date = new Date(in.getInt("Enter the year: ", 4) - 1900, in.getInt("Ent"
                + "er the month: ", 2) - 1, in.getInt("Enter the day: ", 2));
        String sexOfTheAnimal = in.getString("Enter the sex of the animal: ");
        float wightOfAnimal = in.getFloat("Enter the weight in KG: ");
        String typeOfProduct = in.getString("Enter the type of product that "
                + "produce the animal: ");
        FAnimal fAnimal = new FAnimal(id, breed, date, sexOfTheAnimal, 
                0F, wightOfAnimal, typeOfProduct);
        return fAnimal;
    }

    public Chicken recordChicken() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean laysEggs = false;
        if ("yes".equals(in.getYesOrNo("The Chicken put eggs[yes/no]: "))) {
            laysEggs = true;
        }
        Chicken chicken = new Chicken(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), laysEggs, 0);
        return chicken;
    }

    public Pig recordPig() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean sterelized = false;
        if ("yes".equals(in.getYesOrNo("The Pig is sterelized[yes/no]: "))) {
            sterelized = true;
        }
        Pig pig = new Pig(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(), sterelized, 0);
        return pig;
    }

    public Cow recordCow() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean itProduceMilk = false;
        float litersOfMilk = 0F;
        if ("yes".equals(in.getYesOrNo("The Cow produce milk[yes/no]: "))) {
            itProduceMilk = true;
            litersOfMilk = in.getFloat("Enter the liters of milk that produce "
                    + "in one day: ");
        }
        Cow cow = new Cow(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), itProduceMilk, litersOfMilk);
        return cow;
    }

    public Sheep recordSheep() {
        FAnimal fAnimal = recordFarmAnimal();
        boolean hasWoold = false;
        if ("yes".equals(in.getYesOrNo("The Sheep has wool[yes/no]: "))) {
            hasWoold = true;
        }
        Sheep sheep = new Sheep(fAnimal.getId(), fAnimal.getBreed(), fAnimal.
                getBornOn(), fAnimal.getSexOfTheAnimal(), fAnimal.
                getPriceOfProduct(), fAnimal.getWeightOfAnimal(),
                fAnimal.getTypeOfProduct(), hasWoold, 0F);
        return sheep;
    }

    public Horse recordHorse() {
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
        Horse horse = new Horse(id, breed, date, sexOfTheAnimal, priceOfProduct,
                tamed);
        return horse;
    }
    
    public Date recordDatePregnancy(){
        int day = in.getInt("Enter the day of pregnancy: ", 2);
        int month = in.getInt("Enter the month of pregnancy: ", 2) - 1;
        int year = in.getInt("Enter the year of pregnancy: ", 4) - 1900;
        return new Date(year, month, day);
    }
}
