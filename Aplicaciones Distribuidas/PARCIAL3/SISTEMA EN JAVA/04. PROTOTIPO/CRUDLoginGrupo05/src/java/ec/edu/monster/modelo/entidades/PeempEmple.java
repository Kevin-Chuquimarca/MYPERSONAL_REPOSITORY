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
import javax.persistence.Lob;
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
@Table(name = "peemp_emple")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeempEmple.findAll", query = "SELECT p FROM PeempEmple p"),
    @NamedQuery(name = "PeempEmple.findByPeempCodigo", query = "SELECT p FROM PeempEmple p WHERE p.peempCodigo = :peempCodigo"),
    @NamedQuery(name = "PeempEmple.findByPeempApelli", query = "SELECT p FROM PeempEmple p WHERE p.peempApelli = :peempApelli"),
    @NamedQuery(name = "PeempEmple.findByPeempNombre", query = "SELECT p FROM PeempEmple p WHERE p.peempNombre = :peempNombre"),
    @NamedQuery(name = "PeempEmple.findByPeempFecnac", query = "SELECT p FROM PeempEmple p WHERE p.peempFecnac = :peempFecnac"),
    @NamedQuery(name = "PeempEmple.findByPeempFecsal", query = "SELECT p FROM PeempEmple p WHERE p.peempFecsal = :peempFecsal"),
    @NamedQuery(name = "PeempEmple.findByPeempDirec", query = "SELECT p FROM PeempEmple p WHERE p.peempDirec = :peempDirec"),
    @NamedQuery(name = "PeempEmple.findByPeempTelef", query = "SELECT p FROM PeempEmple p WHERE p.peempTelef = :peempTelef"),
    @NamedQuery(name = "PeempEmple.findByPeempEmail", query = "SELECT p FROM PeempEmple p WHERE p.peempEmail = :peempEmail"),
    @NamedQuery(name = "PeempEmple.findByPeempCedula", query = "SELECT p FROM PeempEmple p WHERE p.peempCedula = :peempCedula"),
    @NamedQuery(name = "PeempEmple.findByPeempFoto", query = "SELECT p FROM PeempEmple p WHERE p.peempFoto = :peempFoto"),
    @NamedQuery(name = "PeempEmple.findByPeempCarfam", query = "SELECT p FROM PeempEmple p WHERE p.peempCarfam = :peempCarfam"),
    @NamedQuery(name = "PeempEmple.findByPeempPasapo", query = "SELECT p FROM PeempEmple p WHERE p.peempPasapo = :peempPasapo"),
    @NamedQuery(name = "PeempEmple.findByTecemCodigo", query = "SELECT p FROM PeempEmple p WHERE p.tecemCodigo.tecemCodigo = :tecemCodigo"),
    @NamedQuery(name = "PeempEmple.findByTeproCodigo", query = "SELECT p FROM PeempEmple p WHERE p.teproCodigo.teproCodigo = :teproCodigo")})
