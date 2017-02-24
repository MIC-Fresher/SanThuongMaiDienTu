/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Productvoting;
import model.VoteForm;

/**
 *
 * @author Admin
 */
public interface ProductvotingService {
    public Productvoting addVote(VoteForm voteForm) throws Exception;
}
