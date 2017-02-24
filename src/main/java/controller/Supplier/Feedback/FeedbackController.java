/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Supplier.Feedback;

import entity.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.FeedbackRepository;

@Controller

public class FeedbackController implements Serializable{

    @Autowired
    FeedbackRepository feedbackRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = {"/Supplier/Feedbacks"}, method = RequestMethod.GET)
    public String setupShowAllFeedbacks(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            setupShowFeedbacks(page, mm);

        } catch (Exception e) {
            e.getMessage();
        }
        return "/Supplier/Feedbacks";
    }

    @RequestMapping(value = {"/Supplier/FeedBackDetail"}, method = RequestMethod.GET)
    public String setupShowDetailFeedbacks(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            Feedback feedback = feedbackRepository.findOne(id);
            if (feedback != null) {
                Statusfeedback statusfeedback = feedback.getStatusFeedbackId();
                statusfeedback.setStatusFeedbackId(1);
                feedback.setStatusFeedbackId(statusfeedback);
                feedbackRepository.save(feedback);
                mm.addAttribute("feedBackForm", feedback);
            } else {
                mm.addAttribute("messeger", "Có lỗi xảy ra ");
            }
        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Có lỗi xảy ra ");
        }
        return "/Supplier/Feedback_Detail";
    }

    @RequestMapping(value = {"/Supplier/FeedBackDetail"}, method = RequestMethod.POST)
    public String updateDetailFeedbacks(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            @ModelAttribute(value = "feedBackForm") Feedback feedback,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {

        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/Supplier/Feedbacks";
    }

    @RequestMapping(value = {"/Supplier/deleteFeedBack"}, method = RequestMethod.GET)
    public String deleteFeedbacks(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "searchinput", defaultValue = "", required = false) String searchinput,
            HttpServletRequest request, HttpSession session, ModelMap mm) {

        try {
            Feedback feedback = feedbackRepository.findOne(id);
            if (feedback != null) {
                feedbackRepository.delete(id);
            } else {
                mm.addAttribute("messeger", "Có lỗi xảy ra ");
            }

        } catch (Exception e) {
            e.getMessage();
            mm.addAttribute("messeger", "Có lỗi xảy ra ");
        }
        return "redirect:/Supplier/Feedbacks";
    }

//-----------------------------------------------------------------------------------------------------------
    public void setupShowFeedbacks(Integer page, ModelMap mm) {
        PageRequest pageRequest;
        try {
            pageRequest = new PageRequest(page - 1, 3, Sort.Direction.DESC, "CreateDate");

            Page<Feedback> pager = feedbackRepository.findAll(pageRequest);
            Pages pages = new Pages(pager);
            mm.addAttribute("listFeedbacks", pages);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
