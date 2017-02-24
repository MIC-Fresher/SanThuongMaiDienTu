/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Products;

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
import utils.IMG.IMGUtils;

@Controller

public class SupplierProductLanding implements Serializable {

    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    utils.UtilsAuthencation utilsAuthencation;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

//    ====================================***HandMaping***=======================================================>>
//    ====================================***PRODUCT***=======================================================>>
    @RequestMapping(value = {"/Supplier/Products"}, method = RequestMethod.GET)
    public String Products(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            setupProducts(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Products";
    }

     @RequestMapping(value = {"/Supplier/searchProducts"}, method = RequestMethod.GET)
    public String searchProducts(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            
            searchProducts(searchinput, mm, page);
        } catch (Exception e) {
        }
        return "/Supplier/Products";
    }

    
//    =======================================***METHOD***=====================================================>>
    public void setupProducts(String search, ModelMap mm, int page) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3, Sort.Direction.DESC, "dateCreated");
            Page<Product> pager =  productsService.getAllProducts(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);
            mm.addAttribute("searchinput", search);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void searchProducts(String search, ModelMap mm, int page) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3, Sort.Direction.DESC, "dateCreated");
            Page<Product> pager = productsService.getAllProducts(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);
            mm.addAttribute("searchinput", search);

        } catch (Exception e) {
            e.getMessage();
        }
    }
//    ====================================***PRODUCT***=======================================================>>
//    =======================================***GET/SET***=====================================================>>   
}
