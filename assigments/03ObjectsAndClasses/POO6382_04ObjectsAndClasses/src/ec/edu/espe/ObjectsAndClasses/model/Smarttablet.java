/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ObjectsAndClasses.model;

/**
 *
 * @author santi
 */
public class Smarttablet {
    private String name;
    private String color;
    private String company;
    private int nCamaras;
    
    private void call(){
        System.out.println("The user of Smarttable " + name + " is calling");
    }
    
    public void play(){
        System.out.println("The user of Smarttable " + name + " is playing");
    }
    
    private void senMassage(){
        System.out.println("The user of Smarttable " + name + " is send message");
    }
    
    public void takePictures(){
        System.out.println("The user of Smarttable " + name + " is take a picture");
    }
}
