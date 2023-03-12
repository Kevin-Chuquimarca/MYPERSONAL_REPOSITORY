/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.jpa;

import ec.edu.monster.modelo.entidades.PeempEmple;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author santi
 */
@Stateless
public class PeempEmpleFacade extends AbstractFacade<PeempEmple> {

    @PersistenceContext(unitName = "CRUDLoginGrupo05PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeempEmpleFacade() {
        super(PeempEmple.class);
    }

    public PeempEmple findByPeempCodigo(String peempCodigo) {
        try {
            return find(peempCodigo);
        } catch (Exception e) {
            return new PeempEmple();
        }
    }

    public PeempEmple findByPeempEmail(String peempEmail) {
        try {
            TypedQuery<PeempEmple> query = em.createNamedQuery("PeempEmple.findByPeempEmail", PeempEmple.class);
            query.setParameter("peempEmail", peempEmail);
            return query.getSingleResult();
        } catch (Exception e) {
            return new PeempEmple();
        }
    }

    public String findPeempCodigoByPeempEmail(String peempEmail) {
        try {
            TypedQuery<PeempEmple> query = em.createNamedQuery("PeempEmple.findByPeempEmail", PeempEmple.class);
            query.setParameter("peempEmail", peempEmail);
            return query.getSingleResult().getPeempCodigo();
        } catch (Exception e) {
            return "";
        }
    }

    public String findPeempEmailByPeempEmail(String peempEmail) {
        try {
            TypedQuery<PeempEmple> query = em.createNamedQuery("PeempEmple.findByPeempEmail", PeempEmple.class);
            query.setParameter("peempEmail", peempEmail);
            return query.getSingleResult().getPeempEmail();
        } catch (Exception e) {
            return "";
        }
    }
    
    public List<PeempEmple> findEmpleadosByPeempFecnac(Date peempFecnac){
        try {
            TypedQuery<PeempEmple> query = em.createNamedQuery("PeempEmple.findByPeempFecnac", PeempEmple.class);
            query.setParameter("peempFecnac", peempFecnac);
            return query.getResultList();
        } catch (Exception e) {
            return findAll();
        }
    }
}
