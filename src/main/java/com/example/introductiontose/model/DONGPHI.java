package com.example.introductiontose.model;

import java.time.LocalDateTime;

 public class DONGPHI {
     public KHOANPHI khoanphi;
     public DONGPHI(){}
     public DONGPHI(KHOANPHI khoanphi){
         this.khoanphi=khoanphi;
     }
     public KHOANPHI getKhoanphi(){
         return khoanphi;
     }
     public void setKhoanphi(KHOANPHI khoanphi){
         this.khoanphi=khoanphi;
     }
     public String toString(){
         return khoanphi.toString();
     }
}
