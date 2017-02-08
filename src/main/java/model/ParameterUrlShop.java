/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ParameterUrlShop {

    Integer itemperpage;
    String searchinput = "";

    public Integer getItemperpage() {
        return itemperpage;
    }

    public void setItemperpage(Integer itemperpage) {
        this.itemperpage = itemperpage;
    }

    public String getSearchinput() {
        return searchinput;
    }

    public void setSearchinput(String searchinput) {
        this.searchinput = searchinput;
    }

    @Override
    public String toString() {

        String url = "searchinput=" + searchinput;

        if (this.itemperpage != null) {

            url = url + "&itemperpage=" + this.itemperpage;
        }

        try {
            return url;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
