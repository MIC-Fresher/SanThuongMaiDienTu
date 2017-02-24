/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User.Comment;

import model.Pages;
import model.CommentForm;
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
public class CommentController implements Serializable {

    @Autowired
    CloneObject cloneObject;
    @Autowired
    ProductcommentService productcommentService;
    @Autowired
    utils.UtilsAuthencation utilsAuthencation;
    @Autowired
    OrderdetailRepository orderdetailRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductcommentRepository productcommentRepository;

    @RequestMapping(value = {"/User/Comment"}, method = RequestMethod.POST)
    public String Vote(HttpServletRequest request, ModelMap mm, HttpSession session,
            @ModelAttribute(value = "commentForm") CommentForm commentForm) {

        try {

            commentForm.setUserId(utilsAuthencation.getUserInPrincipal().getUserId());
            // insert 1 vote vào data
            if (productcommentService.addComment(commentForm) != null) {

                if (setUpComment(mm, request, commentForm)) {
                    return "Include/User/comment/comment_form";
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        mm.addAttribute("commentForm", new CommentForm());
        return "Include/User/comment/comment_form";
    }

    public boolean setUpComment(ModelMap mm,
            HttpServletRequest request, CommentForm commentForm) {

        try {
            Productcomment productcomment = productcommentService.addComment(commentForm);
            if (productcomment != null) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return false;
    }

    @RequestMapping(value = {"/Public/pagingComments"}, method = RequestMethod.GET)
    public String pagingComments(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "itemperpage", defaultValue = "5", required = false) Integer itemperpage,
            @RequestParam(value = "id", required = true) Integer id
    ) {
        try {
            setuppagingComments(page, itemperpage, id, mm);
        } catch (Exception e) {
            e.getMessage();
        }
        return "Include/User/comment/comment_items";
    }

    public void setuppagingComments(Integer page, Integer itemperpage, Integer id, ModelMap mm) throws Exception {
        PageRequest pageRequest;
        int statuscommentid = 2;//2 = mở
        Product product = productsRepository.findOne(id);
        pageRequest = new PageRequest(page - 1, itemperpage, Sort.Direction.DESC, "DateCreated");
        try {
            if (product != null) {
                Page<Productcomment> pager
                        = productcommentRepository.findByProductId_productIdAndStatusCommentId_Statuscommentid(pageRequest, id, statuscommentid);
                Pages pages = new Pages(pager);
                mm.addAttribute("product", product);
                mm.addAttribute("productcomments", pages);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
