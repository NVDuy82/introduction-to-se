package com.example.introductiontose.controller;

import com.example.introductiontose.dao.TamTruDAO;
import com.example.introductiontose.database.SqlConnection;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GuiYeuCauTamTruController implements Initializable {
    @FXML
    private Button sendRequest;
    @FXML
    private DatePicker DateBegin, DateEnd, ngayCap, ngaySinh;
    @FXML
    private TextField lyDo, Name, soCCCD, soDienThoai, biDanh, ngheNghiep, danToc, noiCap, queQuan, noiLamViec, quanHeVoiChuHo, choOHienNay;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label errorLabel;
    @FXML
    ComboBox<String> Sex;

    @FXML
    public void handleConfirm() {
        String lyDoString = lyDo.getText();
        String hoTenString = Name.getText();
        String soCCCDString = soCCCD.getText();
        String danTocString = danToc.getText();
        String noiCapString = noiCap.getText();
        String queQuanString = queQuan.getText();
        String noiLamViecString = noiLamViec.getText();
        String biDanhString = biDanh.getText();
        String soDienThoaiString = soDienThoai.getText();
        String ngheNghiepString = ngheNghiep.getText();
        String quanHeString = quanHeVoiChuHo.getText();
        String choOHienNayString = choOHienNay.getText();
        LocalDate selectedNgayCap = ngayCap.getValue();
        LocalDate selectedNgaySinh = ngaySinh.getValue();
        LocalDate selectedDateBegin = DateBegin.getValue();
        LocalDate selectedDateEnd = DateEnd.getValue();
        boolean check = checkBox.isSelected();
        // Clear previous error messages
        errorLabel.setText("");
        String sexString = Sex.getValue();

        // Validate input fields
        if(hoTenString == null){
            errorLabel.setText("Chưa nhập họ tên!");
            return;
        }
        if(soCCCDString == null){
            errorLabel.setText("Chưa nhập số CCCD");
            return;
        }
        if(isNumeric(soCCCDString)){
            errorLabel.setText("Số CCCD sai");
            return;
        }
        if(danTocString == null){
            errorLabel.setText("Chưa điền dân tộc!");
            return;
        }
        if(soDienThoaiString == null){
            errorLabel.setText("Chưa điền số điện thoại");
            return;
        }
        if(noiCapString == null){
            errorLabel.setText("Chưa điền nơi cấp");
            return;
        }
        if(queQuanString == null){
            errorLabel.setText("Chưa điền quan hệ");
            return;
        }
        if(biDanhString == null){
            errorLabel.setText("Chưa nhập bí danh");
            return;
        }
        if(ngheNghiepString == null){
            errorLabel.setText("Chưa nhập nghề nghiệp");
            return;
        }
        if(noiLamViecString == null){
            errorLabel.setText("Chưa nhập nơi làm việc");
            return;
        }

        if(quanHeString == null){
            errorLabel.setText("Chưa nhập quan hệ với chủ hộ");
            return;
        }
        if(choOHienNayString == null){
            errorLabel.setText("Chưa nhập chỗ ở hiện nay");
            return;
        }

        if(selectedNgayCap == null) {
            errorLabel.setText("Ngày bắt đầu trống!");
            return;
        }
        if(selectedNgaySinh == null) {
            errorLabel.setText("Ngày bắt đầu trống!");
            return;
        }

        if(selectedDateBegin == null) {
            errorLabel.setText("Ngày bắt đầu trống!");
            return;
        }
        if(selectedDateEnd == null) {
            errorLabel.setText("Ngày kết thúc trống!");
            return;
        }

        if(lyDoString.isEmpty()) {
            errorLabel.setText("Lý do trống!");
            return;
        }
        if (selectedDateBegin.isAfter(selectedDateEnd) || selectedDateBegin.isEqual(selectedDateEnd)) {
            errorLabel.setText("Ngày không hợp lệ!");
            return;
        }

        // Check date validity
        if (selectedDateBegin.isAfter(selectedDateEnd) || selectedDateBegin.isEqual(selectedDateEnd)) {
            showError("Ngày không hợp lệ!");
            return;
        }

        // Handle checkbox selection
        if (checkBox.isSelected()) {
            handleSelectedCheckbox();
        } else {
            animateCheckbox();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize gender ComboBox
        Sex.setItems(FXCollections.observableArrayList("Nam", "Nữ"));
    }

    // Other methods...

    private void handleSelectedCheckbox() {
        Connection connection = SqlConnection.connect();
            TamTruDAO tamtruDAO = new TamTruDAO(connection);
            System.out.println("handleSelectedCheckBox\n");
    }

    private void animateCheckbox() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(checkBox.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(0.1), new KeyValue(checkBox.opacityProperty(), 0.3)),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(checkBox.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(0.3), new KeyValue(checkBox.opacityProperty(), 0.3)),
                new KeyFrame(Duration.seconds(0.4), new KeyValue(checkBox.opacityProperty(), 1.0))
        );
        timeline.play();
    }

    // Helper methods...

    private boolean isFieldEmpty(TextField field, String fieldName) {
        if (field.getText().isEmpty()) {
            showError("Chưa nhập " + fieldName + "!");
            return true;
        }
        return false;
    }

    private boolean isDateEmpty(LocalDate date, String dateName) {
        if (date == null) {
            showError(dateName + " trống!");
            return true;
        }
        return false;
    }

    private boolean isNumeric(String str) {
        if (!str.matches("\\d+")) {
            return false;
        }
        return true;
    }

    private void showError(String message) {
        errorLabel.setText(message);
    }
}
