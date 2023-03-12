package ec.edu.monster.controlador;

import ec.edu.monster.modelo.RegistrationBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author santi
 */
@Named(value = "registrationBeanController")
@RequestScoped
public class registrationBeanController {

    @Inject
    private RegistrationBean registrationBean;

    public registrationBeanController() {
    }

    public RegistrationBean getRegistrationBean() {
        return registrationBean;
    }

    public void setRegistrationBean(RegistrationBean registrationBean) {
        this.registrationBean = registrationBean;
    }

    public String grabarRegistro() {
        return "confirmacion";
    }

}
