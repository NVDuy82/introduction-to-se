package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.util.ActionButton;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.view.icon.IconController;
import com.example.introductiontose.view.icon.IconType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
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
//        Connection connection = SqlConnection.connect();
//        DataAccessObject accessObject;
//        for (IconController iconController : selectedList) {
//            NhanKhau nhanKhau = iconController.getNhanKhau();
//
//            Stage dialogStage = createInputDialog(nhanKhau, accessObject);
//            if (dialogStage != null) {
//                dialogStage.showAndWait();
//            }
//        }
    }

    private Stage createInputDialog(NhanKhau nhanKhau, DataAccessObject accessObject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InputDialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initOwner(submitButton.getScene().getWindow());

            Scene scene = new Scene(loader.load());
            dialogStage.setScene(scene);

            InputDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTitle(nhanKhau.getThongTinNhanKhau().getHoTen());
            controller.setSoCccd(nhanKhau.getThongTinNhanKhau().getCccd().getSoCccd());
            controller.setAccessObject(accessObject);

            return dialogStage;
        } catch (IOException e) {
            // create icon
            String imagePath = "/com/example/introductiontose/view/iconImg/icons8-alert-96.png";
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));

            // create alert
            AlertUtils.showAlert("Lỗi", "Xảy ra lỗi trong phần mềm.", image);
        }

        return null;
    }
}
