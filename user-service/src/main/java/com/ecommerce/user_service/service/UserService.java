package com.ecommerce.user_service.service;


import com.ecommerce.user_service.dao.UserRepo;
import com.ecommerce.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user){
        return repo.save(user);
    }

}
