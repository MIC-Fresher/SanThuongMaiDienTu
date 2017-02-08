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
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderdetailRepository extends CrudRepository<Orderdetail, Integer>{
    public Page<Orderdetail> findByOrderId_UserId_UserIdOrderByOrderId_OrderDateDesc(Pageable pageable,Integer userid) throws Exception;
}
