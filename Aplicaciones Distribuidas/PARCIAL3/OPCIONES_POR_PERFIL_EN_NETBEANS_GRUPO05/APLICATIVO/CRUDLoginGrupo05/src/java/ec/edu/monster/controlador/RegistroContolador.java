/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.Captcha;
import ec.edu.monster.controlador.util.GenerarUsuario;
import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.controlador.util.SHA1;
import ec.edu.monster.modelo.entidades.PeempEmple;
import ec.edu.monster.modelo.entidades.TecemCaremp;
import ec.edu.monster.modelo.entidades.XeestEstad;
import ec.edu.monster.modelo.entidades.XeperPerfi;
import ec.edu.monster.modelo.entidades.XeusuUsuar;
import ec.edu.monster.modelo.entidades.XeuxpUsupe;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author santi
 */
@Named(value = "registroContolador")
@ViewScoped
public class RegistroContolador implements Serializable {

    @EJB
    private ec.edu.monster.modelo.jpa.XeusuUsuarFacade ejbUserFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.PeempEmpleFacade ejbEmpleFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeperPerfiFacade ejbPerfiFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeuxpUsupeFacade ejbUsupeFacade;
    private XeusuUsuar currentUsuar;
    private PeempEmple currentEmple;
    private XeperPerfi currentPerfi;
    private XeuxpUsupe currentUsupe;

    @Inject
    PeempEmpleController mbPeemEmple;

    @Inject
    ImagenControlador imagenControlador;

    private String captcha;
    private String verfCaptcha;
    private boolean onDiscapa;

    private String cedula, pasaporte, direccion;

    public RegistroContolador() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isOnDiscapa() {
        return onDiscapa;
    }

    public void setOnDiscapa(boolean onDiscapa) {
        this.onDiscapa = onDiscapa;
    }

    public String getCaptcha() {
        System.out.println("ejecutando captcha");
        captcha = Captcha.generateCaptcha();
        System.out.println("valor captcha: " + captcha);
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getVerfCaptcha() {
        return verfCaptcha;
    }

    public void setVerfCaptcha(String verfCaptcha) {
        this.verfCaptcha = verfCaptcha;
    }

    public XeuxpUsupe getCurrentUsupe() {
        if (currentUsupe == null) {
            currentUsupe = new XeuxpUsupe();
            currentUsupe.setXeuxpUsupePK(new ec.edu.monster.modelo.entidades.XeuxpUsupePK());
        }
        return currentUsupe;
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

    public XeusuUsuar getCurrentUser() {
        if (currentUsuar == null) {
            currentUsuar = new XeusuUsuar();
        }
        return currentUsuar;
    }

    public PeempEmple getCurrentEmple() {
        if (currentEmple == null) {
            currentEmple = new PeempEmple();
        }
        return currentEmple;
    }

    public ImagenControlador getImagenControlador() {
        return imagenControlador;
    }

    public void setImagenControlador(ImagenControlador imagenControlador) {
        if (imagenControlador == null) {
            imagenControlador = new ImagenControlador();
        }
        this.imagenControlador = imagenControlador;
    }

    public SelectItem[] getRoles() {
        return JsfUtil.getSelectPerfi(ejbPerfiFacade.findAll(), true);
    }

    private void enviarCorreo(String para, String emailUser, String passUser) {
        EmisorCorreoController emc = new EmisorCorreoController();
        emc.enviarCorreoNuevoUsuario(para, emailUser, passUser);
    }

    public Integer encontrarMayor(List<Integer> lista) {
        Integer mayor = null;
        for (Integer numero : lista) {
            if (mayor == null || numero > mayor) {
                mayor = numero;
            }
        }
        return mayor + 1;
    }

    private void crearNuevoUsuario() throws IOException, NoSuchAlgorithmException {
        Date date = new Date();
        String tempPass = GenerarUsuario.generarContraseniaTemp();
        currentUsuar = new XeusuUsuar(SHA1.getHashSHA1(tempPass), date, date, "firma");
        Integer cod = encontrarMayor(ejbEmpleFacade.findAll().stream().map(e -> Integer.valueOf(e.getPeempCodigo())).collect(Collectors.toList()));
        currentEmple.setPeempCodigo(cod.toString());
        currentEmple.setTecemCodigo(new TecemCaremp("N"));
        currentEmple.setDiscapa(onDiscapa ? new byte[]{48} : new byte[]{49});
        currentEmple.setPeempFoto(currentEmple.getPeempCodigo());
        currentEmple.setPeempFecsal(new Date());
        if (cedula == null || cedula == "") {
            currentEmple.setPeempCedula("-");
        } else {
            currentEmple.setPeempCedula("1727195420");
        }
//        if (pasaporte == null || pasaporte == "") {
        currentEmple.setPeempPasapo("-");
//        } else {
//            currentEmple.setPeempPasapo(pasaporte);
//        }
        if (direccion == null || direccion == "") {
            currentEmple.setPeempDirec("-");
        } else {
            currentEmple.setPeempDirec("Tumbaco");
        }
        System.out.println("valor de la cedula: " + currentEmple.getPeempCedula());
        currentUsuar.setPeempCodigo(currentEmple);
        currentUsuar.setXeestCodigo(new XeestEstad("1"));
        currentUsupe = new XeuxpUsupe(currentUsuar.getXeusuPaswd(), "N", date);
        currentUsupe.setXeuxpFecret(date);
        ejbEmpleFacade.create(currentEmple);
        ejbUserFacade.create(currentUsuar);
        ejbUsupeFacade.create(currentUsupe);
        if (imagenControlador.getFile() != null) {
            imagenControlador.cargarFotoUsuario(currentEmple.getPeempCodigo());
        }
        enviarCorreo(currentEmple.getPeempEmail(), currentEmple.getPeempEmail(), tempPass);
    }

    private void vaciarRegistro() {
        currentEmple = null;
        currentPerfi = null;
        currentUsuar = null;
        verfCaptcha = "";
    }

    public void registrarNuevoUsuario() throws NoSuchAlgorithmException {
        try {
            crearNuevoUsuario();
            FacesContext.getCurrentInstance().addMessage("dialogs:btnRecord", new FacesMessage("Usuario registrado con éxito."));
            vaciarRegistro();
            mbPeemEmple.recreatePagination();
            mbPeemEmple.recreateModel();
            PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
            PrimeFaces.current().ajax().update("form:dt-emple");
        } catch (IOException e) {
            FacesMessage message = new FacesMessage("Usuario no registrado.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("dialogs:btnRecord", message);
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }
}
