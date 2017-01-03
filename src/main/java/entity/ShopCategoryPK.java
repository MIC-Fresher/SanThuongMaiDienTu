/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Admin
 */
@Embeddable
public class ShopCategoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ShopId")
    private int shopId;
    @Basic(optional = false)
    @Column(name = "CategoryId")
    private int categoryId;

    public ShopCategoryPK() {
    }

    public ShopCategoryPK(int shopId, int categoryId) {
        this.shopId = shopId;
        this.categoryId = categoryId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) shopId;
        hash += (int) categoryId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopCategoryPK)) {
            return false;
        }
        ShopCategoryPK other = (ShopCategoryPK) object;
        if (this.shopId != other.shopId) {
            return false;
        }
        if (this.categoryId != other.categoryId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShopCategoryPK[ shopId=" + shopId + ", categoryId=" + categoryId + " ]";
    }
    
}
