/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User.Vote;

import entity.Orderdetail;
import entity.Product;
import entity.Receiver;
import entity.User;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CartInfo;
import model.Pages;
import model.VoteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.OrderdetailRepository;
import utils.UtilsCarts;
import services.ProductvotingService;
import utils.CloneObject;
import utils.UtilsVote;

@Controller

public class VoteController implements Serializable {

    @Autowired
    CloneObject cloneObject;
    @Autowired
    ProductvotingService productvotingService;
    @Autowired
    utils.UtilsAuthencation utilsAuthencation;
    @Autowired
    OrderdetailRepository orderdetailRepository;

    @RequestMapping(value = {"/User/Vote"}, method = RequestMethod.POST)
    public String Vote(HttpServletRequest request, ModelMap mm, HttpSession session,
            @ModelAttribute(value = "voteForm") VoteForm voteForm) {

        try {
          
            voteForm.setUserId(utilsAuthencation.getUserInPrincipal().getUserId());
            // insert 1 vote vào data
            if (productvotingService.addVote(voteForm) != null) {

                setupVote(mm, request, voteForm);
                return "Include/User/comment/modal/comment_and_vote";

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return "Include/User/comment/modal/comment_and_vote";
    }

    public boolean setupVote(ModelMap mm, HttpServletRequest request, VoteForm voteForm) throws Exception {
        CartInfo lastOrderedCart = null;
        try {
            lastOrderedCart = UtilsCarts.getLastOrderedCartInSession(request);
        } catch (Exception e) {
            e.getMessage();
        }

        if (lastOrderedCart == null) {
            return false;
        } else {
          
            //get cart order sau khi vote
            List<Product> products = UtilsVote.getProductsAfterVote(lastOrderedCart, voteForm);
            if (!products.isEmpty()) {
                mm.addAttribute("messeger", "Bạn đã đánh giá thành công");
                mm.addAttribute("products", products);
                mm.addAttribute("voteForm", new VoteForm());
                return true;
            } else {
                return false;
            }

        }
    }

}
