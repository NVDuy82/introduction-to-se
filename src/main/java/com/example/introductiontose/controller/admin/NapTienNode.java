package com.example.introductiontose.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class NapTienNode extends HBox {
    @FXML
    private Label cccd;
    
    @FXML
    private Label ghiChu;
    
    @FXML
    private Label money;
    
    @FXML
    private Label name;
    
    
    public NapTienNode(String soCccd, String name, int money, String ghiChu) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/NapTienNode.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        this.cccd.setText(soCccd);
        this.name.setText(name);
        this.money.setText(String.valueOf(money));
        this.ghiChu.setText(ghiChu);
    }
    
    
    @FXML
    void cancel(ActionEvent event) {
    
    }
    
    @FXML
    void submit(ActionEvent event) {
    
    }
}
