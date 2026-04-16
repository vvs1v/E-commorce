package com.ecommerce.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    public String test() {
        return "User Service Working";
    }


    @GetMapping("/") // This matches the trailing slash in /users/
    public String getAllUsers() {
        return "Returning all users from port 8081";
    }

}
