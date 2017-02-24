/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Shop.Products;

import model.Pages;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.*;
import entity.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;
import repository.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.IMG.IMGUtils;

@Controller

public class ProductController implements Serializable {

   
   
    @Autowired
    utils.UtilsAuthencation utilsAuthencation;
   

    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    SizesRepository sizesRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

//    ====================================***HandMaping***=======================================================>>
//    ====================================***PRODUCT***=======================================================>>
    @RequestMapping(value = {"/Shop/searchProducts"}, method = RequestMethod.GET)
    public String searchProducts(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            searchProducts(searchinput, mm, page, s);
        } catch (Exception e) {
        }
        return "/Shop/Products";
    }

    @RequestMapping(value = {"/Shop/addProduct"}, method = RequestMethod.GET)
    public String addProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {
        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            setupAddProduct(mm);
            searchProducts(searchinput, mm, page, s);
        } catch (Exception e) {
        }
        return "/Shop/Products_Add";
    }

    @RequestMapping(value = {"/Shop/addProduct"}, method = RequestMethod.POST)
    public String addProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @ModelAttribute(value = "product") Product product,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttrs
    ) {
        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            addProduct(page, searchinput, file, product, redirectAttrs);
            searchProducts(searchinput, mm, page, s);
            setupAddProduct(mm);
        } catch (Exception e) {
        }
        return "redirect:/Shop/searchProducts";
    }

    @RequestMapping(value = {"/Shop/updateProduct"}, method = RequestMethod.GET)
    public String updateProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {
        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            setupUpdateProduct(mm, id);
            searchProducts(searchinput, mm, page, s);
        } catch (Exception e) {
        }
        return "/Shop/Products_Update";
    }

    @RequestMapping(value = {"/Shop/updateProduct"}, method = RequestMethod.POST)
    public String updateProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            RedirectAttributes redirectAttrs,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @ModelAttribute(value = "product") Product product,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            updateProduct(page, searchinput, file, product, redirectAttrs);
            searchProducts(searchinput, mm, page, s);
            setupUpdateProduct(mm, product.getProductId());
        } catch (Exception e) {
        }
        return "redirect:/Shop/searchProducts";
    }

    @RequestMapping(value = {"/Shop/deleteProduct"}, method = RequestMethod.GET)
    public String deleteProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm, RedirectAttributes redirectAttrs,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            deleteProductOfShop(id, redirectAttrs);
            searchProducts(searchinput, mm, page, s);
        } catch (Exception e) {
            e.getMessage();
        }

        return "redirect:/Shop/searchProducts";
    }

//    =======================================***METHOD***=====================================================>>
//    ====================================***PRODUCT***=======================================================>>
    public void deleteProductOfShop(int idproduct, RedirectAttributes redirectAttrs) {
        try {
            productsRepository.delete(idproduct);
            //productsRepository.test(idproduct);
            redirectAttrs.addFlashAttribute("messeger", "xóa thành công");

        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("messeger", "xóa thất bại");
            e.getMessage();
        }
    }

    public void addProduct(int page, String searchinput, MultipartFile file, Product product,RedirectAttributes redirectAttrs) {

        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            boolean kq = productsService.addProduct(file, product, s);
            if (kq) {
                redirectAttrs.addFlashAttribute("messeger", "Thêm thành công");
            } else {
                redirectAttrs.addFlashAttribute("messeger", "Thêm thất bại");
            }

        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("messeger", "Thêm thất bại");
            e.getMessage();
        }
    }

    public void updateProduct(int page, String searchinput, MultipartFile file, Product product, RedirectAttributes redirectAttrs) {

        try {
            boolean kq = productsService.updateProduct(file, product);
            if (kq) {
                redirectAttrs.addAttribute("messeger", "Cập nhật thành công");
            } else {
                redirectAttrs.addAttribute("messeger", "Cập nhật thất bại");
            }

        } catch (Exception e) {
            redirectAttrs.addAttribute("messeger", "Cập nhật thất bại");
            e.getMessage();
        }
    }

    public void setupAddProduct(ModelMap mm) {
        entity.User user = utilsAuthencation.getUserInPrincipal();
        Shop s = user.getShop();
        mm.addAttribute("product", new Product());
        mm.addAttribute("type", "add");
        mm.addAttribute("listSizes", sizesRepository.findAll());
        mm.addAttribute("listColors", colorRepository.findAll());
        mm.addAttribute("listCategoriesOfShop", s.getCategoryList());
    }

    public void setupUpdateProduct(ModelMap mm, int idproduct) {
        entity.User user = utilsAuthencation.getUserInPrincipal();
        Shop s = user.getShop();
        mm.addAttribute("product", productsRepository.findOne(idproduct));
        mm.addAttribute("type", "update");
        mm.addAttribute("listSizes", sizesRepository.findAll());
        mm.addAttribute("listColors", colorRepository.findAll());
        mm.addAttribute("listCategoriesOfShop", s.getCategoryList());
    }

    public void searchProducts(String search, ModelMap mm, int page, Shop shop) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3, Sort.Direction.DESC, "dateCreated");
            Page<Product> pager = productsRepository.findByShopId_ShopIdAndProductNameContaining(pageRequest, shop.getShopId(), search);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);
            mm.addAttribute("searchinput", search);

        } catch (Exception e) {
            e.getMessage();
        }
    }

//    =======================================***GET/SET***=====================================================>>   
 

}
