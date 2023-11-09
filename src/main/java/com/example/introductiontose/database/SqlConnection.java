package com.example.introductiontose.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConnection {
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/ten_cua_database";
        String username = "ten_nguoi_dung";
        String password = "mat_khau";
        
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", "true"); // Enable SSL
        properties.setProperty("requireSSL", "true"); // Require SSL
        properties.setProperty("verifyServerCertificate", "true");  // Verify server's certificate
        
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(url, properties);
            System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
        
        return connection;
    }
}
