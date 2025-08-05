package com.example.bai12345.util;

import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static DBConn INSTANCE;
    private static final String URL = "jdbc:mysql://localhost:3306/movie_management";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    private DBConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConn getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBConn();
        }
        return INSTANCE;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
