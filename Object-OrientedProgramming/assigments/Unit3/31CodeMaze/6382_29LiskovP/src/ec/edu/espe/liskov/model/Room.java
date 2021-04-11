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
public class Room {

    Wall walls[] = new Wall[3];
    Door doors[] = new Door[3];
    int doorQuantity = 1;
    int wallQuantity = 1;

    public Room(Wall walls[], Door doors[], int doorQuantity, int wallQuantity) {
        this.walls[3] = walls[3];
        this.doors[3] = doors[3];
        this.doorQuantity = doorQuantity;
        this.wallQuantity = wallQuantity;
    }

    public Door[] createDoors(int doorQuantity, Coordinate coordinates[], int horizontalVertical[], boolean open) {
        //verify/control no more 3 door
        if (doorQuantity <= 3 && doorQuantity > 0) {
            this.doorQuantity = doorQuantity;
            if ((doorQuantity + wallQuantity) <= 4) {
                System.out.println("Building " + this.doorQuantity + "doors");
                for (int i = 0; i < this.doorQuantity; i++) {
                    // TODO control walls and doors coordinates and orientation
                    doors[i] = new Door(coordinates[i], horizontalVertical[i], open);
                    doors[i].open();
                    return doors;
                }
            } else {
                System.out.println("Exceeding number of doors and walls");
                return null;
            }
        } else {
            System.out.println("Exceeding number of maximun doors");
        }
        return null;
    }

    public Wall[] createWalls(int wallQuantity, Coordinate coordinates[], int horizontalVertical[]) {
        if (wallQuantity <= 3 && wallQuantity > 0) {
            this.doorQuantity = wallQuantity;
            if ((wallQuantity + wallQuantity) <= 4) {
                System.out.println("Building " + this.doorQuantity + "doors");
                for (int i = 0; i < this.doorQuantity; i++) {
                    // TODO control walls and doors coordinates and orientation
                    walls[i] = new Wall(coordinates[i], horizontalVertical[i]);
                    //walls[i].open();
                }
                return walls;
            } else {
                System.out.println("Exceeding number of doors and walls");
                return null;
            }
        } else {
            System.out.println("Exceeding number of maximun doors");
            return null;
        }
    }
}
