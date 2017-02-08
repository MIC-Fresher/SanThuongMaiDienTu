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
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    public Page<Orders>
            findDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndUserId_EmailContaining(Pageable pageable, String ShopName, String Email) throws Exception;

    public Page<Orders>
            findDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndUserId_EmailContainingAndOrderDateBetween(Pageable pageable, String ShopName, String Email, @Temporal(TemporalType.DATE) Date fromDate, @Temporal(TemporalType.DATE) Date toDate) throws Exception;

    

    public List<Orders> findDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndOrderDateBetween(String shopName, @Temporal(TemporalType.DATE) Date fromDate, @Temporal(TemporalType.DATE) Date toDate);

    @Query(
            " select Distinct o from "
            + " Orders o "
            + " JOIN  Orderdetail od "
            + " on o.orderId = od.orderId.orderId "
            + " JOIN Product p "
            + " on od.productId.productId = p.productId "
            + " JOIN Shop s "
            + " on s.shopId=p.shopId.shopId "
            + " JOIN User u "
            + " on u.userId=o.userId.userId "
            + " where "
            + " u.email like %:email% "
            + " and s.shopName = :shopName ")
    public Page<Orders> findOrderByShopNameAndEmail(@Param("shopName") String shopName, @Param("email") String email, Pageable pageable);
}
