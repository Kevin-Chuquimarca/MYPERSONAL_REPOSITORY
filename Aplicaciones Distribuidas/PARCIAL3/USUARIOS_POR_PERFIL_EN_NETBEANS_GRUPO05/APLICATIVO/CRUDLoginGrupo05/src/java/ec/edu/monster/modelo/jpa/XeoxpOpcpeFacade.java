/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.jpa;

import ec.edu.monster.modelo.entidades.XeoxpOpcpe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author santi
 */
@Stateless
public class XeoxpOpcpeFacade extends AbstractFacade<XeoxpOpcpe> {

    @PersistenceContext(unitName = "CRUDLoginGrupo05PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeoxpOpcpeFacade() {
        super(XeoxpOpcpe.class);
    }
    
    public XeoxpOpcpe findByXeopcCodigoAndXeperCodigo(String xeopcCodigo, String xeperCodigo){
        try {
            TypedQuery<XeoxpOpcpe> query = em.createNamedQuery("XeoxpOpcpe.findByXeopcCodigoAndXeperCodigo", XeoxpOpcpe.class);
            query.setParameter("xeopcCodigo", xeopcCodigo);
            query.setParameter("xeperCodigo", xeperCodigo);
            return query.getSingleResult();
        } catch (Exception e) {
            return new XeoxpOpcpe();
        }
    }
    
}
