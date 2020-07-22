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
public class B {

    private int s;
    private int t;
    
    IF[] fs = new IF[3];

    public B(int s, int t) {
        this.s = s;
        this.t = t;
    }

    public void m1(){
        System.out.println("m1() in B");
    }

    @Override
    public String toString() {
        return "B{" + "s=" + s + ", t=" + t + '}';
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
}
