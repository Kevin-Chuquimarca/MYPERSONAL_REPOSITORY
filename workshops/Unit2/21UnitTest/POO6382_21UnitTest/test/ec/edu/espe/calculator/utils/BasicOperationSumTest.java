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
public class BasicOperationSumTest {

    public BasicOperationSumTest() {
    }

    /**
     * Test of sum method, of class BasicOperation.
     */
    @Test
    public void testSum1() {
        System.out.println("sum");
        float number1 = 0.0F;
        float number2 = 0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum2() {
        System.out.println("sum");
        float number1 = 1.0F;
        float number2 = -1.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum3() {
        System.out.println("sum");
        float number1 = -2.36F;
        float number2 = -0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = -2.36F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum4() {
        System.out.println("sum");
        float number1 = 100.0F;
        float number2 = -0.1F;
        BasicOperation instance = new BasicOperation();
        float expResult = 99.9F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum5() {
        System.out.println("sum");
        float number1 = 0.001F;
        float number2 = 0.0001F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0011F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum6() {
        System.out.println("sum");
        float number1 = 0.0F;
        float number2 = -0.001F;
        BasicOperation instance = new BasicOperation();
        float expResult = -0.001F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test

    public void testSum7() {
        System.out.println("sum");
        float number1 = 99.0F;
        float number2 = 1000.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 1099.0F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum8() {
        System.out.println("sum");
        float number1 = 1.5F;
        float number2 = 0.55F;
        BasicOperation instance = new BasicOperation();
        float expResult = 2.05F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum9() {
        System.out.println("sum");
        float number1 = -0.0F;
        float number2 = -0.0F;
        BasicOperation instance = new BasicOperation();
        float expResult = 0.0F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSum10() {
        System.out.println("sum");
        float number1 = 1000000000.05F;
        float number2 = 0.005F;
        BasicOperation instance = new BasicOperation();
        float expResult = 1000000000.055F;
        float result = instance.sum(number1, number2);
        assertEquals(expResult, result, 0.0);
    }
}
