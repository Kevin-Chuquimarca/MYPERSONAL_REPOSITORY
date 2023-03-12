/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByDireccionId", query = "SELECT d FROM Direccion d WHERE d.direccionId = :direccionId"),
    @NamedQuery(name = "Direccion.findByDireccionTypeId", query = "SELECT d FROM Direccion d WHERE d.direccionTypeId = :direccionTypeId"),
    @NamedQuery(name = "Direccion.findByAlumnoId", query = "SELECT d FROM Direccion d WHERE d.alumnoId = :alumnoId"),
    @NamedQuery(name = "Direccion.findByDirecLinea1", query = "SELECT d FROM Direccion d WHERE d.direcLinea1 = :direcLinea1"),
    @NamedQuery(name = "Direccion.findByDirecLinea2", query = "SELECT d FROM Direccion d WHERE d.direcLinea2 = :direcLinea2"),
    @NamedQuery(name = "Direccion.findByCiudad", query = "SELECT d FROM Direccion d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Direccion.findByCp", query = "SELECT d FROM Direccion d WHERE d.cp = :cp"),
    @NamedQuery(name = "Direccion.findByEsProvId", query = "SELECT d FROM Direccion d WHERE d.esProvId = :esProvId")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "direccion_id")
    private Integer direccionId;
    @Column(name = "direccion_type_id")
    private Integer direccionTypeId;
    @Column(name = "alumno_id")
    private Integer alumnoId;
    @Size(max = 100)
    @Column(name = "direc_linea1")
    private String direcLinea1;
    @Size(max = 100)
    @Column(name = "direc_linea2")
    private String direcLinea2;
    @Size(max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 5)
    @Column(name = "cp")
    private String cp;
    @Column(name = "es_prov_id")
    private Integer esProvId;

    public Direccion() {
    }

    public Direccion(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public Integer getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public Integer getDireccionTypeId() {
        return direccionTypeId;
    }

    public void setDireccionTypeId(Integer direccionTypeId) {
        this.direccionTypeId = direccionTypeId;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getDirecLinea1() {
        return direcLinea1;
    }

    public void setDirecLinea1(String direcLinea1) {
        this.direcLinea1 = direcLinea1;
    }

    public String getDirecLinea2() {
        return direcLinea2;
    }

    public void setDirecLinea2(String direcLinea2) {
        this.direcLinea2 = direcLinea2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getEsProvId() {
        return esProvId;
    }

    public void setEsProvId(Integer esProvId) {
        this.esProvId = esProvId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionId != null ? direccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.direccionId == null && other.direccionId != null) || (this.direccionId != null && !this.direccionId.equals(other.direccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.Direccion[ direccionId=" + direccionId + " ]";
    }
    
}
