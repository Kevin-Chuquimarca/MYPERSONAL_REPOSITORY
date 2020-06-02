/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.objectandclasses.model;

/**
 *
 * @author santi
 */
public class Chicken {

    private String name;
    private String color;
    private int age;
    private boolean isMolting;

    public void doStuff() {
        cluck();
        wander();
        eat();
        drink();
        poop();
        
        layAndEgg();
    }

    private void cluck() {
        System.out.println("The chicken " + name + " is clucking");
    }

    private void wander() {
        System.out.println("The chicken " + name + " is wandering");
    }

    private void eat() {
        System.out.println("The chicken " + name + " is eating");
    }

    private void drink() {
        System.out.println("The chicken " + name + " is drinking");
    }

    private Poop poop() {
        Poop poopObject = new Poop(); //instance of Poop
        System.out.println("The chicken " + name + " is pooping");
        return poopObject;
    }

    private Egg layAndEgg() {
        Egg egg = new Egg();
        if (!isMolting) {
            System.out.println("The chicken " + name + " is laying and egg");
        }
        return null;
    }
}
