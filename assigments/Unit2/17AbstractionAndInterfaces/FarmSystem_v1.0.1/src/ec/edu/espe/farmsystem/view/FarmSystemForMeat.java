/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.controller.RecordFarmAnimal;
import ec.edu.espe.farmsystem.controller.SaveRecord;
import ec.edu.espe.farmsystem.model.Chicken;
import ec.edu.espe.farmsystem.model.Cow;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystemForMeat {
    
    public static ArrayList<FarmAnimal> chooseFarmAnimalForMeat() throws IOException {
        ImputValidation in = new ImputValidation();
        SaveRecord saveRecord = new SaveRecord();
        RecordFarmAnimal record = new RecordFarmAnimal();
        ArrayList<FarmAnimal> farmAnimals = new ArrayList<>();
        int option;
        float priceOfMeat;
        System.out.println("RECORD OF FARM ANIMAL FOR MEAT");
        do {
            System.out.println(" 1: Chicken\n 2: Pig\n 3: Cow\n 4: Sheep\n 5: "
                    + "Exit");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    Chicken chicken = record.recordChicken();
                    priceOfMeat = in.getFloat("Enter the price of the meat: ");
                    chicken.calculatePriceOfTheMeat(chicken.getWeightOfAnimal(), priceOfMeat);
                    chicken.setPriceOfProduct(priceOfMeat);
                    farmAnimals.add(chicken);
                    break;
                case 2:
                    Pig pig = record.recordPig();
                    priceOfMeat = in.getFloat("Enter the price of the meat: ");
                    pig.calculatePriceOfTheMeat(pig.getWeightOfAnimal(), priceOfMeat);
                    pig.setPriceOfProduct(priceOfMeat);
                    farmAnimals.add(pig);
                    break;
                case 3:
                    Cow cow = record.recordCow();
                    priceOfMeat = in.getFloat("Enter the price of the meat: ");
                    cow.calculatePriceOfTheMeat(cow.getWeightOfAnimal(), priceOfMeat);
                    cow.setPriceOfProduct(priceOfMeat);
                    farmAnimals.add(cow);
                    break;
                case 4:
                    Sheep sheep = record.recordSheep();
                    priceOfMeat = in.getFloat("Enter the price of the meat: ");
                    sheep.calculatePriceOfTheMeat(sheep.getWeightOfAnimal(), priceOfMeat);
                    sheep.setPriceOfProduct(priceOfMeat);
                    farmAnimals.add(sheep);
                    break;
            }
            System.out.println("---------------------------------------------");
            for (int i = 0; i < farmAnimals.size(); i++) {
                System.out.println(farmAnimals.get(i));
                System.out.println("Months-->" + farmAnimals.get(i).getAgeInMonths());
            }
        } while (option != 5);
        saveRecord.saveRecordInTheJson("FarmAniamlsForMeat", farmAnimals);
        return farmAnimals;
    }
}
