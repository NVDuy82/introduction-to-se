package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.ThongTinNhanKhau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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
    private int idHoKhau;
    private Button selectedButton;
    private List<NhanKhau> nhanKhauList = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauList.add(taoNhanKhau("Nguyễn Văn A", LocalDateTime.of(1990, 5, 15, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Trần Thị B", LocalDateTime.of(1985, 8, 22, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Lê Minh C", LocalDateTime.of(2000, 3, 10, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Phạm Hồng D", LocalDateTime.of(1978, 11, 5, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Hoàng Thu E", LocalDateTime.of(1995, 2, 28, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Ngô Văn F", LocalDateTime.of(1982, 7, 7, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Đinh Thị G", LocalDateTime.of(2005, 9, 18, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Vũ Minh H", LocalDateTime.of(1993, 12, 12, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Bùi Thị I", LocalDateTime.of(1989, 4, 3, 0, 0)));
        nhanKhauList.add(taoNhanKhau("Lý Quốc J", LocalDateTime.of(2002, 6, 25, 0, 0)));
        
        initButton();
    }
    
    private NhanKhau taoNhanKhau(String name, LocalDateTime ngaySinh) {
        ThongTinNhanKhau thongTinNhanKhau = new ThongTinNhanKhau();
        thongTinNhanKhau.setHoTen(name);
        thongTinNhanKhau.setNgaySinh(ngaySinh);
        return new NhanKhau(thongTinNhanKhau);
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
            controller.lauch(idHoKhau, nhanKhauList);
        } catch (IOException e) {
            e.printStackTrace();
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
}
