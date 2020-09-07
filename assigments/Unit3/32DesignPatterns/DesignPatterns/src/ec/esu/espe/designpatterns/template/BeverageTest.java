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
public class BeverageTest {
    
    public static void beveragetest(){
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        
        System.out.println("\n Making tea...");
        tea.prepareRecipe();
        
        System.out.println("\n Making coffee...");
        coffee.prepareRecipe();
    }
}
