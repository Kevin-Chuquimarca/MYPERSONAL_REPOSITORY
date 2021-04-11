/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.objectandclasses.view;

import ec.edu.espe.objectandclasses.model.Chicken;
import ec.edu.espe.objectandclasses.utils.FileManager;


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
        System.out.println(chicken);
        
        FileManager fileManager = new FileManager();
        
        fileManager.createFile(fileName);
        fileManager.writeString(chicken.generateCsvData(), fileName);
        fileManager.read(fileName);
        
        System.out.println(fileManager.read(fileName));
        
        //chicken.id = 4;
        //chicken.name = "Luci";
        
        chicken.setId(0);
        chicken.setName("Lucia");
        
        System.out.println(chicken.getName());
    }
}
