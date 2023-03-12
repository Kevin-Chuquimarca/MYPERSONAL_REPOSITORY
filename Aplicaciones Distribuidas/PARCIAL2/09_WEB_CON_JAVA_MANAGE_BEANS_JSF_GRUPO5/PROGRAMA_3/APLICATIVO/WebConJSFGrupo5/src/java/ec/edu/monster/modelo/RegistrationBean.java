package ec.edu.monster.modelo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author santi
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean {

    private String saludo;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String email;

    public RegistrationBean() {
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
