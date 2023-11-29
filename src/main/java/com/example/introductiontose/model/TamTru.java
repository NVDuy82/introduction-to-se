package com.example.introductiontose.model;

import java.time.LocalDate;

public class TamTru {
    private String soCCCD;
    private String CccdChuHo;
    private String hoTen, biDanh;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String tonGiao;
    private String ngheNghiep;
    private String noiLamViec;
    private String noiCap;
    private String diaChiCu, quanHe;
    private String lyDo;
    private LocalDate ngaysinh;
    private LocalDate ngayCap, ngayKetThuc;

    public TamTru(){};
    
    public TamTru(String soCCCD, String CccdChuHo, String hoTen, String biDanh, String noiSinh, String nguyenQuan, String danToc, String tonGiao, String ngheNghiep, String noiLamViec, String noiCap, String diaChiCu, String quanHe, String lyDo, LocalDate ngaysinh, LocalDate ngayCap, LocalDate ngayKetThuc) {
        this.soCCCD = soCCCD;
        this.CccdChuHo = CccdChuHo;
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.noiCap = noiCap;
        this.diaChiCu = diaChiCu;
        this.quanHe = quanHe;
        this.lyDo = lyDo;
        this.ngaysinh = ngaysinh;
        this.ngayCap = ngayCap;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public String getCccdChuHo() {
        return CccdChuHo;
    }

    public void setCccdChuHo(String CccdChuHo) {
        this.CccdChuHo = CccdChuHo;
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

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
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

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
}