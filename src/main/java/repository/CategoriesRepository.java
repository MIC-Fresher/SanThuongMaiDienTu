/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.*;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Integer> {

    public List<Category> findBycategoryName(String categoryName) throws Exception;

    public Page<Category> findAll(Pageable pageable) throws Exception;

    public Page<Category> findBycategoryNameContaining(Pageable pageable, String CategoryName) throws Exception;

    @Procedure(name = "deleteCS")
    int deleteCS(@Param("idcate") Integer idcate, @Param("idshop") Integer idshop) throws Exception;

    @Procedure(name = "addCS")
    int addCS(@Param("idcate") Integer idcate, @Param("idshop") Integer idshop) throws Exception;

    public int countByShopList_ShopNameContainingAndIsActive(String shopName, Integer isActive) throws Exception;

    
}
