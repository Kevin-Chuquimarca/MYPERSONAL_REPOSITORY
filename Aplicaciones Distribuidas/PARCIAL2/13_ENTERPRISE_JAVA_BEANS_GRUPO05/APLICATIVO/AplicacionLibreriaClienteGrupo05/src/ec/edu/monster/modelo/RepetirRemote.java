/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ec.edu.monster.modelo;

import javax.ejb.Remote;

/**
 *
 * @author santi
 */
@Remote
public interface RepetirRemote {

    String repetir(String parameter);
    
}
