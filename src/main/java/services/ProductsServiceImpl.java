/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import repository.*;
import utils.IMGUtils;

@Transactional
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    CategoriesService categoriesService;
    @Autowired
    ProductdetailRepository productdetailRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    IMGUtils iMGUtils;
    @Autowired
    ProducimageRepository ProducimageRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) throws Exception {

        try {
            return productsRepository.findAll(pageable);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public boolean addProduct(MultipartFile file, Product product, Shop shop) throws Exception {
        Producimage pi = new Producimage();
        Productdetail pd;

        try {

            pd = product.getProductdetail();

            product.setProductdetail(null);

            product.setCategoryId(categoriesService.getCategoriesById(product.getCategoryId().getCategoryId()));

            product.setDateCreated(new Date());

            product.setShopId(shop);
            
            product.setTotalVote(0);
            
            product.setIsDiscounted(0);

            product = productsRepository.save(product);

//            ---------------------------------------------------------------tao pd
            pd.setProductId(product);
            pd = productdetailRepository.save(pd);
//            -----------------------------------------------addimg vao p----        

            pi.setUrl(iMGUtils.uploadImg(file));
            pi.setProducDetailtId(pd);
            pi.setIsActive(1);

            ProducimageRepository.save(pi);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;

    }

    @Override
    public boolean updateProduct(MultipartFile file, Product product) throws Exception {
        Product p = new Product();
        Producimage pi = new Producimage();
        Productdetail pd = new Productdetail();
        Category c = new Category();
        Sizes sz = new Sizes();
        Color cl = new Color();

        try {
            p = productsRepository.findOne(product.getProductId());

            c = product.getCategoryId();
            sz = product.getProductdetail().getSizeId();
            cl = product.getProductdetail().getColorId();

            p.setProductName(product.getProductName());
            p.getProductdetail().setColorId(cl);
            p.getProductdetail().setSizeId(sz);
            p.setCategoryId(c);
            p.setUnitPrice(product.getUnitPrice());
            p.setDescription(product.getDescription());
            p.setIsActive(product.getIsActive());
            p.setQuantity(product.getQuantity());

            List<Producimage> lpi = p.getProductdetail().getProducimageList();
            if (file.isEmpty()) {
                p.getProductdetail().setProducimageList(product.getProductdetail().getProducimageList());
            } else {
                lpi.get(0).setUrl(iMGUtils.uploadImg(file));
                p.getProductdetail().setProducimageList(lpi);
            }

            productsRepository.save(p);
            return true;

        } catch (Exception e) {

            e.getMessage();

        }
        return false;
    }

    @Override
    public int deleteProductOfShop(int idproduct, int idshop) throws Exception {
        int kq = 0;
        try {
            productsRepository.delete(idproduct);

            //productsRepository.delete(idproduct);
            return kq;
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }

    @Override
    public Page<Product> getProducts(Pageable pageable, String shopName, Integer shopIsactive, Integer catagoryIsactive, Integer productIsactive, String productName, List<Integer> totalvote, Integer fromPrice, Integer toPrice,String cateName) throws Exception {

        try {
            return productsRepository.findByShopId_ShopNameContainingAndIsActiveAndShopId_UserId_EnabledAndCategoryId_IsActiveAndProductNameContainingAndTotalVoteInAndUnitPriceBetweenAndCategoryId_CategoryNameContaining(pageable, shopName, shopIsactive, catagoryIsactive, productIsactive, productName, totalvote, fromPrice, toPrice,cateName);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
