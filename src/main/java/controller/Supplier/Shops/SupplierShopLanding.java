/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Shops;

import entity.Category;
import entity.Product;
import entity.Role;
import entity.Shop;
import entity.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CategoriesRepository;
import repository.ShopRepository;
import services.CategoriesService;
import services.RoleService;
import services.ShopService;
import services.UserService;

@Controller

public class SupplierShopLanding implements Serializable{

    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    CategoriesRepository categoriesRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }


    @RequestMapping(value = {"/Supplier/Shops"}, method = RequestMethod.GET)
    public String landingShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            searchShop(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Shops";
    }

    public void searchShop(String search, ModelMap mm, int page) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3);
            Page<Shop> pager = shopService.getShopByInput(pageRequest, search, search, search, search, search);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchShops", pages);
            mm.addAttribute("searchinput", search);
        } catch (Exception e) {
        }
    }

  
}
