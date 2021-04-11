/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.objectandclasses.view;

import ec.edu.espe.objectandclasses.model.Chicken;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class CollectionsAndArrays {
    public static void main(String[] args) {
        System.out.println("Chuquimarca Kevin --> 05ObjectsAndClasses");
        Collection things;
        things = new ArrayList();
        Chicken chicken = new Chicken("Lucy", "browm", 2, false);
        
        System.out.println("things ArrayList size --> " + things.size());
        
        things.add(1000);
        things.add("Hello ESPE guys");
        things.add(2567.25F);
        things.add(true);
        things.add("E");
        things.add(chicken);
        things.add(new Chicken("Maria", "white", 1, true));
        things.add(new Chicken("Lucy", "black", 2, true));
        things.add(5);
        things.add(5);
        things.add(5);
        things.add(5);
        
        System.out.println("Our list elements are --> " + things);
        System.out.println("things ArrayList size --> " + things.size());
        
        Object[] thingsArray = new Object[things.size()];
        
        thingsArray = things.toArray();
        
        System.out.println("thingsArray 6th element " + thingsArray[5]);
    
        things.remove(1000);
        
        System.out.println("thingsArray 6th element " + thingsArray[5]);
        
        System.out.println("value returned when removing a chicken -->" + things.remove(chicken));
        things.remove(chicken);
        things.remove(5);
        
        System.out.println("Our list elements are --> " + things);
        System.out.println("things ArrayList size --> " + things.size());
        
        System.out.println("value returned when removing a chicken -->" + things.remove(chicken));
        things.remove(chicken); 
        
        System.out.println("Our list elements are --> " + things);
        System.out.println("things ArrayList size --> " + things.size());
        
        Collection<Chicken> chickens = new ArrayList<>();   //solo se puede insertar objetos de tipo chicken
        
        for (int i = 0; i<5; i++){
            chickens.add(new Chicken("chickensito_ " + (i+1), "white" + (i+1), i, false));
        }
        
        chickens.forEach((chick) -> {
            System.out.println("chicken " + chick);
        });
    }
}
