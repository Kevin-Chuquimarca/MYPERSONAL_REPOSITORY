/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.classsystem.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class C extends B{

    public C(int s, int t) {
        super(s, t);
    }
    
    @Override
    public void m1(){
        System.out.println("m1() in C");
    }

    @Override
    public String toString() {
        return "C{" + super.toString() + '}';
    }
}
