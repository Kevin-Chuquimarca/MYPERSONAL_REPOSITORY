/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.liskov.model;

import java.util.ArrayList;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Path {

    Maze maze; //?
    ArrayList<Door> dooes; //? Door[] ?

    ArrayList<Path> generate() {
        System.out.println("Generating the path");
        connectStarWithEnd();
        return new ArrayList<Path>();
    }

    boolean validate() {
        System.out.println("Validating path");
        return true;
    }

    boolean connectStarWithEnd() {
        System.out.println("");
        return true;
    }
    
    boolean verufySinglePath(){
        System.out.println("varify that is only one path in the maze");
        return true;
    }
}
