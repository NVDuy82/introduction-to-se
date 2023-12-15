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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSach extends Pane {
    private Scene prevScene;
    
    @FXML
    private VBox mainVBox;
    
    @FXML
    private Pane paneContent;
    
    @FXML
    private ScrollPane scrollPane;
    
    public DanhSach() {
        this(null);
    }
    
    public DanhSach(Scene prevScene) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/danh-sach-Pane.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        this.prevScene = prevScene;
        mainVBox.getChildren().clear();
    }
    
    public void launch(List<NhanKhau> nhanKhauList) {
        mainVBox.getChildren().clear();
        try {
            HBox currentHBox = new HBox();
            for (NhanKhau nhanKhau : nhanKhauList) {
                if (currentHBox.getChildren().size() == 4) {
                    mainVBox.getChildren().add(currentHBox);
                    currentHBox = new HBox();
                }
                
                Button button = IconUtils.createButtonIcon(nhanKhau, this::eventClickIcon);
                currentHBox.getChildren().add(button);
            }
            if (!currentHBox.getChildren().isEmpty()) {
                mainVBox.getChildren().add(currentHBox);
            }
        } catch (IOException e) {
            // lỗi phần mềm
        }
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
    
    private void eventClickIcon(NhanKhau nhanKhau) {
        try {
            String name = (prevScene != null) ? "/com/example/introductiontose/view/thong-tin-nhan-khau.fxml" :
                    "/com/example/introductiontose/view/user/hokhau/thong-tin-nhan-khau.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(name));
            Scene scene = mainVBox.getScene();
            Stage stage = (Stage) scene.getWindow();
            
            Scene nextScene = new Scene(fxmlLoader.load());
            ThongTinNhanKhauController controller = fxmlLoader.getController();
            controller.setTitle(nhanKhau);
            controller.setPrevStage(stage);
            controller.setPrevScene(scene);
            controller.setPrevPrevScene(prevScene);
            controller.setData(nhanKhau);
            
            stage.setScene(nextScene);
        } catch (IOException e) {
            // lỗi phần mềm
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
