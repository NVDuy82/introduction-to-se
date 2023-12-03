package com.example.introductiontose;

import com.example.introductiontose.database.SqlConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 * Lớp Application là lớp chính của ứng dụng, thừa kế từ javafx.application.Application.
 * Điều này là lớp khởi động ứng dụng JavaFX và chứa phương thức start() để cấu hình giao diện đồ họa.
 */
public class Application extends javafx.application.Application {
    
    /**
     * Phương thức start() được gọi khi ứng dụng được khởi chạy.
     *
     * @param stage Stage là cửa sổ chính của ứng dụng.
     * @throws IOException Nếu có lỗi khi load file FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load file FXML để cấu hình giao diện
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/hokhau/ho-khau.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/danh-sach-ho-khau.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/qltaikhoan/ql-taikhoan.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Scene scene2 = new Scene(fxmlLoader2.load());
        Scene scene3 = new Scene(fxmlLoader3.load());
        Stage stage2 = new Stage();
        Stage stage3 = new Stage();
        stage2.setScene(scene2);
        stage3.setScene(scene3);
        stage2.show();
        stage3.show();
        
        // Cấu hình Stage với Scene và hiển thị nó
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Phương thức main() là điểm bắt đầu của ứng dụng.
     *
     * @param args Tham số dòng lệnh được truyền vào khi chạy ứng dụng.
     */
    public static void main(String[] args) {
        // Gọi phương thức launch() để bắt đầu ứng dụng
        launch();
    }
}
