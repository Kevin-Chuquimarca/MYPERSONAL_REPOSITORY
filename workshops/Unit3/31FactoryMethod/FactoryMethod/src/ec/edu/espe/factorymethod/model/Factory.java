/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.factorymethod.model;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public abstract class Factory {
    String type = "";
    
    public Factory(){
        createConnection(type);
    }
    
    protected abstract Connection createConnection(String type);
}
