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
public class OracleConnection extends Connection{
    public OracleConnection(){
        
    }
    
    @Override
    public String description(){
        return "Oracle";
    }
}
