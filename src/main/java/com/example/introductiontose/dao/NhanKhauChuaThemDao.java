package com.example.introductiontose.dao;

import com.example.introductiontose.model.NhanKhauChuaThem;
import com.example.introductiontose.model.ThongTinNhanKhau;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Lớp NhanKhauThemDao triển khai giao diện DataAccessObject để thao tác với đối tượng NhanKhauChuaThem trong cơ sở dữ liệu.
 */
public class NhanKhauChuaThemDao implements DataAccessObject<NhanKhauChuaThem, Integer> {
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng NhanKhauThemDao với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public NhanKhauChuaThemDao(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NhanKhauChuaThem> getAll() {
        List<NhanKhauChuaThem> danhSachNhanKhauChuaThem = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM themNhanKhau");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanKhauChuaThem nhanKhauChuaThem = _get(resultSet);
                danhSachNhanKhauChuaThem.add(nhanKhauChuaThem);
            }
        } catch (SQLException e) {
        
        }
        return danhSachNhanKhauChuaThem;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NhanKhauChuaThem> get(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM themNhanKhau WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanKhauChuaThem nhanKhauChuaThem = _get(resultSet);
                return Optional.of(nhanKhauChuaThem);
            }
        } catch (SQLException e) {
        
        }
        return Optional.empty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(@NotNull NhanKhauChuaThem nhanKhauChuaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO themNhanKhau" +
                    "(idHoKhau, hoTen, biDanh, ngaySinh, noiSinh, nguyenQuan, danToc, tonGiao" +
                    "ngheNghiep, noiLamViec, soCccd, ngayCap, noiCap, ngayDKTT, diaChiCu, quanHe) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            _setValuesForStatement(nhanKhauChuaThem, statement, 1);
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull NhanKhauChuaThem nhanKhauChuaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE themNhanKhau SET" +
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
            int parameterIndex = _setValuesForStatement(nhanKhauChuaThem, statement, 1);
            statement.setInt(parameterIndex, nhanKhauChuaThem.getIndex());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull NhanKhauChuaThem nhanKhauChuaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM themNhanKhau WHERE id = ?");
            statement.setInt(1, nhanKhauChuaThem.getIndex());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * Phương thức private để chuyển đổi dữ liệu từ ResultSet thành đối tượng NhanKhauChuaThem.
     *
     * @param resultSet ResultSet chứa dữ liệu từ cơ sở dữ liệu.
     * @return Đối tượng NhanKhauChuaThem được tạo từ dữ liệu ResultSet.
     * @throws SQLException Nếu có lỗi khi truy cập dữ liệu từ ResultSet.
     */
    private NhanKhauChuaThem _get(ResultSet resultSet) throws SQLException {
        int index = resultSet.getInt("idThem");
        ThongTinNhanKhau thongTinNhanKhau = Helper.get(resultSet);
        
        return new NhanKhauChuaThem(index, thongTinNhanKhau);
    }
    
    /**
     * Phương thức private để thiết lập giá trị cho PreparedStatement khi thêm hoặc cập nhật NhanKhauChuaThem.
     *
     * @param nhanKhauChuaThem Đối tượng NhanKhauChuaThem cần được thêm hoặc cập nhật.
     * @param statement   PreparedStatement đang được chuẩn bị.
     * @param index       Index bắt đầu để thiết lập giá trị trong PreparedStatement.
     * @return Index tiếp theo sẽ được sử dụng cho các giá trị khác nếu cần.
     * @throws SQLException Nếu có lỗi khi thiết lập giá trị trong PreparedStatement.
     */
    private int _setValuesForStatement(NhanKhauChuaThem nhanKhauChuaThem, PreparedStatement statement, int index) throws SQLException {
        return Helper.setValuesForStatement(nhanKhauChuaThem.getThongTinNhanKhau(), statement, index);
    }
}
