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
public class Door {

    Coordinate coordinate;
    int horizontal; //horizontal = 0; vertical = 1; |orientation
    boolean open;

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public Door(Coordinate coordinate, int horizontal, boolean open) {
        this.coordinate = coordinate;
        this.horizontal = horizontal;
        this.open = open;
    }
}
