/** Copyright ESPE-DECC
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.controller.FarmAnimalRegistry;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystem {
    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> 16Inthenerance");
        ImputValidation in = new ImputValidation();
        FarmAnimalRegistry registry = new FarmAnimalRegistry();
        ArrayList<FarmAnimal> farmAnimal = new ArrayList<>();
        int option;
        do {
            System.out.println(" 1: Animal\n 2: Chicken\n 3: Pig\n 4: Cow\n"
                    + " 5: Sheep\n 6: Horse\n 7: Exit");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    farmAnimal.add(registry.recordAnimal());
                    break;
                case 2:
                    farmAnimal.add(registry.recordChicken(registry.recordAnimal()));
                    break;
                case 3:
                    farmAnimal.add(registry.recordPig(registry.recordAnimal()));
                    break;
                case 4:
                    farmAnimal.add(registry.recordCow(registry.recordAnimal()));
                    break;
                case 5:
                    farmAnimal.add(registry.recordSheep(registry.recordAnimal()));
                    break;
                case 6:
                    farmAnimal.add(registry.recordHorse(registry.recordAnimal()));
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
            System.out.println("---------------------------------------------");
            for (int i = 0; i<farmAnimal.size(); i++){
            System.out.println(farmAnimal.get(i));
            }
            System.out.println("---------------------------------------------");
        } while (option != 7);
    }
}
