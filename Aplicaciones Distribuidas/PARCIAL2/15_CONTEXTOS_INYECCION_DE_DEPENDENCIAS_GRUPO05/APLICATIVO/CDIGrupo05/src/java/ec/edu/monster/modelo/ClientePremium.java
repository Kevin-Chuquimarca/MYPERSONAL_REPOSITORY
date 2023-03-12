/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.qualifier.Premium;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author santi
 */
@Named
@RequestScoped
@Premium
public class ClientePremium extends Cliente {

    private Integer codigoDescuento;

    public Integer getCodigoDescuento() {
        return codigoDescuento;
    }

    public void setCodigoDescuento(Integer codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }
}