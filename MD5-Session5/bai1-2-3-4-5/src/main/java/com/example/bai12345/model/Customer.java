package com.example.bai12345.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String gender;
    private String email;

    private Role role;

    public static enum Role {
        ADMIN, USER
    }

}
