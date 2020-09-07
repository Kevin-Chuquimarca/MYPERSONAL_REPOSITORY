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
public class Wall {

    Coordinate coordinate;
    int horizontalVertical; //horizontal = 0; vertical = 1; |orientation

    public Wall(Coordinate coordinate, int horizontalVertical) {
        this.coordinate = coordinate;
        this.horizontalVertical = horizontalVertical;
    }
}
