/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
    
}
