/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.calculator.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santi
 */
public class BasicOpertaionDivisionTest {
    
     public BasicOpertaionDivisionTest() {
    }

    /**
     * Test of division method, of class BasicOperation.
     */
    @Test
    public void testDivision1() {
        System.out.println("division");
        float number1 = 1.0F;
        float number2 = 0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision2() {
        System.out.println("division");
        float number1 = 24.0F;
        float number2 = 2.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 12.0F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision3() {
        System.out.println("division");
        float number1 = 12.0F;
        float number2 = -2.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = -6.0F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision4() {
        System.out.println("division");
        float number1 = -4.0F;
        float number2 = -2.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 2.0F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision5() {
        System.out.println("division");
        float number1 = 2.0025F;
        float number2 = 1.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 2.0025F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision6() {
        System.out.println("division");
        float number1 = 36.026F;
        float number2 = 2.036F;
        BasicOperation instance = new BasicOperation();
        float expResult = 17.69449902F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test

    public void testDivision7() {
        System.out.println("division");
        float number1 = 29.9F;
        float number2 = 0.09F;
        BasicOperation instance = new BasicOperation();
        float expResult = 332.2222222F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision8() {
        System.out.println("division");
        float number1 = 0.00009F;
        float number2 = 0.02F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0045F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision9() {
        System.out.println("division");
        float number1 = 1.0001f;
        float number2 = 1.0001f;
        BasicOperation instance = new BasicOperation();
        float expResult = 1.0F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivision10() {
        System.out.println("division");
        float number1 = 0.00002F;
        float number2 = -0.01F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.002F;
        float result = instance.division(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
}
