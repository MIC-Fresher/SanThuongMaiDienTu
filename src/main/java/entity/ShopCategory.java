/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "shop_category")
@NamedQueries({
    @NamedQuery(name = "ShopCategory.findAll", query = "SELECT s FROM ShopCategory s")})
public class ShopCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShopCategoryPK shopCategoryPK;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Category category;
    @JoinColumn(name = "ShopId", referencedColumnName = "ShopId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Shop shop;

    public ShopCategory() {
    }

    public ShopCategory(ShopCategoryPK shopCategoryPK) {
        this.shopCategoryPK = shopCategoryPK;
    }

    public ShopCategory(int shopId, int categoryId) {
        this.shopCategoryPK = new ShopCategoryPK(shopId, categoryId);
    }

    public ShopCategoryPK getShopCategoryPK() {
        return shopCategoryPK;
    }

    public void setShopCategoryPK(ShopCategoryPK shopCategoryPK) {
        this.shopCategoryPK = shopCategoryPK;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopCategoryPK != null ? shopCategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopCategory)) {
            return false;
        }
        ShopCategory other = (ShopCategory) object;
        if ((this.shopCategoryPK == null && other.shopCategoryPK != null) || (this.shopCategoryPK != null && !this.shopCategoryPK.equals(other.shopCategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShopCategory[ shopCategoryPK=" + shopCategoryPK + " ]";
    }
    
}
