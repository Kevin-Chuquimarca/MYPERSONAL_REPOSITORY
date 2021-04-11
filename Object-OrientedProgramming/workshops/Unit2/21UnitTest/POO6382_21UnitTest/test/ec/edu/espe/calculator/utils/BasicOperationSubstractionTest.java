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
public class BasicOperationSubstractionTest {

    public BasicOperationSubstractionTest() {
    }

    /**
     * Test of substraction method, of class BasicOperation.
     */
    @Test
    public void testSubstraction1() {
        System.out.println("substraction");
        float number1 = 0.0F;
        float number2 = 0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction2() {
        System.out.println("substraction");
        float number1 = -0.0F;
        float number2 = -0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction3() {
        System.out.println("substraction");
        float number1 = 20.2F;
        float number2 = 0.02F;
        BasicOperation instance = new BasicOperation();
        float expResult = 20.18F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction4() {
        System.out.println("substraction");
        float number1 = 0.02F;
        float number2 = -20.2F;
        BasicOperation instance = new BasicOperation();
        float expResult = 20.22F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction5() {
        System.out.println("substraction");
        float number1 = 0.001F;
        float number2 = 0.001F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction6() {
        System.out.println("substraction");
        float number1 = 5.036F;
        float number2 = 0.024F;
        BasicOperation instance = new BasicOperation();
        float expResult = 5.012F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction7() {
        System.out.println("substraction");
        float number1 = 0.0F;
        float number2 = -1.002F;
        BasicOperation instance = new BasicOperation();
        float expResult = 1.002F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction8() {
        System.out.println("substraction");
        float number1 = 4.004F;
        float number2 = -0.004F;
        BasicOperation instance = new BasicOperation();
        float expResult = 4.008F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction9() {
        System.out.println("substraction");
        float number1 = 0.03F;
        float number2 = 0.002F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.28F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testSubstraction10() {
        System.out.println("substraction");
        float number1 = 100000.0F;
        float number2 = 0.001F;
        BasicOperation instance = new BasicOperation();
        float expResult = 99999.999F;
        float result = instance.substraction(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
}
