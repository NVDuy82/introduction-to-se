package com.example.introductiontose.model;

import java.time.LocalDateTime;


public class TamVang {
    int idTamVang;
    String soCccd;
    LocalDateTime ngayBatDau, ngayKetThuc;
    String liDo;
    
    // Constructor không tham số
    public TamVang() {}
    
    // Constructor full tham số
    public TamVang(int idTamVang, String soCccd, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, String liDo) {
        this.idTamVang = idTamVang;
        this.soCccd = soCccd;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.liDo = liDo;
    }

    public int getIdTamVang() {
        return idTamVang;
    }

    public void setIdTamVang(int idTamVang) {
        this.idTamVang = idTamVang;
    }

    public String getSoCccd() {
        return soCccd;
    }

    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }

    public LocalDateTime getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDateTime ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }
    
    
}
