package com.example.introductiontose.view.icon;

import com.example.introductiontose.model.NhanKhau;

import java.time.format.DateTimeFormatter;

public class IconNhanKhauController extends IconController<NhanKhau> {
    private NhanKhau nhanKhau;
    
    @Override
    public NhanKhau getData() {
        return nhanKhau;
    }
    
    @Override
    public void setData(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
        // Định dạng ngày giờ theo "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        buttonIcon.setText(nhanKhau.getThongTinNhanKhau().getHoTen() + "\n" +
                nhanKhau.getThongTinNhanKhau().getNgaySinh().format(formatter));
    }
    
    @Override
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
}
