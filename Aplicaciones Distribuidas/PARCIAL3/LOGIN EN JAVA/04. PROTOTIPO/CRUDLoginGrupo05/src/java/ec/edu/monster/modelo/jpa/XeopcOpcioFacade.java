/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.jpa;

import ec.edu.monster.modelo.entidades.XeopcOpcio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author santi
 */
@Stateless
public class XeopcOpcioFacade extends AbstractFacade<XeopcOpcio> {

    @PersistenceContext(unitName = "CRUDLoginGrupo05PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeopcOpcioFacade() {
        super(XeopcOpcio.class);
    }
    
}
