/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "producimage")
@NamedQueries({
    @NamedQuery(name = "Producimage.findAll", query = "SELECT p FROM Producimage p")})
public class Producimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProducimagePK producimagePK;
    @Column(name = "Url")
    private String url;
    @Column(name = "IsActive")
    private Integer isActive;
    @JoinColumn(name = "ProducDetailtId", referencedColumnName = "ProductdetailId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Productdetail productdetail;

    public Producimage() {
    }

    public Producimage(ProducimagePK producimagePK) {
        this.producimagePK = producimagePK;
    }

    public Producimage(int producImageId, int producDetailtId) {
        this.producimagePK = new ProducimagePK(producImageId, producDetailtId);
    }

    public ProducimagePK getProducimagePK() {
        return producimagePK;
    }

    public void setProducimagePK(ProducimagePK producimagePK) {
        this.producimagePK = producimagePK;
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

    public Productdetail getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(Productdetail productdetail) {
        this.productdetail = productdetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producimagePK != null ? producimagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producimage)) {
            return false;
        }
        Producimage other = (Producimage) object;
        if ((this.producimagePK == null && other.producimagePK != null) || (this.producimagePK != null && !this.producimagePK.equals(other.producimagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Producimage[ producimagePK=" + producimagePK + " ]";
    }
    
}
