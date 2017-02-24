/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Product;
import entity.Productcomment;
import entity.Productvoting;
import entity.Statuscomment;
import entity.User;
import java.io.Serializable;
import java.util.Date;
import model.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductcommentRepository;
import repository.ProductsRepository;
import repository.StatuscommentRepository;
import repository.UserRepository;

@Service
public class ProductcommentServiceImpl implements ProductcommentService, Serializable {

    @Autowired
    ProductcommentRepository productcommentRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    StatuscommentRepository statuscommentRepository;

    @Transactional
    @Override
    public Productcomment addComment(CommentForm commentForm) throws Exception {
        Productcomment productcomment = new Productcomment();

        Product product = productsRepository.findOne(commentForm.getProductId());
        User user = userRepository.findOne(commentForm.getUserId());

        try {
            if (product == null || user == null) {
                return null;
            } else {
                Statuscomment statuscomment = statuscommentRepository.findOne(3);

                productcomment.setDateCreated(new Date());
                productcomment.setProductId(product);
                productcomment.setUserId(user);
                productcomment.setContent(commentForm.getCommentContent());
                productcomment.setStatusCommentId(statuscomment);

                return productcommentRepository.save(productcomment);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
