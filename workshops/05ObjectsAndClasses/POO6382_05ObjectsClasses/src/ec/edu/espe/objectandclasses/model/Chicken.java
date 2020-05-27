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
    private boolean nolting;
    
    public void doStuff(){
        
    }
    
    private void cluck(){
        System.out.println("The chicken " + name + " is clucking");
    }
    
    private void wander(){
        System.out.println("The chicken " + name + " is wandering");
    }
}
