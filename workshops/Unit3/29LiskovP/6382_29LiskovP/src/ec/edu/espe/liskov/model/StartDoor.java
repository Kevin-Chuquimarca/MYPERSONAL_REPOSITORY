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
public class StartDoor extends Door {

    public StartDoor(Coordinate coordinate, int horizontal, boolean open) {
        super(coordinate, horizontal, open);
    }
    
    public boolean startGame(){
        System.out.println("Starting th game");
        //if the door is here ... then true, else false
        return true;
    }
}
