/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "role_user")
@NamedQueries({
    @NamedQuery(name = "RoleUser.findAll", query = "SELECT r FROM RoleUser r")})
public class RoleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleUserPK roleUserPK;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role role;

    public RoleUser() {
    }

    public RoleUser(RoleUserPK roleUserPK) {
        this.roleUserPK = roleUserPK;
    }

    public RoleUser(int roleId, int userId) {
        this.roleUserPK = new RoleUserPK(roleId, userId);
    }

    public RoleUserPK getRoleUserPK() {
        return roleUserPK;
    }

    public void setRoleUserPK(RoleUserPK roleUserPK) {
        this.roleUserPK = roleUserPK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleUserPK != null ? roleUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleUser)) {
            return false;
        }
        RoleUser other = (RoleUser) object;
        if ((this.roleUserPK == null && other.roleUserPK != null) || (this.roleUserPK != null && !this.roleUserPK.equals(other.roleUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoleUser[ roleUserPK=" + roleUserPK + " ]";
    }
    
}
