/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.*;
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
import utils.IMGUtils;

@Controller
@Scope("session")
public class ShopController implements Serializable {

    Productdetail pd;
    Producimage pi;
    Product p;
    Category c;
    Shop shopSession;

    @Autowired
    UserService userService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    ShopService shopService;
    @Autowired
    ShopRepository shopRepository;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = "/Shop/ShopIndex", method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {
            User userSpringAuthencation = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            entity.User user = userService.getUser(userSpringAuthencation.getUsername(), "").get(0);
            session.setAttribute("shop", user.getShop());
            shopSession = user.getShop();
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Shop/ShopIndex";
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
            Shop s = (Shop) session.getAttribute("shop");
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
            setupAddProduct(mm);
            searchProducts(searchinput, mm, page, shopSession);
        } catch (Exception e) {
        }
        return "/Shop/Products";
    }

    @RequestMapping(value = {"/Shop/addProduct"}, method = RequestMethod.POST)
    public String addProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @ModelAttribute(value = "product") Product product,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            addProduct(page, searchinput, file, product, mm);
            searchProducts(searchinput, mm, page, shopSession);
            setupAddProduct(mm);
        } catch (Exception e) {
        }
        return "/Shop/Products";
    }

    @RequestMapping(value = {"/Shop/updateProduct"}, method = RequestMethod.GET)
    public String updateProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {
        try {
            setupUpdateProduct(mm, id);
            searchProducts(searchinput, mm, page, shopSession);
        } catch (Exception e) {
        }
        return "/Shop/Products";
    }

    @RequestMapping(value = {"/Shop/updateProduct"}, method = RequestMethod.POST)
    public String updateProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @ModelAttribute(value = "product") Product product,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            updateProduct(page, searchinput, file, product, mm);
            searchProducts(searchinput, mm, page, shopSession);
            setupUpdateProduct(mm, product.getProductId());
        } catch (Exception e) {
        }
        return "/Shop/Products";
    }

    @RequestMapping(value = {"/Shop/deleteProduct"}, method = RequestMethod.GET)
    public String deleteProduct(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {

            deleteProductOfShop(id, mm);
            searchProducts(searchinput, mm, page, shopSession);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Shop/Products";
    }

    @RequestMapping(value = {"/test1"}, method = RequestMethod.GET)
    public String test1(
            HttpServletRequest request, HttpSession session, ModelMap mm
    ) {

        try {

            deleteProductOfShop(3, mm);

        } catch (Exception e) {
            e.getMessage();
        }

        return "/Shop/Products";
    }
//    =======================================***METHOD***=====================================================>>
//    ====================================***PRODUCT***=======================================================>>

    public void deleteProductOfShop(int idproduct, ModelMap mm) {
        try {
            productsRepository.delete(idproduct);
            //productsRepository.test(idproduct);
            mm.addAttribute("messeger", "xóa thành công");

        } catch (Exception e) {
            mm.addAttribute("messeger", "xóa thất bại");
            e.getMessage();
        }
    }

    public void addProduct(int page, String searchinput, MultipartFile file, Product product, ModelMap mm) {

        try {

            boolean kq = productsService.addProduct(file, product, shopSession);
            if (kq) {
                mm.addAttribute("messeger", "Thêm thành công");
            } else {
                mm.addAttribute("messeger", "Thêm thất bại");
            }

        } catch (Exception e) {
            mm.addAttribute("messeger", "Thêm thất bại");
            e.getMessage();
        }
    }

    public void updateProduct(int page, String searchinput, MultipartFile file, Product product, ModelMap mm) {

        try {
            boolean kq = productsService.updateProduct(file, product);
            if (kq) {
                mm.addAttribute("messeger", "Cập nhật thành công");
            } else {
                mm.addAttribute("messeger", "Cập nhật thất bại");
            }

        } catch (Exception e) {
            mm.addAttribute("messeger", "Cập nhật thất bại");
            e.getMessage();
        }
    }

    public void setupAddProduct(ModelMap mm) {
        mm.addAttribute("product", new Product());
        mm.addAttribute("type", "add");
        mm.addAttribute("listSizes", sizesRepository.findAll());
        mm.addAttribute("listColors", colorRepository.findAll());
        mm.addAttribute("listCategoriesOfShop", shopSession.getCategoryList());
    }

    public void setupUpdateProduct(ModelMap mm, int idproduct) {
        mm.addAttribute("product", productsRepository.findOne(idproduct));
        mm.addAttribute("type", "update");
        mm.addAttribute("listSizes", sizesRepository.findAll());
        mm.addAttribute("listColors", colorRepository.findAll());
        mm.addAttribute("listCategoriesOfShop", shopSession.getCategoryList());
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
    public Product getP() {
        return p;
    }

    public Productdetail getPd() {
        return pd;
    }

    public Producimage getPi() {
        return pi;
    }

    public Category getC() {
        return c;
    }

}
