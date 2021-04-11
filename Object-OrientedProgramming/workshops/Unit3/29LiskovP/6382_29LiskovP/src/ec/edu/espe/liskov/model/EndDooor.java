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
public class EndDooor extends Door {

    public EndDooor(Coordinate coordinate, int horizontal, boolean open) {
        super(coordinate, horizontal, open);
    }
    
    public boolean win(){
        System.out.println("you´ve won the game");
        return true;
    }
}
