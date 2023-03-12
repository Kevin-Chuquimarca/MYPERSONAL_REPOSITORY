/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.modelo.UsuarioDTO;
import ec.edu.monster.modelo.entidades.XeperPerfi;
import ec.edu.monster.modelo.entidades.XeuxpUsupe;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;

/**
 *
 * @author santi
 */
@Named(value = "asignacionPerfilesController")
@ViewScoped
public class AsignacionPerfilesController implements Serializable {

    @EJB
    private ec.edu.monster.modelo.jpa.XeperPerfiFacade ejbPerfiFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeuxpUsupeFacade ejbUsupeFacade;

    private XeperPerfi currentPerfi;
    private XeuxpUsupe currentUsupe;

    private List<UsuarioDTO> usuariosConPerfil;
    private List<UsuarioDTO> usuariosSinPerfil;

    private String paswdUsuarioSinPerfil;
    private String paswdUsuarioConPerfil;

    public AsignacionPerfilesController() {
    }

    public String getPaswdUsuarioConPerfil() {
        return paswdUsuarioConPerfil;
    }

    public void setPaswdUsuarioConPerfil(String paswdUsuarioConPerfil) {
        this.paswdUsuarioConPerfil = paswdUsuarioConPerfil;
    }

    public String getPaswdUsuarioSinPerfil() {
        return paswdUsuarioSinPerfil;
    }

    public void setPaswdUsuarioSinPerfil(String paswdUsuarioSinPerfil) {
        this.paswdUsuarioSinPerfil = paswdUsuarioSinPerfil;
    }

    public XeperPerfi getCurrentPerfi() {
        if (currentPerfi == null) {
            currentPerfi = new XeperPerfi();
        }
        return currentPerfi;
    }

    public void setCurrentPerfi(XeperPerfi currentPerfi) {
        this.currentPerfi = currentPerfi;
    }

    public SelectItem[] getRoles() {
        String pattern = "^[^NA]$";
        return JsfUtil.getSelectPerfi(ejbPerfiFacade.findAll().stream().filter(e -> e.getXeperCodigo().matches(pattern)).collect(Collectors.toList()), true);
    }

    public List<UsuarioDTO> getUsuariosSinPerfil() {
        return usuariosSinPerfil = ejbUsupeFacade.findAllUsuarios().stream().filter(e -> e.getPerfil().equals("N")).collect(Collectors.toList());
    }

    public void setUsuariosSinPerfil(List<UsuarioDTO> usuariosSinPerfil) {
        this.usuariosSinPerfil = usuariosSinPerfil;
    }

    public List<UsuarioDTO> getUsuariosConPerfil() {
        return usuariosConPerfil = ejbUsupeFacade.findAllUsuarios().stream().filter(e -> e.getPerfil().equals(getCurrentPerfi().getXeperCodigo())).collect(Collectors.toList());
    }

    public void setUsuariosConPerfil(List<UsuarioDTO> usuariosConPerfil) {
        this.usuariosConPerfil = usuariosConPerfil;
    }

    private void removerCurrentUsupe(String paswdUsuarioPerfil) {
        currentUsupe = ejbUsupeFacade.findByXeusuPaswd(paswdUsuarioPerfil);
        ejbUsupeFacade.remove(currentUsupe);
    }

    private void actualizarCurrentUsupe(String xeperCodigo) {
        currentUsupe.getXeuxpUsupePK().setXeperCodigo(xeperCodigo);
        ejbUsupeFacade.create(currentUsupe);
    }

    public void asignarPerfilUsuario() {
        if (paswdUsuarioSinPerfil != null && currentPerfi.getXeperCodigo() != null) {
            removerCurrentUsupe(paswdUsuarioSinPerfil);
            actualizarCurrentUsupe(currentPerfi.getXeperCodigo());
        }
    }

    public void quitarPerfilUsuario() {
        if (paswdUsuarioConPerfil != null) {
            removerCurrentUsupe(paswdUsuarioConPerfil);
            actualizarCurrentUsupe("N");
        }
    }

    public void asignarPerfilUsuarios() {
        String xeperCodigo = currentPerfi.getXeperCodigo();
        if (xeperCodigo != null) {
            for (UsuarioDTO u : usuariosSinPerfil) {
                removerCurrentUsupe(u.getPassword());
                actualizarCurrentUsupe(xeperCodigo);
            }
        }
    }

    public void quitarPerfilUsuarios() {
        for (UsuarioDTO u : usuariosConPerfil) {
            removerCurrentUsupe(u.getPassword());
            actualizarCurrentUsupe("N");
        }
    }
}
