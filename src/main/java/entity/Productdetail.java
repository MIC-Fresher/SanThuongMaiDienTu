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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "productdetail")
@NamedQueries({
    @NamedQuery(name = "Productdetail.findAll", query = "SELECT p FROM Productdetail p")})
public class Productdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductdetailId")
    private Integer productdetailId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productdetail", fetch = FetchType.EAGER)
    private List<Producimage> producimageList;
    @JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sizes sizeId;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productId;
    @JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Color colorId;

    public Productdetail() {
    }

    public Productdetail(Integer productdetailId) {
        this.productdetailId = productdetailId;
    }

    public Integer getProductdetailId() {
        return productdetailId;
    }

    public void setProductdetailId(Integer productdetailId) {
        this.productdetailId = productdetailId;
    }

    public List<Producimage> getProducimageList() {
        return producimageList;
    }

    public void setProducimageList(List<Producimage> producimageList) {
        this.producimageList = producimageList;
    }

    public Sizes getSizeId() {
        return sizeId;
    }

    public void setSizeId(Sizes sizeId) {
        this.sizeId = sizeId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productdetailId != null ? productdetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productdetail)) {
            return false;
        }
        Productdetail other = (Productdetail) object;
        if ((this.productdetailId == null && other.productdetailId != null) || (this.productdetailId != null && !this.productdetailId.equals(other.productdetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productdetail[ productdetailId=" + productdetailId + " ]";
    }
    
}
