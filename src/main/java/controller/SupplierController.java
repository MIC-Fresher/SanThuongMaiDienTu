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
import services.*;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.*;
import java.util.List;
import java.util.Map;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;
import repository.*;

@Controller
@Scope("session")

public class SupplierController implements Serializable {

    public Category listcata;
    public Shop shop;
    Pages test1;
    Role role;

    Feedback Feedback;
    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = {"/Supplier/SupplierIndex"}, method = RequestMethod.GET)
    public String LoginAdm(HttpServletRequest request, HttpSession session) throws Exception {
        
        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/SupplierIndex";
    }

//    ============================================================================category====>>
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

//    ============================================================================shop====>>
    @RequestMapping(value = {"/Supplier/deactiveShop"}, method = RequestMethod.GET)
    public String deactiveShop(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {

            deactiveShop(id, mm);
            searchShop(searchinput, mm, page);

        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/setupShowDetailShop"}, method = RequestMethod.GET)
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

    @RequestMapping(value = {"/Supplier/activeShop"}, method = RequestMethod.GET)
    public String activeShop(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            activeShop(id, mm);
            searchShop(searchinput, mm, page);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/deleteCategoriesOfShop"}, method = RequestMethod.GET)
    public String deleteCategoriesOfShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "idcategory", required = false) Integer idcategory,
            @RequestParam(value = "idshop", required = false) Integer idshop
    ) {

        try {

            deleteCategoriesOfShop(idcategory, idshop, mm);
            setupShowDetailShop(idshop, mm);
        } catch (Exception e) {
            e.getMessage();
        }

        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/addCatogoryToShop"}, method = RequestMethod.GET)
    public String addCatogoryToShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "idshop", required = false) Integer idshop
    ) {
        try {
            mm.addAttribute("shopCategory", new Category());
            mm.addAttribute("type", "formaddsc");
            setupShowDetailShop(idshop, mm);
        } catch (Exception e) {
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/addCatogoryToShop"}, method = RequestMethod.POST)
    public String addCatogoryToShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "idshop", required = false) Integer idshop,
            @ModelAttribute(value = "shopCategory") Category category
    ) {
        try {
            addCatogoryToShop(category.getCategoryId(), idshop, mm);
            setupShowDetailShop(idshop, mm);
        } catch (Exception e) {
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/addRoleForShop"}, method = RequestMethod.POST)
    public String addRoleForShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "idshop", required = false) Integer idshop,
            @ModelAttribute(value = "role") Role role
    ) {
        Shop s;
        try {
            s = shopService.getShopById(idshop);
            addRoleForShop(role.getRoleId(), s.getUserId().getUserId(), mm);
            setupShowDetailShop(idshop, mm);
        } catch (Exception e) {
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/deleteRoleShop"}, method = RequestMethod.GET)
    public String deleteRoleShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "idshop", required = false) Integer idshop,
            @RequestParam(value = "idrole", required = false) Integer idrole
    ) {

        try {
            deleteRoleShop(idrole, shopService.getShopById(idshop).getUserId().getUserId(), mm);
            setupShowDetailShop(idshop, mm);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Shops";
    }

    @RequestMapping(value = {"/Supplier/searchShop"}, method = RequestMethod.GET)
    public String searchShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            searchShop(searchinput, mm, page);
        } catch (Exception e) {
        }
        return "/Supplier/Shops";
    }
//    ============================================================================feedback====>>

    @RequestMapping(value = {"/Supplier/setupShowAllFeedbacks"}, method = RequestMethod.GET)
    public String setupShowAllFeedbacks(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowFeedbacks(page, mm);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Feedbacks";
    }
//    ============================================================================products====>>

    @RequestMapping(value = {"/Supplier/searchProducts"}, method = RequestMethod.GET)
    public String searchProducts(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {

            searchProducts(searchinput, mm, page);
        } catch (Exception e) {
        }
        return "/Supplier/Products";
    }
