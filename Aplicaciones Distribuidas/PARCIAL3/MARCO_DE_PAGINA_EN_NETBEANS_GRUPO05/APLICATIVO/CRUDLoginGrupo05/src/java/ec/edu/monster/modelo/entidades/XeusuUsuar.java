/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "xeusu_usuar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeusuUsuar.findAll", query = "SELECT x FROM XeusuUsuar x"),
    @NamedQuery(name = "XeusuUsuar.findByXeusuPaswd", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuPaswd = :xeusuPaswd"),
    @NamedQuery(name = "XeusuUsuar.findXeusuPaswdByPeempEmail", query = "SELECT x.xeusuPaswd FROM XeusuUsuar x WHERE x.peempCodigo.peempEmail = :peempEmail"),
    @NamedQuery(name = "XeusuUsuar.findByXeusuFeccre", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuFeccre = :xeusuFeccre"),
    @NamedQuery(name = "XeusuUsuar.findByXeusuFecmod", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuFecmod = :xeusuFecmod"),
    @NamedQuery(name = "XeusuUsuar.findByXeusuPiefir", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuPiefir = :xeusuPiefir")})
public class XeusuUsuar implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUSU_FECCRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeusuFeccre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUSU_FECMOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeusuFecmod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEUSU_PIEFIR")
    private String xeusuPiefir;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "XEUSU_PASWD")
    private String xeusuPaswd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xeusuUsuar")
    private Collection<XeuxpUsupe> xeuxpUsupeCollection;
    @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO")
    @ManyToOne(optional = false)
    private PeempEmple peempCodigo;
    @JoinColumn(name = "XEEST_CODIGO", referencedColumnName = "XEEST_CODIGO")
    @ManyToOne(optional = false)
    private XeestEstad xeestCodigo;

    public XeusuUsuar() {
    }

    public XeusuUsuar(String xeusuPaswd) {
        this.xeusuPaswd = xeusuPaswd;
    }

    public XeusuUsuar(String xeusuPaswd, Date xeusuFeccre, Date xeusuFecmod, String xeusuPiefir) {
        this.xeusuPaswd = xeusuPaswd;
        this.xeusuFeccre = xeusuFeccre;
        this.xeusuFecmod = xeusuFecmod;
        this.xeusuPiefir = xeusuPiefir;
    }

    public String getXeusuPaswd() {
        return xeusuPaswd;
    }

    public void setXeusuPaswd(String xeusuPaswd) {
        this.xeusuPaswd = xeusuPaswd;
    }

    public Date getXeusuFeccre() {
        return xeusuFeccre;
    }

    public void setXeusuFeccre(Date xeusuFeccre) {
        this.xeusuFeccre = xeusuFeccre;
    }

    public Date getXeusuFecmod() {
        return xeusuFecmod;
    }

    public void setXeusuFecmod(Date xeusuFecmod) {
        this.xeusuFecmod = xeusuFecmod;
    }

    public String getXeusuPiefir() {
        return xeusuPiefir;
    }

    public void setXeusuPiefir(String xeusuPiefir) {
        this.xeusuPiefir = xeusuPiefir;
    }

    @XmlTransient
    public Collection<XeuxpUsupe> getXeuxpUsupeCollection() {
        return xeuxpUsupeCollection;
    }

    public void setXeuxpUsupeCollection(Collection<XeuxpUsupe> xeuxpUsupeCollection) {
        this.xeuxpUsupeCollection = xeuxpUsupeCollection;
    }

    public PeempEmple getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(PeempEmple peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public XeestEstad getXeestCodigo() {
        return xeestCodigo;
    }

    public void setXeestCodigo(XeestEstad xeestCodigo) {
        this.xeestCodigo = xeestCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeusuPaswd != null ? xeusuPaswd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeusuUsuar)) {
            return false;
        }
        XeusuUsuar other = (XeusuUsuar) object;
        if ((this.xeusuPaswd == null && other.xeusuPaswd != null) || (this.xeusuPaswd != null && !this.xeusuPaswd.equals(other.xeusuPaswd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.XeusuUsuar[ xeusuPaswd=" + xeusuPaswd + " ]";
    }
    
}
