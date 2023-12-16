package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.model.ThayDoiNhanKhau;
import com.example.introductiontose.util.AlertUtils;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class InputDialogController {
    @FXML
    private Text title;
    @FXML
    private TextField noiChuyenDen;
    @FXML
    private TextField ghiChu;
    @FXML
    private CheckBox daChet;
    
    private Stage dialogStage;
    private String soCccd;
    private DataAccessObject<ThayDoiNhanKhau, Integer> accessObject;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setTitle(String s) {
        title.setText(s);
    }
    
    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }
    
    public void setAccessObject(DataAccessObject<ThayDoiNhanKhau, Integer> accessObject) {
        this.accessObject = accessObject;
    }
    
    @FXML
    private void clickCheckBox() {
        if (daChet.isSelected()) {
            ghiChu.setText("");
        }
        ghiChu.setDisable(daChet.isSelected());
    }
    
    @FXML
    private void handleOKButton() {
        // Xử lý dữ liệu khi người dùng nhấn nút "OK"
        try {
            sendRequire();
        } catch (SQLException e) {
            AlertUtils.showAlertError("Lỗi", "Xóa nhân khẩu thất bại!");
        }
        
        // Đóng dialog
        dialogStage.close();
    }
    
    @FXML
    private void handleCancelButton() {
        // Đóng dialog
        dialogStage.close();
    }
    
    private void sendRequire() throws SQLException {
        accessObject.save(new ThayDoiNhanKhau(0, soCccd, "chờ xác nhận",
                LocalDateTime.now(),
                noiChuyenDen.getText(),
                ghiChu.getText()));
    }
}
