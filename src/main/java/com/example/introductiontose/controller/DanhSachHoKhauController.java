package com.example.introductiontose.controller;

import com.example.introductiontose.Application;
import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.HoKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.key.HoKhauKey;
import com.example.introductiontose.util.SQLUtils;
import com.example.introductiontose.view.icon.IconHoKhauController;
import com.example.introductiontose.view.icon.IconUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
