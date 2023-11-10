package com.example.introductiontose.model;

import java.time.LocalDateTime;

/**
 * Lớp NhanKhauDaThem đại diện cho thông tin của một nhân khẩu mới đã được thêm vào hệ thống.
 */
public class NhanKhauDaThem {
    private int id;
    private LocalDateTime ngayThem;
    
    /**
     * Khởi tạo một đối tượng NhanKhauDaThem mới.
     */
    public NhanKhauDaThem() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDateTime getNgayThem() {
        return ngayThem;
    }
    
    public void setNgayThem(LocalDateTime ngayThem) {
        this.ngayThem = ngayThem;
    }
}
