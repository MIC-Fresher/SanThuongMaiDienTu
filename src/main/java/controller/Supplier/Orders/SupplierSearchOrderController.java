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

public class SupplierSearchOrderController implements Serializable {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    utils.UtilsAuthencation utilsAuthencation;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/Supplier/Orders/Search"}, method = RequestMethod.GET)
    public String Supplierordersearch(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "3", required = false) Integer itemperpage,
            @RequestParam(value = "statusOrder", required = false) Integer statusOrder
    ) {
        try {

            searchOrders(mm, itemperpage, page, searchinput);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Include/Supplier/order/order_table/order_table";
    }

    @RequestMapping(value = {"/Supplier/Orders/Filter"}, method = RequestMethod.GET)
    public String Supplierorderfilter(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "3", required = false) Integer itemperpage,
            @RequestParam(value = "statusOrder", required = false) Integer statusOrder
    ) {
        try {

            filterOrders(mm, itemperpage, page, statusOrder);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Include/Supplier/order/order_table/order_table_filter";
    }


//    ====================================***HandMaping***=======================================================>>
//    =======================================***METHOD***=====================================================>>
    public void searchOrders(ModelMap mm, int itemperpage, int page, String searchinput) {
        ParameterUrlShop parameterUrl = new ParameterUrlShop();
        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, itemperpage, Sort.Direction.DESC, "orderDate");
            //Page<Orders> pager = ordersRepository.findDistinctByOrderdetailList_ProductId_ShopId_ShopNameContainingAndUserId_EmailContaining(pageRequest, s.getShopName(), "");
            Page<Orders> pager = ordersRepository.findOrderByShopNameOrEmail(searchinput, searchinput, pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listOrders", pages);

            parameterUrl.setSearchinput(searchinput);
            parameterUrl.setItemperpage(itemperpage);
            mm.addAttribute("parameterUrl", parameterUrl);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void filterOrders(ModelMap mm, int itemperpage, int page, int statusOrder) {
        ParameterUrlShop parameterUrl = new ParameterUrlShop();
        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, itemperpage, Sort.Direction.DESC, "orderDate");
            Page<Orders> pager = ordersRepository.findOrderByShopNameAndStatus("", statusOrder, pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listOrders", pages);

            parameterUrl.setItemperpage(itemperpage);
            parameterUrl.setStatusOrder(statusOrder);
            mm.addAttribute("parameterUrl", parameterUrl);
        } catch (Exception e) {
            e.getMessage();
        }
    }
//    =======================================***GET/SET***=====================================================>>   

}
