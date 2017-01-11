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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @Column(name = "TotalVote")
    private Integer totalVote;
    @Column(name = "ProductName")
    private String productName;
    @Lob
    @Column(name = "Description")
    private String description;
    @Column(name = "IsDiscounted")
    private Integer isDiscounted;
    @Column(name = "UnitPrice")
    private Integer unitPrice;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "IsActive")
    private Integer isActive;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    

    @JoinColumn(name = "ShopId", referencedColumnName = "ShopId")
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private Shop shopId;

    @OneToOne(cascade =  CascadeType.MERGE   ,mappedBy = "productId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Productdetail productdetail;
    
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne
    private Category categoryId;
    
    @OneToMany(cascade =  CascadeType.MERGE   ,mappedBy = "productId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Productstatus> productstatusList;
    @OneToMany(cascade =  CascadeType.MERGE   ,mappedBy = "productId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Productcomment> productcommentList;
    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "productId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Productvoting> productvotingList;
    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "productId")
    @LazyCollection(LazyCollectionOption.FALSE)
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
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

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    

    public Productdetail getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(Productdetail productdetail) {
        this.productdetail = productdetail;
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

    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    public Integer getTotalVote() {
        return totalVote;
    }

    public void setTotalVote(Integer totalVote) {
        this.totalVote = totalVote;
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
