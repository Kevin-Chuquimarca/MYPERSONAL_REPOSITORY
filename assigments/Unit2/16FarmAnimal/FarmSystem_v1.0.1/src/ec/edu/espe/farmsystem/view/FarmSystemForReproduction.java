/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.controller.RecordFarmAnimal;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystemForReproduction {

    public static FarmAnimal chooseFarmAnimalForReproduction() {
        ImputValidation in = new ImputValidation();
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
                    farmAnimals.add(record.recordChicken());
                    break;
                case 2:
                    farmAnimals.add(record.recordPig());
                    break;
                case 3:
                    farmAnimals.add(record.recordCow());
                    break;
                case 4:
                    farmAnimals.add(record.recordSheep());
                    break;
                case 5:
                    farmAnimals.add(record.recordHorse());
                    break;
            }
        } while (option != 6);
        System.out.println("---------------------------------------------");
        for (int i = 0; i < farmAnimals.size(); i++) {
            System.out.println(farmAnimals.get(i));
            System.out.println("Months-->" + farmAnimals.get(i).getAgeInMonths());
        }
        return null;
    }
}
