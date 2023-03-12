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
@Table(name = "direccion_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionType.findAll", query = "SELECT d FROM DireccionType d"),
    @NamedQuery(name = "DireccionType.findByDireccionTypeId", query = "SELECT d FROM DireccionType d WHERE d.direccionTypeId = :direccionTypeId"),
    @NamedQuery(name = "DireccionType.findByDireccionTypeCode", query = "SELECT d FROM DireccionType d WHERE d.direccionTypeCode = :direccionTypeCode"),
    @NamedQuery(name = "DireccionType.findByDireccionTypeText", query = "SELECT d FROM DireccionType d WHERE d.direccionTypeText = :direccionTypeText")})
public class DireccionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "direccion_type_id")
    private Integer direccionTypeId;
    @Column(name = "direccion_type_code")
    private Character direccionTypeCode;
    @Size(max = 20)
    @Column(name = "direccion_type_text")
    private String direccionTypeText;

    public DireccionType() {
    }

    public DireccionType(Integer direccionTypeId) {
        this.direccionTypeId = direccionTypeId;
    }

    public Integer getDireccionTypeId() {
        return direccionTypeId;
    }

    public void setDireccionTypeId(Integer direccionTypeId) {
        this.direccionTypeId = direccionTypeId;
    }

    public Character getDireccionTypeCode() {
        return direccionTypeCode;
    }

    public void setDireccionTypeCode(Character direccionTypeCode) {
        this.direccionTypeCode = direccionTypeCode;
    }

    public String getDireccionTypeText() {
        return direccionTypeText;
    }

    public void setDireccionTypeText(String direccionTypeText) {
        this.direccionTypeText = direccionTypeText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionTypeId != null ? direccionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionType)) {
            return false;
        }
        DireccionType other = (DireccionType) object;
        if ((this.direccionTypeId == null && other.direccionTypeId != null) || (this.direccionTypeId != null && !this.direccionTypeId.equals(other.direccionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.DireccionType[ direccionTypeId=" + direccionTypeId + " ]";
    }
    
}
