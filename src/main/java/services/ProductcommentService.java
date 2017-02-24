/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Productcomment;
import model.CommentForm;

/**
 *
 * @author Admin
 */
public interface ProductcommentService {
    public Productcomment addComment(CommentForm commentForm) throws Exception;
}
