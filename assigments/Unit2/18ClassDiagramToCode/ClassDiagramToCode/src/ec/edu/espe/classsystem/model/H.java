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
public class H extends G{

    I i;
    
    public H(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void m() {
        System.out.println("m() in H");
    }
    
    @Override
    public void m(int p) {
        System.out.println("m(int q) in H");
    }

    @Override
    public void m(float q) {
        System.out.println("m(float q) in H");
    }
    
    @Override
    public String toString() {
        return "H{" + super.toString() + '}';
    }
}
