/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.liskov.view;

import ec.edu.espe.liskov.model.Maze;
import java.util.Scanner;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class MazeSystem {

    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> Maze");
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the number of rows: ");
        int row = scan.nextInt();
        System.out.println("enter the number of columns: ");
        int column = scan.nextInt();
        Maze maze = new Maze(null, row, column, null, null);
        maze.draw(maze.build());
    }
}
