package com.example.introductiontose.model;

import java.time.LocalDateTime;

public class CCCD {
    private String soCccd;
    private LocalDateTime ngayCap;
    private String noiCap;

    public CCCD(String soCccd, LocalDateTime ngayCap, String noiCap) {
        this.soCccd = soCccd;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
    }

    public String getSoCccd() {
        return soCccd;
    }

    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }

    public LocalDateTime getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDateTime ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }
}
