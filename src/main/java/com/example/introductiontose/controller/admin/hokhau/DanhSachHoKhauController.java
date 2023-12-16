package com.example.introductiontose.controller.admin.hokhau;

import com.example.introductiontose.controller.node.DanhSach;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DanhSachHoKhauController implements Initializable {
    @FXML
    private AnchorPane centerAnchorPane;
    @FXML
    private Pane paneContent;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox mainVBox;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        launch();
    }
    
    public void launch() {
        DanhSach danhSach = new DanhSach();
        danhSach.launch();
        this.paneContent.getChildren().clear();
        this.paneContent.getChildren().add(danhSach);
    }
    
}
