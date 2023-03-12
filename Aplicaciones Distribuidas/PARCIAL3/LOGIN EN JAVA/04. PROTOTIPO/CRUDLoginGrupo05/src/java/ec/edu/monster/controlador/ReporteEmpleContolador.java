/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.controlador.util.PdfReport;
import ec.edu.monster.modelo.entidades.PeempEmple;
import ec.edu.monster.modelo.jpa.PeempEmpleFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

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
    private Date fechaNacimiento;

    public ReporteEmpleContolador() {
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
                    empleados);
        } catch (Exception e) {
            System.out.println("error pdf: " + e.getMessage());
        }
    }
    
    public void filtrarPorFechaNac(){
        empleados = ejbEmpleFacade.findEmpleadosByPeempFecnac(fechaNacimiento);
    }
}
