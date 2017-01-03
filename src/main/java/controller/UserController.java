/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import services.UserService;

@Controller
@Scope("session")
@SessionAttributes({"user"})
public class UserController implements Serializable {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/User/userpage", method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "/User/userpage";
    }

    @RequestMapping(value = "/setupUserlogin", method = RequestMethod.GET)
    public String setupUserLogin(ModelMap mm, HttpServletRequest request) throws Exception {
        mm.addAttribute("UserLG", new User());
        return "userlogin";
    }
    
    
    
    @RequestMapping(value = "Public/setupSignUp", method = RequestMethod.GET)
    public String setupSignUp(ModelMap mm, HttpServletRequest request, HttpSession session) throws Exception {

        

        mm.addAttribute("UserRG", new User());

        return "Public/signup";
    }

    @RequestMapping(value = "Public/signUp", method = RequestMethod.POST)
    public String signUp(HttpSession session, @ModelAttribute(value = "UserRG") User UserRG, HttpServletRequest request) throws Exception {

        try {
            if (!userService.checkEmailExist(UserRG.getEmail())) {
                UserRG.setEnabled(1);
                userService.add(UserRG);
                request.setAttribute("messeger", "bạn đã tạo tài khoản thành công");
                return "Public/aftersignup";

            }

        } catch (Exception e) {
            e.getMessage();
        }
        request.setAttribute("messeger", "có lỗi trong quá trình tạo tài khoản vui lòng tạo lại");
        return "redirect:./setupRegister";
    }
}
