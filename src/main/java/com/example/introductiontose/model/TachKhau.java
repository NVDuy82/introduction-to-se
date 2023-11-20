package com.example.introductiontose.model;

import java.util.List;

public class TachKhau {
    private String soCccdChuHoMoi;
    private int idHoKhau;
    private List<String> danhSachNhanKhau;
    private String trangThai;

    public TachKhau(String soCccdChuHoMoi, int idHoKhau, List<String> danhSachNhanKhau, String trangThai) {
        this.soCccdChuHoMoi = soCccdChuHoMoi;
        this.idHoKhau = idHoKhau;
        this.danhSachNhanKhau = danhSachNhanKhau;
        this.trangThai = trangThai;
    }

    public String getSoCccdChuHoMoi() {
        return soCccdChuHoMoi;
    }

    public void setSoCccdChuHoMoi(String soCccdChuHoMoi) {
        this.soCccdChuHoMoi = soCccdChuHoMoi;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public List<String> getDanhSachNhanKhau() {
        return danhSachNhanKhau;
    }

    public void setDanhSachNhanKhau(List<String> danhSachNhanKhau) {
        this.danhSachNhanKhau = danhSachNhanKhau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
