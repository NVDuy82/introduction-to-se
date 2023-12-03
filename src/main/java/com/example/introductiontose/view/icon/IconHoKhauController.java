package com.example.introductiontose.view.icon;

import com.example.introductiontose.model.HoKhau;

public class IconHoKhauController extends IconController<HoKhau> {
    private HoKhau hoKhau;
    @Override
    public void setData(HoKhau hoKhau) {
        this.hoKhau = hoKhau;
        buttonIcon.setText(String.valueOf(hoKhau.getIdHoKhau()) + " - " + hoKhau.getTenChuHo());
    }
    
    @Override
    public HoKhau getData() {
        return hoKhau;
    }
    
    @Override
    public void mouseEffect() {
        String path = "/com/example/introductiontose/view/iconImg/";
        String name;
        if (buttonIcon.isHover()) {
            name = "icons8-house-fill-100.png";
        } else {
            name = "icons8-house-100.png";
        }
        imageIcon.setImage(imageFromResourceAsStream(path + name));
    }
}
