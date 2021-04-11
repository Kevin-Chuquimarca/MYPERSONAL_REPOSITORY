/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.designpatterns.view;

import ec.edu.espe.designpatterns.observer.PObserved;
import ec.edu.espe.designpatterns.strategy.SortApp;
import java.util.Scanner;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class DesignPatterns {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> Design Patterns");
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("1: Observer\n2: Strategy\nEnter the option: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    PObserved.pObserved();
                    break;
                case 2:
                    SortApp.sortApp();
                    break;
                default:
                    break;
            }
        } while (option != 3);
    }
}
