/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import entity.*;
@Controller
@Scope("session")
public class temp {
    Product p;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }
}
