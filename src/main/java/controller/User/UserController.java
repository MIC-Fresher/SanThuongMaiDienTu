/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User;

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
import org.springframework.web.multipart.MultipartFile;
import utils.IMG.IMGUtils;

@Controller

public class UserController implements Serializable {

    

    
   
    @Autowired
    UserService userService;
   
    

    @PostConstruct
    public void init() {
        
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = "/setupUserlogin", method = RequestMethod.GET)
    public String setupUserLogin(ModelMap mm, HttpServletRequest request) throws Exception {
        mm.addAttribute("UserLG", new User());
        return "userlogin";
    }

    @RequestMapping(value = "/User/index", method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {
            org.springframework.security.core.userdetails.User userSpringAuthencation = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            entity.User user = userService.getUser(userSpringAuthencation.getUsername(), "").get(0);
            session.setAttribute("user", user);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/Public/searchAllProducts";
    }
//    ====================================***HandMaping***=======================================================>>
//    ====================================***ACCOUNT***=======================================================>>

    @RequestMapping(value = "/Public/setupSignUp", method = RequestMethod.GET)
    public String setupSignUp(
            ModelMap mm, HttpServletRequest request, HttpSession session) throws Exception {

        mm.addAttribute("UserRG", new User());

        return "Public/signup";
    }

    @RequestMapping(value = "/Public/signUp", method = RequestMethod.POST)
    public String signUp(
            HttpSession session, @ModelAttribute(value = "UserRG") User UserRG,
            HttpServletRequest request, ModelMap mm) throws Exception {

        if (signUp(UserRG, mm)) {
            return "redirect:setupIndex";
        } else {
            return "redirect:/Public/setupSignUp";
        }

    }

//    =======================================***METHOD***=====================================================>>
//    ====================================***ACCOUNT***=======================================================>>
    public boolean signUp(User user, ModelMap mm) {
        try {
            if (!userService.checkAccountExist(user.getUserName(), user.getEmail())) {
                user.setEnabled(1);
                user.setDateCreated(new Date());
                user = userService.add(user);
                userService.addRoleToUser(2, user.getUserId());

                mm.addAttribute("messeger", "bạn đã tạo tài khoản thành công");
                return true;
            }
        } catch (Exception e) {
            mm.addAttribute("messeger", "có lỗi trong quá trình tạo tài khoản vui lòng tạo lại");
        }
        mm.addAttribute("UserRG", new User());
        mm.addAttribute("messeger", "có lỗi trong quá trình tạo tài khoản vui lòng tạo lại");
        return false;
    }
//    =======================================***get/set***=====================================================>>

  

   
}
