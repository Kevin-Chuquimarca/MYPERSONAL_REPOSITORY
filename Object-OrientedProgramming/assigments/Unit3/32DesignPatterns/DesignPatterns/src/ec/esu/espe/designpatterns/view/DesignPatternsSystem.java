/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.esu.espe.designpatterns.view;

import ec.esu.espe.designpatterns.abstractfactory.ClientApp;
import ec.esu.espe.designpatterns.composite.Setup;
import ec.esu.espe.designpatterns.template.BeverageTest;
import java.util.Scanner;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class DesignPatternsSystem {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> Design Patterns");
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1:Abstract Factory\n2: Composite\n3: Template\n");
            System.out.println("Enter the option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    ClientApp.clientApp();
                    break;
                case 2:
                    Setup.setup();
                    break;
                case 3:
                    BeverageTest.beveragetest();
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        } while (option != 4);
    }
}
