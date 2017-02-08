/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Guest;

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

import java.text.SimpleDateFormat;
import java.util.*;

import model.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestParam;

import repository.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;



@Controller
@Scope("session")
public class LandingController implements Serializable {

    @Autowired
    GroupcategoriesRepository groupcategoriesRepository;
   
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;
   

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

//    ====================================***HandMaping***=======================================================>>
//    ====================================***PRODUCT***=======================================================>>
    @RequestMapping(value = "/setupIndex", method = RequestMethod.GET)
    public String setupIndex(ModelMap mm, HttpServletRequest request) throws Exception {
        return "redirect:/Public/searchAllProducts";
    }

    @RequestMapping(value = {"/Public/searchAllProducts", "/Public/"}, method = RequestMethod.GET)
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
            mm.addAttribute("parameterUrl", parameterUrl);

            mm.addAttribute("listSearchProducts", pages);
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
//    =======================================***get/set***=====================================================>>
}
