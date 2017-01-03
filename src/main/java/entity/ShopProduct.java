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
@Table(name = "shop_product")
@NamedQueries({
    @NamedQuery(name = "ShopProduct.findAll", query = "SELECT s FROM ShopProduct s")})
public class ShopProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShopProductPK shopProductPK;
    @JoinColumn(name = "ShopId", referencedColumnName = "ShopId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Shop shop;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    public ShopProduct() {
    }

    public ShopProduct(ShopProductPK shopProductPK) {
        this.shopProductPK = shopProductPK;
    }

    public ShopProduct(int shopId, int productId) {
        this.shopProductPK = new ShopProductPK(shopId, productId);
    }

    public ShopProductPK getShopProductPK() {
        return shopProductPK;
    }

    public void setShopProductPK(ShopProductPK shopProductPK) {
        this.shopProductPK = shopProductPK;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopProductPK != null ? shopProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopProduct)) {
            return false;
        }
        ShopProduct other = (ShopProduct) object;
        if ((this.shopProductPK == null && other.shopProductPK != null) || (this.shopProductPK != null && !this.shopProductPK.equals(other.shopProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShopProduct[ shopProductPK=" + shopProductPK + " ]";
    }
    
}
