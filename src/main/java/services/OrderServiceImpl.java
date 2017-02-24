/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CartInfo;
import model.CartLineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoriesRepository;
import repository.OrdersRepository;
import repository.*;
import utils.*;

@Transactional
@Service
public class OrderServiceImpl implements OrderService, Serializable {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    CloneObject cloneObject;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    OrderdetailRepository orderdetailRepository;
    @Autowired
    StatusorderRepository statusorderRepository;
    @Autowired
    ReceiverRepository receiverRepository;

    @Transactional
    public boolean addOrder(Receiver receiver, User user, CartInfo cartInfo) {

        Statusorder statusOrder = statusorderRepository.findOne(4);
        CartInfo cartInfoTemp;

        try {
            cartInfoTemp = (CartInfo) cloneObject.clone(cartInfo);
            for (int i = 0; i < cartInfoTemp.getCartLines().size(); i++) {
                Orders order = new Orders();
                Receiver newReceiver = new Receiver();
                newReceiver.setReceiverAddress(receiver.getReceiverAddress());
                newReceiver.setReceiverName(receiver.getReceiverName());
                newReceiver.setReceiverPhone(receiver.getReceiverPhone());
                newReceiver = receiverRepository.save(newReceiver);
                order.setOrderDate(new Date());
                order.setUpdateDate(null);
                order.setReceiverId(newReceiver);
                order.setStatusOrderId(statusOrder);
                order.setUserId(user);

                order = ordersRepository.save(order);
                double totalprice = cartInfoTemp.getCartLines().get(i).getTotalPrice();
                Orderdetail orderdetail = new Orderdetail();
                orderdetail.setOrderId(order);
                orderdetail.setProductId(cartInfoTemp.getCartLines().get(i).getProduct());
                orderdetail.setQuantity(cartInfoTemp.getCartLines().get(i).getQuantity());
                orderdetail.setTotalUnitPrice(cartInfoTemp.getCartLines().get(i).getTotalPrice());

                orderdetailRepository.save(orderdetail);
                for (int h = i + 1; h < cartInfoTemp.getCartLines().size(); h++) {
                    if (cartInfoTemp.getCartLines().get(i).getProduct().getShopId().getShopName().equals(cartInfoTemp.getCartLines().get(h).getProduct().getShopId().getShopName())) {
                        Orderdetail orderdetail1 = new Orderdetail();
                        orderdetail1.setOrderId(order);
                        orderdetail1.setProductId(cartInfoTemp.getCartLines().get(h).getProduct());
                        orderdetail1.setQuantity(cartInfoTemp.getCartLines().get(h).getQuantity());
                        orderdetail1.setTotalUnitPrice(cartInfoTemp.getCartLines().get(h).getTotalPrice());

                        orderdetailRepository.save(orderdetail1);
                        totalprice = totalprice + cartInfoTemp.getCartLines().get(h).getTotalPrice();
                        cartInfoTemp.getCartLines().remove(h);
                        h--;
                    }
                }

                order.setTotalPrice(totalprice);
                order = ordersRepository.save(order);

            }

            return true;

        } catch (Exception e) {
            e.getMessage();
        } finally {
            cartInfoTemp = null;
        }
        return false;
    }

    @Transactional
    @Override
    public Orders updateOrder(Orders order) {

        try {
            Orders newOrder = ordersRepository.findOne(order.getOrderId());

            //setup receiver
            Receiver receiver = order.getReceiverId();

            //setup order
            if (order.getUpdateDate() != null && order.getUpdateDate().before(newOrder.getOrderDate())) {
                return null;
            }
            newOrder.setUpdateDate(order.getUpdateDate());
            newOrder.setTotalPrice(order.getTotalPrice());
            newOrder.setStatusOrderId(order.getStatusOrderId());

            //set orderdetal
            List<Orderdetail> orderDetails = newOrder.getOrderdetailList();
            double totalprice = 0;
            for (int i = 0; i < orderDetails.size(); i++) {
                Product product = orderDetails.get(i).getProductId();
                if (order.getOrderdetailList().get(i).getQuantity() <= product.getStock()) {
                    if (order.getStatusOrderId().getStatusOrderId() == 2) {
                        product.setStock(product.getStock() - order.getOrderdetailList().get(i).getQuantity());
                        productsRepository.save(product);
                    }
                } else {
                    return null;
                }

                orderDetails.get(i).setQuantity(order.getOrderdetailList().get(i).getQuantity());
                orderDetails.get(i).setTotalUnitPrice(
                        (double) order.getOrderdetailList().get(i).getQuantity() * newOrder.getOrderdetailList().get(i).getProductId().getUnitPrice());

                totalprice += orderDetails.get(i).getTotalUnitPrice();
            }

            newOrder.setTotalPrice(totalprice);
            newOrder.setOrderdetailList(orderDetails);

            newOrder = ordersRepository.save(newOrder);
            receiverRepository.save(receiver);
            return newOrder;

        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }
}
