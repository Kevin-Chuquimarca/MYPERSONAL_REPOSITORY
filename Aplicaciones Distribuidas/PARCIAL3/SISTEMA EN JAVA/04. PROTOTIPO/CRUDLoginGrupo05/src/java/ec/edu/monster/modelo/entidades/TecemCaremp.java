/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "tecem_caremp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecemCaremp.findAll", query = "SELECT t FROM TecemCaremp t"),
    @NamedQuery(name = "TecemCaremp.findByTecemCodigo", query = "SELECT t FROM TecemCaremp t WHERE t.tecemCodigo = :tecemCodigo"),
    @NamedQuery(name = "TecemCaremp.findByTecemDescri", query = "SELECT t FROM TecemCaremp t WHERE t.tecemDescri = :tecemDescri")})
public class TecemCaremp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TECEM_CODIGO")
    private String tecemCodigo;
    @Size(max = 20)
    @Column(name = "TECEM_DESCRI")
    private String tecemDescri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecemCodigo")
    private Collection<PeempEmple> peempEmpleCollection;

    public TecemCaremp() {
    }

    public TecemCaremp(String tecemCodigo) {
        this.tecemCodigo = tecemCodigo;
    }

    public String getTecemCodigo() {
        return tecemCodigo;
    }

    public void setTecemCodigo(String tecemCodigo) {
        this.tecemCodigo = tecemCodigo;
    }

    public String getTecemDescri() {
        return tecemDescri;
    }

    public void setTecemDescri(String tecemDescri) {
        this.tecemDescri = tecemDescri;
    }

    @XmlTransient
    public Collection<PeempEmple> getPeempEmpleCollection() {
        return peempEmpleCollection;
    }

    public void setPeempEmpleCollection(Collection<PeempEmple> peempEmpleCollection) {
        this.peempEmpleCollection = peempEmpleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tecemCodigo != null ? tecemCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecemCaremp)) {
            return false;
        }
        TecemCaremp other = (TecemCaremp) object;
        if ((this.tecemCodigo == null && other.tecemCodigo != null) || (this.tecemCodigo != null && !this.tecemCodigo.equals(other.tecemCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.TecemCaremp[ tecemCodigo=" + tecemCodigo + " ]";
    }
    
}
