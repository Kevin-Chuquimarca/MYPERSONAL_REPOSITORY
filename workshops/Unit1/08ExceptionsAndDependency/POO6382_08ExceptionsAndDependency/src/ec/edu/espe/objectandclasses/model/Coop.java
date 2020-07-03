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
public class Coop {
    private int id;
    private Chicken chicken[];

    public Coop(int id, Chicken[] chicken) {
        this.id = id;
        this.chicken = chicken;
    }
    
    public void add(Chicken chicken){
        
    } 
    
    public void remove(int chickenId){
        
    }
    
    public void resetIteration(){
        
    }
    
    public Chicken next(){
        return new Chicken(1,"Lucy","White",2,false);
    }
}
