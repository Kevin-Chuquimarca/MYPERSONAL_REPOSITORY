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
public class I {

    private int z;

    public I(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "I{" + "z=" + z + '}';
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
