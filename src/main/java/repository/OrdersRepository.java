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

    public Page<Orders> findAll(Pageable pageable) throws Exception;

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
    public Page<Orders> findOrderByShopNameAndEmail(@Param("shopName") String shopName, @Param("email") String email, Pageable pageable) throws Exception;

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
            + " or s.shopName like %:shopName% ")
    public Page<Orders> findOrderByShopNameOrEmail(@Param("shopName") String shopName, @Param("email") String email, Pageable pageable) throws Exception;

// tìm đơn hàng theo status và shop name
    @Query(
            " select Distinct o from "
            + " Orders o "
            + " JOIN  Orderdetail od "
            + " on o.orderId = od.orderId.orderId "
            + " JOIN Product p "
            + " on od.productId.productId = p.productId "
            + " JOIN Shop s "
            + " on s.shopId=p.shopId.shopId "
            + " where "
            + " s.shopName like %:shopName% "
            + " and o.statusOrderId.statusOrderId = :statusOrder ")
    public Page<Orders> findOrderByShopNameAndStatus(@Param("shopName") String shopName, @Param("statusOrder") Integer statusOrder, Pageable pageable) throws Exception;

//tìm  số lượng hàng theo status tương ứng với đơn hàng
    @Query(value = ""
            + " select o.orderId , sum(od.quantity)as total_quantity "
            + " from Orders o join o.orderdetailList od  "
            //            + " on o.orderId = od.orderId.orderId "
            + " where o.statusOrderId.statusOrderId = :statusorder "
            + " group by o.orderId  "
            + " order by total_quantity desc ")
    public List<Object[]> findAllOrderdetailByQuanlity(Integer statusOrder) throws Exception;

    //tìm các đơn hàng theo trạng thái đơn hàng và theo ngày
    public List<Orders> findByStatusOrderId_StatusOrderIdAndUpdateDateBetween(Integer statusOrder, @Temporal(TemporalType.DATE) Date fromDate, @Temporal(TemporalType.DATE) Date toDate) throws Exception;

    //tìm các đơn hàng theo trang thái ngày tên cửa hàng
    @Query(
            " select Distinct o "
            + "from "
            + " Orders o "
            + " JOIN  Orderdetail od "
            + " on o.orderId = od.orderId.orderId "
            + " JOIN Product p "
            + " on od.productId.productId = p.productId "
            + " JOIN Shop s "
            + " on s.shopId=p.shopId.shopId "
            + " where "
            + "  s.shopName like %:shopName% "
            + " and o.statusOrderId.statusOrderId = :statusOrder "
            + " and o.updateDate BETWEEN :startDate AND :endDate     ")
    public List<Orders> findOrderByDateAndShop(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("statusOrder") Integer statusOrder,
            @Param("shopName") String shopName);

}
