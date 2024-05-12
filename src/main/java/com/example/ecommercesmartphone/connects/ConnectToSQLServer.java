package com.example.ecommercesmartphone.connects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToSQLServer {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiDienThoai;encrypt=true;trustServerCertificate=true";
    private static final String JDBC_USERNAME = "";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws RuntimeException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
