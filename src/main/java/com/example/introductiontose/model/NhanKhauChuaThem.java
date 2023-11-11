package com.example.introductiontose.model;

/**
 * Lớp NhanKhauChuaThem đại diện cho thông tin của một nhân khẩu mới chưa được thêm vào hệ thống.
 */
public class NhanKhauChuaThem {
    private ThongTinNhanKhau thongTinNhanKhau;
    
    /**
     * Khởi tạo một đối tượng NhanKhauChuaThem mới.
     */
    public NhanKhauChuaThem() {
    }
    
    /**
     * Khởi tạo một đối tượng NhanKhauChuaThem với các thông tin cơ bản.
     *
     * @param thongTinNhanKhau Thông tin chi tiết về nhân khẩu.
     */
    public NhanKhauChuaThem(ThongTinNhanKhau thongTinNhanKhau) {
        this.thongTinNhanKhau = thongTinNhanKhau;
    }
    
    /**
     * Trả về thông tin chi tiết về nhân khẩu mới.
     *
     * @return Thông tin chi tiết về nhân khẩu mới.
     */
    public ThongTinNhanKhau getThongTinNhanKhau() {
        return thongTinNhanKhau;
    }
    
    /**
     * Thiết lập thông tin chi tiết về nhân khẩu mới.
     *
     * @param thongTinNhanKhau Thông tin chi tiết mới về nhân khẩu mới.
     */
    public void setThongTinNhanKhau(ThongTinNhanKhau thongTinNhanKhau) {
        this.thongTinNhanKhau = thongTinNhanKhau;
    }
}
