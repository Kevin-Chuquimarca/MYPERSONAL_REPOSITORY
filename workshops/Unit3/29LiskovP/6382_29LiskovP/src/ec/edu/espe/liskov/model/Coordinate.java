/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.liskov.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Coordinate {
    
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void  setPosition(int nextX, int nextY){
        x = nextX;
        y = nextY;
    }
    
    public void move(int shiftX, int shiftY){
        x = x + shiftX;
        y = y + shiftY;
    }
}
