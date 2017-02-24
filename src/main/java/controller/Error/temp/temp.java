/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Error.temp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import entity.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Pages;
import model.VoteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.OrderdetailRepository;
import repository.OrdersRepository;

@Controller

public class temp {

    Product p;
    Orders o;

    @Autowired
    OrderdetailRepository orderdetailRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    utils.UtilsAuthencation utilsAuthencation;

    @RequestMapping(value = {"/Public/test"}, method = RequestMethod.GET)
    public String Vote(HttpServletRequest request, ModelMap model, HttpSession session,
            ModelMap mm) {
        List<Object[]> l = null;
        //Object o = orderdetailRepository.sumAllQuantityByDate();
//        try {
//            l = ordersRepository.findAllOrderdetailByQuanlity();
//            Object[] arr = null;
//            for (int i = 0; i < l.size(); i++) {
//                arr = l.get(i);
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }

      
        return "User/Result_Checkout";
    }


    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public Orders getO() {
        return o;
    }

    public void setO(Orders o) {
        this.o = o;
    }

}
