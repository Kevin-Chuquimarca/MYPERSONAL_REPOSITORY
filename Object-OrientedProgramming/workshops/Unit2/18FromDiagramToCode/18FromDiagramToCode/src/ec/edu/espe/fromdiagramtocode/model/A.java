/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.fromdiagramtocode.model;

import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class A {
    private ArrayList<B> b;

    public A(ArrayList<B> b) {
        this.b = b;
    }
    
    public void m(D d){
        
    }
    
    public void m2(C c){
        
    }

    @Override
    public String toString() {
        return "A{" + "b=" + b + '}';
    }
}
