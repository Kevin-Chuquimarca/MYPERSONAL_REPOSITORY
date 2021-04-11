/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.io.IOException;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystem {

    public static void main(String[] args) throws IOException {
        System.out.println("Kevin Chuquimarca --> 17AbstractAndInterfaces");
        ImputValidation in = new ImputValidation();
        int option;
        do {
            System.out.println("1: Farm Animal For Derived Products");
            System.out.println("2: Farm Animal For Meat");
            System.out.println("3: Farm Animal For Reproduction\n4: Exit");
            option = in.getInt("Enter the option: ", 1);
            switch (option) {
                case 1:
                    FarmSystemForDerivedProducts.
                            chooseFarmAnimalForDerivedProducts();
                    break;
                case 2:
                    FarmSystemForMeat.chooseFarmAnimalForMeat();
                    break;
                case 3:
                    FarmSystemForReproduction.chooseFarmAnimalForReproduction();
                    break;
            }
        } while (option != 4);
    }
}
