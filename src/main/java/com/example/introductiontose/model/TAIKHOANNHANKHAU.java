package com.example.introductiontose.model;


import java.util.ArrayList;

public class TAIKHOANNHANKHAU  {

    private  String tentaikhoan;
    private  String pass;
    private  int idNHANKHAU;

    public TAIKHOANNHANKHAU(int idNHANKHAU,String tentaikhoan,String pass){
        this.idNHANKHAU=idNHANKHAU;
        this.tentaikhoan=tentaikhoan;
        this.pass=pass;
    }
    public int getIdNHANKHAU(){
        return idNHANKHAU;
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
    public void setIdNHANKHAU(int idNHANKHAU){
        this.idNHANKHAU=idNHANKHAU;
    }
    public void setTentaikhoan(String tentaikhoan){
        this.tentaikhoan=tentaikhoan;
    }

}