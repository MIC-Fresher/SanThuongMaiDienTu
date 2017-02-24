/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User.Order;

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
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;
import repository.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.*;

@Controller

public class OrderLanding implements Serializable {

    @Autowired
    OrderdetailRepository orderdetailRepository;

    @Autowired
    utils.UtilsAuthencation utilsAuthencation;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/User/Order"}, method = RequestMethod.GET)
    public String setupOrder(
            HttpServletRequest request, ModelMap mm, HttpSession session,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "12", required = false) Integer itemperpage) {

        try {
            User user = utilsAuthencation.getUserInPrincipal();
         
            setupOrder(user.getUserId(), page, itemperpage, mm);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/User/Order";
    }

    public void setupOrder(int userid, int page, int itemperpage, ModelMap mm) {
        PageRequest pageRequest;

        try {
            pageRequest = new PageRequest(page - 1, itemperpage);
            Page<Orderdetail> pager = orderdetailRepository.findByOrderId_UserId_UserIdOrderByOrderId_OrderDateDesc(pageRequest, userid);
            Pages pages = new Pages(pager);

            mm.addAttribute("listOrder", pages);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
