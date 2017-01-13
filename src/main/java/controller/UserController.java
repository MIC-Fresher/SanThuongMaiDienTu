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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;
import repository.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import utils.IMGUtils;

@Controller
@Scope("session")
public class UserController implements Serializable {

    Productdetail pd;
    Producimage pi;
    Product p;
    Category c;
    entity.User u;
    Shop shopSession;
    Groupcategories gc;
    @Autowired
    GroupcategoriesRepository groupcategoriesRepository;
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

    @RequestMapping(value = "/User/index", method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {
            org.springframework.security.core.userdetails.User userSpringAuthencation = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            entity.User user = userService.getUser(userSpringAuthencation.getUsername(), "").get(0);
            session.setAttribute("user", user);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/Public/searchProducts";
    }
//    ====================================***HandMaping***=======================================================>>
//    ====================================***ACCOUNT***=======================================================>>

    @RequestMapping(value = "Public/setupSignUp", method = RequestMethod.GET)
    public String setupSignUp(
            ModelMap mm, HttpServletRequest request, HttpSession session) throws Exception {

        mm.addAttribute("UserRG", new User());

        return "Public/signup";
    }

    @RequestMapping(value = "Public/signUp", method = RequestMethod.POST)
    public String signUp(
            HttpSession session, @ModelAttribute(value = "UserRG") User UserRG,
            HttpServletRequest request, ModelMap mm) throws Exception {

        if (signUp(UserRG, mm)) {
            return "/Public/index";
        } else {
            return "Public/signup";
        }

    }
//    ====================================***PRODUCT***=======================================================>>

    @RequestMapping(value = {"/Public/searchProducts"}, method = RequestMethod.GET)
    public String searchProducts(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "categoryname", defaultValue = "", required = false) String categoryname,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "12", required = false) Integer itemperpage,
            @RequestParam(value = "shopname", defaultValue = "", required = false) String shopname,
            @RequestParam(value = "fromprice", defaultValue = "", required = false) Integer fromprice,
            @RequestParam(value = "toprice", defaultValue = "", required = false) Integer toprice,
            @RequestParam(value = "totalvote", defaultValue = "", required = false) Integer totalvote
    ) {
        try {

            searchProducts(searchinput, mm, page, shopname, fromprice, toprice, totalvote, itemperpage, categoryname);
        } catch (Exception e) {
        }
        return "/Public/index";
    }

    @RequestMapping(value = {"/Public/searchAllProducts"}, method = RequestMethod.GET)
    public String searchAllProducts(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "12", required = false) Integer itemperpage
    ) {
        try {

            searchAllProducts(searchinput, mm, page, itemperpage);
            setupCategoriesBar(mm);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Public/index";
    }

    @RequestMapping(value = {"/Public/showProductOfShop"}, method = RequestMethod.GET)
    public String showProductOfShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "categoryname", defaultValue = "", required = false) String categoryname,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "12", required = false) Integer itemperpage,
            @RequestParam(value = "shopname", defaultValue = "", required = false) String shopname,
            @RequestParam(value = "fromprice", defaultValue = "", required = false) Integer fromprice,
            @RequestParam(value = "toprice", defaultValue = "", required = false) Integer toprice,
            @RequestParam(value = "totalvote", defaultValue = "", required = false) Integer totalvote
    ) {
        try {

            searchProducts("", mm, page, shopname, fromprice, toprice, totalvote, itemperpage, categoryname);

            showProductOfShop(shopname, mm);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Public/ProductOfShop";
    }

    @RequestMapping(value = {"/Public/setupShowDetailProduct"}, method = RequestMethod.GET)
    public String setupShowDetailProduct(
            @RequestParam(value = "id", required = true) Integer id,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowDetailProduct(id, mm);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Public/ProductDetail";
    }
//    =======================================***METHOD***=====================================================>>

//    =======================================***PRODUCT***=====================================================>>
    public void searchAllProducts(String searchinput, ModelMap mm, Integer page, Integer itemperpage) {
        ParameterUrlPulic parameterUrl = new ParameterUrlPulic(mm);
        PageRequest pageRequest;
        try {

            pageRequest = new PageRequest(page - 1, itemperpage, Sort.Direction.DESC, "DateCreated");
            Page<Product> pager = productsRepository.findByProductNameContainingAndIsActiveAndShopId_UserId_EnabledAndCategoryId_IsActive(pageRequest, searchinput, 1, 1, 1);
            Pages pages = new Pages(pager);

            parameterUrl.setSearchinput(searchinput);
            parameterUrl.setItemperpage(itemperpage);
            mm.addAttribute("parameterUrl", parameterUrl.toString());
            mm.addAttribute("typesearch", "all");
            mm.addAttribute("listSearchProducts", pages);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void showProductOfShop(String shopName, ModelMap mm) {

        try {
            mm.addAttribute("listGroupcategories", groupcategoriesRepository.findDistinctByCategoryList_ShopList_ShopName(shopName));
            mm.addAttribute("typecategorybar", "shop");
        } catch (Exception e) {
        }
    }

    public void setupShowDetailProduct(int id, ModelMap mm) {
        Product p = null;
        List<Shop> ls = new ArrayList<>();
        try {
            p = productsRepository.findOne(id);

            ls = shopRepository.findDistinctByUserId_EnabledAndCategoryList_IsActiveAndProductList_IsActiveAndProductList_ProductNameContaining(1, 1, 1, p.getProductName());

            mm.addAttribute("listShopSellProduct", ls);
            mm.addAttribute("product", p);
            setupCategoriesBar(mm);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void searchProducts(String search,
            ModelMap mm, int page, String shopname,
            Integer fromprice, Integer toprice,
            Integer totalvote, Integer itemperpage, String cateName) {

        String[] temp;
        ParameterUrlPulic parameterUrl = new ParameterUrlPulic(mm);
        List<Integer> listtt = new ArrayList<>();
        if (!cateName.equals("")) {
            temp = cateName.split(",", 2);
            cateName = temp[0];
        }

        if (!shopname.equals("")) {
            temp = shopname.split(",", 2);
            shopname = temp[0];
        }

        if (!search.equals("")) {
            temp = search.split(",", 2);
            search = temp[0];
        }

        if (fromprice == null && toprice == null) {
            fromprice = 0;
            toprice = 10000000;
        } else {

            parameterUrl.setFromprice(fromprice);
            parameterUrl.setToprice(toprice);
        }

        if (totalvote == null) {

            for (int i = 0; i < 6; i++) {
                listtt.add(i);
            }
        } else {
            listtt.add(totalvote);

            parameterUrl.setTotalvote(totalvote);
        }
        try {
            PageRequest pageRequest;

            pageRequest = new PageRequest(page - 1, itemperpage, Sort.Direction.DESC, "DateCreated");
            Page<Product> pager = productsService.getProducts(pageRequest, shopname, 1, 1, 1, search, listtt, fromprice, toprice, cateName);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);

            parameterUrl.setSearchinput(search);

            parameterUrl.setShopname(shopname);

            parameterUrl.setItemperpage(itemperpage);

            parameterUrl.setCategoryname(cateName);

            setupCategoriesBar(mm);
            mm.addAttribute("parameterUrl", parameterUrl.toString());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setupCategoriesBar(ModelMap mm) {

        try {
            mm.addAttribute("listShops", shopRepository.findByUserId_Enabled(1));
            mm.addAttribute("listGroupcategories", groupcategoriesRepository.findAll());
        } catch (Exception e) {
        }

    }

//    ====================================***ACCOUNT***=======================================================>>
    public boolean signUp(User user, ModelMap mm) {
        try {
            if (!userService.checkAccountExist(user.getUserName(), user.getEmail())) {
                user.setEnabled(1);
                user.setDateCreated(new Date());
                user = userService.add(user);
                userService.addRoleToUser(2, user.getUserId());

                mm.addAttribute("messeger", "bạn đã tạo tài khoản thành công");
                return true;
            }
        } catch (Exception e) {
            mm.addAttribute("messeger", "có lỗi trong quá trình tạo tài khoản vui lòng tạo lại");
        }
        mm.addAttribute("UserRG", new User());
        mm.addAttribute("messeger", "có lỗi trong quá trình tạo tài khoản vui lòng tạo lại");
        return false;
    }
//    =======================================***get/set***=====================================================>>

    public Productdetail getPd() {
        return pd;
    }

    public Producimage getPi() {
        return pi;
    }

    public Product getP() {
        return p;
    }

    public Category getC() {
        return c;
    }

    public Groupcategories getGc() {
        return gc;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

}
