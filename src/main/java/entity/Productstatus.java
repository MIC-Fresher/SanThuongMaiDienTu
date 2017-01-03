/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "productstatus")
@NamedQueries({
    @NamedQuery(name = "Productstatus.findAll", query = "SELECT p FROM Productstatus p")})
public class Productstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductStatusId")
    private Integer productStatusId;
    @Column(name = "NumberSold")
    private Integer numberSold;
    @Column(name = "NumberStock")
    private Integer numberStock;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product productId;

    public Productstatus() {
    }

    public Productstatus(Integer productStatusId) {
        this.productStatusId = productStatusId;
    }

    public Integer getProductStatusId() {
        return productStatusId;
    }

    public void setProductStatusId(Integer productStatusId) {
        this.productStatusId = productStatusId;
    }

    public Integer getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(Integer numberSold) {
        this.numberSold = numberSold;
    }

    public Integer getNumberStock() {
        return numberStock;
    }

    public void setNumberStock(Integer numberStock) {
        this.numberStock = numberStock;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productStatusId != null ? productStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productstatus)) {
            return false;
        }
        Productstatus other = (Productstatus) object;
        if ((this.productStatusId == null && other.productStatusId != null) || (this.productStatusId != null && !this.productStatusId.equals(other.productStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productstatus[ productStatusId=" + productStatusId + " ]";
    }
    
}
