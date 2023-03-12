/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.reflectiongrupo05;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class ReflectionGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numA, numB;
        System.out.println("Operaciones con numeros enteros");
        System.out.println("Ingrese el primer valor: ");
        numA = scanner.nextInt();
        System.out.println("Ingrese el segundo valor: ");
        numB = scanner.nextInt();
        // Obtener una referencia a la clase Calculadora
        Class<?> classCalculator = Calculator.class;

        // Crear una instancia de la clase Calculadora
        Calculator calculator = new Calculator();

        // Obtener una referencia al método de suma de la clase Calculadora utilizando Reflection
        Method sum = classCalculator.getMethod("sumTwoValues", int.class, int.class);

        // Llamar al método de suma de la clase Calculadora utilizando Reflection
        int resSum = (int) sum.invoke(calculator, numA, numB);
        System.out.println("Resultado de la suma: " + resSum);

        // Obtener una referencia al método de multiplicación de la clase Calculadora utilizando Reflection
        Method mult = classCalculator.getMethod("multTwoValues", int.class, int.class);

        // Llamar al método de multiplicación de la clase Calculadora utilizando Reflection
        int restMult = (int) mult.invoke(calculator, numA, numB);
        System.out.println("Resultado de la multiplicación: " + restMult);
    }

}
