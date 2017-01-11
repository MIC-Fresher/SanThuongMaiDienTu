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

    @RequestMapping(value = "/User/userpage", method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "/User/userpage";
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
            return "Public/aftersignup";
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
            @RequestParam(value = "idshop", defaultValue = "", required = false) Integer idshop,
            @RequestParam(value = "fromprice", defaultValue = "", required = false) Integer fromprice,
            @RequestParam(value = "toprice", defaultValue = "", required = false) Integer toprice,
            @RequestParam(value = "totalvote", defaultValue = "", required = false) Integer totalvote
    ) {
        try {
            Shop s = (Shop) session.getAttribute("shop");
            searchProducts(searchinput, mm, page, idshop, fromprice, toprice, totalvote, itemperpage,categoryname);
        } catch (Exception e) {
        }
        return "/Public/index";
    }
//    =======================================***METHOD***=====================================================>>

//    =======================================***PRODUCT***=====================================================>>    
    public void searchProducts(String search, ModelMap mm, int page, Integer idshop, Integer fromprice, Integer toprice, Integer totalvote, Integer itemperpage,String cateName) {

        List<Integer> listtt = new ArrayList<>();
        if (idshop == null) {
            idshop = 100000000;
        } else {
            mm.addAttribute("idshop", idshop);
        }

        if (fromprice == null && toprice == null) {
            fromprice = 0;
            toprice = 10000000;
        } else {
            mm.addAttribute("fromprice", fromprice);
            mm.addAttribute("toprice", toprice);
        }

        if (totalvote == null) {

            for (int i = 0; i < 6; i++) {
                listtt.add(i);
            }
        } else {
            listtt.add(totalvote);
            mm.addAttribute("totalvote", totalvote);
        }
        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, itemperpage, Sort.Direction.DESC, "DateCreated");
            Page<Product> pager = productsService.getProducts(pageRequest, idshop, 1, 1, 1, search, listtt, fromprice, toprice,cateName);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);
            mm.addAttribute("searchinput", search);
            mm.addAttribute("itemperpage", itemperpage);
            mm.addAttribute("listGroupcategories", groupcategoriesRepository.findAll());

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean signUp(User user, ModelMap mm) {
        try {
            if (!userService.checkAccountExist(user.getUserName(), user.getEmail())) {
                user.setEnabled(1);
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

}
