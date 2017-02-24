/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Shops;

import entity.Category;
import entity.Product;
import entity.Role;
import entity.Shop;
import entity.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Mail;
import model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repository.CategoriesRepository;
import repository.ShopRepository;
import services.CategoriesService;
import services.RoleService;
import services.ShopService;
import services.UserService;
import utils.*;
import utils.Mail.MailUtilGmail;
import utils.Number.RandomInt;

@Controller

public class SupplierShopsController implements Serializable {

    @Autowired
    MailUtilGmail mailUtilGmail;
    @Autowired
    Mail mail;
    @Autowired
    RandomInt randomInt;
    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
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
        return "/Supplier/Shop_Detail";
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

        return "/Supplier/Shop_Detail";
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
        return "/Supplier/Shop_Detail";
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
        return "/Supplier/Shop_Detail";
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
        return "/Supplier/Shop_Detail";
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
        return "/Supplier/Shop_Detail";
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

    @RequestMapping(value = {"/Supplier/AddShop"}, method = RequestMethod.GET)
    public String setupaddShop(
            HttpServletRequest request, HttpSession session, ModelMap mm) {
        try {
            mm.addAttribute("shop", new Shop());
        } catch (Exception e) {
            e.getMessage();
        }
        return "Supplier/AddShop";
    }

    @Transactional
    @RequestMapping(value = {"/Supplier/AddShop"}, method = RequestMethod.POST)
    public String AddShop(
            HttpServletRequest request, HttpSession session, ModelMap mm,
            @ModelAttribute(value = "shop") Shop shop, RedirectAttributes redirectAttrs
    ) {
        try {

            shop.getUserId().setPassWord(randomInt.rand(100, 10000).toString());
            shop = shopService.addShop(shop);

            boolean result = mail.sendEmailToShop(shop);
            if (result) {
                redirectAttrs.addFlashAttribute("messeger", "Thêm thành công");
            } else {
                redirectAttrs.addFlashAttribute("messeger", "Có lỗi trong quá trình gửi mail");
            }
        } catch (Exception e) {
            e.getMessage();
            redirectAttrs.addFlashAttribute("messeger", "Có lỗi trong quá trình thực thi");
        }
        return "redirect:/Supplier/Shops";
    }
//------------------------------------------------------------------------------------------

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

        try {
            // get shop
            shop = shopService.getShopById(id);
            //setup categories of shop
            List<Category> categoriesShop = shop.getCategoryList();

            if (categoriesShop != null && categoriesShop.size() > 0) {
                for (int i = 0; i < categoriesShop.size(); i++) {
                    List<Product> products = categoriesShop.get(i).getProductList();
                    if (products != null && products.size() > 0) {
                        for (int j = products.size()-1; j >=0 ; j--) {
                            if (products.get(j).getShopId().getShopId() != shop.getShopId()) {
                                products.remove(j);
                             
                            }
                        }

                    }
                    categoriesShop.get(i).setProductList(products);
                }

            }
            mm.addAttribute("listCategories", categoriesShop);
            //setup role
            setupRoleShop(mm, shop);
            //setup shop detail
            mm.addAttribute("shopDetail", shop);
            // set up categories
            mm.addAttribute("listAllCategories", categoriesService.getAllCategories());
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
}
