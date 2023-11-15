package com.example.introductiontose.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Lớp SqlConnection cung cấp phương thức để kết nối đến cơ sở dữ liệu MySQL.
 */
public class SqlConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/ten_cua_database";
    private final static String USERNAME = "ten_nguoi_dung";
    private final static String PASSWORD = "mat_khau";
    
    /**
     * Phương thức này tạo và trả về một đối tượng Connection để kết nối đến cơ sở dữ liệu MySQL.
     *
     * @return Đối tượng Connection cho kết nối đến cơ sở dữ liệu.
     */
    public static Connection connect() {
        // Tạo đối tượng Properties để cấu hình kết nối.
        Properties properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("useSSL", "true"); // Enable SSL
        properties.setProperty("requireSSL", "true"); // Require SSL
        properties.setProperty("verifyServerCertificate", "true");  // Verify server's certificate
        
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, properties);
            System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
        
        return connection;
    }
}
