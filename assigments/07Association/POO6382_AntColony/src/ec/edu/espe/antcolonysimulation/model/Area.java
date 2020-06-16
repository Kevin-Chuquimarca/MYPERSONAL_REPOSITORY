/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.antcolonysimulation.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Area {
    private int width;
    private int height;
    private int initNumberOfFoodPiles;
    private int tickDuration;
    
    Colony colonies[];
    AntEater antEaters[];
    FoodPile foodPiles[];
    Cell cells[];
    
    public void setup(){
        
    }
    
    public void add(Colony colony){
        
    }
    
    public void add(AntEater antEater){
        
    }
    
    public boolean isAnyFoodRemaining(){
        return false;
        
    }
    
    public Cell getcell(Cell row, Cell col){
        Cell cell = new Cell();
        //TODO code to handle the cell
        
        return cell;
    }
}
