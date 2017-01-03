/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "shopdaily")
@NamedQueries({
    @NamedQuery(name = "Shopdaily.findAll", query = "SELECT s FROM Shopdaily s")})
public class Shopdaily implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShopDailyId")
    private Integer shopDailyId;
    @Column(name = "Action")
    private String action;
    @Column(name = "Target")
    private String target;
    @Column(name = "TargetId")
    private Integer targetId;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JoinColumn(name = "ShopId", referencedColumnName = "ShopId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Shop shopId;

    public Shopdaily() {
    }

    public Shopdaily(Integer shopDailyId) {
        this.shopDailyId = shopDailyId;
    }

    public Integer getShopDailyId() {
        return shopDailyId;
    }

    public void setShopDailyId(Integer shopDailyId) {
        this.shopDailyId = shopDailyId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopDailyId != null ? shopDailyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shopdaily)) {
            return false;
        }
        Shopdaily other = (Shopdaily) object;
        if ((this.shopDailyId == null && other.shopDailyId != null) || (this.shopDailyId != null && !this.shopDailyId.equals(other.shopDailyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shopdaily[ shopDailyId=" + shopDailyId + " ]";
    }
    
}
