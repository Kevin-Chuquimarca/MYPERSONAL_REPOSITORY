/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.antcolonysimulation.view;

import ec.edu.espe.antcolonysimulation.model.Area;
import ec.edu.espe.antcolonysimulation.model.Colony;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class SimulatorDisplay {
    Area areas[];
    
    public static void main(String[] args) {
        System.out.println("Kevin Chuquimarca --> 07Associations<--");
        
        Area area = new Area();
        Colony colony = new Colony();
        
        
        area.setup();
        area.add(colony);
    }
}
