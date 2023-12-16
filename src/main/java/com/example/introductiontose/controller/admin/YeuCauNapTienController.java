package com.example.introductiontose.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class YeuCauNapTienController implements Initializable {
    
    
    @FXML
    private VBox yeuCauList;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        yeuCauList.getChildren().clear();
        for (int i = 0; i < 5; i++) {
            NapTienNode node = new NapTienNode("01230000" + i, "Nguyễn Văn " + i, 1000 * i);
            yeuCauList.getChildren().add(node);
        }
    }
}
