package com.example.introductiontose.dao;

import com.example.introductiontose.model.NhanKhauDaThem;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class NhanKhauDaThemDao triển khai interface DataAccessObject để thao tác với đối tượng NhanKhauDaThem trong cơ sở dữ liệu.
 */
public class NhanKhauDaThemDAO implements DataAccessObject<NhanKhauDaThem, Integer> {
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng NhanKhauThemDao với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public NhanKhauDaThemDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NhanKhauDaThem> getAll() {
        List<NhanKhauDaThem> danhSachNhanKhauDaThem = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nhanKhauDaThem");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanKhauDaThem nhanKhauDaThem = _get(resultSet);
                danhSachNhanKhauDaThem.add(nhanKhauDaThem);
            }
        } catch (SQLException e) {
        
        }
        return danhSachNhanKhauDaThem;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NhanKhauDaThem> get(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nhanKhauDaThem WHERE idDaThem = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanKhauDaThem nhanKhauDaThem = _get(resultSet);
                return Optional.of(nhanKhauDaThem);
            }
        } catch (SQLException e) {
        
        }
        return Optional.empty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(@NotNull NhanKhauDaThem nhanKhauDaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO nhanKhauDaThem" +
                    "(soCccd, idHoKhau, ngayThem) " +
                    "VALUES (?, ?, ?)");
            _setValuesForStatement(nhanKhauDaThem, statement, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull NhanKhauDaThem nhanKhauDaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE nhanKhauDaThem SET" +
                    "idNhanKhau = ?, " +
                    "soCccd = ?, " +
                    "ngayThem = ?, " +
                    "WHERE idDaThem = ?");
            int parameterIndex = _setValuesForStatement(nhanKhauDaThem, statement, 1);
            statement.setInt(parameterIndex, nhanKhauDaThem.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull NhanKhauDaThem nhanKhauDaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM nhanKhauDaThem WHERE idDaThem = ?");
            statement.setInt(1, nhanKhauDaThem.getId());
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
    private NhanKhauDaThem _get(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String soCccd = resultSet.getString("soCcccd");
        int idHoKhau = resultSet.getInt("idHoKhau");
        LocalDateTime ngayThem = resultSet.getTimestamp("ngayThem").toLocalDateTime();
        
        return new NhanKhauDaThem(id, soCccd, idHoKhau, ngayThem);
    }
    
    /**
     * Phương thức private để thiết lập giá trị cho PreparedStatement khi thêm hoặc cập nhật NhanKhau.
     *
     * @param nhanKhauDaThem   Đối tượng NhanKhau cần được thêm hoặc cập nhật.
     * @param statement        PreparedStatement đang được chuẩn bị.
     * @param index            Index bắt đầu để thiết lập giá trị trong PreparedStatement.
     * @return Index tiếp theo sẽ được sử dụng cho các giá trị khác nếu cần.
     * @throws SQLException Nếu có lỗi khi thiết lập giá trị trong PreparedStatement.
     */
    private int _setValuesForStatement(NhanKhauDaThem nhanKhauDaThem, PreparedStatement statement, int index) throws SQLException {
        statement.setString(index++, nhanKhauDaThem.getSoCccd());
        statement.setInt(index++, nhanKhauDaThem.getIdHoKhau());
        statement.setTimestamp(index++, Timestamp.valueOf(nhanKhauDaThem.getNgayThem()));
        
        return index;
    }
}
