/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface ProductcommentRepository extends CrudRepository<Productcomment, Integer>{
      public Page<Productcomment> findByProductId_productIdAndStatusCommentId_Statuscommentid(Pageable pageable , Integer productId,Integer statuscommentid) throws Exception;
}
