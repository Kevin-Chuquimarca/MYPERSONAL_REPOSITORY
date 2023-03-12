/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.EmailContext;
import ec.edu.monster.controlador.util.SHA1;
import ec.edu.monster.modelo.entidades.PeempEmple;
import ec.edu.monster.modelo.entidades.XeestEstad;
import ec.edu.monster.modelo.entidades.XeusuUsuar;
import ec.edu.monster.modelo.entidades.XeuxpUsupe;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author santi
 */
@Named(value = "usuarioControlador")
@ViewScoped
public class UsuarioControlador implements Serializable {

    @EJB
    private ec.edu.monster.modelo.jpa.PeempEmpleFacade ejbEmpleFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeusuUsuarFacade ejbUsuarFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeuxpUsupeFacade ejbUsupeFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeopcOpcioFacade ejbOpcioFacade;

    private PeempEmple currentEmple;
    private XeusuUsuar currentUser;
    private XeuxpUsupe currentUsupe;

    private String nuevaContrasenia;
    private String verfContrasenia;
    private boolean[] mostrarPanels = new boolean[3];
    private boolean[] showOptionsBtn = new boolean[6];
    private String cargo;

    public UsuarioControlador() {

    }

    public boolean[] getShowOptionsBtn() {
        List<String> options = ejbOpcioFacade.findOptionsByUserPerfil(EmailContext.passSha);
        showOptionsBtn[0] = options.contains("A");
        showOptionsBtn[1] = options.contains("E");
        showOptionsBtn[2] = options.contains("G");
        showOptionsBtn[3] = options.contains("P");
        showOptionsBtn[4] = options.contains("R");
        showOptionsBtn[5] = options.contains("H");
        return showOptionsBtn;
    }

    public void setShowOptionsBtn(boolean[] showOptionsBtn) {
        this.showOptionsBtn = showOptionsBtn;
    }

    public boolean[] getMostrarPanels() {
        return mostrarPanels;
    }

    public void setMostrarPanels(boolean[] mostrarPanels) {
        this.mostrarPanels = mostrarPanels;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNuevaContrasenia() {
        return nuevaContrasenia;
    }

    public void setNuevaContrasenia(String nuevaContrasenia) {
        this.nuevaContrasenia = nuevaContrasenia;
    }

    public String getVerfContrasenia() {
        return verfContrasenia;
    }

    public void setVerfContrasenia(String verfContrasenia) {
        this.verfContrasenia = verfContrasenia;
    }

    public XeuxpUsupe getCurrentUsupe() {
        if (currentUsupe == null) {
            currentUsupe = new XeuxpUsupe();
            currentUsupe.setXeuxpUsupePK(new ec.edu.monster.modelo.entidades.XeuxpUsupePK());
        }
        return currentUsupe;
    }

    public XeusuUsuar getCurrentUser() {
        if (currentUser == null) {
            currentUser = new XeusuUsuar();
        }
        return currentUser;
    }

    public PeempEmple getCurrentEmple() {
        if (currentEmple == null) {
            currentEmple = ejbEmpleFacade.findByPeempEmail(EmailContext.getEmail());
            currentUser = ejbUsuarFacade.findByXeusuPaswd(EmailContext.getPassSha());
            if (currentUser.getXeestCodigo().getXeestCodigo().equals("1")) {
                PrimeFaces.current().executeScript("PF('miModal').show();");
            }
            cargo = ejbUsupeFacade.findXeperDescriByXeusuPaswd(currentUser.getXeusuPaswd());
            mostrarPanels[0] = cargo.equals("Administrador");
            mostrarPanels[1] = cargo.equals("Empleado");
            mostrarPanels[2] = cargo.equals("Cliente");
        }
        return currentEmple;
    }

    public void salir() throws IOException {
        EmailContext.setEmail("");
        EmailContext.setPassSha("");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/faces/login.xhtml");
    }

    private void removerContraseniaActual() {
        currentUser = ejbUsuarFacade.findByXeusuPaswd(EmailContext.getPassSha());
        currentUsupe = ejbUsupeFacade.findByXeusuPaswd(EmailContext.getPassSha());
        ejbUsupeFacade.remove(currentUsupe);
        ejbUsuarFacade.remove(currentUser);
    }

    private void actualizarContrasenia() throws NoSuchAlgorithmException {
        Date date = new Date();
        currentUser.setXeusuPaswd(SHA1.getHashSHA1(nuevaContrasenia));
        currentUser.setXeestCodigo(new XeestEstad("2"));
        currentUser.setXeusuFecmod(date);
        ejbUsuarFacade.create(currentUser);
        currentUsupe.getXeuxpUsupePK().setXeuxpFecasi(date);
        currentUsupe.getXeuxpUsupePK().setXeusuPaswd(currentUser.getXeusuPaswd());
        ejbUsupeFacade.create(currentUsupe);
    }

    public void cambiarContrasenia() throws NoSuchAlgorithmException, IOException {
        if (nuevaContrasenia.equals(verfContrasenia)) {
            removerContraseniaActual();
            actualizarContrasenia();
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/login.xhtml");
        }
    }
}
