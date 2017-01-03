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
public class ProducimagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ProducImageId")
    private int producImageId;
    @Basic(optional = false)
    @Column(name = "ProducDetailtId")
    private int producDetailtId;

    public ProducimagePK() {
    }

    public ProducimagePK(int producImageId, int producDetailtId) {
        this.producImageId = producImageId;
        this.producDetailtId = producDetailtId;
    }

    public int getProducImageId() {
        return producImageId;
    }

    public void setProducImageId(int producImageId) {
        this.producImageId = producImageId;
    }

    public int getProducDetailtId() {
        return producDetailtId;
    }

    public void setProducDetailtId(int producDetailtId) {
        this.producDetailtId = producDetailtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) producImageId;
        hash += (int) producDetailtId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProducimagePK)) {
            return false;
        }
        ProducimagePK other = (ProducimagePK) object;
        if (this.producImageId != other.producImageId) {
            return false;
        }
        if (this.producDetailtId != other.producDetailtId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProducimagePK[ producImageId=" + producImageId + ", producDetailtId=" + producDetailtId + " ]";
    }
    
}
