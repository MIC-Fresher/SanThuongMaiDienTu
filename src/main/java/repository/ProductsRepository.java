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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {

    public Page<Product> findAll(Pageable pageable) throws Exception;

    public Page<Product>
            findByShopId_ShopNameContainingAndIsActiveAndShopId_UserId_EnabledAndCategoryId_IsActiveAndProductNameContainingAndTotalVoteInAndUnitPriceBetweenAndCategoryId_CategoryNameContaining(Pageable pageable, String shopName, Integer shopIsactive, Integer catagoryIsactive, Integer productIsactive, String productName, List<Integer> totalvote, Integer fromPrice, Integer toPrice, String cateName) throws Exception;

    public Page<Product> findByShopId_ShopIdAndProductNameContaining(Pageable pageable, Integer shopId, String productName) throws Exception;

    public Page<Product> findByProductNameContainingAndIsActiveAndShopId_UserId_EnabledAndCategoryId_IsActive(Pageable pageable, String productName, Integer productActive, Integer shopActive, Integer catagoryActive) throws Exception;

   

    public List<Product> findByShopId_ShopNameContainingAndIsActiveAndStockGreaterThanAndDateCreatedBetween(String shopName, Integer isActive, Integer stock,@Temporal(TemporalType.DATE) Date fromDate,@Temporal(TemporalType.DATE) Date toDate) throws Exception;

    public List<Product> findByShopId_ShopNameContainingAndIsActiveAndStockEqualsAndDateCreatedBetween(String shopName, Integer isActive, Integer stock,@Temporal(TemporalType.DATE) Date fromDate,@Temporal(TemporalType.DATE) Date toDate) throws Exception;

}
