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
public class B {
    private C[] c = new C[10];

    public B(C[] c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "B{" + "c=" + c + '}';
    }
}
