/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Error;

import entity.User;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController implements Serializable {
    
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(ModelMap mm, HttpServletRequest request) throws Exception {
        return "Error/403";
    }
    
 
}
