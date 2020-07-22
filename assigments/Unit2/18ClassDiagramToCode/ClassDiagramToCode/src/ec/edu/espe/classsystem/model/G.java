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
public abstract class G implements IF {
    private int x;
    private int y;

    public G(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "G{" + "x=" + x + ", y=" + y + '}';
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
