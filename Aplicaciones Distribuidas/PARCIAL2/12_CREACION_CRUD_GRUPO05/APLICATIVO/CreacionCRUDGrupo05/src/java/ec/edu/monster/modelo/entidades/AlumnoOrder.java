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
@Table(name = "alumno_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoOrder.findAll", query = "SELECT a FROM AlumnoOrder a"),
    @NamedQuery(name = "AlumnoOrder.findByAlumnoOrderId", query = "SELECT a FROM AlumnoOrder a WHERE a.alumnoOrderId = :alumnoOrderId"),
    @NamedQuery(name = "AlumnoOrder.findByAlumnoId", query = "SELECT a FROM AlumnoOrder a WHERE a.alumnoId = :alumnoId"),
    @NamedQuery(name = "AlumnoOrder.findByOrderNumero", query = "SELECT a FROM AlumnoOrder a WHERE a.orderNumero = :orderNumero"),
    @NamedQuery(name = "AlumnoOrder.findByOrderDescription", query = "SELECT a FROM AlumnoOrder a WHERE a.orderDescription = :orderDescription"),
    @NamedQuery(name = "AlumnoOrder.findByItemId", query = "SELECT a FROM AlumnoOrder a WHERE a.itemId = :itemId")})
public class AlumnoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno_order_id")
    private Integer alumnoOrderId;
    @Column(name = "alumno_id")
    private Integer alumnoId;
    @Size(max = 100)
    @Column(name = "order_numero")
    private String orderNumero;
    @Size(max = 100)
    @Column(name = "order_description")
    private String orderDescription;
    @Column(name = "item_id")
    private Integer itemId;

    public AlumnoOrder() {
    }

    public AlumnoOrder(Integer alumnoOrderId) {
        this.alumnoOrderId = alumnoOrderId;
    }

    public Integer getAlumnoOrderId() {
        return alumnoOrderId;
    }

    public void setAlumnoOrderId(Integer alumnoOrderId) {
        this.alumnoOrderId = alumnoOrderId;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getOrderNumero() {
        return orderNumero;
    }

    public void setOrderNumero(String orderNumero) {
        this.orderNumero = orderNumero;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoOrderId != null ? alumnoOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoOrder)) {
            return false;
        }
        AlumnoOrder other = (AlumnoOrder) object;
        if ((this.alumnoOrderId == null && other.alumnoOrderId != null) || (this.alumnoOrderId != null && !this.alumnoOrderId.equals(other.alumnoOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.AlumnoOrder[ alumnoOrderId=" + alumnoOrderId + " ]";
    }
    
}
