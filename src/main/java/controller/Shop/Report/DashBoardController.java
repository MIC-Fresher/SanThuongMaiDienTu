/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Shop.Report;

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
import utils.IMG.IMGUtils;

@Controller
@Scope("session")
public class DashBoardController implements Serializable {

    @Autowired
    utils.Authencation.UtilsAuthencation utilsAuthencation;
    @Autowired
    OrdersRepository ordersRepository;

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
    CategoriesRepository categoriesRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/Shop/DashBoard"}, method = RequestMethod.GET)
    public String dashBoard(
            HttpServletRequest request, HttpSession session, ModelMap mm
    ) {
        try {
            //
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            DashBoardSearchForm dashBoard = new DashBoardSearchForm();

            mm.addAttribute("dashBoard", dashBoard);

            //setup dashboard object
            setupDashBoard(mm, 10, s, dashBoard);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Shop/DashBoard";
    }

    @RequestMapping(value = {"/Shop/DashBoard/Search"}, method = RequestMethod.POST)
    public String dashBoardSearch(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "OrdersItem", defaultValue = "10", required = false) Integer OrdersItem,
            @ModelAttribute(value = "dashBoard") DashBoardSearchForm dashBoard
    ) {
        try {
            //
            
            //
            entity.User user = utilsAuthencation.getUserInPrincipal();
            Shop s = user.getShop();
            //
            mm.addAttribute("dashBoard", dashBoard);
            //

            setupDashBoard(mm, OrdersItem, s, dashBoard);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Shop/DashBoard";
    }
//    ====================================***HandMaping***=======================================================>>

//    =======================================***METHOD***=====================================================>>
    public void searchRecentOrders(ModelMap mm, int OrdersItem, Shop s, DashBoardSearchForm dashBoard) {
        
        try {

            PageRequest pageRequest;
            pageRequest = new PageRequest(0, OrdersItem, Sort.Direction.DESC, "orderDate");

            Page<Orders> pager = ordersRepository.findDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndUserId_EmailContainingAndOrderDateBetween(pageRequest, s.getShopName(), "", dashBoard.getFromDate(), dashBoard.getToDate());
            //Page<Orders> pager = ordersRepository.findOrderByShopNameAndEmail(s.getShopName(), "", pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listOrders", pages);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setupDashBoard(ModelMap mm, int OrdersItem, Shop s, DashBoardSearchForm dashBoard) {

        try {
            searchRecentOrders(mm, OrdersItem, s, dashBoard);
            mm.addAttribute("totalOrder", ordersRepository.findDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndOrderDateBetween(s.getShopName(), dashBoard.getFromDate(), dashBoard.getToDate()).size());
            mm.addAttribute("totalProductsActive", productsRepository.findByShopId_ShopNameContainingAndIsActiveAndStockGreaterThanAndDateCreatedBetween(s.getShopName(), 1, 0, dashBoard.getFromDate(), dashBoard.getToDate()).size());
            mm.addAttribute("totalProductsOld", productsRepository.findByShopId_ShopNameContainingAndIsActiveAndStockEqualsAndDateCreatedBetween(s.getShopName(), 1, 0, dashBoard.getFromDate(), dashBoard.getToDate()).size());
            mm.addAttribute("ShopCategories", categoriesRepository.countByShopList_ShopNameContainingAndIsActive(s.getShopName(), 1));
        } catch (Exception e) {
            e.getMessage();
        }

    }
//    =======================================***GET/SET***=====================================================>>   

}
