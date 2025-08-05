package com.example.bai12345.dao.Impl;

import com.example.bai12345.dao.CustomerDAO;
import com.example.bai12345.model.Customer;
import com.example.bai12345.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer findById(int id) {
        String sql = "{CALL get_customer_by_id(?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customer.setPhone(rs.getString("phone"));
                customer.setGender(rs.getString("gender"));
                customer.setRole(Customer.Role.valueOf(rs.getString("role")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "{CALL get_all_customer()}";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customer.setPhone(rs.getString("phone"));
                customer.setGender(rs.getString("gender"));
                customer.setRole(Customer.Role.valueOf(rs.getString("role")));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findByUserNamePassword(String username, String password) {
        String sql = "{CALL get_customer_by_username_and_password(?,?)}";
        try (Connection connection = DBConn.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
