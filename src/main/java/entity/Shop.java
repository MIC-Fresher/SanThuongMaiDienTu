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
@Table(name = "shop")
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
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;
    @OneToMany(mappedBy = "shopId", fetch = FetchType.EAGER)
    private List<ShopAddress> shopAddressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<ShopCategory> shopCategoryList;
    @OneToMany(mappedBy = "shopId", fetch = FetchType.EAGER)
    private List<Shopdaily> shopdailyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<ShopProduct> shopProductList;

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

    public List<ShopCategory> getShopCategoryList() {
        return shopCategoryList;
    }

    public void setShopCategoryList(List<ShopCategory> shopCategoryList) {
        this.shopCategoryList = shopCategoryList;
    }

    public List<Shopdaily> getShopdailyList() {
        return shopdailyList;
    }

    public void setShopdailyList(List<Shopdaily> shopdailyList) {
        this.shopdailyList = shopdailyList;
    }

    public List<ShopProduct> getShopProductList() {
        return shopProductList;
    }

    public void setShopProductList(List<ShopProduct> shopProductList) {
        this.shopProductList = shopProductList;
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
