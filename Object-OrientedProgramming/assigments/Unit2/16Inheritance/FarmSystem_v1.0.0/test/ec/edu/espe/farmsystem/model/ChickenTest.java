/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santi
 */
public class ChickenTest {
    
    public ChickenTest() {
    }

    /**
     * Test of calculateEggsOfChicken method, of class Chicken.
     */
     @Test
    public void testCalculateEggsOfChicken1() {
        System.out.println("calculateEggsOfChicken");
        int daysLife = 168;
        int expResult = 28;
        int result = Chicken.calculateEggsOfChicken(daysLife);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testCalculateEggsOfChicken2() {
        System.out.println("calculateEggsOfChicken");
        int daysLife = 140;
        int expResult = 0;
        int result = Chicken.calculateEggsOfChicken(daysLife);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testCalculateEggsOfChicken3() {
        System.out.println("calculateEggsOfChicken");
        int daysLife = 141;
        int expResult = 1;
        int result = Chicken.calculateEggsOfChicken(daysLife);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testCalculateEggsOfChicken4() {
        System.out.println("calculateEggsOfChicken");
        int daysLife = 139;
        int expResult = 0;
        int result = Chicken.calculateEggsOfChicken(daysLife);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testCalculateEggsOfChicken5() {
        System.out.println("calculateEggsOfChicken");
        int daysLife = 1236;
        int expResult = 1096;
        int result = Chicken.calculateEggsOfChicken(daysLife);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculatePriceOfEggs method, of class Chicken.
     */
    @Test
    public void testPriceOfEggs1() {
        System.out.println("priceOfEggs");
        int totalEggs = 15;
        int priceOfOneEgg = 15;
        float expResult = 2.25F;
        float result = Chicken.calculatePriceOfEggs(totalEggs, priceOfOneEgg);
        assertEquals(expResult, result, 0.0);
    }
    
     @Test
    public void testPriceOfEggs2() {
        System.out.println("priceOfEggs");
        int totalEggs = 20;
        int priceOfOneEgg = 10;
        float expResult = 2.0F;
        float result = Chicken.calculatePriceOfEggs(totalEggs, priceOfOneEgg);
        assertEquals(expResult, result, 0.0);
    }
    
     @Test
    public void testPriceOfEggs3() {
        System.out.println("priceOfEggs");
        int totalEggs = 18;
        int priceOfOneEgg = 12;
        float expResult = 2.16F;
        float result = Chicken.calculatePriceOfEggs(totalEggs, priceOfOneEgg);
        assertEquals(expResult, result, 0.0);
    }
    
     @Test
    public void testPriceOfEggs4() {
        System.out.println("priceOfEggs");
        int totalEggs = 155;
        int priceOfOneEgg = 15;
        float expResult = 23.25F;
        float result = Chicken.calculatePriceOfEggs(totalEggs, priceOfOneEgg);
        assertEquals(expResult, result, 0.0);
    }
    
     @Test
    public void testPriceOfEggs5() {
        System.out.println("priceOfEggs");
        int totalEggs = 0;
        int priceOfOneEgg = 10;
        float expResult = 0.0F;
        float result = Chicken.calculatePriceOfEggs(totalEggs, priceOfOneEgg);
        assertEquals(expResult, result, 0.0);
    }
}
