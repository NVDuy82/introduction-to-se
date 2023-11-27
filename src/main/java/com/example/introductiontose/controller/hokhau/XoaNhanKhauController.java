package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.TachKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.TachKhau;
import com.example.introductiontose.model.key.TachKhauKey;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconController;
import com.example.introductiontose.view.icon.IconType;
import javafx.scene.image.Image;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XoaNhanKhauController extends DanhSachHoController {
    private final List<IconController> selectedList = new ArrayList<>();
    
    public XoaNhanKhauController() {
        this.originalIconType = IconType.NHANKHAU;
    }
    
    @Override
    void submit() {
        // create icon
        String imagePath = "/com/example/introductiontose/view/iconImg/icons8-alert-96.png";
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        
        if (selectedList.isEmpty()) {
            // create alert
            AlertUtils.showAlert("Chưa chọn đối tượng", "Hãy chọn ít nhất 1 nhân khẩu.", image);
        } else {
            // create alert
            AlertUtils.showAlert("Xác nhận", "Bạn có chắc chắn xóa " +
                    selectedList.size() +
                    " người khỏi hộ khẩu không?", image, this::sendRequire);
        }
    }
    
    @Override
    void eventClickIcon(IconController iconController) {
        if (iconController.isSelected()) {
            if (selectedList.isEmpty()) {
                ActionButton.showButtonSubmit(submitButton);
                ActionButton.showButtonClear(clearButton);
                isAnyObjectSelected = true;
            }
            selectedList.add(iconController);
        } else {
            selectedList.remove(iconController);
            if (selectedList.isEmpty()) {
                ActionButton.hideButtonSubmit(submitButton);
                ActionButton.hideButtonClear(clearButton);
                isAnyObjectSelected = false;
            }
        }
    }
    
    @Override
    void clearSelected() {
        selectedList.clear();
        isAnyObjectSelected = false;
    }
    
    private void sendRequire() {
        Connection connection = SqlConnection.connect();
        
    }
}
