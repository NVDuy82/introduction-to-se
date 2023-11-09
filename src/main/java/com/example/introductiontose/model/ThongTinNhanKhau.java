package com.example.introductiontose.model;

import java.time.LocalDateTime;

public class ThongTinNhanKhau {
    private int idHoKhau;
    private String hoTen;
    private String biDanh;
    private LocalDateTime ngaySinh;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String tonGiao;
    private String ngheNghiep;
    private String noiLamViec;
    private CCCD cccd;
    private LocalDateTime ngayDKTT;
    private String diaChiCu;
    private String quanHe;

    public ThongTinNhanKhau() {
    }

    public ThongTinNhanKhau(int idHoKhau, String hoTen, String biDanh, LocalDateTime ngaySinh, String noiSinh, String nguyenQuan, String danToc, String tonGiao, String ngheNghiep, String noiLamViec, CCCD cccd, LocalDateTime ngayDKTT, String diaChiCu, String quanHe) {
        this.idHoKhau = idHoKhau;
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.cccd = cccd;
        this.ngayDKTT = ngayDKTT;
        this.diaChiCu = diaChiCu;
        this.quanHe = quanHe;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public LocalDateTime getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDateTime ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public CCCD getCccd() {
        return cccd;
    }

    public void setCccd(CCCD cccd) {
        this.cccd = cccd;
    }

    public LocalDateTime getNgayDKTT() {
        return ngayDKTT;
    }

    public void setNgayDKTT(LocalDateTime ngayDKTT) {
        this.ngayDKTT = ngayDKTT;
    }

    public String getDiaChiCu() {
        return diaChiCu;
    }

    public void setDiaChiCu(String diaChiCu) {
        this.diaChiCu = diaChiCu;
    }

    public String getQuanHe() {
        return quanHe;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }
}
