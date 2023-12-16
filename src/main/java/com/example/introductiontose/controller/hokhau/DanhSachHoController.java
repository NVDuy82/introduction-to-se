package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconNhanKhauController;
import com.example.introductiontose.view.icon.IconType;
import com.example.introductiontose.view.icon.IconUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class DanhSachHoController {
    @FXML
    Text title;
    @FXML
    Button submitButton;
    @FXML
    Button clearButton;
    @FXML
    VBox mainVBox;
    HoKhau hoKhau;
    IconType originalIconType;
    List<NhanKhau> nhanKhauList;
    List<IconNhanKhauController> iconNhanKhauControllerList;
    boolean isAnyObjectSelected = false;
    
    abstract void submit();
    abstract void eventClickIcon(IconNhanKhauController iconNhanKhauController);
    abstract void clearSelected();
    
    @FXML
    void submitButtonClick(ActionEvent event) {
        if (!isAnyObjectSelected) return;
        submit();
    }
    
    @FXML
    void clearButtonClick(ActionEvent event) {
        if (!isAnyObjectSelected) return;
        try {
            this.showInVBox(originalIconType);
            ActionButton.hideButtonSubmit(submitButton);
            ActionButton.hideButtonClear(clearButton);
        } catch (Exception e) {
            AlertUtils.showAlertError("Lỗi", "Xảy ra lỗi trong phần mềm.");
        }
    }
    
    public void launch(HoKhau hoKhau, List<NhanKhau> nhanKhauList) throws IOException {
        this.hoKhau = hoKhau;
        this.nhanKhauList = nhanKhauList;
        this.showInVBox(this.originalIconType);
        ActionButton.hideButtonSubmit(submitButton);
        ActionButton.hideButtonClear(clearButton);
    }
    
    void showInVBox(IconType iconType) throws IOException {
        mainVBox.getChildren().clear();
        clearSelected();
        iconNhanKhauControllerList = new ArrayList<>();
        
        HBox currentHBox = new HBox();
        for (NhanKhau nhanKhau : nhanKhauList) {
            if (currentHBox.getChildren().size() == 3) {
                mainVBox.getChildren().add(currentHBox);
                currentHBox = new HBox();
            }
            
            Button button = IconUtils.createButtonIcon(iconType, nhanKhau, iconNhanKhauControllerList, this::eventClickIcon);
            currentHBox.getChildren().add(button);
        }
        if (!currentHBox.getChildren().isEmpty()) {
            mainVBox.getChildren().add(currentHBox);
        }
    }
}
