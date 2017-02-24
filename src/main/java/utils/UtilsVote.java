/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Orders;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import model.CartInfo;
import model.VoteForm;

public class UtilsVote {

    public static List<Product> getProductsAfterVote(CartInfo orderCart, VoteForm voteForm) {

        if (orderCart != null && !orderCart.getCartLines().isEmpty() && voteForm != null) {
            for (int i = orderCart.getCartLines().size() - 1; i >= 0; i--) {
                if (orderCart.getCartLines().get(i).getProduct().getProductId() == voteForm.getProductId()) {
                    orderCart.getCartLines().remove(i);
                }
            }

            List<Product> products = new ArrayList<>();
            for (int i = 0; i < orderCart.getCartLines().size(); i++) {
                products.add(orderCart.getCartLines().get(i).getProduct());
            }
            return products;
        } else {
            return null;
        }

    }
}
