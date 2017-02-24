/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;


import entity.Statuscomment;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface StatuscommentRepository extends CrudRepository<Statuscomment, Integer>{
    
}
