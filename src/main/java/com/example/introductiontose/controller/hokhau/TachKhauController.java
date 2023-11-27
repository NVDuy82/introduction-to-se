package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.TachKhauDAO;
import com.example.introductiontose.dao.ThayDoiHoKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.TachKhau;
import com.example.introductiontose.model.ThayDoiHoKhau;
import com.example.introductiontose.model.key.TachKhauKey;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconController;
import com.example.introductiontose.view.icon.IconType;
import javafx.scene.image.Image;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TachKhauController extends DanhSachHoController {
    private final List<IconController> selectedList = new ArrayList<>();
    
    public TachKhauController() {
        this.originalIconType = IconType.CHUHO;
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
            AlertUtils.showAlert("Xác nhận", "Bạn có chắc chắn tách " +
                    selectedList.get(0).getNhanKhau().getThongTinNhanKhau().getHoTen() +
                    " và " +
                    (selectedList.size() - 1) +
                    " người khác sang hộ khẩu mới không?", image, this::sendRequire);
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
            if (!selectedList.isEmpty() && selectedList.get(0) == iconController) {
                iconController.setIconType(IconType.NHANKHAU);
            }
            selectedList.remove(iconController);
            
            if (selectedList.isEmpty()) {
                ActionButton.hideButtonSubmit(submitButton);
                ActionButton.hideButtonClear(clearButton);
                isAnyObjectSelected = true;
            }
        }
        
        reload(iconControllerList);
    }
    
    @Override
    void clearSelected() {
        selectedList.clear();
        isAnyObjectSelected = false;
    }
    
    private void reload(List<IconController> iconControllerList) {
        if (selectedList.isEmpty()) {
            changeIconType(iconControllerList, IconType.CHUHO);
        } else {
            if (selectedList.size() == 1) {
                changeIconType(iconControllerList, IconType.NHANKHAU);
            }
            selectedList.get(0).setIconType(IconType.CHUHO);
        }
    }
    
    private void changeIconType(List<IconController> iconControllerList, IconType iconType) {
        for (IconController iconController : iconControllerList) {
            if (!iconController.isSelected()) {
                iconController.setIconType(iconType);
            }
        }
    }
    
    private void sendRequire() {
        Connection connection = SqlConnection.connect();
        DataAccessObject<TachKhau, TachKhauKey> accessObject = new TachKhauDAO(connection);
        List<String> danhSachNhanKhau = new ArrayList<>();
        for (int i = 1; i < selectedList.size(); i++) {
            danhSachNhanKhau.add(selectedList.get(i).getNhanKhau().getThongTinNhanKhau().getCccd().getSoCccd());
        }
        TachKhau change = new TachKhau(selectedList.get(0).getNhanKhau().getThongTinNhanKhau().getCccd().getSoCccd(),
                idHoKhau,
                danhSachNhanKhau,
                null);
        try {
            accessObject.save(change);
            connection.close();
        } catch (Exception e) {
            AlertUtils.showAlert("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }
}
