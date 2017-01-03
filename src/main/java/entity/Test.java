/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "test")
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtest")
    private Integer idtest;
    @Column(name = "enabled")
    private Integer enabled;
    @Column(name = "pass")
    private String pass;
    @Column(name = "role")
    private String role;
    @Column(name = "user")
    private String user;

    public Test() {
    }

    public Test(Integer idtest) {
        this.idtest = idtest;
    }

    public Integer getIdtest() {
        return idtest;
    }

    public void setIdtest(Integer idtest) {
        this.idtest = idtest;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtest != null ? idtest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.idtest == null && other.idtest != null) || (this.idtest != null && !this.idtest.equals(other.idtest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Test[ idtest=" + idtest + " ]";
    }
    
}
