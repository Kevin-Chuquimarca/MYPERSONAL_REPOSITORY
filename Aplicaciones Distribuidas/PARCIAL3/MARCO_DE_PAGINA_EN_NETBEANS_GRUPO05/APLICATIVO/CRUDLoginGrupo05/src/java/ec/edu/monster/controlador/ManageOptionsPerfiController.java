/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.modelo.entidades.XeopcOpcio;
import ec.edu.monster.modelo.entidades.XeoxpOpcpe;
import ec.edu.monster.modelo.entidades.XeoxpOpcpePK;
import ec.edu.monster.modelo.entidades.XeperPerfi;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author santi
 */
@Named(value = "manageOptionsPerfiController")
@ViewScoped
public class ManageOptionsPerfiController implements Serializable {

    @EJB
    private ec.edu.monster.modelo.jpa.XeperPerfiFacade ejbPerfiFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeopcOpcioFacade ejbOpcioFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.XeoxpOpcpeFacade ejbOpcpeFacade;

    private XeperPerfi currentPerfi;
    private XeopcOpcio currentOpcio;
    private XeoxpOpcpe currentOpcpe;

    private List<XeopcOpcio> options;
    private List<String> codOptions;

    public ManageOptionsPerfiController() {
    }

    public List<String> getCodOptions() {
        codOptions = new ArrayList<>();
        List<String> auxCodOptions = ejbOpcioFacade.findOptionsByXeopcCodigo(getCurrentPerfi().getXeperCodigo());
        if (!auxCodOptions.isEmpty()) {
            for (var c : auxCodOptions) {
                codOptions.add(ejbOpcioFacade.findByXeopcCodigo(c).toString());
            }
        }
        return codOptions;
    }

    public void setCodOptions(List<String> codOptions) {
        this.codOptions = codOptions;
    }

    public List<XeopcOpcio> getOptions() {
        return options = ejbOpcioFacade.findAll();
    }

    public void setOptions(List<XeopcOpcio> options) {
        this.options = options;
    }

    public XeperPerfi getCurrentPerfi() {
        if (currentPerfi == null) {
            return new XeperPerfi();
        }
        return currentPerfi;
    }

    public void setCurrentPerfi(XeperPerfi currentPerfi) {
        this.currentPerfi = currentPerfi;
    }

    public XeopcOpcio getCurrentOpcio() {
        if (currentOpcio == null) {
            return new XeopcOpcio();
        }
        return currentOpcio;
    }

    public void setCurrentOpcio(XeopcOpcio currentOpcio) {
        this.currentOpcio = currentOpcio;
    }

    public SelectItem[] getOpts() {
        return JsfUtil.getSelectOptions(ejbOpcioFacade.findAll(), false);
    }

    public SelectItem[] getRoles() {
        String pattern = "^[^NA]$";
        return JsfUtil.getSelectPerfi(ejbPerfiFacade.findAll().stream().filter(e -> e.getXeperCodigo().matches(pattern)).collect(Collectors.toList()), true);
//        return JsfUtil.getSelectPerfi(ejbPerfiFacade.findAll(), true);
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//    public void addOptionToPerfi() {
//        XeoxpOpcpePK opcpePK = new XeoxpOpcpePK(currentOpcio.getXeopcCodigo(), currentPerfi.getXeperCodigo(), new Date());
//        currentOpcpe = new XeoxpOpcpe(opcpePK);
//        ejbOpcpeFacade.create(currentOpcpe);
//    }
    public void addOptionToPerfi(String xeopcCodigo, String xeperCodigo) {
        XeoxpOpcpePK opcpePK = new XeoxpOpcpePK(xeopcCodigo, xeperCodigo, new Date());
        currentOpcpe = new XeoxpOpcpe(opcpePK);
        ejbOpcpeFacade.create(currentOpcpe);
    }

//    public void removeOptionToPerfi() {
//        currentOpcpe = ejbOpcpeFacade.findByXeopcCodigoAndXeperCodigo(currentOpcio.getXeopcCodigo(), currentPerfi.getXeperCodigo());
//        ejbOpcpeFacade.remove(currentOpcpe);
//    }
    public void removeOptionToPerfi(String xeopcCodigo, String xeperCodigo) {
        currentOpcpe = ejbOpcpeFacade.findByXeopcCodigoAndXeperCodigo(xeopcCodigo, xeperCodigo);
        ejbOpcpeFacade.remove(currentOpcpe);
    }

    public void addOptionsPerfi() {
        for (var j : getOptions()) {
            removeOptionToPerfi(j.getXeopcCodigo(), getCurrentPerfi().getXeperCodigo());
        }
        for (int i = 0; i < codOptions.size(); i++) {
            for (var j : getOptions()) {
                if (j.toString().equals(codOptions.get(i))) {
                    addOptionToPerfi(j.getXeopcCodigo(), getCurrentPerfi().getXeperCodigo());
                }
            }
        }
    }

}
