package com.example.introductiontose;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view/ThuPhi,Thongtin/Scence1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        
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
