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
public class ShopProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ShopId")
    private int shopId;
    @Basic(optional = false)
    @Column(name = "ProductId")
    private int productId;

    public ShopProductPK() {
    }

    public ShopProductPK(int shopId, int productId) {
        this.shopId = shopId;
        this.productId = productId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) shopId;
        hash += (int) productId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopProductPK)) {
            return false;
        }
        ShopProductPK other = (ShopProductPK) object;
        if (this.shopId != other.shopId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShopProductPK[ shopId=" + shopId + ", productId=" + productId + " ]";
    }
    
}
