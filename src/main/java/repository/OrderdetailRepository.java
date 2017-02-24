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
public interface OrderdetailRepository extends CrudRepository<Orderdetail, Integer> {

    public Page<Orderdetail> findByOrderId_UserId_UserIdOrderByOrderId_OrderDateDesc(Pageable pageable, Integer userid) throws Exception;

    @Query(value = ""
            + " select sum(od.quantity)as total_quantity "
            + " from Orders o join o.orderdetailList od  "
            + " where "
            + "o.statusOrderId.statusOrderId = :statusOrder "
            + " and o.updateDate BETWEEN :startDate AND :endDate     "
    )
    public Object sumAllQuantityByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("statusOrder") Integer statusOrder) throws Exception;

    //tìm tổng số sản phẩm theo trạng thái đơn hàng và theo ngày
    @Query(
            " select Distinct sum(od.quantity)as total_quantity from "
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
    public Object sumAllQuantityByDateAndShop(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("statusOrder") Integer statusOrder,
            @Param("shopName") String shopName);

}
