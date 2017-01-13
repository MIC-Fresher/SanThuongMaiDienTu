/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.springframework.ui.ModelMap;

/**
 *
 * @author Admin
 */
public class ParameterUrlPulic {

    String categoryname = "";
    Integer itemperpage;
    String shopname="";
    Integer fromprice;
    Integer toprice;
    Integer totalvote;
    String searchinput = "";
    ModelMap mm;
    String url = "";

    public ParameterUrlPulic(ModelMap mm) {
        this.mm = mm;
    }

    public ParameterUrlPulic() {
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
        mm.addAttribute("categoryname", categoryname);
    }

    public Integer getItemperpage() {
        return itemperpage;
    }

    public void setItemperpage(Integer itemperpage) {
        this.itemperpage = itemperpage;
        mm.addAttribute("itemperpage", itemperpage);
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
        mm.addAttribute("shopname", shopname);
    }

    public Integer getFromprice() {
        return fromprice;
    }

    public void setFromprice(Integer fromprice) {
        this.fromprice = fromprice;
        mm.addAttribute("fromprice", fromprice);
    }

    public Integer getToprice() {
        return toprice;
    }

    public void setToprice(Integer toprice) {
        this.toprice = toprice;
        mm.addAttribute("toprice", toprice);
    }

    public Integer getTotalvote() {
        return totalvote;
    }

    public void setTotalvote(Integer totalvote) {
        this.totalvote = totalvote;
        mm.addAttribute("totalvote", totalvote);
    }

    public String getSearchinput() {
        return searchinput;
    }

    public void setSearchinput(String searchinput) {
        this.searchinput = searchinput;
        mm.addAttribute("searchinput", searchinput);
    }

    @Override
    public String toString() {

        url = url + "searchinput=" + searchinput;

        if (this.itemperpage != null) {

            url = url + "&itemperpage=" + this.itemperpage;
        }
        if (this.fromprice != null) {
            url = url + "&fromprice=" + fromprice;

        }
        if (this.toprice != null) {
            url = url + "&toprice=" + toprice;

        }
        if (this.totalvote != null) {
            url = url + "&totalvote=" + totalvote;

        }
        if (!this.categoryname.equals("")) {
            url = url + "&categoryname=" + categoryname;

        }
        if (!this.shopname.equals("")) {
            url = url + "&shopname=" + shopname;

        }

        try {
            return url;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
