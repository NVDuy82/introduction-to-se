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
        mainVBox.getChildren().clear();
        Connection connection = SqlConnection.connect();
        DataAccessObject<HoKhau, HoKhauKey> accessObject = new HoKhauDAO(connection);
        List<HoKhau> danhSachHo = new ArrayList<>();
        
        try {
            danhSachHo = accessObject.getAll();
            SqlConnection.close(connection);
        } catch (SQLException e) {
        
        }
        
        try {
            HBox currentHBox = new HBox();
            for (HoKhau hoKhau : danhSachHo) {
                if (currentHBox.getChildren().size() == 4) {
                    mainVBox.getChildren().add(currentHBox);
                    currentHBox = new HBox();
                }
                
                Button button = IconUtils.createButtonIcon(hoKhau, this::eventClickIcon);
                currentHBox.getStyleClass().add("transparent-hbox");
                currentHBox.getChildren().add(button);
            }
            if (!currentHBox.getChildren().isEmpty()) {
                currentHBox.getStyleClass().add("transparent-hbox");
                mainVBox.getChildren().add(currentHBox);
            }
        } catch (IOException e) {
        
        }
    }
    
    private void eventClickIcon(IconHoKhauController iconHoKhauController) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/danh-sach-nhan-khau.fxml"));
            Scene scene = mainVBox.getScene();
            Stage stage = (Stage) scene.getWindow();
            
            Scene nextScene = new Scene(fxmlLoader.load());
            DanhSachNhanKhauController controller = fxmlLoader.getController();
            controller.setTitle("Hộ khẩu " + iconHoKhauController.getData().getIdHoKhau());
            controller.setPrevStage(stage);
            controller.setPrevScene(scene);
            
            List<NhanKhau> nhanKhauList = getNhanKhauList(iconHoKhauController);
            if (nhanKhauList == null) return;
            
            controller.launch(nhanKhauList);
            stage.setScene(nextScene);
        } catch (IOException e) {
            // lỗi phần mềm
        }
    }
    
    private List<NhanKhau> getNhanKhauList(IconHoKhauController iconHoKhauController) {
        try {
            return SQLUtils.getNhanKhauFromHoKhau(iconHoKhauController.getData().getIdHoKhau());
        } catch (SQLException e) {
            // lỗi kết nối
        }
        return null;
    }
}
