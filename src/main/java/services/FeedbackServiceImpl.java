/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoriesRepository;
import repository.*;

@Transactional
@Service
public class FeedbackServiceImpl implements FeedbackService, Serializable {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public Page<Feedback> getAllFeedback(Pageable pageable) throws Exception {

        try {
            return feedbackRepository.findAll(pageable);
        } catch (Exception e) {
        }
        return null;
    }

    @Transactional
    @Override
    public Feedback addFeedBack(Feedback feedback, User user) throws Exception {

        try {
            Statusfeedback statusfeedback = new Statusfeedback();
            statusfeedback.setStatusFeedbackId(2);
            feedback.setUserId(user);
            feedback.setCreateDate(new Date());
            feedback.setStatusFeedbackId(statusfeedback);

            return feedbackRepository.save(feedback);
        } catch (Exception e) {
            e.getMessage();

        }
        return null;
    }

}
