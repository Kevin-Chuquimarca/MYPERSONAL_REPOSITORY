/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "tepro_proyec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeproProyec.findAll", query = "SELECT t FROM TeproProyec t"),
    @NamedQuery(name = "TeproProyec.findByTeproCodigo", query = "SELECT t FROM TeproProyec t WHERE t.teproCodigo = :teproCodigo"),
    @NamedQuery(name = "TeproProyec.findByTeproNombr", query = "SELECT t FROM TeproProyec t WHERE t.teproNombr = :teproNombr"),
    @NamedQuery(name = "TeproProyec.findByTeproFechai", query = "SELECT t FROM TeproProyec t WHERE t.teproFechai = :teproFechai"),
    @NamedQuery(name = "TeproProyec.findByTeproFechaf", query = "SELECT t FROM TeproProyec t WHERE t.teproFechaf = :teproFechaf"),
    @NamedQuery(name = "TeproProyec.findByTetprTeprod", query = "SELECT t FROM TeproProyec t WHERE t.tetprTeprod = :tetprTeprod"),
    @NamedQuery(name = "TeproProyec.findByTeproCosto", query = "SELECT t FROM TeproProyec t WHERE t.teproCosto = :teproCosto")})
public class TeproProyec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEPRO_CODIGO")
    private Integer teproCodigo;
    @Size(max = 50)
    @Column(name = "TEPRO_NOMBR")
    private String teproNombr;
    @Column(name = "TEPRO_FECHAI")
    @Temporal(TemporalType.DATE)
    private Date teproFechai;
    @Column(name = "TEPRO_FECHAF")
    @Temporal(TemporalType.DATE)
    private Date teproFechaf;
    @Size(max = 150)
    @Column(name = "TETPR_DESCRI")
    private String tetprTeprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEPRO_COSTO")
    private Float teproCosto;
    @OneToMany(mappedBy = "teproCodigo")
    private Collection<PeempEmple> peempEmpleCollection;
    @JoinColumn(name = "TETPR_CODIGO", referencedColumnName = "TETPR_CODIGO")
    @ManyToOne(optional = false)
    private TetprTippro tetprCodigo;

    public TeproProyec() {
    }

    public TeproProyec(Integer teproCodigo) {
        this.teproCodigo = teproCodigo;
    }

    public Integer getTeproCodigo() {
        return teproCodigo;
    }

    public void setTeproCodigo(Integer teproCodigo) {
        this.teproCodigo = teproCodigo;
    }

    public String getTeproNombr() {
        return teproNombr;
    }

    public void setTeproNombr(String teproNombr) {
        this.teproNombr = teproNombr;
    }

    public Date getTeproFechai() {
        return teproFechai;
    }

    public void setTeproFechai(Date teproFechai) {
        this.teproFechai = teproFechai;
    }

    public Date getTeproFechaf() {
        return teproFechaf;
    }

    public void setTeproFechaf(Date teproFechaf) {
        this.teproFechaf = teproFechaf;
    }

    public String getTetprTeprod() {
        return tetprTeprod;
    }

    public void setTetprTeprod(String tetprTeprod) {
        this.tetprTeprod = tetprTeprod;
    }

    public Float getTeproCosto() {
        return teproCosto;
    }

    public void setTeproCosto(Float teproCosto) {
        this.teproCosto = teproCosto;
    }

    @XmlTransient
    public Collection<PeempEmple> getPeempEmpleCollection() {
        return peempEmpleCollection;
    }

    public void setPeempEmpleCollection(Collection<PeempEmple> peempEmpleCollection) {
        this.peempEmpleCollection = peempEmpleCollection;
    }

    public TetprTippro getTetprCodigo() {
        return tetprCodigo;
    }

    public void setTetprCodigo(TetprTippro tetprCodigo) {
        this.tetprCodigo = tetprCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teproCodigo != null ? teproCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeproProyec)) {
            return false;
        }
        TeproProyec other = (TeproProyec) object;
        if ((this.teproCodigo == null && other.teproCodigo != null) || (this.teproCodigo != null && !this.teproCodigo.equals(other.teproCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.TeproProyec[ teproCodigo=" + teproCodigo + " ]";
    }
    
}
