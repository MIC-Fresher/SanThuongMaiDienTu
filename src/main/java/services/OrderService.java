/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Orders;
import entity.Receiver;
import entity.User;
import model.CartInfo;

/**
 *
 * @author Admin
 */
public interface OrderService {

    public boolean addOrder(Receiver receiver, User user, CartInfo cartInfo);
    public Orders updateOrder(Orders order);
}
