/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShopService {

    public Shop addShop(Shop shop) throws Exception;

    public void removerShop(Integer id) throws Exception;

    public List<Shop> getAllShop() throws Exception;

    public Page<Shop> getAllShop(Pageable pageable)throws Exception;

    public Shop getShopById(Integer id) throws Exception;

    public void updateShop(Shop shop) throws Exception;

    public Page<Shop> getShopByInput(
            Pageable pageable,String ShopName , String ShopPhone 
            ,String  UserName ,String UserPhone ,String UserEmail)throws Exception; 
}
