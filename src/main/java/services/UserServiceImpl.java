/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkEmailExist(String email) throws Exception {
        if (userRepository.findByemail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void add(User user) throws Exception {
       userRepository.save(user);
    }

}
