package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.NhanKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.util.SQLUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class HoKhauController implements Initializable {
    @FXML
    private Button buttonMenuDoiChuHo;
    @FXML
    private Button buttonMenuThemNhanKhau;
    @FXML
    private Button buttonMenuXoaNhanKhau;
    @FXML
    private Button buttonMenuTachKhau;
    @FXML
    private Pane paneContent;
    private HoKhau hoKhau;
    private int idHoKhau;
    private Button selectedButton;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idHoKhau = 1;
        initButton();
    }
    
    
    public void setHoKhau(HoKhau hoKhau) {
        this.hoKhau = hoKhau;
        this.idHoKhau = hoKhau.getIdHoKhau();
    }
    
    @FXML
    private void showDoiChuHo(ActionEvent event) {
        DanhSachHoController controller = new DoiChuHoController();
        loadDanhSachHo(controller);
    }
    
    @FXML
    private void showThemNhanKhau(ActionEvent event) {
        loadThemNhanKhau();
    }
    
    @FXML
    private void showXoaNhanKhau(ActionEvent event) {
        DanhSachHoController controller = new XoaNhanKhauController();
        loadDanhSachHo(controller);
    }
    
    @FXML
    private void showTachKhau(ActionEvent event) {
        DanhSachHoController controller = new TachKhauController();
        loadDanhSachHo(controller);
    }
    
    private void initButton() {
        List<Button> buttonMenu = Arrays.asList(buttonMenuDoiChuHo, buttonMenuThemNhanKhau,
                buttonMenuXoaNhanKhau, buttonMenuTachKhau);
        
        for (Button button : buttonMenu) {
            button.setOnMouseClicked(event -> {
                if (button != selectedButton) {
                    if (selectedButton != null) {
                        selectedButton.getStyleClass().remove("btn-menu-on-select");
                    }
                    button.getStyleClass().add("btn-menu-on-select");
                    selectedButton = button;
                }
            });
        }
    }
    
    private void loadDanhSachHo(DanhSachHoController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/hokhau/ho-khau-danh-sach-ho.fxml"));
        
        
        paneContent.getChildren().clear();
        fxmlLoader.setController(controller);
        
        try {
            paneContent.getChildren().add(fxmlLoader.load());
            List<NhanKhau> nhanKhauList = getNhanKhauList();
            if (nhanKhauList == null) return;
            
            controller.launch(this.hoKhau, nhanKhauList);
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtils.showAlertError("Lỗi", "Xảy ra lỗi trong phần mềm.");
        }
    }
    
    private void loadThemNhanKhau() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/hokhau/ho-khau-them-nhan-khau.fxml"));
        
        try {
            paneContent.getChildren().clear();
            paneContent.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            AlertUtils.showAlertError("Lỗi", "Xảy ra lỗi trong phần mềm.");
        }
    }
    
    private List<NhanKhau> getNhanKhauList() {
        try {
            return SQLUtils.getNhanKhauFromHoKhau(idHoKhau);
        } catch (SQLException e) {
            // lỗi kết nối
            
            return null;
        }
    }
}
