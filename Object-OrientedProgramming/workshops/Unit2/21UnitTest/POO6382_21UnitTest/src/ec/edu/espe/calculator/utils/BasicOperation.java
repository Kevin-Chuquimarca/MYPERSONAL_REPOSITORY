/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.calculator.utils;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class BasicOperation {

    public float sum(float number1, float number2) {
        float answer = number1 + number2;
        return answer;
    }

    public float substraction(float number1, float number2) {
        float answer = number1 - number2;
        return answer;
    }

    public float multiplication(float number1, float number2) {
        float answer = number1 * number2;
        return answer;
    }

    public float division(float number1, float number2) {
        float answer = 0;
        if (number2 != 0) {
            answer = number1 / number2;
        } else {
            System.out.println("Not exist division for 0");
        }
        return answer;
    }
}
