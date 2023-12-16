package com.example.introductiontose.controller.admin.hokhau;

import com.example.introductiontose.model.NhanKhau;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class ThongTinNhanKhauController {
    @FXML
    private Button title;
    @FXML
    private Button prevTitle;
    @FXML
    private Pane paneContent;
    @FXML
    private Text hoTen;
    @FXML
    private Text biDanh;
    @FXML
    private Text ngaySinh;
    @FXML
    private Text noiSinh;
    @FXML
    private Text nguyenQuan;
    @FXML
    private Text danToc;
    @FXML
    private Text tonGiao;
    @FXML
    private Text diaChiCu;
    @FXML
    private Text soCccd;
    @FXML
    private Text ngayCap;
    @FXML
    private Text noiCap;
    @FXML
    private Text ngheNghiep;
    @FXML
    private Text noiLamViec;
    @FXML
    private Text ngayDKTT;
    @FXML
    private Text quanHe;
    @FXML
    private Text idHoKhau;
    private Scene prevPrevScene;
    private Scene prevScene;
    private Stage prevStage;
    
    @FXML
    private void goBackPrev() {
        if (prevScene == null) return;
        prevStage.setScene(prevScene);
    }
    
    @FXML
    private void goBackPrevPrev() {
        if (prevPrevScene == null) return;
        prevStage.setScene(prevPrevScene);
    }
    
    public void setPrevPrevScene(Scene prevPrevScene) {
        this.prevPrevScene = prevPrevScene;
    }
    
    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }
    
    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }
    
    public void setData(NhanKhau nhanKhau) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        hoTen.setText(nhanKhau.getThongTinNhanKhau().getHoTen());
        biDanh.setText(nhanKhau.getThongTinNhanKhau().getBiDanh());
        ngaySinh.setText(nhanKhau.getThongTinNhanKhau().getNgaySinh().format(formatter));
        noiSinh.setText(nhanKhau.getThongTinNhanKhau().getNoiSinh());
        nguyenQuan.setText(nhanKhau.getThongTinNhanKhau().getNguyenQuan());
        danToc.setText(nhanKhau.getThongTinNhanKhau().getDanToc());
        tonGiao.setText(nhanKhau.getThongTinNhanKhau().getTonGiao());
        diaChiCu.setText(nhanKhau.getThongTinNhanKhau().getDiaChiCu());
        soCccd.setText(nhanKhau.getThongTinNhanKhau().getCccd().getSoCccd());
        ngayCap.setText(nhanKhau.getThongTinNhanKhau().getCccd().getNgayCap().format(formatter));
        noiCap.setText(nhanKhau.getThongTinNhanKhau().getCccd().getNoiCap());
        ngheNghiep.setText(nhanKhau.getThongTinNhanKhau().getNgheNghiep());
        noiLamViec.setText(nhanKhau.getThongTinNhanKhau().getNoiLamViec());
        ngayDKTT.setText(nhanKhau.getThongTinNhanKhau().getNgayDKTT().format(formatter));
        quanHe.setText(nhanKhau.getThongTinNhanKhau().getQuanHe());
        idHoKhau.setText(String.valueOf(nhanKhau.getThongTinNhanKhau().getIdHoKhau()));
    }
    
    public void setTitle(NhanKhau nhanKhau) {
        title.setText(nhanKhau.getThongTinNhanKhau().getHoTen());
        prevTitle.setText("Hộ khâu " + nhanKhau.getThongTinNhanKhau().getIdHoKhau());
    }
}
