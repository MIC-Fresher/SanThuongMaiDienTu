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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "groupcategories")
@NamedQueries({
    @NamedQuery(name = "Groupcategories.findAll", query = "SELECT g FROM Groupcategories g")})
public class Groupcategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GroupCategoriesId")
    private Integer groupCategoriesId;
    @Column(name = "GroupCategoriesName")
    private String groupCategoriesName;
    @Column(name = "Description")
    private String description;
    
    @OneToMany(cascade =  CascadeType.MERGE ,mappedBy = "groupCategoriesId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Category> categoryList;

    public Groupcategories() {
    }

    public Groupcategories(Integer groupCategoriesId) {
        this.groupCategoriesId = groupCategoriesId;
    }

    public Integer getGroupCategoriesId() {
        return groupCategoriesId;
    }

    public void setGroupCategoriesId(Integer groupCategoriesId) {
        this.groupCategoriesId = groupCategoriesId;
    }

    public String getGroupCategoriesName() {
        return groupCategoriesName;
    }

    public void setGroupCategoriesName(String groupCategoriesName) {
        this.groupCategoriesName = groupCategoriesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupCategoriesId != null ? groupCategoriesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupcategories)) {
            return false;
        }
        Groupcategories other = (Groupcategories) object;
        if ((this.groupCategoriesId == null && other.groupCategoriesId != null) || (this.groupCategoriesId != null && !this.groupCategoriesId.equals(other.groupCategoriesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Groupcategories[ groupCategoriesId=" + groupCategoriesId + " ]";
    }
    
}
