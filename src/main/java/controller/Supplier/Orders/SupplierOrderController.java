/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Orders;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.IMG.IMGUtils;

@Controller

public class SupplierOrderController implements Serializable {

    @Autowired
    StatusorderRepository statusorderRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    ReceiverRepository receiverRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/Supplier/OrderDetail"}, method = RequestMethod.GET)
    public String SuppliersetupOrderDetail(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "itemperpage", defaultValue = "3", required = false) Integer itemperpage
    ) {
        try {

            ParameterUrlShop parameterUrl = new ParameterUrlShop();
            setupOrderDetail(id, mm);
            parameterUrl.setItemperpage(itemperpage);
            parameterUrl.setSearchinput(searchinput);
            mm.addAttribute("parameterUrl", parameterUrl);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Order_Detail";
    }
//    ====================================***HandMaping***=======================================================>>
//    =======================================***METHOD***=====================================================>>

  

    public void setupOrderDetail(int id, ModelMap mm) {
        try {
            Orders order = ordersRepository.findOne(id);
            if (order != null) {
                mm.addAttribute("statusOrders", statusorderRepository.findAll());
                mm.addAttribute("order", order);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
//    =======================================***GET/SET***=====================================================>>   

}
