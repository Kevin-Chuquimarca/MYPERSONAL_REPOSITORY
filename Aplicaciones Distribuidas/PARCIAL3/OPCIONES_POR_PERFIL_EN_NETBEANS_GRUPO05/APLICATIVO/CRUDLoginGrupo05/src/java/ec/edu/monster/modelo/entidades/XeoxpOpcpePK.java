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
public class XeoxpOpcpePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "XEOPC_CODIGO")
    private String xeopcCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "XEPER_CODIGO")
    private String xeperCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEOXP_FECASI")
    @Temporal(TemporalType.DATE)
    private Date xeoxpFecasi;

    public XeoxpOpcpePK() {
    }

    public XeoxpOpcpePK(String xeopcCodigo, String xeperCodigo, Date xeoxpFecasi) {
        this.xeopcCodigo = xeopcCodigo;
        this.xeperCodigo = xeperCodigo;
        this.xeoxpFecasi = xeoxpFecasi;
    }

    public String getXeopcCodigo() {
        return xeopcCodigo;
    }

    public void setXeopcCodigo(String xeopcCodigo) {
        this.xeopcCodigo = xeopcCodigo;
    }

    public String getXeperCodigo() {
        return xeperCodigo;
    }

    public void setXeperCodigo(String xeperCodigo) {
        this.xeperCodigo = xeperCodigo;
    }

    public Date getXeoxpFecasi() {
        return xeoxpFecasi;
    }

    public void setXeoxpFecasi(Date xeoxpFecasi) {
        this.xeoxpFecasi = xeoxpFecasi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeopcCodigo != null ? xeopcCodigo.hashCode() : 0);
        hash += (xeperCodigo != null ? xeperCodigo.hashCode() : 0);
        hash += (xeoxpFecasi != null ? xeoxpFecasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeoxpOpcpePK)) {
            return false;
        }
        XeoxpOpcpePK other = (XeoxpOpcpePK) object;
        if ((this.xeopcCodigo == null && other.xeopcCodigo != null) || (this.xeopcCodigo != null && !this.xeopcCodigo.equals(other.xeopcCodigo))) {
            return false;
        }
        if ((this.xeperCodigo == null && other.xeperCodigo != null) || (this.xeperCodigo != null && !this.xeperCodigo.equals(other.xeperCodigo))) {
            return false;
        }
        if ((this.xeoxpFecasi == null && other.xeoxpFecasi != null) || (this.xeoxpFecasi != null && !this.xeoxpFecasi.equals(other.xeoxpFecasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.XeoxpOpcpePK[ xeopcCodigo=" + xeopcCodigo + ", xeperCodigo=" + xeperCodigo + ", xeoxpFecasi=" + xeoxpFecasi + " ]";
    }
    
}
