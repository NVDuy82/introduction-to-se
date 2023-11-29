package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.ThayDoiHoKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.ThayDoiHoKhau;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconController;
import com.example.introductiontose.view.icon.IconType;
import javafx.scene.image.Image;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Objects;

public class DoiChuHoController extends DanhSachHoController {
    private IconController selectedController;
    
    public DoiChuHoController() {
        this.originalIconType = IconType.CHUHO;
    }
    
    @Override
    void submit() {
        // create icon
        String imagePath = "/com/example/introductiontose/view/iconImg/icons8-alert-96.png";
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        
        if (selectedController == null) {
            // create alert
            AlertUtils.showAlert("Chưa chọn đối tượng", "Hãy chọn ít nhất 1 nhân khẩu.", image);
        } else {
            // create alert
            AlertUtils.showAlert("Xác nhận", "Bạn có chắc chắn thay đổi " +
                            selectedController.getNhanKhau().getThongTinNhanKhau().getHoTen() +
                            " làm chủ hộ không?", image, this::sendRequire);
        }
    }
    
    @Override
    void eventClickIcon(IconController iconController) {
        if (iconController.isSelected()) {
            if (selectedController != null) {
                selectedController.setSelected(false);
            } else {
                ActionButton.showButtonSubmit(submitButton);
                ActionButton.showButtonClear(clearButton);
                isAnyObjectSelected = true;
            }
            selectedController = iconController;
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
                idHoKhau,
                null,
                selectedController.getNhanKhau().getThongTinNhanKhau().getCccd().getSoCccd(),
                null,
                LocalDateTime.now());
        try {
            accessObject.save(change);
            connection.close();
        } catch (Exception e) {
            AlertUtils.showAlert("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }
}
