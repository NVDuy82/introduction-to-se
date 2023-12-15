package com.example.introductiontose.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class NapTienNode extends HBox {
    public NapTienNode() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/NapTienNode.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    @FXML
    void cancel(ActionEvent event) {
    
    }
    
    @FXML
    void submit(ActionEvent event) {
    
    }
}
