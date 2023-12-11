package com.example.introductiontose.controller;

import com.example.introductiontose.Application;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.view.icon.IconUtils;
import javafx.event.ActionEvent;
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
    
    private void eventClickIcon(NhanKhau nhanKhau) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/introductiontose/view/thong-tin-nhan-khau.fxml"));
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
}
