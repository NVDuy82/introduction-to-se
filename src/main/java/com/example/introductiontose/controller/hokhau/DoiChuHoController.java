package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.ThayDoiHoKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.ThayDoiHoKhau;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconNhanKhauController;
import com.example.introductiontose.view.icon.IconType;
import javafx.scene.image.Image;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Objects;

public class DoiChuHoController extends DanhSachHoController {
    private IconNhanKhauController selectedController;
    
    public DoiChuHoController() {
        this.originalIconType = IconType.CHUHO;
    }
    
    @Override
    void submit() {
        
        if (selectedController == null) {
            // create alert
            AlertUtils.showAlertError("Chưa chọn đối tượng", "Hãy chọn ít nhất 1 nhân khẩu.");
        } else {
            // create alert
            AlertUtils.showAlert("Xác nhận", "Bạn có chắc chắn thay đổi " +
                            selectedController.getData().getThongTinNhanKhau().getHoTen() +
                            " làm chủ hộ không?", this::sendRequire);
        }
    }
    
    @Override
    void eventClickIcon(IconNhanKhauController iconNhanKhauController) {
        if (iconNhanKhauController.isSelected()) {
            if (selectedController != null) {
                selectedController.setSelected(false);
            } else {
                ActionButton.showButtonSubmit(submitButton);
                ActionButton.showButtonClear(clearButton);
                isAnyObjectSelected = true;
            }
            selectedController = iconNhanKhauController;
        } else {
            selectedController = null;
            ActionButton.hideButtonSubmit(submitButton);
            ActionButton.hideButtonClear(clearButton);
            isAnyObjectSelected = false;
        }
    }
    
    @Override
    void clearSelected() {
        selectedController = null;
        isAnyObjectSelected = false;
    }
    
    private void sendRequire() {
        Connection connection = SqlConnection.connect();
        DataAccessObject<ThayDoiHoKhau, Integer> accessObject = new ThayDoiHoKhauDAO(connection);
        ThayDoiHoKhau change = new ThayDoiHoKhau(0,
                hoKhau.getIdHoKhau(),
                "chờ xác nhận",
                selectedController.getData().getThongTinNhanKhau().getCccd().getSoCccd(),
                "thay đổi chủ hộ (idHoKhau = " + hoKhau.getIdHoKhau() + ") từ ông " + hoKhau.getTenChuHo() + " sang ông " +
                selectedController.getData().getThongTinNhanKhau().getHoTen(),
                LocalDateTime.now());
        try {
            accessObject.save(change);
            SqlConnection.close(connection);
        } catch (Exception e) {
            AlertUtils.showAlert("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }
}
