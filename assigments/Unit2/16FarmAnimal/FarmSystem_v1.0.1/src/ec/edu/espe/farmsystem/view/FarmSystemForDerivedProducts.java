/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.controller.RecordFarmAnimal;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.model.FarmAnimalGeneral;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystemForDerivedProducts {

    public static ArrayList<FarmAnimal> chooseFarmAnimalForDerivedProducts() {
        ImputValidation in = new ImputValidation();
        RecordFarmAnimal record = new RecordFarmAnimal();
        ArrayList<FarmAnimal> farmAnimals = new ArrayList<>();
        int option;
        System.out.println("RECORD OF FARM ANIMAL FOR DERIVED PRODUCTS");
        do {
            System.out.println(" 1: Chicken\n 2: Cow\n 3: Sheep\n 4: Exit");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    farmAnimals.add(record.recordChicken());
                    break;
                case 2:
                    farmAnimals.add(record.recordCow());
                    break;
                case 3:
                    farmAnimals.add(record.recordSheep());
                    break;
            }
        } while (option != 4);
        System.out.println("---------------------------------------------");
        for (int i = 0; i < farmAnimals.size(); i++) {
            System.out.println(farmAnimals.get(i));
            System.out.println("Months-->" + farmAnimals.get(i).getAgeInMonths());
        }
        return farmAnimals;
    }
}
