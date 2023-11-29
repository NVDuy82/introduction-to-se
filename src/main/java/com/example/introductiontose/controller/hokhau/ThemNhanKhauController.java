package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.NhanKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.CCCD;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.ThongTinNhanKhau;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.util.StringConverterLocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class ThemNhanKhauController implements Initializable {
    @FXML
    private TextField hoTenText;
    @FXML
    private TextField biDanhText;
    @FXML
    private TextField noiSinhText;
    @FXML
    private TextField nguyenQuanText;
    @FXML
    private TextField danTocText;
    @FXML
    private TextField tonGiaoText;
    @FXML
    private TextField diaChiCuText;
    @FXML
    private TextField soCccdText;
    @FXML
    private TextField noiCapText;
    @FXML
    private TextField ngheNghiepText;
    @FXML
    private TextField noiLamViecText;
    @FXML
    private TextField quanHeText;
    @FXML
    private DatePicker ngaySinhDatePicker;
    @FXML
    private DatePicker ngayCapDatePicker;
    @FXML
    private DatePicker ngayDKTTDatePicker;
    private int idHoKhau;
    
    @FXML
    private void addClick(ActionEvent event) {
        submit();
    }
    
    @FXML
    private void fill(ActionEvent event) throws SQLException {
        Connection connection = SqlConnection.connect();
        DataAccessObject<NhanKhau, String> accessObject = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAU);
        Optional<NhanKhau> result = accessObject.get(soCccdText.getText());
        result.ifPresent(this::_fill);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ngaySinhDatePicker.setConverter(new StringConverterLocalDate());
        ngayCapDatePicker.setConverter(new StringConverterLocalDate());
        ngayDKTTDatePicker.setConverter(new StringConverterLocalDate());
    }
    
    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }
    
    private boolean areRequiredFieldsFilled() {
        TextField[] textFields = {hoTenText, noiSinhText, quanHeText};
        DatePicker[] datePickers = {ngaySinhDatePicker, ngayCapDatePicker};
        
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) return false;
        }
        for (DatePicker datePicker : datePickers) {
            if (datePicker.getValue() == null) return false;
        }
        
        return true;
    }
    
    private void submit() {
        // create icon
        String imagePath = "/com/example/introductiontose/view/iconImg/icons8-alert-96.png";
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        
        if (areRequiredFieldsFilled()) {
            // create alert
            AlertUtils.showAlert("Xác nhận", "Bạn có chắc chắn muốn thêm nhân khẩu " +
                    hoTenText.getText() +
                    " không?", image, this::sendRequire);
        } else {
            // create alert
            AlertUtils.showAlert("Thiếu thông tin", "Các thông tin có đánh dấu (*) là bắt buộc.", image);
        }
    }
    
    private NhanKhau getNhanKhau() {
        return new NhanKhau(this.getInfo());
    }
    
    private ThongTinNhanKhau getInfo() {
        return new ThongTinNhanKhau(new CCCD(soCccdText.getText(),
                (ngayCapDatePicker.getValue() == null) ? LocalDateTime.now() : ngayCapDatePicker.getValue().atStartOfDay(),
                noiCapText.getText()),
                idHoKhau,
                hoTenText.getText(),
                biDanhText.getText(),
                (ngaySinhDatePicker.getValue() == null) ? LocalDateTime.now() : ngaySinhDatePicker.getValue().atStartOfDay(),
                noiSinhText.getText(),
                nguyenQuanText.getText(),
                danTocText.getText(),
                tonGiaoText.getText(),
                ngheNghiepText.getText(),
                noiLamViecText.getText(),
                (ngayDKTTDatePicker.getValue() == null) ? LocalDateTime.now() : ngayDKTTDatePicker.getValue().atStartOfDay(),
                diaChiCuText.getText(),
                quanHeText.getText());
    }
    
    private void sendRequire() {
        Connection connection = SqlConnection.connect();
        DataAccessObject<NhanKhau, String> accessObject = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAUCHUATHEM);
        NhanKhau change = getNhanKhau();
        try {
            accessObject.save(change);
            connection.close();
        } catch (Exception e) {
            AlertUtils.showAlert("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }
    
    private void _fill(NhanKhau nhanKhau) {
        hoTenText.setText(nhanKhau.getThongTinNhanKhau().getHoTen());
        biDanhText.setText(nhanKhau.getThongTinNhanKhau().getBiDanh());
        ngaySinhDatePicker.setValue(nhanKhau.getThongTinNhanKhau().getNgaySinh().toLocalDate());
        noiSinhText.setText(nhanKhau.getThongTinNhanKhau().getNoiSinh());
        nguyenQuanText.setText(nhanKhau.getThongTinNhanKhau().getNguyenQuan());
        danTocText.setText(nhanKhau.getThongTinNhanKhau().getDanToc());
        tonGiaoText.setText(nhanKhau.getThongTinNhanKhau().getTonGiao());
        diaChiCuText.setText(nhanKhau.getThongTinNhanKhau().getDiaChiCu());
        ngayCapDatePicker.setValue(nhanKhau.getThongTinNhanKhau().getCccd().getNgayCap().toLocalDate());
        noiCapText.setText(nhanKhau.getThongTinNhanKhau().getCccd().getNoiCap());
        ngheNghiepText.setText(nhanKhau.getThongTinNhanKhau().getNgheNghiep());
        noiLamViecText.setText(nhanKhau.getThongTinNhanKhau().getNoiLamViec());
        ngayDKTTDatePicker.setValue(nhanKhau.getThongTinNhanKhau().getNgayDKTT().toLocalDate());
    }
}
