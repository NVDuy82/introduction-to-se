package com.example.introductiontose.dao;

import com.example.introductiontose.model.CCCD;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.ThongTinNhanKhau;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class NhanKhauDao triển khai interface DataAccessObject để thao tác với đối tượng NhanKhau trong cơ sở dữ liệu.
 */
public class NhanKhauDao implements DataAccessObject<NhanKhau, Integer>{
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng NhanKhauDao với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public NhanKhauDao(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NhanKhau> getAll() {
        List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nhanKhau");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanKhau nhanKhau = _get(resultSet);
                danhSachNhanKhau.add(nhanKhau);
            }
        } catch (SQLException e) {
        
        }
        return danhSachNhanKhau;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NhanKhau> get(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nhanKhau WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanKhau nhanKhau = _get(resultSet);
                return Optional.of(nhanKhau);
            }
        } catch (SQLException e) {
        
        }
        return Optional.empty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(@NotNull NhanKhau nhanKhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO nhanKhau" +
                    "(idHoKhau, hoTen, biDanh, ngaySinh, noiSinh, nguyenQuan, danToc, tonGiao" +
                    "ngheNghiep, noiLamViec, soCccd, ngayCap, noiCap, ngayDKTT, diaChiCu, quanHe) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            _setValuesForStatement(nhanKhau, statement, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull NhanKhau nhanKhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE nhanKhau SET" +
                    "idHoKhau = ?, " +
                    "hoTen = ?, " +
                    "biDanh = ?, " +
                    "ngaySinh = ?, " +
                    "noiSinh = ?, " +
                    "nguyenQuan = ?, " +
                    "danToc = ?, " +
                    "tonGiao = ?, " +
                    "ngheNghiep = ?, " +
                    "noiLamViec = ?, " +
                    "soCccd = ?, " +
                    "ngayCap = ?, " +
                    "noiCap = ?, " +
                    "ngayDKTT = ?, " +
                    "diaChiCu = ?, " +
                    "quanHe = ?" +
                    "WHERE id = ?");
            int parameterIndex = _setValuesForStatement(nhanKhau, statement, 1);
            statement.setInt(parameterIndex, nhanKhau.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull NhanKhau nhanKhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM nhanKhau WHERE id = ?");
            statement.setInt(1, nhanKhau.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * Phương thức private để chuyển đổi dữ liệu từ ResultSet thành đối tượng NhanKhau.
     *
     * @param resultSet ResultSet chứa dữ liệu từ cơ sở dữ liệu.
     * @return Đối tượng NhanKhau được tạo từ dữ liệu ResultSet.
     * @throws SQLException Nếu có lỗi khi truy cập dữ liệu từ ResultSet.
     */
    private static NhanKhau _get(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("idNhanKhau");
        ThongTinNhanKhau thongTinNhanKhau = Helper.get(resultSet);
        
        return new NhanKhau(id, thongTinNhanKhau);
    }
    
    /**
     * Phương thức private để thiết lập giá trị cho PreparedStatement khi thêm hoặc cập nhật NhanKhau.
     *
     * @param nhanKhau   Đối tượng NhanKhau cần được thêm hoặc cập nhật.
     * @param statement  PreparedStatement đang được chuẩn bị.
     * @param index       Index bắt đầu để thiết lập giá trị trong PreparedStatement.
     * @return Index tiếp theo sẽ được sử dụng cho các giá trị khác nếu cần.
     * @throws SQLException Nếu có lỗi khi thiết lập giá trị trong PreparedStatement.
     */
    private int _setValuesForStatement(NhanKhau nhanKhau, PreparedStatement statement, int index) throws SQLException {
        return Helper.setValuesForStatement(nhanKhau.getThongTinNhanKhau(), statement, index);
    }
}
