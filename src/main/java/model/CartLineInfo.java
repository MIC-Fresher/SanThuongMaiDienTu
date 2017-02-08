/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;

/**
 *
 * @author Admin
 */
public class CartLineInfo {

    private Product product;
    private int quantity;
    private double totalPrice;
    private int NumberCanOrder;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getUnitPrice() * this.quantity;
    }

    public int getNumberCanOrder() {
        return NumberCanOrder;
    }

    public void setNumberCanOrder(int NumberCanOrder) {
        this.NumberCanOrder = NumberCanOrder;
    }

    

}
