package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconController;
import com.example.introductiontose.view.icon.IconType;
import com.example.introductiontose.view.icon.IconUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    int idHoKhau;
    IconType originalIconType;
    List<NhanKhau> nhanKhauList;
    List<IconController> iconControllerList;
    boolean isAnyObjectSelected = false;
    
    abstract void submit();
    abstract void eventClickIcon(IconController iconController);
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
        
        }
    }
    
    public void lauch(int idHoKhau, List<NhanKhau> nhanKhauList) throws IOException {
        this.idHoKhau = idHoKhau;
        this.nhanKhauList = nhanKhauList;
        this.showInVBox(this.originalIconType);
    }
    
    void showInVBox(IconType iconType) throws IOException {
        mainVBox.getChildren().clear();
        clearSelected();
        iconControllerList = new ArrayList<>();
        
        HBox currentHBox = new HBox();
        for (NhanKhau nhanKhau : nhanKhauList) {
            if (currentHBox.getChildren().size() == 3) {
                mainVBox.getChildren().add(currentHBox);
                currentHBox = new HBox();
            }
            
            Button button = IconUtils.createButtonIcon(iconType, nhanKhau, iconControllerList, this::eventClickIcon);
            currentHBox.getChildren().add(button);
        }
        if (!currentHBox.getChildren().isEmpty()) {
            mainVBox.getChildren().add(currentHBox);
        }
    }
}
