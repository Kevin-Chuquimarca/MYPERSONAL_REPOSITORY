/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.modelo.entidades.PeempEmple;
import ec.edu.monster.modelo.entidades.TeproProyec;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author santi
 */
@Named(value = "asignacionEmpleParaProyController")
@ViewScoped
public class AsignacionEmpleParaProyController implements Serializable {

    @EJB
    private ec.edu.monster.modelo.jpa.PeempEmpleFacade ejbEmpleFacade;
    @EJB
    private ec.edu.monster.modelo.jpa.TeproProyecFacade ejbProyectFacade;

    private PeempEmple currentEmple;
    private TeproProyec currentProy;

    private List<PeempEmple> empleWithoutProy;
    private List<PeempEmple> empleInProy;

    private String idEmpleWithoutProy;
    private String idEmpleInProy;

    public AsignacionEmpleParaProyController() {
    }

    public PeempEmple getCurrentEmple() {
        if (currentEmple == null) {
            return new PeempEmple();
        }
        return currentEmple;
    }

    public void setCurrentEmple(PeempEmple currentEmple) {
        this.currentEmple = currentEmple;
    }

    public TeproProyec getCurrentProy() {
        if (currentProy == null) {
            currentProy = new TeproProyec();
        }
        return currentProy;
    }

    public void setCurrentProy(TeproProyec currentProy) {
        this.currentProy = currentProy;
    }

    public List<PeempEmple> getEmpleWithoutProy() {
        return empleWithoutProy = ejbEmpleFacade.findAllEmple().stream().filter(e -> e.getTeproCodigo() == null).collect(Collectors.toList());
    }

    public void setEmpleWithoutProy(List<PeempEmple> empleWithoutProy) {
        this.empleWithoutProy = empleWithoutProy;
    }

    public List<PeempEmple> getEmpleInProy() {
        return empleInProy = ejbEmpleFacade.findByTeproCodigo(currentProy.getTeproCodigo());
    }

    public void setEmpleInProy(List<PeempEmple> empleInProy) {
        this.empleInProy = empleInProy;
    }

    public String getIdEmpleWithoutProy() {
        return idEmpleWithoutProy;
    }

    public void setIdEmpleWithoutProy(String idEmpleWithoutProy) {
        this.idEmpleWithoutProy = idEmpleWithoutProy;
    }

    public String getIdEmpleInProy() {
        return idEmpleInProy;
    }

    public void setIdEmpleInProy(String idEmpleInProy) {
        this.idEmpleInProy = idEmpleInProy;
    }

    public SelectItem[] getProyects() {
        return JsfUtil.getSelectProyects(ejbProyectFacade.findAll(), true);
    }

    private void updateEmpleWithProyect(String peempCodigo) {
        currentEmple = ejbEmpleFacade.find(peempCodigo);
        currentEmple.setTeproCodigo(currentProy);
        ejbEmpleFacade.edit(currentEmple);
    }
    
    private void updateEmpleWithoutProyect(String peempCodigo) {
        currentEmple = ejbEmpleFacade.find(peempCodigo);
        currentEmple.setTeproCodigo(null);
        ejbEmpleFacade.edit(currentEmple);
    }

    public void addEmpleToProy() {
        if (idEmpleWithoutProy != null && currentProy.getTeproCodigo() != null) {
            updateEmpleWithProyect(idEmpleWithoutProy);
        }
    }

    public void removeEmpleToProy() {
        if (idEmpleInProy != null) {
            updateEmpleWithoutProyect(idEmpleInProy);
        }
    }

    public void addEmplesToProy() {
        for (var emple : empleWithoutProy){
            updateEmpleWithProyect(emple.getPeempCodigo());
        }
    }

    public void removeEmplesToPro() {
        for (var emple: empleInProy){
            updateEmpleWithoutProyect(emple.getPeempCodigo());
        }
    }

}
