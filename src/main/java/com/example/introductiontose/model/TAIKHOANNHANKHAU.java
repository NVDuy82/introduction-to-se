package com.example.introductiontose.model;


public class TAIKHOANNHANKHAU  {

    private  String tentaikhoan;
    private  String pass;
    private  int soCCCD;

    public TAIKHOANNHANKHAU(int soCCCD,String tentaikhoan,String pass){
        this.soCCCD=soCCCD;
        this.tentaikhoan=tentaikhoan;
        this.pass=pass;
    }
    public int getSoCCCD(){
        return soCCCD;
    }
    public String getTentaikhoan(){
        return tentaikhoan;
    }
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        this.pass=pass;
    }
    public void setSoCCCD(int soCCCD){
        this.soCCCD=soCCCD;
    }
    public void setTentaikhoan(String tentaikhoan){
        this.tentaikhoan=tentaikhoan;
    }

}