/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import entity.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CartInfo implements Serializable {

  
    private int index;
    private User user;
    private List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
    private double totalPrice;

    //xóa 1 cartline trong cart
    public void removeProduct(Product product) {
        CartLineInfo line = this.findLineByCode(product.getProductId());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

//update số lượng của tất cả line
    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProduct().getProductId(), line.getQuantity());
            }
        }

    }
//tìm 1 cartline thông qua id sp

    private CartLineInfo findLineByCode(int id) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProduct().getProductId() == id) {
                return line;
            }
        }
        return null;
    }
//thêm 1 cartline vào cart

    public void addProduct(Product product, int quantity) {

        try {

            CartLineInfo line = this.findLineByCode(product.getProductId());

            if (line == null) {
                line = new CartLineInfo();
                line.setQuantity(0);
                line.setProduct(product);

                if (product.getStock() >= 5) {
                    line.setNumberCanOrder(5);
                } else {
                    line.setNumberCanOrder(product.getStock());
                }

                this.cartLines.add(line);
            }
            int newQuantity = line.getQuantity() + quantity;
            if (newQuantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(newQuantity);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
//update số lượng sp của 1 cartline trong cart

    public void updateProduct(int code, int quantity) {
        CartLineInfo line = this.findLineByCode(code);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }

    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }
//tính tổng số lượng sp của 1 cart

    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }
//    tính tổng giá của 1 cart

    public double getTotalPrice() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getTotalPrice();
        }
        return total;
    }
//--------------------------------------------------------------------

    
//--------------------------------------------------------------------    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartLineInfo> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLineInfo> cartLines) {
        this.cartLines = cartLines;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
