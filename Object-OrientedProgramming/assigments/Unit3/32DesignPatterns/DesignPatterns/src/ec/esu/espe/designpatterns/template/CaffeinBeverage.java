/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.esu.espe.designpatterns.template;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public abstract class CaffeinBeverage {
    
    void prepareRecipe(){
        boilWater();
        brew();
        pourlnCup();
        if (wantsCondiments()){
            addCondiments();
        }
    }
    
    void boilWater(){
        System.out.println("Boiling water");
    }
    
    abstract void brew();
    
    void pourlnCup(){
        System.out.println("Pouring into cup");
    }
    
    abstract void addCondiments();
    
    boolean wantsCondiments(){
        return true;
    }
}
