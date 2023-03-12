/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Cliente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author santi
 */
@Named
@RequestScoped
public class ControladorCliente {
    @Inject
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String navegarAConfirmacion() {
        //en una aplicacion real, deberiamos salvar los 
        //nuevos clientes a la base de datos aqui.
        return "confirmacion";
    }
}
