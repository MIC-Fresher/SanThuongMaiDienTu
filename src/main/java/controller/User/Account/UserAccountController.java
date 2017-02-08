/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User.Account;

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
import model.*;
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
import utils.CartShopping.*;

@Controller
@Scope("session")
public class UserAccountController implements Serializable {

    @Autowired
    UserRepository userRepository;
    @Autowired
    utils.Authencation.UtilsAuthencation utilsAuthencation;
  
    

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/User/InformationAccount"}, method = RequestMethod.GET)
    public String setupInformationAccount(
            HttpServletRequest request, ModelMap mm, HttpSession session) {

        try {
            User user = utilsAuthencation.getUserInPrincipal();
            user = userRepository.findOne(user.getUserId());
            mm.addAttribute("userInformation", user);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/User/UserInfomation";
    }

    @RequestMapping(value = {"/User/InformationAccount"}, method = RequestMethod.POST)
    public String updateInformationAccount(HttpServletRequest request, ModelMap model, HttpSession session) {

        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "/User/Checkout";
    }

}
