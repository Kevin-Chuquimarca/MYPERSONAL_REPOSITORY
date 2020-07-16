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
public class Sheep extends FarmAnimal {

    private static boolean hasWool;
    private static String colorWool;

    public Sheep(int id, String breed, Date bornOn, int sexOfAnimal,
            boolean hasWool, String colorWool) {
        super(id, breed, bornOn, sexOfAnimal);
        Sheep.hasWool = hasWool;
        Sheep.colorWool = colorWool;
    }

    public static Date recordForNextCutWool(Date date, int months){
        if (months >= 6){
            Sheep.hasWool = true;
            return new Date(date.getYear(), date.getMonth() + 5, date.getDay());
        }
        return null;
    }

    public static String cutTheWool() {
        if (hasWool == true) {
            return "The sheep is ready that cut her wool";
        }
        return "The sheep isn't ready that cut her wool";
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + ", hasWool= " + hasWool
                + ", colorWool= " + colorWool + '}';
    }

    public static boolean isHasWool() {
        return hasWool;
    }

    public static void setHasWool(boolean hasWool) {
        Sheep.hasWool = hasWool;
    }

    public static String getColorWool() {
        return colorWool;
    }

    public static void setColorWool(String colorWool) {
        Sheep.colorWool = colorWool;
    }
    
    
}
