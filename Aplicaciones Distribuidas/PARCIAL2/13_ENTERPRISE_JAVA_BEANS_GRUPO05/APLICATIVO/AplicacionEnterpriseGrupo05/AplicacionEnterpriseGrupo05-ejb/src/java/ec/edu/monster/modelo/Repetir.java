/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ec.edu.monster.modelo;

import javax.ejb.Stateless;

/**
 *
 * @author santi
 */
@Stateless
public class Repetir implements RepetirRemote {

    @Override
    public String repetir(String parameter) {
        return "repitiendo: " + parameter;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
