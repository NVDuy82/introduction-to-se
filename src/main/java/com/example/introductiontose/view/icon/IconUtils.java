package com.example.introductiontose.view.icon;

import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhau;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class IconUtils {
    public static Button createButtonIcon(IconType iconType, NhanKhau nhanKhau, List<IconNhanKhauController> iconNhanKhauControllerList, Consumer<IconNhanKhauController> eventClickIcon) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IconUtils.class.getResource("/com/example/introductiontose/view/icon/ho-khau-icon.fxml"));
        
        // Tạo controller và set controller cho fxmlLoader
        IconNhanKhauController iconNhanKhauController = new IconNhanKhauController();
        fxmlLoader.setController(iconNhanKhauController);
        iconNhanKhauControllerList.add(iconNhanKhauController);
        
        // Load fxml
        Button button = fxmlLoader.load();
        HBox.setMargin(button, new Insets(10));
        
        // Set event click cho button
        button.setOnMouseClicked(event -> {
            iconNhanKhauController.setSelected(!iconNhanKhauController.isSelected());
            eventClickIcon.accept(iconNhanKhauController);
        });
        
        // Truyền dữ liệu cho controller
        iconNhanKhauController.setIconType(iconType);
        iconNhanKhauController.setData(nhanKhau);
        
        return button;
    }
    
    public static Button createButtonIcon(NhanKhau nhanKhau, Consumer<NhanKhau> eventClickIcon) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IconUtils.class.getResource("/com/example/introductiontose/view/icon/ho-khau-icon.fxml"));
        
        // Tạo controller và set controller cho fxmlLoader
        IconNhanKhauController iconNhanKhauController = new IconNhanKhauController();
        fxmlLoader.setController(iconNhanKhauController);
        
        // Load fxml
        Button button = fxmlLoader.load();
        HBox.setMargin(button, new Insets(10));
        
        // Set event click cho button
        button.setOnMouseClicked(event -> {
            eventClickIcon.accept(iconNhanKhauController.getData());
        });
        
        // Truyền dữ liệu cho controller
        iconNhanKhauController.setIconType(nhanKhau.getThongTinNhanKhau().getQuanHe().isEmpty() ? IconType.CHUHO : IconType.NHANKHAU);
        iconNhanKhauController.setData(nhanKhau);
        
        return button;
    }
    
    public static Button createButtonIcon(HoKhau hoKhau, Consumer<IconHoKhauController> eventClickIcon) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IconUtils.class.getResource("/com/example/introductiontose/view/icon/ho-khau-icon.fxml"));
        
        // Tạo controller và set controller cho fxmlLoader
        IconHoKhauController iconHoKhauController = new IconHoKhauController();
        fxmlLoader.setController(iconHoKhauController);
        
        // Load fxml
        Button button = fxmlLoader.load();
        HBox.setMargin(button, new Insets(10));
        
        // Set event click cho button
        button.setOnMouseClicked(event -> {
            iconHoKhauController.setSelected(!iconHoKhauController.isSelected());
            eventClickIcon.accept(iconHoKhauController);
        });
        
        // Truyền dữ liệu cho controller
        iconHoKhauController.setIconType(IconType.HOKHAU);
        iconHoKhauController.setData(hoKhau);
        
        return button;
    }
}
