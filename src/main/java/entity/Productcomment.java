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
import javax.persistence.Lob;
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
@Table(name = "productcomment")
@NamedQueries({
    @NamedQuery(name = "Productcomment.findAll", query = "SELECT p FROM Productcomment p")})
public class Productcomment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductCommentId")
    private Integer productCommentId;
    @Lob
    @Column(name = "Content")
    private String content;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("productcommentList")
    @ManyToOne
    private User userId;
    
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("productcommentList")
    @ManyToOne
    private Product productId;

    @JoinColumn(name = "StatusCommentId", referencedColumnName = "statuscommentid")
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("productcommentList")
    @ManyToOne
    private Statuscomment statusCommentId;
    
    
    public Productcomment() {
    }

    public Productcomment(Integer productCommentId) {
        this.productCommentId = productCommentId;
    }

    public Integer getProductCommentId() {
        return productCommentId;
    }

    public void setProductCommentId(Integer productCommentId) {
        this.productCommentId = productCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Statuscomment getStatusCommentId() {
        return statusCommentId;
    }

    public void setStatusCommentId(Statuscomment statusCommentId) {
        this.statusCommentId = statusCommentId;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCommentId != null ? productCommentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcomment)) {
            return false;
        }
        Productcomment other = (Productcomment) object;
        if ((this.productCommentId == null && other.productCommentId != null) || (this.productCommentId != null && !this.productCommentId.equals(other.productCommentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productcomment[ productCommentId=" + productCommentId + " ]";
    }
    
}
