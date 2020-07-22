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
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystemForDerivedProducts {

    public static ArrayList<FarmAnimal> chooseFarmAnimalForDerivedProducts() 
            throws IOException {
        ImputValidation in = new ImputValidation();
        SaveRecord saveRecord = new SaveRecord();
        RecordFarmAnimal record = new RecordFarmAnimal();
        FarmAnimal farmAnimal;
        ArrayList<FarmAnimal> farmAnimals = new ArrayList<>();
        int option;
        float totalProduct;
        float priceProduct;
        System.out.println("RECORD OF FARM ANIMAL FOR DERIVED PRODUCTS");
        do {
            System.out.println(" 1: Chicken\n 2: Cow\n 3: Sheep\n 4: Exit");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    Chicken chicken = record.recordChicken();
                    farmAnimal = chicken;
                    totalProduct = chicken.calculateQuantilyOfProduct(
                            farmAnimal.getAgeInDays());
                    chicken.setNumberOfEggs((int) totalProduct);
                    priceProduct = in.getFloat("Enter the price of "
                            + "the eggs: ");
                    chicken.calculatePriceOftTheProduct(totalProduct,
                            priceProduct);
                    chicken.setPriceOfProduct(priceProduct);
                    farmAnimals.add(chicken);
                    break;
                case 2:
                    Cow cow = record.recordCow();
                    farmAnimal = cow;
                    totalProduct = cow.calculateQuantilyOfProduct(
                            farmAnimal.getAgeInDays());
                    cow.setLitersOfMilkPerDay((int) totalProduct);
                    priceProduct = in.getFloat("Enter the price of "
                            + "the milk: ");
                    cow.calculatePriceOftTheProduct(totalProduct,
                            priceProduct);
                    cow.setPriceOfProduct(priceProduct);
                    farmAnimals.add(cow);
                    break;
                case 3:
                    Sheep sheep = record.recordSheep();
                    farmAnimal = sheep;
                    totalProduct = sheep.calculateQuantilyOfProduct(
                            farmAnimal.getAgeInDays());
                    sheep.setWoolQuantity((int) totalProduct);
                    priceProduct = in.getFloat("Enter the price of "
                            + "the wool: ");
                    sheep.calculatePriceOftTheProduct(totalProduct,
                            priceProduct);
                    sheep.setPriceOfProduct(priceProduct);
                    farmAnimals.add(sheep);
                    break;
            }
            System.out.println("---------------------------------------------");
            for (int i = 0; i < farmAnimals.size(); i++) {
                System.out.println(farmAnimals.get(i).toString());
                System.out.println("Months-->" + farmAnimals.get(i).getAgeInMonths());
            }
        } while (option != 4);
        saveRecord.saveRecordInTheJson("FarmAnimalsForDerivedProducts", farmAnimals);
        return farmAnimals;
    }
}
