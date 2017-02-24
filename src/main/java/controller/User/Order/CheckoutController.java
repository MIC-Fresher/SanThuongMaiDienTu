/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User.Order;

import model.VoteForm;
import model.CartInfo;
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

public class CheckoutController implements Serializable {

    @Autowired
    OrderService orderService;

    @Autowired
    utils.UtilsAuthencation utilsAuthencation;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping(value = {"/User/checkoutOrder"}, method = RequestMethod.GET)
    public String shoppingCartCustomerForm(HttpServletRequest request, ModelMap model, HttpSession session) {

        CartInfo myCart = UtilsCarts.getCartInSession(request);

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
        //cartinfo get from session
        CartInfo cartInfo = UtilsCarts.getCartInSession(request);

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

                // Remove Cart In Session.
                UtilsCarts.removeCartInSession(request);

                // Store Last ordered cart to Session.
                UtilsCarts.storeLastOrderedCartInSession(request, cartInfo);
                return "redirect:/User/shoppingCartFinalize";

            } else {
                redirectAttributes.addFlashAttribute("messeger", "Đặt hàng thất bại");
                return "redirect:/User/Checkout";
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return "redirect:/User/Checkout";
    }

    @RequestMapping(value = {"/User/shoppingCartFinalize"}, method = RequestMethod.GET)
    public String shoppingCartFinalize(
            HttpServletRequest request, ModelMap model,
            RedirectAttributes redirectAttributes) {
        try {

            //get list last order cart
            CartInfo lastOrderedCart = UtilsCarts.getLastOrderedCartInSession(request);

            if (lastOrderedCart == null) {
                return "redirect:/Public/shoppingCart";
            } else {
                model.addAttribute("messeger", "Bạn đã đặt hàng thành công");
                List<Product> products = new ArrayList<>();

                for (int i = 0; i < lastOrderedCart.getCartLines().size(); i++) {
                    products.add(lastOrderedCart.getCartLines().get(i).getProduct());
                }
                model.addAttribute("products", products);
                model.addAttribute("cartLines", lastOrderedCart.getCartLines());
                model.addAttribute("voteForm", new VoteForm());
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return "/User/Result_Checkout";
    }
}
