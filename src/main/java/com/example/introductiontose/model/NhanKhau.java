package com.example.introductiontose.model;

import java.time.LocalDateTime;

public class NhanKhau {
    private int id;
    private ThongTinNhanKhau thongTinNhanKhau;
    
    public NhanKhau() {
    }

    public NhanKhau(int id, ThongTinNhanKhau thongTinNhanKhau) {
        this.id = id;
        this.thongTinNhanKhau = thongTinNhanKhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThongTinNhanKhau getThongTinNhanKhau() {
        return thongTinNhanKhau;
    }

    public void setThongTinNhanKhau(ThongTinNhanKhau thongTinNhanKhau) {
        this.thongTinNhanKhau = thongTinNhanKhau;
    }
}
