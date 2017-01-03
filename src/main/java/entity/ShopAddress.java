/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "shop_address")
@NamedQueries({
    @NamedQuery(name = "ShopAddress.findAll", query = "SELECT s FROM ShopAddress s")})
public class ShopAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShopAddressId")
    private Integer shopAddressId;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @JoinColumn(name = "ShopId", referencedColumnName = "ShopId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Shop shopId;

    public ShopAddress() {
    }

    public ShopAddress(Integer shopAddressId) {
        this.shopAddressId = shopAddressId;
    }

    public Integer getShopAddressId() {
        return shopAddressId;
    }

    public void setShopAddressId(Integer shopAddressId) {
        this.shopAddressId = shopAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopAddressId != null ? shopAddressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopAddress)) {
            return false;
        }
        ShopAddress other = (ShopAddress) object;
        if ((this.shopAddressId == null && other.shopAddressId != null) || (this.shopAddressId != null && !this.shopAddressId.equals(other.shopAddressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShopAddress[ shopAddressId=" + shopAddressId + " ]";
    }
    
}
