/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santi
 */
public class FarmAnimalTest {
    
    public FarmAnimalTest() {
    }

       /**
     * Test of getAgeInMonths method, of class FarmAnimal.
     */
    @Test
    public void testGetAgeInMonths1() {
        System.out.println("getAgeInMonths");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(120, 06, 16), 0);
        int expResult = 0;
        int result = instance.getAgeInMonths();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInMonths2() {
        System.out.println("getAgeInMonths");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(119, 06, 16), 0);
        int expResult = 12;
        int result = instance.getAgeInMonths();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInMonths3() {
        System.out.println("getAgeInMonths");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(118, 05, 16), 0);
        int expResult = 25;
        int result = instance.getAgeInMonths();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInMonths4() {
        System.out.println("getAgeInMonths");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(119, 01, 01), 0);
        int expResult = 17;
        int result = instance.getAgeInMonths();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInMonths5() {
        System.out.println("getAgeInMonths");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(120, 07, 16), 0);
        int expResult = -01;
        int result = instance.getAgeInMonths();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgeInDays method, of class FarmAnimal.
     */
    @Test
    public void testGetAgeInDays1() {
        System.out.println("getAgeInDays");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(120, 06, 16), 0);
        int expResult = 0;
        int result = instance.getAgeInDays();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInDays2() {
        System.out.println("getAgeInDays");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(119, 06, 16), 0);
        int expResult = 365;
        int result = instance.getAgeInDays();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInDays3() {
        System.out.println("getAgeInDays");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(119, 06, 10), 0);
        int expResult = 359;
        int result = instance.getAgeInDays();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInDays4() {
        System.out.println("getAgeInDays");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(120, 05, 16), 0);
        int expResult = 30;
        int result = instance.getAgeInDays();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetAgeInDays5() {
        System.out.println("getAgeInDays");
        FarmAnimal instance = new FarmAnimal(0, "", new Date(120, 07, 16), 0);
        int expResult = -30;
        int result = instance.getAgeInDays();
        assertEquals(expResult, result);
    }
}
