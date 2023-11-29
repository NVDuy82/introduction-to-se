package com.example.introductiontose.view.icon;

import com.example.introductiontose.Application;
import com.example.introductiontose.model.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class IconController implements Initializable {
    private enum ImageType {
        NHANKHAU_IN_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-100.png"),
        NHANKHAU_OUT_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-gray-100.png"),
        NHANKHAU_IN_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-white-100.png"),
        NHANKHAU_OUT_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-user-100.png"),
        CHUHO_IN_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-9FAAE5-100.png"),
        CHUHO_OUT_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-color-100.png"),
        CHUHO_IN_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-white-100.png"),
        CHUHO_OUT_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-user-color-100.png");
        
        private final String iconPath;
        
        ImageType(String iconPath) {
            this.iconPath = iconPath;
        }
        
        public String getIconPath() {
            return iconPath;
        }
    }
    
    @FXML
    private Button buttonIcon;
    @FXML
    private ImageView imageIcon;
    private boolean isSelected = false;
    private IconType iconType;
    private NhanKhau nhanKhau;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (nhanKhau != null) {
            buttonIcon.setText(nhanKhau.getThongTinNhanKhau().getHoTen());
        }
        setIconType(IconType.NHANKHAU);
    }
    
    public void setIconType(IconType iconType) {
        this.iconType = iconType;
        setCssButton(iconType);
        mouseEffect();
    }
    
    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
        // Định dạng ngày giờ theo "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        buttonIcon.setText(nhanKhau.getThongTinNhanKhau().getHoTen() + "\n" +
                nhanKhau.getThongTinNhanKhau().getNgaySinh().format(formatter));
    }
    
    public void setSelected(boolean selected) {
        isSelected = selected;
        mouseEffect();
    }
    
    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }
    
    public boolean isSelected() {
        return isSelected;
    }
    
    public void mouseEffect() {
        ImageType imageType = null;
        
        if (buttonIcon.isHover()) {
            if (isSelected && iconType == IconType.CHUHO) {
                imageType = ImageType.CHUHO_IN_SELECTED;
            } else if (isSelected && iconType == IconType.NHANKHAU) {
                imageType = ImageType.NHANKHAU_IN_SELECTED;
            } else if (!isSelected && iconType == IconType.CHUHO) {
                imageType = ImageType.CHUHO_IN_UNSELECTED;
            } else if (!isSelected && iconType == IconType.NHANKHAU) {
                imageType = ImageType.NHANKHAU_IN_UNSELECTED;
            }
        } else {
            if (isSelected && iconType == IconType.CHUHO) {
                imageType = ImageType.CHUHO_OUT_SELECTED;
            } else if (isSelected && iconType == IconType.NHANKHAU) {
                imageType = ImageType.NHANKHAU_OUT_SELECTED;
            } else if (!isSelected && iconType == IconType.CHUHO) {
                imageType = ImageType.CHUHO_OUT_UNSELECTED;
            } else if (!isSelected && iconType == IconType.NHANKHAU) {
                imageType = ImageType.NHANKHAU_OUT_UNSELECTED;
            }
        }
        
        if (imageType != null) {
            imageIcon.setImage(imageFromResourceAsStream(imageType.getIconPath()));
        }
    }
    
    private void setCssButton(IconType iconType) {
        // Xóa tất cả các style class hiện tại
        buttonIcon.getStyleClass().clear();

        // Set Css
        buttonIcon.getStyleClass().add(iconType.getClassName());
    }
    
    private Image imageFromResourceAsStream(String name) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(name)));
    }
}
