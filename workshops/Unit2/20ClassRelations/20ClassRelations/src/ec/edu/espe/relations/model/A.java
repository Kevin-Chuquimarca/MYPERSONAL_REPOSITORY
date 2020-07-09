/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.relations.model;

import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class A {
    private B b;
    private ArrayList<C> cs;
    private D d;

    public A(B b, ArrayList<C> cs, D d) {
        this.b = b;
        this.cs = cs;
        this.d = d;
    }
    
    
    
    public void m(E e){
        
    }
    
    public D m(){
        return d;
    }
}
