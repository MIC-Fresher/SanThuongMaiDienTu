/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.*;

/**
 *
 * @author Admin
 */
public interface UtilsAuthencation {

    public User getUserInPrincipal();

    public org.springframework.security.core.userdetails.User getPrincipal();
}
