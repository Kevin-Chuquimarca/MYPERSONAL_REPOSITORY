/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.view;

import ec.edu.espe.farmsystem.abstractions.Chicken;
import ec.edu.espe.farmsystem.abstractions.Cow;
import ec.edu.espe.farmsystem.abstractions.FarmAnimal;
import ec.edu.espe.farmsystem.abstractions.Food;
import ec.edu.espe.farmsystem.interfaces.IFarmAnimal;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmSystem {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> Abstraction And Interfae");
        FarmAnimal farmAnimal;
        //farmAnimal = new FarmAnimal();
        farmAnimal = new Chicken();
        System.out.println("--------------------ABSTRACT CLASSES---------------");

        System.out.println("--------------------Chicken---------------");
        farmAnimal.computeAgeInMonths();
        farmAnimal.computeFoodMoney(new Food());
        farmAnimal.computeEarningMoney(5.0F, 3);

        farmAnimal = new Cow();
        System.out.println("--------------------Cow---------------");
        farmAnimal.computeAgeInMonths();
        farmAnimal.computeFoodMoney(new Food());
        farmAnimal.computeEarningMoney(8.0F, 4);
        
        
        System.out.println("--------------------Interfaces---------------");
        IFarmAnimal farmAnimal2;
        farmAnimal2 = new ec.edu.espe.farmsystem.interfaces.Chicken();
        ec.edu.espe.farmsystem.interfaces.Chicken chicken = new ec.edu.espe.farmsystem.interfaces.Chicken();
        farmAnimal2.computeFoodMoney(new Food());
        farmAnimal2.computeEarningMoney(0);
    }
}
