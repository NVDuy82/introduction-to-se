package com.example.introductiontose.model;

import java.time.LocalDateTime;

public class KHOANPHI {
    private int idPhi;
    private String kieuphi;
    private String noidungphi;
    private int mucphi;
    private LocalDateTime ngaytao;
    private LocalDateTime ngayketthuc;
    private String tieudephi;
    
    public KHOANPHI() {
    }
    
    public KHOANPHI(int idPhi, String kieuphi, String noidungohi, int mucphi, LocalDateTime ngayketthuc, LocalDateTime ngaytao, String tieudephi){
        this.idPhi=idPhi;
        this.kieuphi=kieuphi;
        this.noidungphi=noidungohi;
        this.mucphi=mucphi;
        this.ngayketthuc=ngayketthuc;
        this.ngaytao=ngaytao;
        this.tieudephi=tieudephi;
    }
    
    public int getIdPhi() {
        return idPhi;
    }
    
    public void setIdPhi(int idPhi) {
        this.idPhi = idPhi;
    }
    
    public String getKieuphi() {
        return kieuphi;
    }
    
    public void setKieuphi(String kieuphi) {
        this.kieuphi = kieuphi;
    }
    
    public String getNoidungphi() {
        return noidungphi;
    }
    
    public void setNoidungphi(String noidungphi) {
        this.noidungphi = noidungphi;
    }
    
    public int getMucphi() {
        return mucphi;
    }
    
    public void setMucphi(int mucphi) {
        this.mucphi = mucphi;
    }
    
    public LocalDateTime getNgaytao() {
        return ngaytao;
    }
    
    public void setNgaytao(LocalDateTime ngaytao) {
        this.ngaytao = ngaytao;
    }
    
    public LocalDateTime getNgayketthuc() {
        return ngayketthuc;
    }
    
    public void setNgayketthuc(LocalDateTime ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }
    
    public String getTieudephi() {
        return tieudephi;
    }
    
    public void setTieudephi(String tieudephi) {
        this.tieudephi = tieudephi;
    }
}