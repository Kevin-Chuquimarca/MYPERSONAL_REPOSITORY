/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.EmailContext;
import ec.edu.monster.controlador.util.GenerarUsuario;
import ec.edu.monster.controlador.util.SHA1;
import ec.edu.monster.modelo.entidades.XeestEstad;
import ec.edu.monster.modelo.entidades.XeusuUsuar;
import ec.edu.monster.modelo.entidades.XeuxpUsupe;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@Named(value = "inicioSesionControlador")
@ViewScoped
public class InicioSesionControlador implements Serializable {

    private String email;
    private String contrasenia;
    private String emailRecuperacion;
    @EJB
    private ec.edu.monster.modelo.jpa.XeusuUsuarFacade ejbUsuarFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.PeempEmpleFacade ejbEmpleFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeuxpUsupeFacade ejbUsupeFacade;

    public InicioSesionControlador() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmailRecuperacion() {
        return emailRecuperacion;
    }

    public void setEmailRecuperacion(String emailRecuperacion) {
        this.emailRecuperacion = emailRecuperacion;
    }

    public void validarUsuario() throws NoSuchAlgorithmException, IOException {
        String passSha1 = SHA1.getHashSHA1(contrasenia);
        String xeusuPaswd = ejbUsuarFacade.findXeusuPaswdByXeusuPaswd(passSha1);
        String peempEmail = ejbEmpleFacade.findPeempEmailByPeempEmail(email);
        if (peempEmail.equals(email) && xeusuPaswd.equals(passSha1)) {
            EmailContext.setEmail(peempEmail);
            EmailContext.setPassSha(passSha1);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/usuario.xhtml");
        }
        FacesContext.getCurrentInstance().addMessage("mmsUserId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Usuario o contraseña incorrectos", ""));
    }

    private void enviarCorreo(String para, String emailUser, String passUser) {
        EmisorCorreoController emc = new EmisorCorreoController();
        emc.enviarCorreoNuevoUsuario(para, emailUser, passUser);
    }

    private void actualizarXeusuPaswd(String xeusuPaswdActual, String xeusuPaswdNueva) throws NoSuchAlgorithmException {
        XeusuUsuar currentUser = ejbUsuarFacade.findByXeusuPaswd(xeusuPaswdActual);
        XeuxpUsupe currentUsupe = ejbUsupeFacade.findByXeusuPaswd(xeusuPaswdActual);
        ejbUsupeFacade.remove(currentUsupe);
        ejbUsuarFacade.remove(currentUser);
        Date date = new Date();
        currentUser.setXeusuPaswd(SHA1.getHashSHA1(xeusuPaswdNueva));
        currentUser.setXeestCodigo(new XeestEstad("1"));
        currentUser.setXeusuFecmod(date);
        ejbUsuarFacade.create(currentUser);
        currentUsupe.getXeuxpUsupePK().setXeuxpFecasi(date);
        currentUsupe.getXeuxpUsupePK().setXeusuPaswd(currentUser.getXeusuPaswd());
        ejbUsupeFacade.create(currentUsupe);
    }

    public String recuperarContrasenia() throws NoSuchAlgorithmException {
        String xeusuPaswdActual = ejbUsuarFacade.findXeusuPaswdByPeempEmail(emailRecuperacion);
        if (!xeusuPaswdActual.equals("")) {
            String xeusuPaswdNueva = GenerarUsuario.generarContraseniaTemp();
            actualizarXeusuPaswd(xeusuPaswdActual, xeusuPaswdNueva);
            enviarCorreo(emailRecuperacion, emailRecuperacion, xeusuPaswdNueva);
        }
        return "login";
    }
}
