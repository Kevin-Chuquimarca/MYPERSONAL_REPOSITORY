package ec.edu.monster.modelo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author santi
 */
@Named(value = "direccionBean")
@RequestScoped
public class DireccionBean {

    private String linea1;
    private String linea2;
    private String ciudad;
    private String provincia;
    private String cp;
    
    public DireccionBean() {
    }

    public String getLinea1() {
        return linea1;
    }

    public void setLinea1(String linea1) {
        this.linea1 = linea1;
    }

    public String getLinea2() {
        return linea2;
    }

    public void setLinea2(String linea2) {
        this.linea2 = linea2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    
}
