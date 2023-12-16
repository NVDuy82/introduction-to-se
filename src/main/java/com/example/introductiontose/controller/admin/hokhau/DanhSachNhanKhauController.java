package com.example.introductiontose.controller.admin.hokhau;

import com.example.introductiontose.controller.node.DanhSach;
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

public class DanhSachNhanKhauController {
    @FXML
    private Button title;
    @FXML
    private Pane paneContent;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox mainVBox;
    private Scene prevScene;
    private Stage prevStage;
    
    public void setTitle(String title) {
        this.title.setText(title);
    }
    
    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }
    
    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }
    
    @FXML
    private void goBack(ActionEvent event) {
        prevStage.setScene(prevScene);
    }
    
    public void launch(List<NhanKhau> nhanKhauList) {
        DanhSach danhSach = new DanhSach(prevScene);
        danhSach.launch(nhanKhauList);
        this.paneContent.getChildren().clear();
        this.paneContent.getChildren().add(danhSach);
    }
}
