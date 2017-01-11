/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.*;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {

    public Page<Product> findAll(Pageable pageable) throws Exception;

    public Page<Product> findByShopId_ShopId(Pageable pageable, int shopId) throws Exception;

    public Page<Product>
            findByShopId_ShopIdOrIsActiveAndShopId_UserId_EnabledAndCategoryId_IsActiveAndProductNameContainingAndTotalVoteInAndUnitPriceBetweenAndCategoryId_CategoryNameContaining(Pageable pageable, Integer shopId, Integer shopIsactive, Integer catagoryIsactive, Integer productIsactive, String productName, List<Integer> totalvote, Integer fromPrice, Integer toPrice,String cateName) throws Exception;

    public Page<Product> findByShopId_ShopIdAndProductNameContaining(Pageable pageable, Integer shopId, String productName) throws Exception;

    

}
