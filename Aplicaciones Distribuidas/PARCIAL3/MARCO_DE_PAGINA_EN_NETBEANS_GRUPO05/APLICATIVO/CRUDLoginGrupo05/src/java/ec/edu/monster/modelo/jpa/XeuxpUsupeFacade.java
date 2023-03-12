/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.jpa;

import ec.edu.monster.modelo.UsuarioDTO;
import ec.edu.monster.modelo.entidades.XeuxpUsupe;
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
public class XeuxpUsupeFacade extends AbstractFacade<XeuxpUsupe> {

    @PersistenceContext(unitName = "CRUDLoginGrupo05PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeuxpUsupeFacade() {
        super(XeuxpUsupe.class);
    }
    
    public XeuxpUsupe findByXeusuPaswd(String xeusuPaswd) {
        try {
            TypedQuery<XeuxpUsupe> query = em.createNamedQuery("XeuxpUsupe.findByXeusuPaswd", XeuxpUsupe.class);
            query.setParameter("xeusuPaswd", xeusuPaswd);
            return query.getSingleResult();
        } catch (Exception e) {
            return new XeuxpUsupe();
        }
    }

    public String findXeperDescriByXeusuPaswd(String xeusuPaswd) {
        try {
            TypedQuery<String> query = em.createNamedQuery("XeuxpUsupe.findXeperDescriByXeusuPaswd", String.class);
            query.setParameter("xeusuPaswd", xeusuPaswd);
            return query.getSingleResult();
        } catch (Exception e) {
            return "";
        }
    }

//    public List<UsuarioDTO> findAllUsuarios() {
//        TypedQuery<Object[]> query = em.createNamedQuery("XeuxpUsupe.findAllUsuarios", Object[].class);
//        List<Object[]> results = query.getResultList();
//        List<UsuarioDTO> usuarios = new ArrayList<>();
//        for (Object[] row : results) {
//            usuarios.add(new UsuarioDTO((String) row[0], (String) row[1], (String) row[2], (String) row[3]));
//        }
//        return usuarios;
//    }
    
    public List<UsuarioDTO> findAllUsuarios() {
        Query query = em.createNativeQuery("select xe.XEUSU_PASWD, pe.PEEMP_APELLI, pe.PEEMP_NOMBRE, xe.XEPER_CODIGO from xeuxp_usupe xe inner join xeusu_usuar xu on xe.XEUSU_PASWD = xu.XEUSU_PASWD inner join peemp_emple pe on xu.PEEMP_CODIGO = pe.PEEMP_CODIGO");
        List<Object[]> results = query.getResultList();
        List<UsuarioDTO> usuarios = new ArrayList<>();
        for (Object[] row : results) {
            usuarios.add(new UsuarioDTO((String) row[0], (String) row[1], (String) row[2], (String) row[3]));
        }
        return usuarios;
    }
}
