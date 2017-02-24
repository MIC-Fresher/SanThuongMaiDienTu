/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.servlet.http.HttpServletRequest;
import model.CartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import services.UserService;
import entity.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

@Service
public class UtilsAuthencationImpl implements UtilsAuthencation, Serializable {

    @Autowired
    UserService userService;
    private static final long serialVersionUID = 1L;

    public User getUserInPrincipal() {

        try {
            org.springframework.security.core.userdetails.User userSpringAuthencation = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            entity.User user = userService.getUser(userSpringAuthencation.getUsername(), "").get(0);
            return user;
        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    public org.springframework.security.core.userdetails.User getPrincipal() {
        return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
