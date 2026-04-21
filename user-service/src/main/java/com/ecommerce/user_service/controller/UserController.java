package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.UserServiceApplication;
import com.ecommerce.user_service.model.User;
import com.ecommerce.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String test() {
        return "User Service Working";
    }


    @GetMapping("/") // This matches the trailing slash in /users/
    public String getAllUsers() {
        return "Returning all users from port 8081";
    }

    @PostMapping("/users/register")
    public User register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userService.saveUser(user);
//        return user;
    }

}
