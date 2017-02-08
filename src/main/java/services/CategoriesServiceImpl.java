/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoriesRepository;
import repository.UserRepository;

@Transactional
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Transactional
    @Override
    public void addCategories(Category category) throws Exception {
        try {
            categoriesRepository.save(category);
        } catch (Exception e) {
        }
    }

    @Transactional
    @Override
    public void removerCategories(Integer id) throws Exception {
        try {
            categoriesRepository.delete(id);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Category> getAllCategories() throws Exception {
        List<Category> list = null;
        try {
            list = (List<Category>) categoriesRepository.findAll();
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Category getCategoriesById(Integer id) throws Exception {
        Category category = null;
        try {
            category = categoriesRepository.findOne(id);
            return category;
        } catch (Exception e) {
            e.getMessage();
        }
        return category;
    }

    @Transactional
    @Override
    public void updateCategories(Category Category) throws Exception {
        try {
            categoriesRepository.save(Category);
        } catch (Exception e) {
        }
    }

    @Override
    public Page<Category> getAllCategories(Pageable pageable) throws Exception {

        try {
            return categoriesRepository.findAll(pageable);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Page<Category> getCategoriesByInput(Pageable pageable, String input) throws Exception {
        try {
            return categoriesRepository.findBycategoryNameContaining(pageable, input);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Transactional
    @Override
    public int addCategoryToShop(int idcate, int idshop) throws Exception {
        return categoriesRepository.addCS(idcate, idshop);
    }

    @Transactional
    @Override
    public int deleteCategoryFromShop(int idcate, int idshop) throws Exception {
        return categoriesRepository.deleteCS(idcate, idshop);
    }

}
