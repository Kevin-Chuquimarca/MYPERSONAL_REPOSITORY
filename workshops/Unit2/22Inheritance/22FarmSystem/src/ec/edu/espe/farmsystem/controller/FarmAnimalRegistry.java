/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.controller;

import ec.edu.espe.farmsystem.model.Chicken;
import ec.edu.espe.farmsystem.model.Crow;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.Date;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmAnimalRegistry {

    FarmAnimal farmAnimal;
    ImputValidation in = new ImputValidation();

    public boolean recordAnimal() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        int day = in.getInt("Enter the day[00]:", 2);
        int month = in.getInt("Enter the month[00]:", 2);
        int year = in.getInt("Enter the year[20--]:", 4) - 1900;
        farmAnimal = new FarmAnimal(id, breed, new Date(year, month, day));
        System.out.println("Farm Animal -> " + farmAnimal);
        System.out.println("Month -> " + farmAnimal.getAgeInMonths());
        return true;
    }

    public boolean recordChicken() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        int day = in.getInt("Enter the day[00]:", 2);
        int month = in.getInt("Enter the month[00]:", 2);
        int year = in.getInt("Enter the year[20--]:", 4) - 1900;
        farmAnimal = new Chicken(id, breed, new Date(year, month, day), true);
        System.out.println("Chicken -> " + farmAnimal);
        System.out.println("Month -> " + farmAnimal.getAgeInMonths());
        System.out.println(Chicken.putEgg(month));
        return true;
    }

    public boolean recordPig() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        int day = in.getInt("Enter the day[00]:", 2);
        int month = in.getInt("Enter the month[00]:", 2);
        int year = in.getInt("Enter the year[20--]:", 4) - 1900;
        farmAnimal = new Pig(100.5F, id, breed, new Date(year, month, day));
        System.out.println("Pig -> " + farmAnimal);
        System.out.println("Month -> " + farmAnimal.getAgeInMonths());
        System.out.println(Pig.toSellPig());
        return true;
    }

    public boolean recordCrow() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        int day = in.getInt("Enter the day[00]:", 2);
        int month = in.getInt("Enter the month[00]:", 2);
        int year = in.getInt("Enter the year[20--]:", 4) - 1900;
        String sex = in.getString("Enter the sex: ");
        farmAnimal = new Crow(sex, id, breed, new Date(year, month, day));
        System.out.println("Crow -> " + farmAnimal);
        System.out.println("Month -> " + farmAnimal.getAgeInMonths());
        System.out.println(Crow.fly(month));
        return true;
    }

    public boolean recordSheep() {
        int id = in.getInt("Enter the id[0000]: ", 4);
        String breed = in.getString("Enter the breed: ");
        int day = in.getInt("Enter the day[00]:", 2);
        int month = in.getInt("Enter the month[00]:", 2);
        int year = in.getInt("Enter the year[20--]:", 4) - 1900;
        farmAnimal = new Sheep(true, id, breed, new Date(year, month, day));
        System.out.println("Pig -> " + farmAnimal);
        System.out.println("Month -> " + farmAnimal.getAgeInMonths());
        System.out.println(Sheep.cutTheWool());
        return true;
    }
}
