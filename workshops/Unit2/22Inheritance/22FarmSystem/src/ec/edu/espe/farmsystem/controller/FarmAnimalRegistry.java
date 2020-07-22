/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.farmsystem.controller;

import ec.edu.espe.farmsystem.model.Chicken;
import ec.edu.espe.farmsystem.model.Cow;
import ec.edu.espe.farmsystem.model.FarmAnimal;
import ec.edu.espe.farmsystem.model.Horse;
import ec.edu.espe.farmsystem.model.Pig;
import ec.edu.espe.farmsystem.model.Sheep;
import ec.edu.espe.farmsystem.utils.ImputValidation;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class FarmAnimalRegistry {

    FarmAnimal farmAnimal;
    ImputValidation in = new ImputValidation();
    Scanner scanner = new Scanner(System.in);

    public FarmAnimal recordAnimal() {
        String breed = in.getString("Enter the name of the animal: ");
        int id = in.getInt("Enter the id[0000]: ", 4);
        int day = in.getInt("Enter the day[00]:", 2);
        int month = in.getInt("Enter the month[00]:", 2) - 1;
        int year = in.getInt("Enter the year[20--]:", 4) - 1900;
        int sexOfAnimal = recordSexOfTheAnimal();
        farmAnimal = new FarmAnimal(id, breed, new Date(year, month, day), sexOfAnimal);
        return farmAnimal;
    }

    public int recordSexOfTheAnimal() {
        int sexOfAnimal;
        do {
            sexOfAnimal = in.getInt("Select the sex of Animal\n 1: "
                    + "female\n 2: male", 1);
        } while (!(sexOfAnimal == 1 | sexOfAnimal == 2));
        return sexOfAnimal;
    }

    public FarmAnimal recordChicken(FarmAnimal chicken) {
        String breed = in.getString("Enter the breed of the chicken: ");
        farmAnimal = new Chicken(chicken.getId(), chicken.getBreed() + " "
                + breed, chicken.getBornOn(), chicken.getSexOfAnimal(), true, 0);
        int ageInMonths = chicken.getAgeInMonths();
        if (chicken.getSexOfAnimal() == 1 & ageInMonths > 4) {
            int daysOfLife = chicken.getAgeInDays();
            int eggs = Chicken.calculateEggsOfChicken(daysOfLife);
            System.out.println("Chicken -> " + chicken.toString());
            System.out.println("Eggs -> " + eggs);
            System.out.println("Price of Eggs -> " + Chicken.calculatePriceOfEggs(eggs, 
                    in.getInt("Enter the price of Eggs in cents: ", 2)));
        } else {
            System.out.println("Chicken -> " + chicken.toString());
        }
        System.out.println("Month -> " + ageInMonths);
        return farmAnimal;
    }

    public FarmAnimal recordPig(FarmAnimal pig) {
        String breed = in.getString("Enter the breed of the pig: ");
        String answer = in.getYesOrNo("The pig is sterelized[yes/no]: ");
        farmAnimal = new Pig(pig.getId(), pig.getBreed() + " " + breed,
                pig.getBornOn(), pig.getSexOfAnimal(), false, 0.0F);
        System.out.println("Enter the wight in KG: ");
        Pig.setWeightKG(scanner.nextFloat());
        if ("yes".equals(answer)) {
            Pig.setSterilized(true);
            Pig.increaseFood(pig.getAgeInMonths());
        }
        System.out.println("Pig -> " + pig.toString());
        System.out.println("Price of pig-> $" + Pig.calculatePriceOfThePig());
        System.out.println("Month -> " + pig.getAgeInMonths());
        return farmAnimal;
    }

    public FarmAnimal recordCow(FarmAnimal cow) {
        String breed = in.getString("Enter the breed of the cow: ");
        farmAnimal = new Cow(cow.getId(), cow.getBreed() + " " + breed,
                cow.getBornOn(), cow.getSexOfAnimal(), false, 0.0F);
        int ageInMonths = farmAnimal.getAgeInMonths();
        if (cow.getSexOfAnimal() == 1 & ageInMonths >= 24) {
            if ("yes".equals(in.getYesOrNo("The cow produce milk [yes/no]: "))) {
                Cow.setItProduceMilk(true);
                System.out.println("Enter liters of milk produced daily: ");
                Cow.setLitersOfMilk(scanner.nextFloat());
                Cow.calculateLitersOfMilkMonthly(ageInMonths);
                Cow.determineInseminationDate(ageInMonths, cow.getBornOn());
            }
        }
        System.out.println("Crow -> " + farmAnimal);
        System.out.println("Month -> " + ageInMonths);
        return farmAnimal;
    }

    public FarmAnimal recordSheep(FarmAnimal sheep) {
        String breed = in.getString("Enter the breed of the sheep: ");
        farmAnimal = new Sheep(sheep.getId(), sheep.
                getBreed() + " " + breed, sheep.getBornOn(),
                sheep.getSexOfAnimal(), false, "");
        Sheep.setColorWool(in.getString("Enter the color of wool: "));
        System.out.println("Sheep -> " + farmAnimal);
        int months = farmAnimal.getAgeInMonths();
        System.out.println("Date for first cut wool: " + 
                Sheep.recordForNextCutWool(sheep.getBornOn(), months));
        System.out.println(Sheep.cutTheWool());
        System.out.println("Month -> " + months);
        return farmAnimal;
    }

    public FarmAnimal recordHorse(FarmAnimal horse) {
        String breed = in.getString("Enter the breed of the horse: ");
        farmAnimal = new Horse(horse.getId(), horse.
                getBreed() + " " + breed, horse.getBornOn(),
                horse.getSexOfAnimal(), false, 0.0F);
        if ("yes".equals(in.getYesOrNo("The horse is tamed[yes/no]: "))) {
            Horse.setTamed(true);
            System.out.println("Spped of horse[m/s]: " + 
                    Horse.calculateSppedMaxOfHorse());
        }
        System.out.println("Enter the price of the horse: ");
        Horse.setPrice(scanner.nextFloat());
        System.out.println("Horse -> " + farmAnimal);
        System.out.println("Month -> " + farmAnimal.getAgeInMonths());
        return farmAnimal;
    }
}
