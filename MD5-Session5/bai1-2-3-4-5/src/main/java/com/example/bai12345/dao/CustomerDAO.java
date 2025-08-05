package com.example.bai12345.dao;

import com.example.bai12345.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomers();
    Customer findById(int id);
    Customer findByUserNamePassword(String username, String password);
}
