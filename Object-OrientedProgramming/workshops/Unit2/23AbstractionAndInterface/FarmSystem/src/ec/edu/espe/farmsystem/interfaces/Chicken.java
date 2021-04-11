/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.interfaces;

import ec.edu.espe.farmsystem.abstractions.Food;
/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Chicken implements IFarmAnimal {

    @Override
    public float computeEarningMoney(float product) {
        //TODO compute earning for the Chicken IMPLEMENTATION
        System.out.println("Computing earning money for the Chicken Implemetation ");
        return 100.0F;
    }

    @Override
    public float computeFoodMoney(Food food) {
        //TODO compute food money for the Chicken IMPLEMENTATION
        System.out.println("Computing Food Money for the Chicken");
        return 30.0F;
    }
}
