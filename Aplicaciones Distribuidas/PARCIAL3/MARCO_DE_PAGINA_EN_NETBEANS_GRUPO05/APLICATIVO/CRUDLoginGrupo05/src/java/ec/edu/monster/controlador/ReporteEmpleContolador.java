/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.PdfReport;
import ec.edu.monster.modelo.entidades.PeempEmple;
import ec.edu.monster.modelo.jpa.PeempEmpleFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.util.LangUtils;

/**
 *
 * @author santi
 */
@Named(value = "reporteEmpleContolador")
@ViewScoped
public class ReporteEmpleContolador implements Serializable {

    @EJB
    private ec.edu.monster.modelo.jpa.PeempEmpleFacade ejbEmpleFacade;

    private List<PeempEmple> empleados;
    private List<PeempEmple> selectedEmpleados;
    private Date fechaNacimiento;

    public ReporteEmpleContolador() {
    }

    public List<PeempEmple> getSelectedEmpleados() {
        return selectedEmpleados;
    }

    public void setSelectedEmpleados(List<PeempEmple> selectedEmpleados) {
        this.selectedEmpleados = selectedEmpleados;
    }
    
    public List<PeempEmple> getEmpleados() {
        if (empleados == null) {
            empleados = ejbEmpleFacade.findAll();
        }
        return empleados;
    }

    public void setEmpleados(List<PeempEmple> empleados) {
        this.empleados = empleados;
    }

    public PeempEmpleFacade getEjbEmpleFacade() {
        return ejbEmpleFacade;
    }

    public void setEjbEmpleFacade(PeempEmpleFacade ejbEmpleFacade) {
        this.ejbEmpleFacade = ejbEmpleFacade;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void generarReportePdf() {
        try {
            byte[] pdfContent = PdfReport.generateEmployeeReportPdf(
                    "",
                    selectedEmpleados);
        } catch (Exception e) {
            System.out.println("error pdf: " + e.getMessage());
        }
    }
    
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (LangUtils.isBlank(filterText)) {
            return true;
        }
        PeempEmple customer = (PeempEmple) value;
        return customer.getPeempCodigo().toLowerCase().contains(filterText)
                || customer.getPeempApelli().toLowerCase().contains(filterText)
                || customer.getPeempNombre().toLowerCase().contains(filterText)
                || customer.getPeempFecnac().toString().contains(filterText);
    }
}
