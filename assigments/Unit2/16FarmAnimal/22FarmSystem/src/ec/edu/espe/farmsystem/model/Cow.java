/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.model;

import java.util.Date;

/**
 *
 * @author santi
 */
public class Cow extends FarmAnimal {

    private static boolean itProduceMilk;
    private static float litersOfMilkPerDay;

    public Cow(int id, String breed, Date bornOn, int sexOfAnimal,
            boolean itProduceMilk, float litersOfMilkPerDay) {
        super(id, breed, bornOn, sexOfAnimal);
        Cow.itProduceMilk = itProduceMilk;
        Cow.litersOfMilkPerDay = litersOfMilkPerDay;
    }

    public static float calculateLitersOfMilkMonthly(int monthOfLifeCow) {
        if (monthOfLifeCow >= 24) {
            return litersOfMilkPerDay * 30;
        }
        return 0f;
    }

    public static Date determineInseminationDate(int month, Date date) {
        if (month <= 15 | itProduceMilk == false) {
            int monthOfBorn = date.getMonth() + 15;
            int yearOfBorn = date.getYear();
            return new Date(yearOfBorn, monthOfBorn, 0);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Crow{" + super.toString() + ", itProduceMilk=" + itProduceMilk
                + ", litersOfMilkPerDay= " + litersOfMilkPerDay + '}';
    }

    public static boolean isItProduceMilk() {
        return itProduceMilk;
    }

    public static void setItProduceMilk(boolean itProduceMilk) {
        Cow.itProduceMilk = itProduceMilk;
    }

    public static float getLitersOfMilk() {
        return litersOfMilkPerDay;
    }

    public static void setLitersOfMilk(float litersOfMilkPerDay) {
        Cow.litersOfMilkPerDay = litersOfMilkPerDay;
    }
}
