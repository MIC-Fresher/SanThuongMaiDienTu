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
import org.springframework.web.servlet.support.RequestContextUtils;
import repository.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Scope("session")
public class SearchProductsByShopController implements Serializable {

    @Autowired
    GroupcategoriesRepository groupcategoriesRepository;

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
    @RequestMapping(value = {"/Public/{shopname}/searchProducts/"}, method = RequestMethod.GET)
    public String searchProductOfShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @PathVariable(value = "shopname") String shopname
    ) {
        try {
            Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
            Integer page = (Integer) inputFlashMap.get("page");
            String searchinput = (String) inputFlashMap.get("searchinput");
            Integer itemperpage = (Integer) inputFlashMap.get("itemperpage");
            String categoryname = (String) inputFlashMap.get("categoryname");
            Integer fromprice = (Integer) inputFlashMap.get("fromprice");
            Integer toprice = (Integer) inputFlashMap.get("toprice");
            Integer totalvote = (Integer) inputFlashMap.get("totalvote");

            searchProductOfShop(searchinput, mm, page, shopname, fromprice, toprice, totalvote, itemperpage, categoryname);
            setupCategoriesBar(mm, shopname);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Public/ProductOfShop";
    }

    @RequestMapping(value = {"/Public/setupSearchProducts"}, method = RequestMethod.GET)
    public String redirectSearchProductOfShop(
            HttpServletRequest request, HttpSession session, ModelMap mm, RedirectAttributes redirectAttrs,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "12", required = false) Integer itemperpage,
            @RequestParam(value = "shopname", defaultValue = "", required = false) String shopname,
            @RequestParam(value = "categoryname", defaultValue = "", required = false) String categoryname,
            @RequestParam(value = "fromprice", defaultValue = "", required = false) Integer fromprice,
            @RequestParam(value = "toprice", defaultValue = "", required = false) Integer toprice,
            @RequestParam(value = "totalvote", defaultValue = "", required = false) Integer totalvote
    ) {
        try {
            redirectAttrs.addFlashAttribute("searchinput", searchinput);
            redirectAttrs.addFlashAttribute("page", page);
            redirectAttrs.addFlashAttribute("itemperpage", itemperpage);
            redirectAttrs.addFlashAttribute("categoryname", categoryname);
            redirectAttrs.addFlashAttribute("fromprice", fromprice);
            redirectAttrs.addFlashAttribute("toprice", toprice);
            redirectAttrs.addFlashAttribute("totalvote", totalvote);

        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/Public/" + shopname + "/searchProducts/";
    }

//    =======================================***METHOD***=====================================================>>
//    =======================================***PRODUCT***=====================================================>>
    public void searchProductOfShop(String search,
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

    public void setupCategoriesBar(ModelMap mm, String shopName) {

        try {
            mm.addAttribute("listGroupcategories", groupcategoriesRepository.findDistinctByCategoryList_ShopList_ShopName(shopName));
        } catch (Exception e) {
        }

    }

//    =======================================***get/set***=====================================================>>
}
