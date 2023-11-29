package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.NhanKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.NhanKhau;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

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
    private int idHoKhau;
    private Button selectedButton;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idHoKhau = 1;
        initButton();
    }
    
    
    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
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
            controller.lauch(idHoKhau, getNhanKhauList());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "ssss");
        }
    }
    
    private void loadThemNhanKhau() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/hokhau/ho-khau-them-nhan-khau.fxml"));
        
        try {
            paneContent.getChildren().clear();
            paneContent.getChildren().add(fxmlLoader.load());
        } catch (Exception e) {
        
        }
    }
    
    private List<NhanKhau> getNhanKhauList() {
        try {
            Connection connection = SqlConnection.connect();
            DataAccessObject<NhanKhau, String> accessObject = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAU);
            List<NhanKhau> result = accessObject.getAll();
            result.removeIf(nhanKhau -> nhanKhau.getThongTinNhanKhau().getIdHoKhau() != idHoKhau);
            
            connection.close();
            return result;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
}
