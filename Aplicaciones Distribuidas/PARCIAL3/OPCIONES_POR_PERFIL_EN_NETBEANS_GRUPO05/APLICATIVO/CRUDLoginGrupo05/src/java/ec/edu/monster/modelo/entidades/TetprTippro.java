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
@Table(name = "tetpr_tippro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TetprTippro.findAll", query = "SELECT t FROM TetprTippro t"),
    @NamedQuery(name = "TetprTippro.findByTetprCodigo", query = "SELECT t FROM TetprTippro t WHERE t.tetprCodigo = :tetprCodigo"),
    @NamedQuery(name = "TetprTippro.findByTetprDescri", query = "SELECT t FROM TetprTippro t WHERE t.tetprDescri = :tetprDescri")})
public class TetprTippro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TETPR_CODIGO")
    private String tetprCodigo;
    @Size(max = 150)
    @Column(name = "TETPR_DESCRI")
    private String tetprDescri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tetprCodigo")
    private Collection<TeproProyec> teproProyecCollection;

    public TetprTippro() {
    }

    public TetprTippro(String tetprCodigo) {
        this.tetprCodigo = tetprCodigo;
    }

    public String getTetprCodigo() {
        return tetprCodigo;
    }

    public void setTetprCodigo(String tetprCodigo) {
        this.tetprCodigo = tetprCodigo;
    }

    public String getTetprDescri() {
        return tetprDescri;
    }

    public void setTetprDescri(String tetprDescri) {
        this.tetprDescri = tetprDescri;
    }

    @XmlTransient
    public Collection<TeproProyec> getTeproProyecCollection() {
        return teproProyecCollection;
    }

    public void setTeproProyecCollection(Collection<TeproProyec> teproProyecCollection) {
        this.teproProyecCollection = teproProyecCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tetprCodigo != null ? tetprCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TetprTippro)) {
            return false;
        }
        TetprTippro other = (TetprTippro) object;
        if ((this.tetprCodigo == null && other.tetprCodigo != null) || (this.tetprCodigo != null && !this.tetprCodigo.equals(other.tetprCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.TetprTippro[ tetprCodigo=" + tetprCodigo + " ]";
    }
    
}
