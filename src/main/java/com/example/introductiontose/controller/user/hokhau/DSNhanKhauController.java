package com.example.introductiontose.controller.user.hokhau;

import com.example.introductiontose.controller.DanhSach;
import com.example.introductiontose.model.NhanKhau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class DSNhanKhauController {
    @FXML
    private Button title;
    @FXML
    private Pane paneContent;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox mainVBox;
    
    public void setTitle(String title) {
        this.title.setText(title);
    }
    
    public void launch(List<NhanKhau> nhanKhauList) {
        DanhSach danhSach = new DanhSach();
        danhSach.launch(nhanKhauList);
        this.paneContent.getChildren().clear();
        this.paneContent.getChildren().add(danhSach);
    }
}
