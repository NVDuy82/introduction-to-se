package com.example.introductiontose.view.icon;

import com.example.introductiontose.model.NhanKhau;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class IconUtils {
    public static Button createButtonIcon(IconType iconType, NhanKhau nhanKhau, List<IconController> iconControllerList, Consumer<IconController> eventClickIcon) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IconUtils.class.getResource("/com/example/introductiontose/view/icon/ho-khau-icon.fxml"));
        Button button = fxmlLoader.load();
        HBox.setMargin(button, new Insets(10));
        
        // Lấy controller từ fxmlLoader
        IconController iconController = fxmlLoader.getController();
        iconControllerList.add(iconController);
        
        // Set event click cho button
        button.setOnMouseClicked(event -> {
            iconController.setSelected(!iconController.isSelected());
            eventClickIcon.accept(iconController);
        });
        
        // Truyền dữ liệu cho controller
        iconController.setIconType(iconType);
        iconController.setNhanKhau(nhanKhau);
        
        return button;
    }
    
}
