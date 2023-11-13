package com.example.introductiontose.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class THONGBAO  {
    private LocalDateTime ngaytao;
    private int idTHONGBAO;
    private String tenthongbao;
    private String noidung;
    private  String soCCCD;

    //private Nhankhau nhankhau;còn idNhanKhau chưa thêm;
    public THONGBAO(LocalDateTime ngaytao, int idTHONGBAO, String tenthongbao, String noidung, String soCCCD) {
        this.ngaytao = ngaytao;
        this.idTHONGBAO = idTHONGBAO;
        this.tenthongbao = tenthongbao;
        this.noidung = noidung;
        this.soCCCD = soCCCD;
    }
    public LocalDateTime getNgaytao() {
        return ngaytao;
    }
    public void setNgaytao(LocalDateTime ngaytao) {
        this.ngaytao = ngaytao;
    }
    public int getIdTHONGBAO() {
        return idTHONGBAO;
    }
    public void setIdTHONGBAO(int idTHONGBAO) {
        this.idTHONGBAO = idTHONGBAO;
    }
    public String getTenthongbao() {
        return tenthongbao;
    }
    public void setTenthongbao(String tenthongbao) {
        this.tenthongbao = tenthongbao;
    }
    public String getNoidung() {
        return noidung;
    }
    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    public String getSoCCCD() {
        return soCCCD;
    }
    public void setSoCCCD(String soCCCD){
        this.soCCCD = soCCCD;
    }

}