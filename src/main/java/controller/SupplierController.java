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

    @RequestMapping(value = {"/Supplier/SuplierIndex"}, method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {

        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/SuplierIndex";
    }

    @RequestMapping(value = {"/Suplier/setupShowAllCategories"}, method = RequestMethod.GET)
    public String setupShowAllCategories(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            HttpServletRequest request,
            HttpSession session, ModelMap mm) {

        try {
            PageRequest pageRequest = new PageRequest(page - 1, 3);
            // tạo 1 đối tượng pagerequest tham số đầu vào là trang hiện tại và số trang sẽ lấy
            Page<Category> pager = categoriesService.getAllCategories(pageRequest);
            // lấy tất cả categories
            Pages pages = new Pages(pager);
            //tạo 1 đối tượng pages chứa các trang vừa mới lấy về trong lớp pages chứa các phương thức 
            //xử lý các trang trước khi đưa vào sử dụng
            mm.addAttribute("listCategories", pages);
            return "/Supplier/Categories";
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
            PageRequest pageRequest = new PageRequest(page - 1, 3);
            Page<Shop> pager = shopService.getAllShop(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listShops", pages);
            return "/Supplier/Shops";
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Suplier/deactiveCategory"}, method = RequestMethod.GET)
    public String deactiveCategory(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        Category cate = null;
        try {
            cate = categoriesService.getCategoriesById(id);
            cate.setIsActive(0);
            categoriesService.updateCategories(cate);
            request.setAttribute("page", page);
            mm.addAttribute("messeger", "Khóa thành công");
            return "forward:/Suplier/setupShowAllCategories";

        } catch (Exception e) {
            e.getMessage();
        }
        request.setAttribute("messeger", "Khóa thất bại");
        return "forward:/Suplier/setupShowAllCategories";
    }

    @RequestMapping(value = {"/Suplier/activeCategory"}, method = RequestMethod.GET)
    public String activeCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id
    ) {

        Category cate = null;
        try {
            cate = categoriesService.getCategoriesById(id);
            cate.setIsActive(1);
            categoriesService.updateCategories(cate);
            request.setAttribute("page", page);
            mm.addAttribute("messeger", "Mở khóa thành công");
            return "forward:/Suplier/setupShowAllCategories";

        } catch (Exception e) {
            e.getMessage();
        }
        request.setAttribute("messeger", "Mở khóa thất bại");
        return "forward:/Suplier/setupShowAllCategories";
    }

    @RequestMapping(value = {"/Suplier/addCategory"}, method = RequestMethod.GET)
    public String setupCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", required = false , defaultValue = "1") Integer page
    ) {

        try {
            mm.addAttribute("categories", new Category());
            mm.addAttribute("type", "formadd");
            request.setAttribute("page", page);
        } catch (Exception e) {
            e.getMessage();
        }

        return "forward:/Suplier/setupShowAllCategories";
    }

    @RequestMapping(value = {"/Suplier/addCategory"}, method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", required = false,defaultValue = "1") Integer page,
            @ModelAttribute(value = "categories") Category category
            
    ) {
        Category cate = null;
        try {
           
            categoriesService.addCategories(category);
            request.setAttribute("page", page);
            mm.addAttribute("messeger", "Thêm thành công");
            return "redirect:../";

        } catch (Exception e) {
            e.getMessage();
        }
        request.setAttribute("messeger", "Thêm thất bại");
        return "redirect:./";
    }

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
