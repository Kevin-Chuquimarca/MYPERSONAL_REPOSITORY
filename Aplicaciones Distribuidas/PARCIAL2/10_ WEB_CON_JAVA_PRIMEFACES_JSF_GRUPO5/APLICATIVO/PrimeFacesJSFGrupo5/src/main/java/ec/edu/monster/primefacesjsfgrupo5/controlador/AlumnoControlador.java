package ec.edu.monster.primefacesjsfgrupo5.controlador;

import ec.edu.monster.primefacesjsfgrupo5.modelo.Alumno;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author santi
 */
@Named(value = "alumnoControlador")
@RequestScoped
public class AlumnoControlador implements Serializable{

    @Inject private Alumno alumno;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
//    public String salvarAlumno(){
//        return "confirmacion";
//    }
    
    public void guardarAlumno(ActionEvent actionEvent){
        FacesMessage facesMessage = new FacesMessage("Datos salvados correctamente");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
