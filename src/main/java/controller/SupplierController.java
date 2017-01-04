/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import services.*;
import entity.*;
import model.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Scope("session")
//SessionAttributes({"listCategories", "listShops"})
public class SupplierController implements Serializable {

    public Category listcata;
    public Shop shop;
    Pages test1;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ShopService shopService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/Supplier/SuplierIndex"}, method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/SuplierIndex";
    }

    @RequestMapping(value = {"/Suplier/setupShowAllCategories"}, method = RequestMethod.GET)
    public String setupShowAllCategories(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            HttpServletRequest request,
            HttpSession session, ModelMap mm) {

        try {
            setupShowCategories(page, request, mm);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Suplier/setupShowAllShops"}, method = RequestMethod.GET)
    public String setupShowAllShops(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowShops(page, mm);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Suplier/setupShowDetailShop"}, method = RequestMethod.GET)
    public String setupShowDetailShop(
            @RequestParam(value = "id", required = true) Integer id,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowDetailShop(id, mm);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Suplier/deactiveShop"}, method = RequestMethod.GET)
    public String deactiveShop(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowShops(page, mm);
            deactiveShop(id, mm);

        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Suplier/activeShop"}, method = RequestMethod.GET)
    public String activeShop(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowShops(page, mm);
            activeShop(id, mm);

        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Suplier/deactiveCategory"}, method = RequestMethod.GET)
    public String deactiveCategory(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowCategories(page, request, mm);
            deactiveCategory(id, mm);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Suplier/activeCategory"}, method = RequestMethod.GET)
    public String activeCategory(HttpServletRequest request,
            HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id
    ) {

        try {
            setupShowCategories(page, request, mm);
            activeCategory(id, mm);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Suplier/addCategory"}, method = RequestMethod.GET)
    public String setupCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {

        try {
            setupShowCategories(page, request, mm);
            mm.addAttribute("categories", new Category());
            mm.addAttribute("type", "formadd");
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Suplier/addCategory"}, method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @ModelAttribute(value = "categories") Category category
    ) {

        try {
            setupShowCategories(page, request, mm);
            addCategory(mm, category);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

//    ======================================================================================Method=========>>
    public void activeCategory(Integer id, ModelMap mm) {
        Category cate = null;
        try {

            cate = categoriesService.getCategoriesById(id);
            cate.setIsActive(1);
            categoriesService.updateCategories(cate);

            mm.addAttribute("messeger", "Mở khóa thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Mở khóa thất bại");
        }

    }

    public void deactiveCategory(Integer id, ModelMap mm) {
        Category cate = null;
        try {
            cate = categoriesService.getCategoriesById(id);
            cate.setIsActive(0);
            categoriesService.updateCategories(cate);
            mm.addAttribute("messeger", "Khóa thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Khóa thất bại");
        }

    }

    public void activeShop(Integer id, ModelMap mm) {
        Shop shop = null;
        User user = null;
        try {
            shop = shopService.getShopById(id);
            user = shop.getUserId();
            user.setEnabled(1);
            userService.updateUser(user);

            mm.addAttribute("messeger", "Khóa thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Khóa thất bại");
        }

    }

    public void deactiveShop(Integer id, ModelMap mm) {
        Shop shop = null;
        User user = null;
        try {
            shop = shopService.getShopById(id);
            user = shop.getUserId();
            user.setEnabled(0);
            userService.updateUser(user);

            mm.addAttribute("messeger", "Khóa thành công");

        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Khóa thất bại");
        }

    }

    public void setupShowShops(Integer page, ModelMap mm) {
        PageRequest pageRequest;
        try {
            pageRequest = new PageRequest(page - 1, 3);
            Page<Shop> pager = shopService.getAllShop(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listShops", pages);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setupShowCategories(Integer page, HttpServletRequest request, ModelMap mm) {

        PageRequest pageRequest;
        try {

            pageRequest = new PageRequest(page - 1, 3);

            // tạo 1 đối tượng pagerequest tham số đầu vào là trang hiện tại và số trang sẽ lấy
            Page<Category> pager = categoriesService.getAllCategories(pageRequest);
            // lấy tất cả categories
            Pages pages = new Pages(pager);
            //tạo 1 đối tượng pages chứa các trang vừa mới lấy về trong lớp pages chứa các phương thức 
            //xử lý các trang trước khi đưa vào sử dụng
            mm.addAttribute("listCategories", pages);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void addCategory(ModelMap mm, Category category) {
        Category cate = null;
        try {
            categoriesService.addCategories(category);
            mm.addAttribute("messeger", "Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Thêm thất bại");
        }

    }

    public void setupShowDetailShop(Integer id, ModelMap mm) {

        Shop shop = null;
        try {
            shop = shopService.getShopById(id);
            mm.addAttribute("shopDetail", shop);
        } catch (Exception e) {
        }
    }

    public void setupRoleShop(Integer id, ModelMap mm) {
        Shop shop = null;
        try {
            shop = shopService.getShopById(id);
        } catch (Exception e) {
        }
    }
//    ========================================================================================get/set====>>

    public Category getListcata() {
        return listcata;
    }

    public Shop getShop() {
        return shop;
    }

    public Pages getTest1() {
        return test1;
    }

    public void setTest1(Pages test1) {
        this.test1 = test1;
    }

}
