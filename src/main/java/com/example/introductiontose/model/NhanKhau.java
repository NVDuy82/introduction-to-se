package com.example.introductiontose.model;

/**
 * Lớp NhanKhau đại diện cho thông tin của một nhân khẩu trong hệ thống.
 */
public class NhanKhau {
    private int id;
    private ThongTinNhanKhau thongTinNhanKhau;
    
    /**
     * Khởi tạo một đối tượng NhanKhau mới.
     */
    public NhanKhau() {
    }
    
    /**
     * Khởi tạo một đối tượng NhanKhau với các thông tin cơ bản.
     *
     * @param id                ID của nhân khẩu.
     * @param thongTinNhanKhau Thông tin chi tiết về nhân khẩu.
     */
    public NhanKhau(int id, ThongTinNhanKhau thongTinNhanKhau) {
        this.id = id;
        this.thongTinNhanKhau = thongTinNhanKhau;
    }
    
    /**
     * Trả về ID của nhân khẩu.
     *
     * @return ID của nhân khẩu.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Thiết lập ID của nhân khẩu.
     *
     * @param id ID mới của nhân khẩu.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Trả về thông tin chi tiết về nhân khẩu.
     *
     * @return Thông tin chi tiết về nhân khẩu.
     */
    public ThongTinNhanKhau getThongTinNhanKhau() {
        return thongTinNhanKhau;
    }
    
    /**
     * Thiết lập thông tin chi tiết về nhân khẩu.
     *
     * @param thongTinNhanKhau Thông tin chi tiết mới về nhân khẩu.
     */
    public void setThongTinNhanKhau(ThongTinNhanKhau thongTinNhanKhau) {
        this.thongTinNhanKhau = thongTinNhanKhau;
    }
}
