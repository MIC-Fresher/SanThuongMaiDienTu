/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Admin
 */
@Embeddable
public class RoleUserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "RoleId")
    private int roleId;
    @Basic(optional = false)
    @Column(name = "UserId")
    private int userId;

    public RoleUserPK() {
    }

    public RoleUserPK(int roleId, int userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleUserPK)) {
            return false;
        }
        RoleUserPK other = (RoleUserPK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoleUserPK[ roleId=" + roleId + ", userId=" + userId + " ]";
    }
    
}
