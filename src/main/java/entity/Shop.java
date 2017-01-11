/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
@Table(name = "shop")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "deletePS",
            procedureName = "deletePS",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "KQ", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idproduct", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idshop", type = Integer.class)
            }),
    @NamedStoredProcedureQuery(
            name = "addPS",
            procedureName = "addPS",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "KQ", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idproduct", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idshop", type = Integer.class)
            })
})
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s")})
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShopId")
    private Integer shopId;
    @Column(name = "ShopName")
    private String shopName;
    @Lob
    @Column(name = "ShopLogo")
    private String shopLogo;
    @Column(name = "ShopPhone")
    private String shopPhone;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @ManyToMany(mappedBy = "shopList", cascade =  CascadeType.MERGE  )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Category> categoryList;

    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "shopId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> productList;

    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @OneToOne
    private User userId;
    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "shopId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ShopAddress> shopAddressList;
    @OneToMany( cascade =  CascadeType.MERGE   ,mappedBy = "shopId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Shopdaily> shopdailyList;

    public Shop() {
    }

    public Shop(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<ShopAddress> getShopAddressList() {
        return shopAddressList;
    }

    public void setShopAddressList(List<ShopAddress> shopAddressList) {
        this.shopAddressList = shopAddressList;
    }

    public List<Shopdaily> getShopdailyList() {
        return shopdailyList;
    }

    public void setShopdailyList(List<Shopdaily> shopdailyList) {
        this.shopdailyList = shopdailyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopId != null ? shopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.shopId == null && other.shopId != null) || (this.shopId != null && !this.shopId.equals(other.shopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shop[ shopId=" + shopId + " ]";
    }

}
