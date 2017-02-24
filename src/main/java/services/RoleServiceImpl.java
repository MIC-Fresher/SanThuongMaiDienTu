/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoriesRepository;
import repository.*;
import entity.*;
import java.io.Serializable;

@Transactional
@Service
public class RoleServiceImpl implements RoleService,Serializable {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() throws Exception {
        List<Role> list;
        try {
            list = (List<Role>) roleRepository.findAll();
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
