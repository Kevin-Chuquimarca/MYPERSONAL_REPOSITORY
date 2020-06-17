/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.objectandclasses.view;

import ec.edu.espe.objectandclasses.model.Chicken;
import ec.edu.espe.objectandclasses.utils.FileManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;


/**
 *
 * @author santi
 */
public class FarmSystem {
    public static void main(String[] args) {
        String fileName = "chickens.csv";
       
        Chicken chicken;
        chicken = new Chicken(1,"Lucy","white",2,false);
        System.out.println("Chuquimarca Kevin --> 05ObjectsAndClasses");
        System.out.println("chicken is instancied using the parametrized constuctor" +chicken);
        
        /*
        FileManager fileManager = new FileManager();
        
        fileManager.createFile(fileName);
        fileManager.writeString(chicken.generateCsvData(), fileName);
        fileManager.read(fileName);
        
        System.out.println(fileManager.read(fileName)); */
        
        //chicken.id = 4;
        //chicken.name = "Luci";
        
        chicken.setId(0);
        chicken.setName("Lucia");
        
        System.out.println("name of chicken" + chicken.getName()); 
        
        //class Object(instancia)  Constructor
        Chicken chicken3 = new Chicken();
        System.out.println("chicken 3 using the no-args constructor -->" + chicken3);
    
        Chicken chicken4 = new Chicken("Maruja", "brown", 1, false);
        
        System.out.println("chicken 4 -->" + chicken4);
        
        Chicken chicken5 = new Chicken("Maria", "black", 1, true);
        
        System.out.println("chicken 5 -->" + chicken5);
        
        System.out.println("indexCounter -->" + chicken5.getIndexCounter());
    
        Chicken chicken6 = new Chicken("Junior", "white", 2, false);
        System.out.println("chicken6 -->" + chicken6);
        
        System.out.println("indexCounter from chicken1" + chicken.getIndexCounter());
    
        int coopMaxSize = 20;
        Chicken[] chickens= new Chicken[coopMaxSize];
        
        for (int j = 0; j < coopMaxSize; j++){
            chickens[j] = new Chicken("chicken_" +(j+1), "white" + j, j, true);
        }
        
        for (int i = 0; i < coopMaxSize; i++){
            System.out.println("chicken" + (i+1) + "-->" + chickens[i]);
        }
        
        
        int coopMaxSize2 = 5;
        Chicken[] chickens2= new Chicken[coopMaxSize2];
        
        for (int j = 0; j < coopMaxSize2; j++){
            chickens2[j] = new Chicken("chicken_" +(j+1), "white" + j, j, true);
        }
        
        for (int i = 0; i < coopMaxSize2; i++){
            System.out.println("chicken" + (i+1) + "-->" + chickens2[i]);
        }
    }
}
