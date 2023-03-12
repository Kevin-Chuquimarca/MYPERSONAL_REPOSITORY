/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.jpa;

import ec.edu.monster.modelo.entidades.XeusuUsuar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author santi
 */
@Stateless
public class XeusuUsuarFacade extends AbstractFacade<XeusuUsuar> {

    @PersistenceContext(unitName = "CRUDLoginGrupo05PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeusuUsuarFacade() {
        super(XeusuUsuar.class);
    }
    
    public XeusuUsuar findByXeusuPaswd(String xeusuPaswd) {
        try {
            return find(xeusuPaswd);
        } catch (Exception e) {
            return new XeusuUsuar();
        }
    }
    
    public String findXeusuPaswdByXeusuPaswd(String xeusuPaswd) {
        try {
            TypedQuery<XeusuUsuar> query = em.createNamedQuery("XeusuUsuar.findByXeusuPaswd", XeusuUsuar.class);
            query.setParameter("xeusuPaswd", xeusuPaswd);
            return query.getSingleResult().getXeusuPaswd();
        } catch (Exception e) {
            return "";
        }
    }
    
    public String findXeusuPaswdByPeempEmail(String peempEmail) {
        try {
            TypedQuery<String> query = em.createNamedQuery("XeusuUsuar.findXeusuPaswdByPeempEmail", String.class);
            query.setParameter("peempEmail", peempEmail);
            return query.getSingleResult();
        } catch (Exception e) {
            return "";
        }
    }
}
