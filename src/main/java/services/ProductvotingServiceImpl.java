/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Productvoting;
import java.io.Serializable;
import java.util.Date;
import model.VoteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductsRepository;
import repository.ProductvotingRepository;
import repository.UserRepository;
import entity.Product;
import entity.User;
import org.springframework.stereotype.Service;
import entity.Orders;

@Service
public class ProductvotingServiceImpl implements ProductvotingService, Serializable {

    @Autowired
    ProductvotingRepository productvotingRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    //insert 1 record vào bảng vote với dữ liệu lấy từ voteform
    public Productvoting addVote(VoteForm voteForm) throws Exception {

        Productvoting productvoting = new Productvoting();
        Product product = productsRepository.findOne(voteForm.getProductId());
        User user = userRepository.findOne(voteForm.getUserId());
        try {
            if (product == null || user == null) {
                return null;
            } else {
                productvoting.setDateCreated(new Date());
                productvoting.setProductId(product);
                productvoting.setMark(voteForm.getMarkVote());
                productvoting.setUserId(user);

                product.setTotalVote((product.getTotalVote() + voteForm.getMarkVote()) / 2);
                productsRepository.save(product);
                return productvotingRepository.save(productvoting);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
