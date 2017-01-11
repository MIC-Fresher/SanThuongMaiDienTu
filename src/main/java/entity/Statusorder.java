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
@Table(name = "statusorder")
@NamedQueries({
    @NamedQuery(name = "Statusorder.findAll", query = "SELECT s FROM Statusorder s")})
public class Statusorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StatusOrderId")
    private Integer statusOrderId;
    @Column(name = "status")
    private Integer status;
    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "statusOrderId")
      @LazyCollection(LazyCollectionOption.FALSE)
    private List<Orders> ordersList;

    public Statusorder() {
    }

    public Statusorder(Integer statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public Integer getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(Integer statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusOrderId != null ? statusOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusorder)) {
            return false;
        }
        Statusorder other = (Statusorder) object;
        if ((this.statusOrderId == null && other.statusOrderId != null) || (this.statusOrderId != null && !this.statusOrderId.equals(other.statusOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statusorder[ statusOrderId=" + statusOrderId + " ]";
    }
    
}
