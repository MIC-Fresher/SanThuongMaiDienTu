/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.User;
import java.util.List;
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
    public boolean checkAccountExist(String username, String email) throws Exception {
        if (userRepository.findByUserNameOrEmail(username, email).size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User add(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userRepository.save(user);

    }

    @Override
    public int deleteRoleOfUser(int idrole, int iduser) throws Exception {
        return userRepository.deleteRU(idrole, iduser);
    }

    @Override
    public int addRoleToUser(int idrole, int iduser) throws Exception {
        return userRepository.addRU(idrole, iduser);
    }

    @Override
    public List<User> getUser(String username, String email) throws Exception {
        return userRepository.findByUserNameOrEmail(username, email);
    }

}
