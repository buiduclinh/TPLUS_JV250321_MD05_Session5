package com.example.bai12345.controller;

import com.example.bai12345.dao.CustomerDAO;
import com.example.bai12345.dao.Impl.CustomerDAOImpl;
import com.example.bai12345.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    CustomerDAO customerDAO;

    public LoginServlet() {
        customerDAO = new CustomerDAOImpl();
    }

    public void getAllCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerDAO.getAllCustomers();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            Customer customer = customerDAO.findByUserNamePassword(req.getParameter("username"), req.getParameter("password"));
            if (customer != null) {
                req.setAttribute("customer", customer);
                req.getRequestDispatcher("view/listMovie.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("view/error.jsp").forward(req, resp);
            }
        }
    }
}
