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
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Integer> {

    public List<Category> findBycategoryName(String categoryName) throws Exception;

    public Page<Category> findAll(Pageable pageable);
}
