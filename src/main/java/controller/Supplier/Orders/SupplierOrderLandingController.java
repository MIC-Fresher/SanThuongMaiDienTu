/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Orders;

import model.Pages;
import model.ParameterUrlShop;
import controller.Shop.Order.*;
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

public class SupplierOrderLandingController implements Serializable {

    
    @Autowired
    OrdersRepository ordersRepository;

    

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/Supplier/Orders"}, method = RequestMethod.GET)
    public String Supplierorderlanding(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "itemperpage", defaultValue = "3", required = false) Integer itemperpage
    ) {
        try {
            
            searchOrders(mm, itemperpage);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Orders";
    }
//    ====================================***HandMaping***=======================================================>>

//    =======================================***METHOD***=====================================================>>
    public void searchOrders(ModelMap mm, int itemperpage) {
        ParameterUrlShop parameterUrl = new ParameterUrlShop();
        try {

            PageRequest pageRequest;
            pageRequest = new PageRequest(0, itemperpage, Sort.Direction.DESC, "orderDate");

            //Page<Orders> pager = ordersRepository.findOrderdetailList_ProductIdDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndUserId_EmailContaining(pageRequest, s.getShopName(), "");
            Page<Orders> pager = ordersRepository.findAll(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listOrders", pages);

            parameterUrl.setItemperpage(itemperpage);
            mm.addAttribute("parameterUrl", parameterUrl);
        } catch (Exception e) {
            e.getMessage();
        }
    }
//    =======================================***GET/SET***=====================================================>>   

    

}
