package com.example.introductiontose.dao;

import com.example.introductiontose.model.NhanKhauThem;
import com.example.introductiontose.model.ThongTinNhanKhau;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Lớp NhanKhauThemDao triển khai giao diện DataAccessObject để thao tác với đối tượng NhanKhauThem trong cơ sở dữ liệu.
 */
public class NhanKhauThemDao implements DataAccessObject<NhanKhauThem, Integer> {
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng NhanKhauThemDao với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public NhanKhauThemDao(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NhanKhauThem> getAll() {
        List<NhanKhauThem> danhSachNhanKhauThem = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM table_name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanKhauThem nhanKhauThem = _get(resultSet);
                danhSachNhanKhauThem.add(nhanKhauThem);
            }
        } catch (SQLException e) {
        
        }
        return danhSachNhanKhauThem;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NhanKhauThem> get(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM table_name WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanKhauThem nhanKhauThem = _get(resultSet);
                return Optional.of(nhanKhauThem);
            }
        } catch (SQLException e) {
        
        }
        return Optional.empty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(@NotNull NhanKhauThem nhanKhauThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO table_name" +
                    "(idHoKhau, hoTen, biDanh, ngaySinh, noiSinh, nguyenQuan, danToc, tonGiao" +
                    "ngheNghiep, noiLamViec, soCccd, ngayCap, noiCap, ngayDKTT, diaChiCu, quanHe) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            _setValuesForStatement(nhanKhauThem, statement, 1);
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull NhanKhauThem nhanKhauThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE table_name SET" +
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
            int parameterIndex = _setValuesForStatement(nhanKhauThem, statement, 1);
            statement.setInt(parameterIndex, nhanKhauThem.getIndex());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull NhanKhauThem nhanKhauThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM table_name WHERE id = ?");
            statement.setInt(1, nhanKhauThem.getIndex());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * Phương thức private để chuyển đổi dữ liệu từ ResultSet thành đối tượng NhanKhauThem.
     *
     * @param resultSet ResultSet chứa dữ liệu từ cơ sở dữ liệu.
     * @return Đối tượng NhanKhauThem được tạo từ dữ liệu ResultSet.
     * @throws SQLException Nếu có lỗi khi truy cập dữ liệu từ ResultSet.
     */
    private NhanKhauThem _get(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("column-name");
        ThongTinNhanKhau thongTinNhanKhau = Helper.get(resultSet);
        
        return new NhanKhauThem(id, thongTinNhanKhau);
    }
    
    /**
     * Phương thức private để thiết lập giá trị cho PreparedStatement khi thêm hoặc cập nhật NhanKhauThem.
     *
     * @param nhanKhauThem Đối tượng NhanKhauThem cần được thêm hoặc cập nhật.
     * @param statement   PreparedStatement đang được chuẩn bị.
     * @param index       Index bắt đầu để thiết lập giá trị trong PreparedStatement.
     * @return Index tiếp theo sẽ được sử dụng cho các giá trị khác nếu cần.
     * @throws SQLException Nếu có lỗi khi thiết lập giá trị trong PreparedStatement.
     */
    private int _setValuesForStatement(NhanKhauThem nhanKhauThem, PreparedStatement statement, int index) throws SQLException {
        return Helper.setValuesForStatement(nhanKhauThem.getThongTinNhanKhau(), statement, index);
    }
}
