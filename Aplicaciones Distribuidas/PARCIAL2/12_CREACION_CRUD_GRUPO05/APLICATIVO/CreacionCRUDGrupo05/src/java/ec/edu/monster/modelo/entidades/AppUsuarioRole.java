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
@Table(name = "app_usuario_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUsuarioRole.findAll", query = "SELECT a FROM AppUsuarioRole a"),
    @NamedQuery(name = "AppUsuarioRole.findByRoleId", query = "SELECT a FROM AppUsuarioRole a WHERE a.roleId = :roleId"),
    @NamedQuery(name = "AppUsuarioRole.findByRoleName", query = "SELECT a FROM AppUsuarioRole a WHERE a.roleName = :roleName")})
public class AppUsuarioRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private Integer roleId;
    @Size(max = 10)
    @Column(name = "role_name")
    private String roleName;

    public AppUsuarioRole() {
    }

    public AppUsuarioRole(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUsuarioRole)) {
            return false;
        }
        AppUsuarioRole other = (AppUsuarioRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.entidades.AppUsuarioRole[ roleId=" + roleId + " ]";
    }
    
}
