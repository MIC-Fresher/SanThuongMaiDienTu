/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "PassWord")
    private String passWord;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address")
    private String address;
    @Column(name = "Genders")
    private String genders;
    @Column(name = "Phone")
    private String phone;
    @Lob
    @Column(name = "IdFacebook")
    private String idFacebook;
    @Lob
    @Column(name = "NameFacebook")
    private String nameFacebook;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "enabled")
    private Integer enabled;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Shop> shopList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Feedback> feedbackList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Productcomment> productcommentList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Productvoting> productvotingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<RoleUser> roleUserList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Orders> ordersList;
    @JoinColumn(name = "SupplierId", referencedColumnName = "SupplierId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplierId;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String getNameFacebook() {
        return nameFacebook;
    }

    public void setNameFacebook(String nameFacebook) {
        this.nameFacebook = nameFacebook;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public List<Productcomment> getProductcommentList() {
        return productcommentList;
    }

    public void setProductcommentList(List<Productcomment> productcommentList) {
        this.productcommentList = productcommentList;
    }

    public List<Productvoting> getProductvotingList() {
        return productvotingList;
    }

    public void setProductvotingList(List<Productvoting> productvotingList) {
        this.productvotingList = productvotingList;
    }

    public List<RoleUser> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(List<RoleUser> roleUserList) {
        this.roleUserList = roleUserList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ userId=" + userId + " ]";
    }
    
}