public class PeempEmple implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PEEMP_APELLI")
    private String peempApelli;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 50)
    @Column(name = "PEEMP_NOMBRE")
    private String peempNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_FECNAC")
    @Temporal(TemporalType.DATE)
    private Date peempFecnac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_FECSAL")
    @Temporal(TemporalType.DATE)
    private Date peempFecsal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PEEMP_DIREC")
    private String peempDirec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PEEMP_TELEF")
    private String peempTelef;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEEMP_EMAIL")
    private String peempEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PEEMP_CEDULA")
    private String peempCedula;
    @Size(max = 100)
    @Column(name = "PEEMP_FOTO")
    private String peempFoto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_CARFAM")
    private short peempCarfam;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    @Column(name = "PEEMP_PASAPO")
    private String peempPasapo;
    @Basic(optional = false)
    @NotNull
    @Lob()
    @Column(name = "DISCAPA")
    private byte[] discapa;
    @JoinColumn(name = "TECEM_CODIGO", referencedColumnName = "TECEM_CODIGO")
    @ManyToOne(optional = false)
    private TecemCaremp tecemCodigo;
    @JoinColumn(name = "TEPRO_CODIGO", referencedColumnName = "TEPRO_CODIGO")
    @ManyToOne
    private TeproProyec teproCodigo;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peempCodigo")
    private Collection<XeusuUsuar> xeusuUsuarCollection;

    public PeempEmple() {
    }

    public PeempEmple(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public PeempEmple(String peempCodigo, String peempApelli, String peempNombre, Date peempFecnac, Date peempFecsal, String peempDirec, String peempTelef, String peempEmail, String peempCedula, short peempCarfam, String peempPasapo) {
        this.peempCodigo = peempCodigo;
        this.peempApelli = peempApelli;
        this.peempNombre = peempNombre;
        this.peempFecnac = peempFecnac;
        this.peempFecsal = peempFecsal;
        this.peempDirec = peempDirec;
        this.peempTelef = peempTelef;
        this.peempEmail = peempEmail;
        this.peempCedula = peempCedula;
        this.peempCarfam = peempCarfam;
        this.peempPasapo = peempPasapo;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public String getPeempApelli() {
        return peempApelli;
    }

    public void setPeempApelli(String peempApelli) {
        this.peempApelli = peempApelli;
    }

    public String getPeempNombre() {
        return peempNombre;
    }

    public void setPeempNombre(String peempNombre) {
        this.peempNombre = peempNombre;
    }

    public Date getPeempFecnac() {
        return peempFecnac;
    }

    public void setPeempFecnac(Date peempFecnac) {
        this.peempFecnac = peempFecnac;
    }

    public Date getPeempFecsal() {
        return peempFecsal;
    }

    public void setPeempFecsal(Date peempFecsal) {
        this.peempFecsal = peempFecsal;
    }

    public String getPeempDirec() {
        return peempDirec;
    }

    public void setPeempDirec(String peempDirec) {
        this.peempDirec = peempDirec;
    }

    public String getPeempTelef() {
        return peempTelef;
    }

    public void setPeempTelef(String peempTelef) {
        this.peempTelef = peempTelef;
    }

    public String getPeempEmail() {
        return peempEmail;
    }

    public void setPeempEmail(String peempEmail) {
        this.peempEmail = peempEmail;
    }

    public String getPeempCedula() {
        return peempCedula;
    }

    public void setPeempCedula(String peempCedula) {
        this.peempCedula = peempCedula;
    }

    public String getPeempFoto() {
        return peempFoto;
    }

    public void setPeempFoto(String peempFoto) {
        this.peempFoto = peempFoto;
    }

    public short getPeempCarfam() {
        return peempCarfam;
    }

    public void setPeempCarfam(short peempCarfam) {
        this.peempCarfam = peempCarfam;
    }

    public String getPeempPasapo() {
        return peempPasapo;
    }

    public void setPeempPasapo(String peempPasapo) {
        this.peempPasapo = peempPasapo;
    }

    @XmlTransient
    public Collection<XeusuUsuar> getXeusuUsuarCollection() {
        return xeusuUsuarCollection;
    }

    public void setXeusuUsuarCollection(Collection<XeusuUsuar> xeusuUsuarCollection) {
        this.xeusuUsuarCollection = xeusuUsuarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempCodigo != null ? peempCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeempEmple)) {
            return false;
        }
        PeempEmple other = (PeempEmple) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.PeempEmple[ peempCodigo=" + peempCodigo + " ]";
    }

    public byte[] getDiscapa() {
        return discapa;
    }

    public void setDiscapa(byte[] discapa) {
        this.discapa = discapa;
    }

    public TecemCaremp getTecemCodigo() {
        return tecemCodigo;
    }

    public void setTecemCodigo(TecemCaremp tecemCodigo) {
        this.tecemCodigo = tecemCodigo;
    }

    public TeproProyec getTeproCodigo() {
        return teproCodigo;
    }

    public void setTeproCodigo(TeproProyec teproCodigo) {
        this.teproCodigo = teproCodigo;
    }

}
