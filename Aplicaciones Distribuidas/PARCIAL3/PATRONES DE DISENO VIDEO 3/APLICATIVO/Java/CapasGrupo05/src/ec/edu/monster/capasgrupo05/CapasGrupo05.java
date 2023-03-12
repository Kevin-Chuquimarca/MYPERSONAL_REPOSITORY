/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.capasgrupo05;

import ec.edu.monster.capasgrupo05.service.CakeBakingService;
import ec.edu.monster.capasgrupo05.service.CakeBakingServiceImpl;

/**
 *
 * @author santi
 */
public class CapasGrupo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CakeBakingService cakeService = new CakeBakingServiceImpl();
        var cakes = cakeService.getAllCakes();
        for (var cake: cakes){
            System.out.println(cake.getNombre());
        }
    }
    
}
