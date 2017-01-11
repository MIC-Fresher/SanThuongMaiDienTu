/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "producimage")
@NamedQueries({
    @NamedQuery(name = "Producimage.findAll", query = "SELECT p FROM Producimage p")})
public class Producimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProducImageId")
    private Integer producImageId;
    @Column(name = "Url")
    private String url;
    @Column(name = "IsActive")
    private Integer isActive;
    @JoinColumn(name = "ProducDetailtId", referencedColumnName = "ProductdetailId")
    @ManyToOne
    private Productdetail producDetailtId;

    public Producimage() {
    }

    public Producimage(Integer producImageId) {
        this.producImageId = producImageId;
    }

    public Integer getProducImageId() {
        return producImageId;
    }

    public void setProducImageId(Integer producImageId) {
        this.producImageId = producImageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Productdetail getProducDetailtId() {
        return producDetailtId;
    }

    public void setProducDetailtId(Productdetail producDetailtId) {
        this.producDetailtId = producDetailtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producImageId != null ? producImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producimage)) {
            return false;
        }
        Producimage other = (Producimage) object;
        if ((this.producImageId == null && other.producImageId != null) || (this.producImageId != null && !this.producImageId.equals(other.producImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Producimage[ producImageId=" + producImageId + " ]";
    }
    
}
