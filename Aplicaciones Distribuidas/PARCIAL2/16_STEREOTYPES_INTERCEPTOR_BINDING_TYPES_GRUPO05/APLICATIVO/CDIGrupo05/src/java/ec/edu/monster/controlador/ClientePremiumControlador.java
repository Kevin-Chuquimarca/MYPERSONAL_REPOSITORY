/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.interceptorbinding.InterceptorInicioSesionBinding;
import ec.edu.monster.modelo.Cliente;
import ec.edu.monster.modelo.ClientePremium;
import ec.edu.monster.qualifier.Premium;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author santi
 */
@InterceptorInicioSesionBinding
@Named
@RequestScoped
public class ClientePremiumControlador {

    private static final Logger logger = Logger.getLogger(
            ClientePremiumControlador.class.getName()
    );
    
    @Inject
    @Premium
    private Cliente cliente;
    
    public String salvarCliente(){
        //aqui se guarda la informacion en la base de datos
        ClientePremium clientePremium = (ClientePremium) cliente;
        logger.log(Level.INFO, "Salvando la siguiente informacion \n" + "{0} {1}, codigo descuento = {3}", new Object[]{clientePremium.getNombre(), clientePremium.getPrimerApellido(), clientePremium.getSegundoApellido(), clientePremium.getEmail(), clientePremium.getCodigoDescuento()});
        return "cliente_premium_confirmacion";
    }
}
