/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "statuscomment")
@NamedQueries({
    @NamedQuery(name = "Statuscomment.findAll", query = "SELECT s FROM Statuscomment s")})
public class Statuscomment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "statuscommentid")
    private Integer statuscommentid;
    @Column(name = "status")
    private String status;
    
    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "statusCommentId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("statusCommentId")
    private List<Productcomment> productcommentList;

    public Statuscomment() {
    }

    public Statuscomment(Integer statuscommentid) {
        this.statuscommentid = statuscommentid;
    }

    public Integer getStatuscommentid() {
        return statuscommentid;
    }

    public void setStatuscommentid(Integer statuscommentid) {
        this.statuscommentid = statuscommentid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Productcomment> getProductcommentList() {
        return productcommentList;
    }

    public void setProductcommentList(List<Productcomment> productcommentList) {
        this.productcommentList = productcommentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statuscommentid != null ? statuscommentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statuscomment)) {
            return false;
        }
        Statuscomment other = (Statuscomment) object;
        if ((this.statuscommentid == null && other.statuscommentid != null) || (this.statuscommentid != null && !this.statuscommentid.equals(other.statuscommentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statuscomment[ statuscommentid=" + statuscommentid + " ]";
    }
    
}
