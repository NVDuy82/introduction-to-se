package com.example.introductiontose.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class THONGBAO  {
    private LocalDateTime ngaytao;
    private int idTHONGBAO;
    private String tieuDe;
    private String noidung;
    private  int soCCCD;

    //private Nhankhau nhankhau;còn idNhanKhau chưa thêm;
    public THONGBAO(int idTHONGBAO, int soCCCD,  String tieuDe, String noidung,LocalDateTime ngaytao) {
        this.ngaytao = ngaytao;
        this.idTHONGBAO = idTHONGBAO;
        this.tieuDe = tieuDe;
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
    public String getTieuDe() {
        return tieuDe;
    }
    public void setTieuDe(String tenthongbao) {
        this.tieuDe = tenthongbao;
    }
    public String getNoidung() {
        return noidung;
    }
    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    public int getSoCCCD() {
        return soCCCD;
    }
    public void setSoCCCD(int soCCCD){
        this.soCCCD = soCCCD;
    }

}