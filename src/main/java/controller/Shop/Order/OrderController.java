/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Shop.Order;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.IMG.IMGUtils;

@Controller
@Scope("session")
public class OrderController implements Serializable {

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

    @RequestMapping(value = {"/Shop/OrderDetail"}, method = RequestMethod.GET)
    public String setupOrderDetail(HttpServletRequest request, HttpSession session, ModelMap mm,
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
        return "/Shop/Order_Detail";
    }

    @RequestMapping(value = {"/Shop/OrderDetail"}, method = RequestMethod.POST)
    public String orderDetail(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            RedirectAttributes redirectAttrs,
            @ModelAttribute(value = "order") Orders order,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "itemperpage", defaultValue = "3", required = false) Integer itemperpage
    ) {
        try {

            ParameterUrlShop parameterUrl = new ParameterUrlShop();

            Orders result = orderService.updateOrder(order);

            if (result != null) {
                redirectAttrs.addFlashAttribute("messeger", "Cập nhật thành công");
            } else {
                redirectAttrs.addFlashAttribute("messeger", "Cập nhật thất bại");
            }
            //-------
            parameterUrl.setItemperpage(itemperpage);
            parameterUrl.setSearchinput(searchinput);
            //--------
            redirectAttrs.addFlashAttribute("parameterUrl", parameterUrl);

        } catch (Exception e) {
            e.getMessage();
            redirectAttrs.addFlashAttribute("messeger", "Cập nhật thất bại");
        }
        return "redirect:/Shop/OrderDetail?id=" + order.getOrderId();
    }

    @RequestMapping(value = {"/Shop/deleteOrder"}, method = RequestMethod.GET)
    public String deleteOrder(
            HttpServletRequest request, HttpSession session, ModelMap mm, 
            RedirectAttributes redirectAttrs,
            @RequestParam(value = "id", required = true) Integer id
            
    ) {

        try {
            deleteOrder(id, redirectAttrs);
        } catch (Exception e) {
            e.getMessage();
        }

        return "redirect:/Shop/Orders";
    }
//    ====================================***HandMaping***=======================================================>>
//    =======================================***METHOD***=====================================================>>

    public void deleteOrder(int idorder, RedirectAttributes redirectAttrs) {
        try {
            Orders order = ordersRepository.findOne(idorder);
            receiverRepository.delete(order.getReceiverId().getReceiverId());
            //productsRepository.test(idproduct);
            redirectAttrs.addFlashAttribute("messeger", "xóa thành công");

        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("messeger", "xóa thất bại");
            e.getMessage();
        }
    }

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
