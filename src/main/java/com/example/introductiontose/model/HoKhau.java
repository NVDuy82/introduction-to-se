package com.example.introductiontose.model;

import java.time.LocalDateTime;

public class HoKhau {
    private int idHoKhau;
    private String tenChuHo;
    private String soCccdChuHo;
    private String diaChiNha;
    private LocalDateTime ngayTaoHK;
    public HoKhau() {

    }

    public HoKhau(int idHoKhau, String tenChuHo, String soCccdChuHo, String diaChiNha, LocalDateTime ngayTaoHK) {
        this.idHoKhau = idHoKhau;
        this.tenChuHo = tenChuHo;
        this.soCccdChuHo = soCccdChuHo;
        this.diaChiNha = diaChiNha;
        this.ngayTaoHK = ngayTaoHK;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getSoCccdChuHo() {
        return soCccdChuHo;
    }

    public void setSoCccdChuHo(String soCccdChuHo) {
        this.soCccdChuHo = soCccdChuHo;
    }

    public String getDiaChiNha() {
        return diaChiNha;
    }

    public void setDiaChiNha(String diaChiNha) {
        this.diaChiNha = diaChiNha;
    }

    public LocalDateTime getNgayTaoHK() {
        return ngayTaoHK;
    }

    public void setNgayTaoHK(LocalDateTime ngayTaoHK) {
        this.ngayTaoHK = ngayTaoHK;
    }
}
