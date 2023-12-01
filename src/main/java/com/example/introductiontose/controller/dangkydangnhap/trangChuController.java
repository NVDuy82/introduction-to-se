package com.example.introductiontose.controller.dangkydangnhap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class trangChuController {

    @FXML
    private Text nameUser;

    public void signOut (ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/introductiontose/view/dangkydangnhap/dangNhap.fxml"));
        Parent dangxuat = loader.load();
        Scene scene = new Scene(dangxuat);
        stage.setScene(scene);
    }

    public void display(String username) {
        nameUser.setText(username);
    }
}
