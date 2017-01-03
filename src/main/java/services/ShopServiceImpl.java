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
import repository.*;

@Transactional
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Override
    public void addShop(Shop shop) throws Exception {
        try {
            shopRepository.save(shop);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void removerShop(Integer id) throws Exception {
        try {
            shopRepository.delete(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public List<Shop> getAllShop() throws Exception {
        List<Shop> list = null;
        try {
            list = (List<Shop>) shopRepository.findAll();
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Shop getShopById(Integer id) throws Exception {
        Shop shop = null;
        try {
            shop = shopRepository.findOne(id);
            return shop;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void updateShop(Shop shop) throws Exception {
        try {
            shopRepository.save(shop);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Page<Shop> getAllShop(Pageable pageable) throws Exception {
        try {
            return shopRepository.findAll(pageable);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
