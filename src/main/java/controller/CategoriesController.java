/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Scope("session")
@SessionAttributes({"listCategories"})
public class CategoriesController implements Serializable {
    
}
