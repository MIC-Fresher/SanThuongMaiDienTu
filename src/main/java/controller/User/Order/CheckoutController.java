/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User.Order;

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
public class CheckoutController implements Serializable {

    @Autowired
    OrderService orderService;
    
    @Autowired
    utils.Authencation.UtilsAuthencation utilsAuthencation;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/User/checkoutOrder"}, method = RequestMethod.GET)
    public String shoppingCartCustomerForm(HttpServletRequest request, ModelMap model, HttpSession session) {

        CartInfo myCart = Utils.getCartInSession(request);

        // Cart is empty.
        if (myCart.isEmpty()) {

            // Redirect to shoppingCart page.
            return "redirect:/Public/shoppingCart";
        }

        User User = myCart.getUser();
        if (User == null) {
            myCart.setUser(utilsAuthencation.getUserInPrincipal());
        }

        model.addAttribute("customerForm", new Receiver());
        model.addAttribute("cartForm", myCart);
        return "/User/Checkout";
    }

    @RequestMapping(value = {"/User/checkoutOrder"}, method = RequestMethod.POST)
    public String shoppingCartCustomerSave(HttpServletRequest request, //
            ModelMap model, HttpSession session, //
            @ModelAttribute("customerForm") Receiver customerForm, //
            final RedirectAttributes redirectAttributes) {
        CartInfo cartInfo = Utils.getCartInSession(request);

        if (cartInfo.isEmpty()) {
            // Redirect to shoppingCart page.
            return "redirect:/Public/shoppingCart";
        }

        if (cartInfo.getCartLines().size() <= 0) {
            return "redirect:/Public/shoppingCart";
        }
        try {
            boolean order = orderService.addOrder(customerForm, utilsAuthencation.getUserInPrincipal(), cartInfo);
            if (order) {

                redirectAttributes.addFlashAttribute("messeger", "Đặt hàng thành công");
            } else {
                redirectAttributes.addFlashAttribute("messeger", "Đặt hàng thất bại");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        // Remove Cart In Session.
        Utils.removeCartInSession(request);

        // Store Last ordered cart to Session.
        Utils.storeLastOrderedCartInSession(request, cartInfo);

        return "redirect:/User/shoppingCartFinalize";
    }

    @RequestMapping(value = {"/User/shoppingCartFinalize"}, method = RequestMethod.GET)
    public String shoppingCartFinalize(HttpServletRequest request, ModelMap model) {

        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);

        if (lastOrderedCart == null) {
            return "redirect:/Public/shoppingCart";
        }

        return "/User/Result_Checkout";
    }
}
