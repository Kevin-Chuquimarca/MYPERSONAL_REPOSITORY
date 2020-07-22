/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.classsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class E extends B {
    
    private int u;
    private int v;
    
    J j;
    ArrayList<K> ks = new ArrayList<>();

    public E(int u, int v, int s, int t) {
        super(s, t);
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return "E{" + super.toString() + "u=" + u + ", v=" + v + '}';
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
