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
public class K {

    private int k;

    public K(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "K{" + "k=" + k + '}';
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
