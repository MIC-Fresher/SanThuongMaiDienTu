/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Category;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;


public interface CategoriesService {

    public void addCategories(Category category) throws Exception;

    public void removerCategories(Integer id) throws Exception;

    public  List<Category> getAllCategories() throws Exception;
    
    public  Page<Category> getAllCategories(Pageable pageable) throws Exception;

    Category getCategoriesById(Integer id) throws Exception;

    public void updateCategories(Category Category) throws Exception;
}
