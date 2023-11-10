package com.example.introductiontose.model;

/**
 * Lớp NhanKhauThem đại diện cho thông tin của một nhân khẩu mới được thêm vào hệ thống.
 */
public class NhanKhauThem {
    private int index;
    private ThongTinNhanKhau thongTinNhanKhau;
    
    /**
     * Khởi tạo một đối tượng NhanKhauThem mới.
     */
    public NhanKhauThem() {
    }
    
    /**
     * Khởi tạo một đối tượng NhanKhauThem với các thông tin cơ bản.
     *
     * @param index             Index nhân khẩu trong danh sách cần thêm.
     * @param thongTinNhanKhau Thông tin chi tiết về nhân khẩu.
     */
    public NhanKhauThem(int index, ThongTinNhanKhau thongTinNhanKhau) {
        this.index = index;
        this.thongTinNhanKhau = thongTinNhanKhau;
    }
    
    /**
     * Trả về Index nhân khẩu trong danh sách cần thêm.
     *
     * @return Index nhân khẩu trong danh sách cần thêm.
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Thiết lập Index mới cho nhân khẩu trong danh sách cần thêm.
     *
     * @param index Index mới của nhân khẩu trong danh sách cần thêm.
     */
    public void setIndex(int index) {
        this.index = index;
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
