/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.liskov.view;

import ec.edu.espe.liskov.model.Maze;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class MazeSystem {
    
    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> Maze");
        Maze maze = new Maze(null, 10, 10, null, null);
        maze.draw(maze.build());
    }
}
