/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.*;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {

    public Page<Shop> findAll(Pageable pageable);

    @Procedure(name = "deletePS")
    int deletePS(@Param("idproduct") Integer idproduct, @Param("idshop") Integer idshop) throws Exception;

    @Procedure(name = "addPS")
    int addPS(@Param("idproduct") Integer idproduct, @Param("idshop") Integer idshop) throws Exception;

    public Page<Shop> findByShopNameContainingOrShopPhoneContainingOrUserId_UserNameContainingOrUserId_PhoneContainingOrUserId_EmailContaining(
            Pageable pageable, String ShopName, String ShopPhone, String UserName, String UserPhone, String UserEmail);

    public List<Shop>
            findDistinctByUserId_EnabledAndCategoryList_IsActiveAndProductList_IsActiveAndProductList_ProductNameContaining(
                    Integer shopActive, Integer categoryActive, Integer productActive, String productName) throws Exception;

    List<Shop> findByUserId_Enabled(Integer shopActive) throws Exception;
}
