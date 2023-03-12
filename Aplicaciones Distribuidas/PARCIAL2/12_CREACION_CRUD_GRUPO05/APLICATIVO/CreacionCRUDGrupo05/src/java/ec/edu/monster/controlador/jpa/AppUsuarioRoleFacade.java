/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.jpa;

import ec.edu.monster.modelo.entidades.AppUsuarioRole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author santi
 */
@Stateless
public class AppUsuarioRoleFacade extends AbstractFacade<AppUsuarioRole> {

    @PersistenceContext(unitName = "CreacionCRUDGrupo05PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppUsuarioRoleFacade() {
        super(AppUsuarioRole.class);
    }
    
}
