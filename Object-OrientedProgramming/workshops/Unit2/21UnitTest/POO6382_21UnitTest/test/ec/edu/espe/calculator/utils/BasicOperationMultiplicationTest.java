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
public class BasicOperationMultiplicationTest {
     public BasicOperationMultiplicationTest() {
    }

   /**
     * Test of multiplication method, of class BasicOperation.
     */
    @Test
    public void testMultiplication1() {
        System.out.println("multiplication");
        float number1 = 0.0F;
        float number2 = 0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication2() {
        System.out.println("multiplication");
        float number1 = 0.0F;
        float number2 = -0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication3() {
        System.out.println("multiplication");
        float number1 = -0.0F;
        float number2 = -0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication4() {
        System.out.println("multiplication");
        float number1 = 0.0F;
        float number2 = 1.0001F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication5() {
        System.out.println("multiplication");
        float number1 = 2.01F;
        float number2 = 0.01F;
        BasicOperation instance = new BasicOperation();
        float expResult = 2.02F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
      @Test
    public void testMultiplication6() {
        System.out.println("multiplication");
        float number1 = -3.0F;
        float number2 = -4.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 12.0F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication7() {
        System.out.println("multiplication");
        float number1 = 1236.01F;
        float number2 = 1.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 1236.01F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication8() {
        System.out.println("multiplication");
        float number1 = 1.0F;
        float number2 = -0.0036F;
        BasicOperation instance = new BasicOperation();
        float expResult = -277.7777778F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication9() {
        System.out.println("multiplication");
        float number1 = 5.5F;
        float number2 = 0.00036F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.00198F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
    
      @Test
    public void testMultiplication10() {
        System.out.println("multiplication");
        float number1 = 0.001F;
        float number2 = 0.001F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.000001F;
        float result = instance.multiplication(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
}
