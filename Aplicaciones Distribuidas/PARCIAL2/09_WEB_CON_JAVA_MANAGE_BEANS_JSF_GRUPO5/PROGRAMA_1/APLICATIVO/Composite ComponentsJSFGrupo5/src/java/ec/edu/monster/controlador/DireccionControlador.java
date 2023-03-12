package ec.edu.monster.controlador;

import ec.edu.monster.modelo.DireccionBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author santi
 */
@Named(value = "direccionControlador")
@RequestScoped
public class DireccionControlador {

    @Inject
    private DireccionBean direccionBean;

    public DireccionBean getDireccionBean() {
        return direccionBean;
    }

    public void setDireccionBean(DireccionBean direccionBean) {
        this.direccionBean = direccionBean;
    }

    public String registrarDireccion() {
        return "confirmacion";
    }
}
