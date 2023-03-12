/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "xeuxp_usupe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeuxpUsupe.findAll", query = "SELECT x FROM XeuxpUsupe x"),
    @NamedQuery(name = "XeuxpUsupe.findByXeusuPaswd", query = "SELECT x FROM XeuxpUsupe x WHERE x.xeuxpUsupePK.xeusuPaswd = :xeusuPaswd"),
    @NamedQuery(name = "XeuxpUsupe.findXeperDescriByXeusuPaswd", query = "SELECT xe.xeperDescri FROM XeuxpUsupe x INNER JOIN x.xeperPerfi xe ON x.xeuxpUsupePK.xeperCodigo = xe.xeperCodigo WHERE x.xeuxpUsupePK.xeusuPaswd = :xeusuPaswd"),
    @NamedQuery(name = "XeuxpUsupe.findAllUsuarios", query = "SELECT xu.xeusuPaswd, pe.peempApelli, pe.peempNombre, xe.xeperPerfi.xeperCodigo FROM XeuxpUsupe xe INNER JOIN xe.xeusuUsuar xu ON xe.xeuxpUsupePK.xeusuPaswd = xu.xeusuPaswd INNER JOIN xu.peempCodigo pe ON xu.peempCodigo = pe.peempCodigo"),
    @NamedQuery(name = "XeuxpUsupe.findByXeperCodigo", query = "SELECT x FROM XeuxpUsupe x WHERE x.xeuxpUsupePK.xeperCodigo = :xeperCodigo"),
    @NamedQuery(name = "XeuxpUsupe.findByXeuxpFecasi", query = "SELECT x FROM XeuxpUsupe x WHERE x.xeuxpUsupePK.xeuxpFecasi = :xeuxpFecasi"),
    @NamedQuery(name = "XeuxpUsupe.findByXeuxpFecret", query = "SELECT x FROM XeuxpUsupe x WHERE x.xeuxpFecret = :xeuxpFecret")})
public class XeuxpUsupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XeuxpUsupePK xeuxpUsupePK;
    @Column(name = "XEUXP_FECRET")
    @Temporal(TemporalType.DATE)
    private Date xeuxpFecret;
    @JoinColumn(name = "XEPER_CODIGO", referencedColumnName = "XEPER_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XeperPerfi xeperPerfi;
    @JoinColumn(name = "XEUSU_PASWD", referencedColumnName = "XEUSU_PASWD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XeusuUsuar xeusuUsuar;

    public XeuxpUsupe() {
    }

    public XeuxpUsupe(XeuxpUsupePK xeuxpUsupePK) {
        this.xeuxpUsupePK = xeuxpUsupePK;
    }

    public XeuxpUsupe(String xeusuPaswd, String xeperCodigo, Date xeuxpFecasi) {
        this.xeuxpUsupePK = new XeuxpUsupePK(xeusuPaswd, xeperCodigo, xeuxpFecasi);
    }

    public XeuxpUsupePK getXeuxpUsupePK() {
        return xeuxpUsupePK;
    }

    public void setXeuxpUsupePK(XeuxpUsupePK xeuxpUsupePK) {
        this.xeuxpUsupePK = xeuxpUsupePK;
    }

    public Date getXeuxpFecret() {
        return xeuxpFecret;
    }

    public void setXeuxpFecret(Date xeuxpFecret) {
        this.xeuxpFecret = xeuxpFecret;
    }

    public XeperPerfi getXeperPerfi() {
        return xeperPerfi;
    }

    public void setXeperPerfi(XeperPerfi xeperPerfi) {
        this.xeperPerfi = xeperPerfi;
    }

    public XeusuUsuar getXeusuUsuar() {
        return xeusuUsuar;
    }

    public void setXeusuUsuar(XeusuUsuar xeusuUsuar) {
        this.xeusuUsuar = xeusuUsuar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeuxpUsupePK != null ? xeuxpUsupePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeuxpUsupe)) {
            return false;
        }
        XeuxpUsupe other = (XeuxpUsupe) object;
        if ((this.xeuxpUsupePK == null && other.xeuxpUsupePK != null) || (this.xeuxpUsupePK != null && !this.xeuxpUsupePK.equals(other.xeuxpUsupePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.XeuxpUsupe[ xeuxpUsupePK=" + xeuxpUsupePK + " ]";
    }
    
}
