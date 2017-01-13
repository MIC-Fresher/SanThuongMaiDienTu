/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ProductsService {

    public Page<Product> getAllProducts(Pageable pageable) throws Exception;

    public boolean addProduct(MultipartFile file, Product product, Shop shop) throws Exception;

    public boolean updateProduct(MultipartFile file, Product product) throws Exception;

    public int deleteProductOfShop(int idproduct, int idshop) throws Exception;

    public Page<Product> getProducts(
            Pageable pageable, String shopName,
            Integer shopIsactive, Integer catagoryIsactive,
            Integer productIsactive, String productName, List<Integer> totalvote,
            Integer fromPrice, Integer toPrice,String cateName) throws Exception;

}
