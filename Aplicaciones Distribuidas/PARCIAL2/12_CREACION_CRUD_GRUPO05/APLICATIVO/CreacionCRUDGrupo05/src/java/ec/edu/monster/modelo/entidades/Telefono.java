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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByTelefonoId", query = "SELECT t FROM Telefono t WHERE t.telefonoId = :telefonoId"),
    @NamedQuery(name = "Telefono.findByTelefonoTypeId", query = "SELECT t FROM Telefono t WHERE t.telefonoTypeId = :telefonoTypeId"),
    @NamedQuery(name = "Telefono.findByAlumnoId", query = "SELECT t FROM Telefono t WHERE t.alumnoId = :alumnoId")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_id")
    private Integer telefonoId;
    @Column(name = "telefono_type_id")
    private Integer telefonoTypeId;
    @Column(name = "alumno_id")
    private Integer alumnoId;

    public Telefono() {
    }

    public Telefono(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public Integer getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public Integer getTelefonoTypeId() {
        return telefonoTypeId;
    }

    public void setTelefonoTypeId(Integer telefonoTypeId) {
        this.telefonoTypeId = telefonoTypeId;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefonoId != null ? telefonoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefonoId == null && other.telefonoId != null) || (this.telefonoId != null && !this.telefonoId.equals(other.telefonoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.Telefono[ telefonoId=" + telefonoId + " ]";
    }
    
}
