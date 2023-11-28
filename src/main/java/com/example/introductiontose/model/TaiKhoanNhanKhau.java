package com.example.introductiontose.model;

/**
 * Lớp TaiKhoanNhanKhau đại diện cho thông tin về tài khoản của nhân khẩu trong hệ thống.
 */
public class TaiKhoanNhanKhau {
    private String tentaikhoan;
    private String pass;
    private int soCCCD;
    
    /**
     * Khởi tạo một đối tượng TaiKhoanNhanKhau mới với thông tin cung cấp.
     *
     * @param soCCCD       Số CCCD của nhân khẩu.
     * @param tentaikhoan  Tên tài khoản.
     * @param pass         Mật khẩu.
     */
    public TaiKhoanNhanKhau(int soCCCD, String tentaikhoan, String pass) {
        this.soCCCD = soCCCD;
        this.tentaikhoan = tentaikhoan;
        this.pass = pass;
    }
    
    /**
     * Lấy số CCCD của nhân khẩu.
     *
     * @return Số CCCD của nhân khẩu.
     */
    public int getSoCCCD() {
        return soCCCD;
    }
    
    /**
     * Lấy tên tài khoản.
     *
     * @return Tên tài khoản.
     */
    public String getTentaikhoan() {
        return tentaikhoan;
    }
    
    /**
     * Lấy mật khẩu.
     *
     * @return Mật khẩu.
     */
    public String getPass() {
        return pass;
    }
    
    /**
     * Thiết lập mật khẩu mới.
     *
     * @param pass Mật khẩu mới.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    /**
     * Thiết lập số CCCD của nhân khẩu.
     *
     * @param soCCCD Số CCCD của nhân khẩu.
     */
    public void setSoCCCD(int soCCCD) {
        this.soCCCD = soCCCD;
    }
    
    /**
     * Thiết lập tên tài khoản mới.
     *
     * @param tentaikhoan Tên tài khoản mới.
     */
    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }
}
