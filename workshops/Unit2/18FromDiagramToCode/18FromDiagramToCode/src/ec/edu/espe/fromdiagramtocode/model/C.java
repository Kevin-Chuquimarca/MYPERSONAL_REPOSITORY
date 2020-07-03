/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.fromdiagramtocode.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class C {
    private F f;
    private E[] e = new E[5];

    public C(F f) {
        this.f = f;
    }
    
    public E[] m(D d){
        
        return e;
    } 

    @Override
    public String toString() {
        return "C{" + "f=" + f + ", e=" + e + '}';
    }
}
