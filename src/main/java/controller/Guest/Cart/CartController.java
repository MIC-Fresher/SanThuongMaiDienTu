/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Guest.Cart;


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

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import repository.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.*;

@Controller

public class CartController implements Serializable {


    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;
  
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @RequestMapping({"/Public/addProduct"})
    public @ResponseBody
    int listProductHandler(HttpServletRequest request, ModelMap model, //
            @RequestParam(value = "id", required = true) int id) {

        Product product = null;
        CartInfo cartInfo = null;
        try {
            product = productsRepository.findOne(id);

            if (product != null) {

                // Cart info stored in Session.
                cartInfo = UtilsCarts.getCartInSession(request);

                cartInfo.addProduct(product, 1);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        // return cartline
        return cartInfo.getCartLines().size();
    }


    @RequestMapping(value = {"/Public/shoppingCart"}, method = RequestMethod.GET)
    public String shoppingCartHandler(HttpServletRequest request, ModelMap model) {
        CartInfo myCart = UtilsCarts.getCartInSession(request);

        model.addAttribute("cartForm", myCart);
        return "/Public/Cart";
    }

    // POST: Update quantity of products in cart.
    @RequestMapping(value = {"/Public/shoppingCart"}, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request, //
            ModelMap model, //
            @ModelAttribute("cartForm") CartInfo cartForm) {

        CartInfo cartInfo = UtilsCarts.getCartInSession(request);
        cartInfo.updateQuantity(cartForm);

        // Redirect to shoppingCart page.
        return "redirect:/Public/shoppingCart";
    }

    @RequestMapping({"/Public/shoppingCartRemoveProduct"})
    public String removeProductHandler(HttpServletRequest request, ModelMap model, //
            @RequestParam(value = "id", required = true) int id) {
        Product product = null;
        CartInfo cartInfo = null;
        try {

            product = productsRepository.findOne(id);
            if (product != null) {

                // Cart Info stored in Session.
                cartInfo = UtilsCarts.getCartInSession(request);

                cartInfo.removeProduct(product);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        // Redirect to shoppingCart page.
        return "redirect:/Public/shoppingCart";
    }

}
