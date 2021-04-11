/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.esu.espe.designpatterns.composite;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class Client {
    
    public static Employee employee;
    
    public static void doClientTasks(){
        employee.stateName();
    }
}
