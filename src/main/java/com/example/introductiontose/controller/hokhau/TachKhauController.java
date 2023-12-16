package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.TachKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.TachKhau;
import com.example.introductiontose.model.key.TachKhauKey;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconNhanKhauController;
import com.example.introductiontose.view.icon.IconType;
import javafx.scene.image.Image;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TachKhauController extends DanhSachHoController {
    private final List<IconNhanKhauController> selectedList = new ArrayList<>();
    
    public TachKhauController() {
        this.originalIconType = IconType.CHUHO;
    }
    
    @Override
    void submit() {
        if (selectedList.isEmpty()) {
            // create alert
            AlertUtils.showAlert("Chưa chọn đối tượng", "Hãy chọn ít nhất 1 nhân khẩu.");
        } else {
            // create alert
            AlertUtils.showAlert("Xác nhận", "Bạn có chắc chắn tách " +
                    selectedList.get(0).getData().getThongTinNhanKhau().getHoTen() +
                    " và " +
                    (selectedList.size() - 1) +
                    " người khác sang hộ khẩu mới không?", this::sendRequire);
        }
    }
    
    @Override
    void eventClickIcon(IconNhanKhauController iconNhanKhauController) {
        if (iconNhanKhauController.isSelected()) {
            if (selectedList.isEmpty()) {
                ActionButton.showButtonSubmit(submitButton);
                ActionButton.showButtonClear(clearButton);
                isAnyObjectSelected = true;
            }
            selectedList.add(iconNhanKhauController);
        } else {
            if (!selectedList.isEmpty() && selectedList.get(0) == iconNhanKhauController) {
                iconNhanKhauController.setIconType(IconType.NHANKHAU);
            }
            selectedList.remove(iconNhanKhauController);
            
            if (selectedList.isEmpty()) {
                ActionButton.hideButtonSubmit(submitButton);
                ActionButton.hideButtonClear(clearButton);
                isAnyObjectSelected = true;
            }
        }
        
        reload(iconNhanKhauControllerList);
    }
    
    @Override
    void clearSelected() {
        selectedList.clear();
        isAnyObjectSelected = false;
    }
    
    private void reload(List<IconNhanKhauController> iconNhanKhauControllerList) {
        if (selectedList.isEmpty()) {
            changeIconType(iconNhanKhauControllerList, IconType.CHUHO);
        } else {
            if (selectedList.size() == 1) {
                changeIconType(iconNhanKhauControllerList, IconType.NHANKHAU);
            }
            selectedList.get(0).setIconType(IconType.CHUHO);
        }
    }
    
    private void changeIconType(List<IconNhanKhauController> iconNhanKhauControllerList, IconType iconType) {
        for (IconNhanKhauController iconNhanKhauController : iconNhanKhauControllerList) {
            if (!iconNhanKhauController.isSelected()) {
                iconNhanKhauController.setIconType(iconType);
            }
        }
    }
    
    private void sendRequire() {
        Connection connection = SqlConnection.connect();
        DataAccessObject<TachKhau, TachKhauKey> accessObject = new TachKhauDAO(connection);
        List<String> danhSachNhanKhau = new ArrayList<>();
        for (int i = 1; i < selectedList.size(); i++) {
            danhSachNhanKhau.add(selectedList.get(i).getData().getThongTinNhanKhau().getCccd().getSoCccd());
        }
        TachKhau change = new TachKhau(selectedList.get(0).getData().getThongTinNhanKhau().getCccd().getSoCccd(),
                hoKhau.getIdHoKhau(),
                danhSachNhanKhau,
                null);
        try {
            accessObject.save(change);
            SqlConnection.close(connection);
        } catch (SQLException e) {
            AlertUtils.showAlertError("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }
}
