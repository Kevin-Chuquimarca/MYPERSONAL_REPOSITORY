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
//check the coordinates
//check the rooms created
//chech paths
public class Maze {

    Path path;
    int height;
    int width;
    StartDoor startDoor;
    EndDooor endDoor;
    Coordinate coordinate = new Coordinate(0, 0);
    ArrayList<Room> rooms = new ArrayList<>();
    String[][] maze;

    public Maze(Path path, int height, int width, StartDoor startDoor, EndDooor endDoor) {
        this.path = path;
        this.height = height;
        this.width = width;
        this.startDoor = startDoor;
        this.endDoor = endDoor;
    }

    public String[][] build() {
        maze = new String[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = "  ";
                if (j % 2 == 0) {
                    maze[i][j] = " |";
                } else {
                    maze[i][j] = " _";
                }
                if (i == 0 | i == width - 1) {
                    maze[i][j] = " _";
                }
                if ((j % 3 == 0 && i % 4 == 0) | (j % 2 == 0 && i % 5 == 0) | 
                        (j % 4 == 0 && i % 2 == 0)) {
                    maze[i][j] = "  ";
                }
            }
        }
        return maze;
    }

    public void draw(String[][] maze) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

}
