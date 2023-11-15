package com.example.introductiontose.model;


import java.util.ArrayList;

public class TAIKHOANNHANKHAU  {

    private  String tentaikhoan;
    private  String pass;
    private  String soCCCD;

    public TAIKHOANNHANKHAU(String soCCCD,String tentaikhoan,String pass){
        this.soCCCD=soCCCD;
        this.tentaikhoan=tentaikhoan;
        this.pass=pass;
    }
    public String  getSoCCCD(){
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
    public void setSoCCCD(String soCCCD){
        this.soCCCD=soCCCD;
    }
    public void setTentaikhoan(String tentaikhoan){
        this.tentaikhoan=tentaikhoan;
    }

}