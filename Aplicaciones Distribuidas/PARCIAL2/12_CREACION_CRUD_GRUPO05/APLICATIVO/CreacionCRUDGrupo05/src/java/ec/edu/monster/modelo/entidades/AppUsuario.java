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
@Table(name = "app_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUsuario.findAll", query = "SELECT a FROM AppUsuario a"),
    @NamedQuery(name = "AppUsuario.findByAppUsuarioId", query = "SELECT a FROM AppUsuario a WHERE a.appUsuarioId = :appUsuarioId"),
    @NamedQuery(name = "AppUsuario.findByUsuarioName", query = "SELECT a FROM AppUsuario a WHERE a.usuarioName = :usuarioName"),
    @NamedQuery(name = "AppUsuario.findByPassword", query = "SELECT a FROM AppUsuario a WHERE a.password = :password")})
public class AppUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "app_usuario_id")
    private Integer appUsuarioId;
    @Size(max = 10)
    @Column(name = "usuario_name")
    private String usuarioName;
    @Size(max = 15)
    @Column(name = "password")
    private String password;

    public AppUsuario() {
    }

    public AppUsuario(Integer appUsuarioId) {
        this.appUsuarioId = appUsuarioId;
    }

    public Integer getAppUsuarioId() {
        return appUsuarioId;
    }

    public void setAppUsuarioId(Integer appUsuarioId) {
        this.appUsuarioId = appUsuarioId;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appUsuarioId != null ? appUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUsuario)) {
            return false;
        }
        AppUsuario other = (AppUsuario) object;
        if ((this.appUsuarioId == null && other.appUsuarioId != null) || (this.appUsuarioId != null && !this.appUsuarioId.equals(other.appUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.AppUsuario[ appUsuarioId=" + appUsuarioId + " ]";
    }
    
}
