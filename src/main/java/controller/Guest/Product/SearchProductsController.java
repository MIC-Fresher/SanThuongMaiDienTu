/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Guest.Product;

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
public class SearchProductsController implements Serializable {

    @Autowired
    GroupcategoriesRepository groupcategoriesRepository;
    
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductsService productsService;
    
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

//    ====================================***HandMaping***=======================================================>>
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
            setupCategoriesBar(mm);
        } catch (Exception e) {
        }
        return "/Public/Search";
    }

//    =======================================***METHOD***=====================================================>>
//    =======================================***PRODUCT***=====================================================>>
    public void searchProducts(String search,
            ModelMap mm, int page, String shopname,
            Integer fromprice, Integer toprice,
            Integer totalvote, Integer itemperpage, String cateName) {

        String[] temp;
        ParameterUrlPulic parameterUrl = new ParameterUrlPulic(mm);
        List<Integer> listtt = new ArrayList<>();
        
        

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

            mm.addAttribute("parameterUrl", parameterUrl);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @RequestMapping(value = {"/Public/pagingProducts"}, method = RequestMethod.GET)
    public String pagingProducts(
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
            e.getMessage();
        }
        return "Include/Public/sections/component/table/featuresitem";
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
