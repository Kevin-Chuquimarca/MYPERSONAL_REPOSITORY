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
public class D extends B{

    public D(int s, int t) {
        super(s, t);
    }
    
    @Override
    public void m1(){
        System.out.println("m1() in D");
    }

    @Override
    public String toString() {
        return "D{" + super.toString() + '}';
    }
}
