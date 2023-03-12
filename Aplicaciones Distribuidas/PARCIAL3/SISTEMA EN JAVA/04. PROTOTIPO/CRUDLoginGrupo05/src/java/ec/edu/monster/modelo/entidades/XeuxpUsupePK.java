/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author santi
 */
@Embeddable
public class XeuxpUsupePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "XEUSU_PASWD")
    private String xeusuPaswd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "XEPER_CODIGO")
    private String xeperCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUXP_FECASI")
    @Temporal(TemporalType.DATE)
    private Date xeuxpFecasi;

    public XeuxpUsupePK() {
    }

    public XeuxpUsupePK(String xeusuPaswd, String xeperCodigo, Date xeuxpFecasi) {
        this.xeusuPaswd = xeusuPaswd;
        this.xeperCodigo = xeperCodigo;
        this.xeuxpFecasi = xeuxpFecasi;
    }

    public String getXeusuPaswd() {
        return xeusuPaswd;
    }

    public void setXeusuPaswd(String xeusuPaswd) {
        this.xeusuPaswd = xeusuPaswd;
    }

    public String getXeperCodigo() {
        return xeperCodigo;
    }

    public void setXeperCodigo(String xeperCodigo) {
        this.xeperCodigo = xeperCodigo;
    }

    public Date getXeuxpFecasi() {
        return xeuxpFecasi;
    }

    public void setXeuxpFecasi(Date xeuxpFecasi) {
        this.xeuxpFecasi = xeuxpFecasi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeusuPaswd != null ? xeusuPaswd.hashCode() : 0);
        hash += (xeperCodigo != null ? xeperCodigo.hashCode() : 0);
        hash += (xeuxpFecasi != null ? xeuxpFecasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeuxpUsupePK)) {
            return false;
        }
        XeuxpUsupePK other = (XeuxpUsupePK) object;
        if ((this.xeusuPaswd == null && other.xeusuPaswd != null) || (this.xeusuPaswd != null && !this.xeusuPaswd.equals(other.xeusuPaswd))) {
            return false;
        }
        if ((this.xeperCodigo == null && other.xeperCodigo != null) || (this.xeperCodigo != null && !this.xeperCodigo.equals(other.xeperCodigo))) {
            return false;
        }
        if ((this.xeuxpFecasi == null && other.xeuxpFecasi != null) || (this.xeuxpFecasi != null && !this.xeuxpFecasi.equals(other.xeuxpFecasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.XeuxpUsupePK[ xeusuPaswd=" + xeusuPaswd + ", xeperCodigo=" + xeperCodigo + ", xeuxpFecasi=" + xeuxpFecasi + " ]";
    }
    
}
