package com.example.introductiontose.model;

import java.time.LocalDateTime;

 public class DONGPHI {
     private int idPhi;
     private int idHoKhau;
     private LocalDateTime ngayDong;
     private int soTien;
     public DONGPHI(){
     }
     public DONGPHI (int idPhi, int idHoKhau,int soTien, LocalDateTime ngayDong){
         this.idPhi=idPhi;
         this.idHoKhau=idHoKhau;
         this.soTien=soTien;
         this.ngayDong=ngayDong;
     }
     public static int getIdPhi() {
         return idPhi;
     }
     public void setIdPhi(int idPhi) {
         this.idPhi = idPhi;
     }
     public int getIdHoKhau(){
         return idHoKhau;
     }
     public void setIdHoKhau(int idHoKhau){
         this.idHoKhau=idHoKhau;
     }
     public LocalDateTime getNgayDong(){
         return ngayDong;
     }
     public void setNgayDong(LocalDateTime ngayDong){
         this.ngayDong=ngayDong;
     }
     public void setSoTien(int soTien){
         this.soTien=soTien;
     }
     public int getSoTien(){
         return soTien;
     }
}
