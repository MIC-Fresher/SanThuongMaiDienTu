/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Shop;

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
public class ShopController implements Serializable {

    
    @Autowired
    utils.Authencation.UtilsAuthencation utilsAuthencation;
    

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = "/setupShopLogin", method = RequestMethod.GET)
    public String setupShopLogin(ModelMap mm, HttpServletRequest request) throws Exception {
        return "shoplogin";
    }

    @RequestMapping(value = {"/Shop/ShopIndex", "/Shop/"}, method = RequestMethod.GET)
    public String shopIndex(HttpServletRequest request, HttpSession session) throws Exception {

        try {
            entity.User user = utilsAuthencation.getUserInPrincipal();

            session.setAttribute("shop", user.getShop());
            
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Shop/ShopIndex";
    }
//    ====================================***HandMaping***=======================================================>>

//    =======================================***METHOD***=====================================================>>
//    =======================================***GET/SET***=====================================================>>   
  

}
