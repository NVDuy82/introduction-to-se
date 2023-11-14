package com.example.introductiontose.model;

import java.time.LocalDateTime;


public class tamtru {
    int idtamtru;
    String soCccd;
    LocalDateTime ngayBatDau, ngayKetThuc;
    String liDo;
    
    // Constructor không tham số
    public tamtru() {}
    
    // Constructor full tham số
    public tamtru(int idtamtru, String soCccd, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, String liDo) {
        this.idtamtru = idtamtru;
        this.soCccd = soCccd;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.liDo = liDo;
    }

    public int getIdtamtru() {
        return idtamtru;
    }

    public void setIdtamtru(int idtamtru) {
        this.idtamtru = idtamtru;
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
