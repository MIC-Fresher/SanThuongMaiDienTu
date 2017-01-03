/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductId")
    private Integer productId;
    @Column(name = "ProductName")
    private String productName;
    @Lob
    @Column(name = "Description")
    private String description;
    @Column(name = "IsDiscounted")
    private Integer isDiscounted;
    @Column(name = "UnitPrice")
    private BigInteger unitPrice;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "IsActive")
    private Integer isActive;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private List<Productdetail> productdetailList;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId", fetch = FetchType.EAGER)
    private List<Productstatus> productstatusList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private List<Productcomment> productcommentList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private List<Productvoting> productvotingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER)
    private List<ShopProduct> shopProductList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private List<Orderdetail> orderdetailList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDiscounted() {
        return isDiscounted;
    }

    public void setIsDiscounted(Integer isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Productdetail> getProductdetailList() {
        return productdetailList;
    }

    public void setProductdetailList(List<Productdetail> productdetailList) {
        this.productdetailList = productdetailList;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public List<Productstatus> getProductstatusList() {
        return productstatusList;
    }

    public void setProductstatusList(List<Productstatus> productstatusList) {
        this.productstatusList = productstatusList;
    }

    public List<Productcomment> getProductcommentList() {
        return productcommentList;
    }

    public void setProductcommentList(List<Productcomment> productcommentList) {
        this.productcommentList = productcommentList;
    }

    public List<Productvoting> getProductvotingList() {
        return productvotingList;
    }

    public void setProductvotingList(List<Productvoting> productvotingList) {
        this.productvotingList = productvotingList;
    }

    public List<ShopProduct> getShopProductList() {
        return shopProductList;
    }

    public void setShopProductList(List<ShopProduct> shopProductList) {
        this.shopProductList = shopProductList;
    }

    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ productId=" + productId + " ]";
    }
    
}
