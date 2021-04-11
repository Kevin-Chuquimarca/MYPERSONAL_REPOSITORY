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
public class Cow extends FarmAnimal{

    @Override
    public float computeEarningMoney(float product, int quantity) {
        //TODO compute earning money for the cow
        System.out.println("Computing earning money for the Cow --> " + product + ", " + quantity);
        return 100.0F;
    }

    @Override
    public float computeFoodMoney(Food food) {
       //TODO compute Food Money for the Cow
        System.out.println("Computing Food Money for the Cow");
        return 30.0F;
    }
    
    @Override
    public int computeAgeInMonths(){
        //TODO own compute age in months for the cow
        System.out.println("computing age in months for the cow");
        return 5;
    }
}
