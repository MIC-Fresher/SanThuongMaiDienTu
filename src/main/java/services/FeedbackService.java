/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Category;
import entity.Feedback;
import entity.User;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;

public interface FeedbackService {

    public Page<Feedback> getAllFeedback(Pageable pageable) throws Exception;
    
    public Feedback addFeedBack(Feedback feedback,User user)throws Exception;
}
