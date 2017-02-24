/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoriesRepository;
import repository.*;
import utils.UtilsAuthencation;

@Transactional
@Service
public class ShopServiceImpl implements ShopService,Serializable {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UtilsAuthencation utilsAuthencation;
    @Autowired
    UserService userService;

    @Transactional
    @Override
    public Shop addShop(Shop shop) throws Exception {

        try {
            User user = shop.getUserId();
            user.setDateCreated(new Date());
            user.setSupplierId(supplierRepository.findByUserName(utilsAuthencation.getPrincipal().getUsername()));
            user.setEnabled(1);
            user = userRepository.save(user);
            userService.addRoleToUser(1, user.getUserId());
            shop.setUserId(user);

            shop.setDateCreated(new Date());
            shop = shopRepository.save(shop);
            return shop;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Transactional
    @Override
    public void removerShop(Integer id) throws Exception {
        try {
            shopRepository.delete(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Transactional
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

    @Transactional
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

    @Override
    public Page<Shop> getShopByInput(Pageable pageable, String ShopName, String ShopPhone, String UserName, String UserPhone, String UserEmail) throws Exception {

        try {
            return shopRepository.findByShopNameContainingOrShopPhoneContainingOrUserId_UserNameContainingOrUserId_PhoneContainingOrUserId_EmailContaining(pageable, ShopName, ShopPhone, UserName, UserPhone, UserEmail);
        } catch (Exception e) {
        }
        return null;
    }

}
