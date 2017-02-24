/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Categories;

import entity.Category;
import entity.Product;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CategoriesRepository;
import services.CategoriesService;

@Controller

public class SupplierCategoriesController implements Serializable{

    @Autowired
    CategoriesService categoriesService;
    @Autowired
    CategoriesRepository categoriesRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
    @RequestMapping(value = {"/Supplier/deactiveCategory"}, method = RequestMethod.GET)
    public String deactiveCategory(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            deactiveCategory(id, mm);
            searchCategory(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Supplier/activeCategory"}, method = RequestMethod.GET)
    public String activeCategory(HttpServletRequest request,
            HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {

            activeCategory(id, mm);
            searchCategory(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Supplier/addCategory"}, method = RequestMethod.GET)
    public String setupCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {
            searchCategory(searchinput, mm, page);

            mm.addAttribute("categories", new Category());
            mm.addAttribute("type", "formadd");
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Supplier/addCategory"}, method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @ModelAttribute(value = "categories") Category category,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {
            addCategory(mm, category);
            searchCategory(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Supplier/updateCategory"}, method = RequestMethod.GET)
    public String updateCategory(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {
            searchCategory(searchinput, mm, page);

            mm.addAttribute("categories", categoriesService.getCategoriesById(id));
            mm.addAttribute("type", "formupdate");
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Supplier/updateCategory"}, method = RequestMethod.POST)
    public String updateCategory(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @ModelAttribute(value = "categories") Category category,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput
    ) {

        try {
            updateCategory(mm, category);
            searchCategory(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Categories";
    }

    @RequestMapping(value = {"/Supplier/searchCategory"}, method = RequestMethod.GET)
    public String searchCategory(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            searchCategory(searchinput, mm, page);
        } catch (Exception e) {
        }
        return "/Supplier/Categories";
    }

    public void addCategory(ModelMap mm, Category category) {

        try {
            List<Product> lp = new ArrayList<>();
            category.setProductList(lp);
            categoriesService.addCategories(category);
            mm.addAttribute("messeger", "Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Thêm thất bại");
        }

    }

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

    public void updateCategory(ModelMap mm, Category category) {
        Category cate = null;
        try {
            categoriesService.updateCategories(category);
            mm.addAttribute("messeger", "Cập nhật thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Cập nhật thất bại");
        }

    }

    public void searchCategory(String search, ModelMap mm, int page) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3);
            Page<Category> pager = categoriesService.getCategoriesByInput(pageRequest, search);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchCategories", pages);
            mm.addAttribute("searchinput", search);
            //mm.addAttribute("page", page);
        } catch (Exception e) {
        }
    }
}
