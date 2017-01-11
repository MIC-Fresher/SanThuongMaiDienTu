/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "productvoting")
@NamedQueries({
    @NamedQuery(name = "Productvoting.findAll", query = "SELECT p FROM Productvoting p")})
public class Productvoting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductVotingId")
    private Integer productVotingId;
    @Column(name = "Mark")
    private Integer mark;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private User userId;

    public Productvoting() {
    }

    public Productvoting(Integer productVotingId) {
        this.productVotingId = productVotingId;
    }

    public Integer getProductVotingId() {
        return productVotingId;
    }

    public void setProductVotingId(Integer productVotingId) {
        this.productVotingId = productVotingId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productVotingId != null ? productVotingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productvoting)) {
            return false;
        }
        Productvoting other = (Productvoting) object;
        if ((this.productVotingId == null && other.productVotingId != null) || (this.productVotingId != null && !this.productVotingId.equals(other.productVotingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productvoting[ productVotingId=" + productVotingId + " ]";
    }
    
}
