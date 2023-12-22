package com.example.introductiontose;

import com.example.introductiontose.controller.user.hokhau.DSNhanKhauController;
import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.util.SQLUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

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
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/dangkydangnhap/dangNhap.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/admin/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
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
