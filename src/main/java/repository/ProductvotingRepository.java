/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Category;
import entity.Productvoting;
import org.springframework.data.repository.CrudRepository;


public interface ProductvotingRepository extends CrudRepository<Productvoting, Integer>{
    
}
