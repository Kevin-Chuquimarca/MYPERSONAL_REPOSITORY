/** Copyright ESPE-DECC
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.controller.FarmAnimalRegistry;
import ec.edu.espe.farmsystem.utils.ImputValidation;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystem {

    public static void main(String[] args) {
        ImputValidation in = new ImputValidation();
        FarmAnimalRegistry registry = new FarmAnimalRegistry();
        int option;
        do {
            System.out.println(" 1: Animal\n 2: Chicken\n 3: Pig\n 4: Crow\n"
                    + " 5: Sheep");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    registry.recordAnimal();
                    break;
                case 2:
                    registry.recordChicken();
                    break;
                case 3:
                    registry.recordPig();
                    break;
                case 4:
                    registry.recordCrow();
                    break;
                case 5:
                    registry.recordSheep();
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        } while (option != 6);
    }
}
