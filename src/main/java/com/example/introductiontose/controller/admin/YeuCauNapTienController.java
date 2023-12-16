package com.example.introductiontose.controller.admin;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.NapTienDao;
import com.example.introductiontose.dao.NhanKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.NapTien;
import com.example.introductiontose.model.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class YeuCauNapTienController implements Initializable {
    
    
    @FXML
    private VBox yeuCauList;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection connection = SqlConnection.connect();
            DataAccessObject<NapTien, Integer> accessNapTien = new NapTienDao(connection);
            DataAccessObject<NhanKhau, String> accessNhanKhau = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAU);
            List<NapTien> danhSachNapTien = accessNapTien.getAll();
            
            yeuCauList.getChildren().clear();
            for (NapTien napTien : danhSachNapTien) {
                accessNhanKhau.get(napTien.getSoCccd()).ifPresent(nhanKhau -> {
                    NapTienNode node = new NapTienNode(napTien.getSoCccd(), nhanKhau.getThongTinNhanKhau().getHoTen(), napTien.getSoTienNap(), napTien.getGhiChu());
                    yeuCauList.getChildren().add(node);
                });
            }
            
            SqlConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
