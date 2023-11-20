package database.models;

import java.time.LocalDateTime;

/**
 * Lớp CacKhoanPhi đại diện cho các khoản phí trong hệ thống.
 */
public class CacKhoanPhi {
    private int idPhi;
    private String kieuphi;
    private String noidungphi;
    private int mucphi;
    private LocalDateTime ngaytao;
    private LocalDateTime ngayketthuc;
    private String tieudephi;
    
    /**
     * Khởi tạo một đối tượng CacKhoanPhi mới với thông tin cung cấp.
     *
     * @param idPhi       ID của khoản phí.
     * @param kieuphi     Loại khoản phí.
     * @param noidungphi  Nội dung của khoản phí.
     * @param mucphi      Mức phí.
     * @param ngayketthuc Ngày kết thúc hiệu lực của khoản phí.
     * @param ngaytao     Ngày tạo khoản phí.
     * @param tieudephi   Tiêu đề của khoản phí.
     */
    public CacKhoanPhi(int idPhi, String kieuphi, String noidungphi, int mucphi, LocalDateTime ngayketthuc, LocalDateTime ngaytao, String tieudephi) {
        this.idPhi = idPhi;
        this.kieuphi = kieuphi;
        this.noidungphi = noidungphi;
        this.mucphi = mucphi;
        this.ngayketthuc = ngayketthuc;
        this.ngaytao = ngaytao;
        this.tieudephi = tieudephi;
    }
    
    /**
     * Lấy ID của khoản phí.
     *
     * @return ID của khoản phí.
     */
    public int getIdPhi() {
        return idPhi;
    }
    
    /**
     * Thiết lập ID mới cho khoản phí.
     *
     * @param idPhi ID mới cho khoản phí.
     */
    public void setIdPhi(int idPhi) {
        this.idPhi = idPhi;
    }
    
    /**
     * Lấy loại khoản phí.
     *
     * @return Loại khoản phí.
     */
    public String getKieuphi() {
        return kieuphi;
    }
    
    /**
     * Thiết lập loại mới cho khoản phí.
     *
     * @param kieuphi Loại mới cho khoản phí.
     */
    public void setKieuphi(String kieuphi) {
        this.kieuphi = kieuphi;
    }
    
    /**
     * Lấy nội dung của khoản phí.
     *
     * @return Nội dung của khoản phí.
     */
    public String getNoidungphi() {
        return noidungphi;
    }
    
    /**
     * Thiết lập nội dung mới cho khoản phí.
     *
     * @param noidungphi Nội dung mới cho khoản phí.
     */
    public void setNoidungphi(String noidungphi) {
        this.noidungphi = noidungphi;
    }
    
    /**
     * Lấy mức phí của khoản phí.
     *
     * @return Mức phí của khoản phí.
     */
    public int getMucphi() {
        return mucphi;
    }
    
    /**
     * Thiết lập mức phí mới cho khoản phí.
     *
     * @param mucphi Mức phí mới cho khoản phí.
     */
    public void setMucphi(int mucphi) {
        this.mucphi = mucphi;
    }
    
    /**
     * Lấy ngày tạo của khoản phí.
     *
     * @return Ngày tạo của khoản phí.
     */
    public LocalDateTime getNgaytao() {
        return ngaytao;
    }
    
    /**
     * Thiết lập ngày tạo mới cho khoản phí.
     *
     * @param ngaytao Ngày tạo mới cho khoản phí.
     */
    public void setNgaytao(LocalDateTime ngaytao) {
        this.ngaytao = ngaytao;
    }
    
    /**
     * Lấy ngày kết thúc hiệu lực của khoản phí.
     *
     * @return Ngày kết thúc hiệu lực của khoản phí.
     */
    public LocalDateTime getNgayketthuc() {
        return ngayketthuc;
    }
    
    /**
     * Thiết lập ngày kết thúc mới cho khoản phí.
     *
     * @param ngayketthuc Ngày kết thúc mới cho khoản phí.
     */
    public void setNgayketthuc(LocalDateTime ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }
    
    /**
     * Lấy tiêu đề của khoản phí.
     *
     * @return Tiêu đề của khoản phí.
     */
    public String getTieudephi() {
        return tieudephi;
    }
    
    /**
     * Thiết lập tiêu đề mới cho khoản phí.
     *
     * @param tieudephi Tiêu đề mới cho khoản phí.
     */
    public void setTieudephi(String tieudephi) {
        this.tieudephi = tieudephi;
    }
}
