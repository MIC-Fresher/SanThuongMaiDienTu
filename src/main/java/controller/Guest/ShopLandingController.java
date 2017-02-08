/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Guest;

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
import model.*;
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
import org.springframework.web.multipart.MultipartFile;
import utils.IMG.IMGUtils;

@Controller
@Scope("session")
public class ShopLandingController implements Serializable {


    @Autowired
    GroupcategoriesRepository groupcategoriesRepository;
    @Autowired
    UserService userService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    ShopService shopService;
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    SizesRepository sizesRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

//    ====================================***HandMaping***=======================================================>>
//    ====================================***PRODUCT***=======================================================>>
    @RequestMapping(value = {"/Public/{shopname}/"}, method = RequestMethod.GET)
    public String showProductOfShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @PathVariable("shopname") String shopname
           
    ) {
        try {

            showProductOfShop(mm, shopname);

            setupCategoriesBar(mm, shopname);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Public/ProductOfShop";
    }

//    =======================================***METHOD***=====================================================>>
//    =======================================***PRODUCT***=====================================================>>
    public void showProductOfShop(
            ModelMap mm, String shopname
    ) {

        List<Integer> listtt = new ArrayList<>();
        ParameterUrlPulic parameterUrl = new ParameterUrlPulic(mm);
        for (int i = 0; i < 6; i++) {
            listtt.add(i);
        }
        try {
            PageRequest pageRequest;

            pageRequest = new PageRequest(0, 12, Sort.Direction.DESC, "DateCreated");
            Page<Product> pager = productsService.getProducts(pageRequest, shopname, 1, 1, 1, "", listtt, 0, 10000000, "");
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);

            parameterUrl.setItemperpage(12);
            parameterUrl.setShopname(shopname);
            mm.addAttribute("parameterUrl", parameterUrl);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setupCategoriesBar(ModelMap mm, String shopName) {

        try {
            mm.addAttribute("listGroupcategories", groupcategoriesRepository.findDistinctByCategoryList_ShopList_ShopName(shopName));
        } catch (Exception e) {
        }

    }


//    =======================================***get/set***=====================================================>>
}
