/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "receiver")
@NamedQueries({
    @NamedQuery(name = "Receiver.findAll", query = "SELECT r FROM Receiver r")})
public class Receiver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReceiverId")
    private Integer receiverId;
    @Column(name = "ReceiverName")
    private String receiverName;
    @Column(name = "ReceiverAddress")
    private String receiverAddress;
    @Column(name = "ReceiverPhone")
    private String receiverPhone;
    @OneToMany(mappedBy = "receiverId", fetch = FetchType.EAGER)
    private List<Orders> ordersList;

    public Receiver() {
    }

    public Receiver(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiverId != null ? receiverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receiver)) {
            return false;
        }
        Receiver other = (Receiver) object;
        if ((this.receiverId == null && other.receiverId != null) || (this.receiverId != null && !this.receiverId.equals(other.receiverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Receiver[ receiverId=" + receiverId + " ]";
    }
    
}
