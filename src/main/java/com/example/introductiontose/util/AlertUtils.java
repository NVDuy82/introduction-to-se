package com.example.introductiontose.util;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class AlertUtils {
    public static void showAlert(String title, String content) {
        // Tạo thông báo
        Alert alert = createAlert(title, content);
        
        // Hiển thị
        alert.showAndWait();
    }
    
    public static void showAlert(String title, String content, ImageView imageView) {
        // Tạo thông báo
        Alert alert = createAlert(title, content);
        
        // Thêm icon cho Alert
        alert.getDialogPane().setGraphic(imageView);
        
        // Hiển thị
        alert.showAndWait();
    }
    
    private static Alert createAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        
        // Xóa mọi phần tử không cần thiết
        alert.getDialogPane().getButtonTypes().clear();
        
        // Thêm nút "OK"
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(okButton);
        
        // Tăng kích thước của cửa sổ để vừa với nội dung
        Node graphic = alert.getDialogPane().getGraphic();
        if (graphic instanceof Region) {
            ((Region) graphic).setMaxHeight(Double.MAX_VALUE);
            ((Region) graphic).setMaxWidth(Double.MAX_VALUE);
        }
        
        return alert;
    }
}