//    =====================================*****METHOD****============================================================>>
//    ============================================================================category====>>

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
//    ============================================================================shop====>>

    public void searchShop(String search, ModelMap mm, int page) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3);
            Page<Shop> pager = shopService.getShopByInput(pageRequest, search, search, search, search, search);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchShops", pages);
            mm.addAttribute("searchinput", search);
        } catch (Exception e) {
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

            mm.addAttribute("messeger", "Mở khóa thành công");
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Mở khóa thất bại");
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

    public void setupShowDetailShop(Integer id, ModelMap mm) {

        Shop shop = null;

        List<Category> listAllCategories = new ArrayList<>();
        try {
            shop = shopService.getShopById(id);
            listAllCategories = categoriesService.getAllCategories();
            setupRoleShop(mm, shop);
            mm.addAttribute("listCategories", shop.getCategoryList());
            mm.addAttribute("shopDetail", shop);
            mm.addAttribute("listAllCategories", listAllCategories);
        } catch (Exception e) {
        }
    }

    public void setupRoleShop(ModelMap mm, Shop shop) {
        List<Role> listRole;
        List<Role> listRoleofShop = new ArrayList<>();

        try {
            listRole = roleService.getAllRole();
            listRoleofShop = shop.getUserId().getRoleList();

            mm.addAttribute("role", new Role());
            mm.addAttribute("listRole", listRole);

            mm.addAttribute("listRoleofShop", listRoleofShop);

        } catch (Exception e) {
        }

    }

    public void deleteCategoriesOfShop(Integer idcategory, Integer idshop, ModelMap mm) {
        try {
            int kq = categoriesService.deleteCategoryFromShop(idcategory, idshop);
            if (kq != 0) {
                mm.addAttribute("messeger", "xóa thành công");
            } else {
                mm.addAttribute("messeger", "xóa thất bại");
            }
        } catch (Exception e) {
        }
    }

    public void addCatogoryToShop(Integer idcategory, Integer idshop, ModelMap mm) {

        try {
            int kq = categoriesService.addCategoryToShop(idcategory, idshop);
            if (kq != 0) {
                mm.addAttribute("messeger", "thêm thành công");
            } else {
                mm.addAttribute("messeger", "thêm thất bại");
            }
        } catch (Exception e) {
        }
    }

    public void addRoleForShop(Integer idrole, Integer iduser, ModelMap mm) {

        try {
            int kq = userService.addRoleToUser(idrole, iduser);
            if (kq != 0) {
                mm.addAttribute("messeger", "thêm thành công");
            } else {
                mm.addAttribute("messeger", "thêm thất bại");
            }
        } catch (Exception e) {
        }
    }

    public void deleteRoleShop(Integer idrole, Integer iduser, ModelMap mm) {
        try {
            int kq = userService.deleteRoleOfUser(idrole, iduser);
            if (kq != 0) {
                mm.addAttribute("messeger", "xóa thành công");
            } else {
                mm.addAttribute("messeger", "xóa thất bại");
            }
        } catch (Exception e) {
        }
    }
//    ============================================================================feedback====>>

    public void setupShowFeedbacks(Integer page, ModelMap mm) {
        PageRequest pageRequest;
        try {
            pageRequest = new PageRequest(page - 1, 3);
            Page<Feedback> pager = feedbackRepository.findAll(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listFeedbacks", pages);
        } catch (Exception e) {
            e.getMessage();
        }
    }
//    ============================================================================products====>>

    public void searchProducts(String search, ModelMap mm, int page) {

        try {
            PageRequest pageRequest;
            pageRequest = new PageRequest(page - 1, 3, Sort.Direction.DESC, "dateCreated");
            Page<Product> pager = productsRepository.findByShopId_ShopIdAndProductNameContaining(pageRequest, null, search);
            Pages pages = new Pages(pager);
            mm.addAttribute("listSearchProducts", pages);
            mm.addAttribute("searchinput", search);
//            mm.addAttribute("page", page);
        } catch (Exception e) {
        }
    }
//    =======================================***GET/SET***=====================================================>>

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Feedback getFeedback() {
        return Feedback;
    }

}
