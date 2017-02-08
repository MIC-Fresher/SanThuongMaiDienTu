/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "category")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "deleteCS",
            procedureName = "deleteCS",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "KQ", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idcate", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idshop", type = Integer.class)
            }),
    @NamedStoredProcedureQuery(
            name = "addCS",
            procedureName = "addCS",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "KQ", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idcate", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "idshop", type = Integer.class)
            })
})
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CategoryId")
    private Integer categoryId;
    @Column(name = "CategoryName")
    private String categoryName;
    @Column(name = "isActive")
    private Integer isActive;

    @JoinTable(name = "shop_category", joinColumns = {
        @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")}, inverseJoinColumns = {
        @JoinColumn(name = "ShopId", referencedColumnName = "ShopId")})
    @ManyToMany
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("categoryList")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Shop> shopList;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "categoryId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("categoryId")
    private List<Product> productList;

    @JoinColumn(name = "GroupCategoriesId", referencedColumnName = "GroupCategoriesId")
    @ManyToOne
    private Groupcategories groupCategoriesId;

    public Category() {
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ categoryId=" + categoryId + " ]";
    }

}
