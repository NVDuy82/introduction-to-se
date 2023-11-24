package com.example.introductiontose.model.key;

import java.io.Serializable;

// Class khóa chính
public class HoKhauKey implements Serializable {
    private String soCccdChuHo;
    private int idHoKhau;

    public HoKhauKey(String soCccdChuHo, int idHoKhau) {
        this.soCccdChuHo = soCccdChuHo;
        this.idHoKhau = idHoKhau;
    }

    public String getSoCccdChuHo() {
        return soCccdChuHo;
    }

    public void setSoCccdChuHo(String soCccdChuHo) {
        this.soCccdChuHo = soCccdChuHo;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }
}
