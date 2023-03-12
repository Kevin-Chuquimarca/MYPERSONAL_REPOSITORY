package ec.edu.monster.primefacesjsfgrupo5.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author santi
 */
@Named(value = "alumno")
@RequestScoped
public class Alumno {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String dirLinea1;
    private String dirLinea2;
    private String dirCiudad;
    private String dirProvincia;
    private String dirCp;
    private String telefonoCasa;
    private String telefonoMovil;
    private String telefonoTrabajo;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getDirLinea1() {
        return dirLinea1;
    }

    public void setDirLinea1(String dirLinea1) {
        this.dirLinea1 = dirLinea1;
    }

    public String getDirLinea2() {
        return dirLinea2;
    }

    public void setDirLinea2(String dirLinea2) {
        this.dirLinea2 = dirLinea2;
    }

    public String getDirCiudad() {
        return dirCiudad;
    }

    public void setDirCiudad(String dirCiudad) {
        this.dirCiudad = dirCiudad;
    }

    public String getDirProvincia() {
        return dirProvincia;
    }

    public void setDirProvincia(String dirProvincia) {
        this.dirProvincia = dirProvincia;
    }

    public String getDirCp() {
        return dirCp;
    }

    public void setDirCp(String dirCp) {
        this.dirCp = dirCp;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }
    
    
}
