/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.jpa;

import ec.edu.monster.modelo.entidades.XeopcOpcio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    
    public XeopcOpcio findByXeopcCodigo(String xeopcCodigo) {
        try {
            TypedQuery<XeopcOpcio> query = em.createNamedQuery("XeopcOpcio.findByXeopcCodigo", XeopcOpcio.class);
            query.setParameter("xeopcCodigo", xeopcCodigo);
            return query.getSingleResult();
        } catch (Exception e) {
            return new XeopcOpcio();
        }
    }

    public XeopcOpcio findByXeopcDescri(String xeopcDescri) {
        try {
            TypedQuery<XeopcOpcio> query = em.createNamedQuery("XeopcOpcio.findByXeopcDescri", XeopcOpcio.class);
            query.setParameter("xeopcDescri", xeopcDescri);
            return query.getSingleResult();
        } catch (Exception e) {
            return new XeopcOpcio();
        }
    }

    public List<String> findOptionsByUserPerfil(String passUser) {
        Query query = em.createNativeQuery("select x.XEOPC_CODIGO from xeusu_usuar xe inner join  xeuxp_usupe xu on xe.XEUSU_PASWD = xu.XEUSU_PASWD inner join xeper_perfi xp on xu.XEPER_CODIGO = xp.XEPER_CODIGO inner join xeoxp_opcpe xo on xp.XEPER_CODIGO = xo.XEPER_CODIGO inner join xeopc_opcio x on xo.XEOPC_CODIGO = x.XEOPC_CODIGO where xe.XEUSU_PASWD = '" + passUser + "';");
        List<Object[]> results = query.getResultList();
        List<String> usuarios = new ArrayList<>();
        for (Object row : results) {
            usuarios.add((String) row);
        }
        return usuarios;
    }

    public List<String> findOptionsByXeopcCodigo(String xeperCodigo) {
        Query query = em.createNativeQuery("select x.XEOPC_CODIGO from xeper_perfi xe inner join xeoxp_opcpe xo on xe.XEPER_CODIGO = xo.XEPER_CODIGO inner join xeopc_opcio x on xo.XEOPC_CODIGO = x.XEOPC_CODIGO where xe.XEPER_CODIGO = '" + xeperCodigo + "';");
        List<Object[]> results = query.getResultList();
        List<String> usuarios = new ArrayList<>();
        for (Object row : results) {
            usuarios.add((String) row);
        }
        return usuarios;
    }

}
