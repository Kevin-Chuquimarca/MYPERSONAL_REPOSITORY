/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.esu.espe.designpatterns.abstractfactory;

import java.util.Scanner;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public abstract class GUIFactory {

    public static GUIFactory getFactory() {
        Scanner scan = new Scanner(System.in);
        System.out.println("0: WinFactory\n1: LinuxFactory\n");
        System.out.println("Enter the option: ");
        int sys = scan.nextInt();
        if (sys == 0) {
            return (new WinFactory());
        } else {
            return (new LinuxFactory());
        }
    }

    public abstract Button createButton();

    public abstract Menu createMenu();
}
