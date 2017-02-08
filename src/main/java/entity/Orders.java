/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderId")
    private Integer orderId;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "TotalPrice")
    private Double totalPrice;
    
    @JoinColumn(name = "ReceiverId", referencedColumnName = "ReceiverId")
    @ManyToOne
    private Receiver receiverId;
    
    @JoinColumn(name = "StatusOrderId", referencedColumnName = "StatusOrderId")
    @ManyToOne
    private Statusorder statusOrderId;
    
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private User userId;
    
    @OneToMany(cascade =  CascadeType.MERGE   ,mappedBy = "orderId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Orderdetail> orderdetailList;

    public Orders() {
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Receiver getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Receiver receiverId) {
        this.receiverId = receiverId;
    }

    public Statusorder getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(Statusorder statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ orderId=" + orderId + " ]";
    }

}
