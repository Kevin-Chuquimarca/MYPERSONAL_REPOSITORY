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

    private int id;
    private String name;
    private String color;
    private int age;
    private boolean isMolting;

    public Chicken(int id, String name, String color, int age, boolean isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.isMolting = isMolting;
    }
    
    public void doStuff(int forTime) {
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
        Egg egg = new Egg(1);
        if (!isMolting) {
            System.out.println("The chicken " + name + " is laying and egg");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color + ", age=" + age + ", isMolting=" + isMolting + '}';
    }
    
    public String generateCsvData(){
        return id + "," + name + "," + color + "," + age + "," + isMolting + '}';
    }
}
