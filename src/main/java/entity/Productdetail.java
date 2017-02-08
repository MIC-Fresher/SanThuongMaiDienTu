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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    
    @JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
    @ManyToOne
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("productdetailList")
    private Sizes sizeId;
    
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("productdetail")
    @OneToOne
    private Product productId;
    
    
    @JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
    @ManyToOne
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("productdetailList")
    private Color colorId;
    
    @OneToMany(  cascade =  CascadeType.MERGE   ,mappedBy = "producDetailtId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("producDetailtId")
    private List<Producimage> producimageList;

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

    public List<Producimage> getProducimageList() {
        return producimageList;
    }

    public void setProducimageList(List<Producimage> producimageList) {
        this.producimageList = producimageList;
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
