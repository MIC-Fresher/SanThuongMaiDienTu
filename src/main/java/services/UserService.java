/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.util.List;
public interface UserService {
    public boolean checkAccountExist(String username , String email) throws Exception;
    public User add(User user) throws Exception;
    public List<User> getUser(String username, String email) throws Exception;
    public void updateUser(User user) throws Exception;
    int deleteRoleOfUser(int idrole , int iduser)throws Exception;
    int addRoleToUser(int idrole , int iduser)throws Exception;
}
