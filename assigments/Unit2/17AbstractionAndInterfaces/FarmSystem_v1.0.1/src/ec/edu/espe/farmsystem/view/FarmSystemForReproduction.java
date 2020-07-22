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
import ec.edu.espe.farmsystem.model.Horse;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystemForReproduction {

    public static ArrayList<FarmAnimal> chooseFarmAnimalForReproduction() 
            throws IOException {
        ImputValidation in = new ImputValidation();
        SaveRecord saveRecord = new SaveRecord();
        RecordFarmAnimal record = new RecordFarmAnimal();
        ArrayList<FarmAnimal> farmAnimals = new ArrayList<>();
        int option;
        System.out.println("RECORD OF FARM ANIMAL FOR REPRODUCTION");
        do {
            System.out.println(" 1: Chicken\n 2: Pig\n 3: Cow\n 4: Sheep\n 5: "
                    + "Horse\n 6: Exit");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    Chicken chicken = record.recordChicken();
                    System.out.println("Lightting Date --> " + chicken.
                            defineLightingDate(record.recordDatePregnancy()));
                    farmAnimals.add(chicken);
                    break;
                case 2:
                    Pig pig = record.recordPig();
                    System.out.println("Lightting Date --> " + pig.
                            defineLightingDate(record.recordDatePregnancy()));
                    farmAnimals.add(pig);
                    break;
                case 3:
                    Cow cow = record.recordCow();
                    System.out.println("Lightting Date --> " + cow.
                            defineLightingDate(record.recordDatePregnancy()));
                    farmAnimals.add(cow);
                    break;
                case 4:
                    Sheep sheep = record.recordSheep();
                    System.out.println("Lightting Date --> " + sheep.
                            defineLightingDate(record.recordDatePregnancy()));
                    farmAnimals.add(sheep);
                    break;
                case 5:
                    Horse horse = record.recordHorse();
                    System.out.println("Lightting Date --> " + horse.
                            defineLightingDate(record.recordDatePregnancy()));
                    farmAnimals.add(horse);
                    break;
            }
            System.out.println("---------------------------------------------");
            for (int i = 0; i < farmAnimals.size(); i++) {
                System.out.println(farmAnimals.get(i));
                System.out.println("Months-->" + farmAnimals.get(i).getAgeInMonths());
            }
        } while (option != 6);
        saveRecord.saveRecordInTheJson("FarmAnimalsReproductor", farmAnimals);
        return farmAnimals;
    }
}
