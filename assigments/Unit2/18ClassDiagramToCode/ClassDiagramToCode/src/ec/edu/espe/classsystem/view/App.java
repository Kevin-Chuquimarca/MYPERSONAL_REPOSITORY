/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.classsystem.view;

import ec.edu.espe.classsystem.model.A;
import ec.edu.espe.classsystem.model.B;
import ec.edu.espe.classsystem.model.C;
import ec.edu.espe.classsystem.model.D;
import ec.edu.espe.classsystem.model.E;
import ec.edu.espe.classsystem.model.IF;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> 17ClassDiagramToCode");
        A[] as = new A[3];
        B b = new B(0, 0);
        System.out.println(b.toString());
        b.m1();
        b = new C(1, 1);
        System.out.println(b.toString());
        b.m1();
        b = new D(2, 2);
        System.out.println(b.toString());
        b.m1();
        b = new E(3, 3, 3, 3);
        System.out.println(b.toString());
        IF f = new ec.edu.espe.classsystem.model.H(0, 0);
        f.toString();
        f.m();
        f.m(0);
        f.m(0F);
    }
}
