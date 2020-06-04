package ec.edu.espe.FlowControlAndDataTypes.controller;

import ec.edu.espe.FlowControlAndDataTypes.model.Triangle;
import ec.edu.espe.FlowControlAndDataTypes.utils.Keyboard;

public class Operation {

    public void operator() {
        int lad1;
        int lad2;
        boolean control = false;
        String answer;
        Triangle triangle;
        float hypotenuse;
        Keyboard keyboard = new Keyboard();
        do {
            lad1 = keyboard.getInt("enter the value of A [10-99]: ", 2);
            lad2 = keyboard.getInt("enter the value of B [10-99]: ", 2);
            triangle = new Triangle(lad1, lad2);
            lad1 = triangle.getCateto1();
            lad2 = triangle.getCateto2();
            hypotenuse = (float) Math.sqrt(lad1 * lad1 + lad2 * lad2);
            System.out.println("C = " + hypotenuse);
            answer = keyboard.getString("\nyou want to make another calculation [yes/no]: ");
            if ("no".equals(answer)) {
                control = true;
            }
        } while (control == false);
    }
}
