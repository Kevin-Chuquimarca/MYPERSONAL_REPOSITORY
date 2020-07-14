/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * Kevin Chuquimarca ESPE-DCCO
 */
public class Sheep extends FarmAnimal{
    private static boolean hasWool;

    public Sheep(boolean hasWool, int id, String breed, Date bornOn) {
        super(id, breed, bornOn);
        Sheep.hasWool = hasWool;
    }
    
    public static String cutTheWool(){
        if (hasWool==true){
            return "The sheep is ready that cut her wool";
        }
        return "The sheep isn't ready that cut her wool";
    }

    @Override
    public String toString() {
        return "Sheep{" + "hasWool=" + hasWool + super.toString() + '}';
    }

    public boolean isHasWool() {
        return hasWool;
    }

    public void setHasWool(boolean hasWool) {
        Sheep.hasWool = hasWool;
    }
}
