/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "es_prov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsProv.findAll", query = "SELECT e FROM EsProv e"),
    @NamedQuery(name = "EsProv.findByEsProvId", query = "SELECT e FROM EsProv e WHERE e.esProvId = :esProvId"),
    @NamedQuery(name = "EsProv.findByEsProvCd", query = "SELECT e FROM EsProv e WHERE e.esProvCd = :esProvCd"),
    @NamedQuery(name = "EsProv.findByEsProvNm", query = "SELECT e FROM EsProv e WHERE e.esProvNm = :esProvNm")})
public class EsProv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "es_prov_id")
    private Integer esProvId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "es_prov_cd")
    private String esProvCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "es_prov_nm")
    private String esProvNm;
    @OneToMany(mappedBy = "esProvId")
    private Collection<EsCiudad> esCiudadCollection;

    public EsProv() {
    }

    public EsProv(Integer esProvId) {
        this.esProvId = esProvId;
    }

    public EsProv(Integer esProvId, String esProvCd, String esProvNm) {
        this.esProvId = esProvId;
        this.esProvCd = esProvCd;
        this.esProvNm = esProvNm;
    }

    public Integer getEsProvId() {
        return esProvId;
    }

    public void setEsProvId(Integer esProvId) {
        this.esProvId = esProvId;
    }

    public String getEsProvCd() {
        return esProvCd;
    }

    public void setEsProvCd(String esProvCd) {
        this.esProvCd = esProvCd;
    }

    public String getEsProvNm() {
        return esProvNm;
    }

    public void setEsProvNm(String esProvNm) {
        this.esProvNm = esProvNm;
    }

    @XmlTransient
    public Collection<EsCiudad> getEsCiudadCollection() {
        return esCiudadCollection;
    }

    public void setEsCiudadCollection(Collection<EsCiudad> esCiudadCollection) {
        this.esCiudadCollection = esCiudadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esProvId != null ? esProvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsProv)) {
            return false;
        }
        EsProv other = (EsProv) object;
        if ((this.esProvId == null && other.esProvId != null) || (this.esProvId != null && !this.esProvId.equals(other.esProvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.EsProv[ esProvId=" + esProvId + " ]";
    }
    
}
