package com.ecommerce.user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

//    public String getusername;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String username;
    private String password;
    private String role;
//
//    public User(String role) {
//        this.role = role;
//    }
}
