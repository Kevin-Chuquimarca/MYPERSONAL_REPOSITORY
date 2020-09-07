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
                if (i % 2 == 0 && j % 3 == 0) {
                    maze[i][j] = "|";
                }
                if (i % 4 == 0 && j % 3 == 0) {
                    maze[i][j] = "_ ";
                }
                if (j == 0 | j == height - 1) {
                    maze[i][j] = "|";
                }
                if (i == 0 | i == width - 1) {
                    maze[i][j] = "_ ";
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
            System.out.println("");
        }
    }

}
