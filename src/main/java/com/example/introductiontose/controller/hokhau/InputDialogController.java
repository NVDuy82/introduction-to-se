package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private DataAccessObject accessObject;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setTitle(String s) {
        title.setText(s);
    }
    
    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }
    
    public void setAccessObject(DataAccessObject accessObject) {
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
        sendRequire();
        
        // Đóng dialog
        dialogStage.close();
    }
    
    @FXML
    private void handleCancelButton() {
        // Đóng dialog
        dialogStage.close();
    }
    
    private void sendRequire() {
    
    }
}
