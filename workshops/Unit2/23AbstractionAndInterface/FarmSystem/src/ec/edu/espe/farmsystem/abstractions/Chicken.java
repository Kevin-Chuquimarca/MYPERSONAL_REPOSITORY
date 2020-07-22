/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.abstractions;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Chicken extends FarmAnimal{

    
    
    @Override
    public float computeEarningMoney(float product, int quantity) {
          //TODO compute earning money for the Chicken
        System.out.println("Computing earning money for the Chicken --> " + product + ", " + quantity);
        return 100.0F;
    }

    @Override
    public float computeFoodMoney(Food food) {
       //TODO compute Food Money for the Chicken
        System.out.println("Computing Food Money for the Chicken");
        return 30.0F;
    } 
}
