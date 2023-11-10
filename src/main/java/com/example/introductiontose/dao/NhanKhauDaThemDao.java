package com.example.introductiontose.dao;

import com.example.introductiontose.model.NhanKhauDaThem;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Class NhanKhauDaThemDao triển khai interface DataAccessObject để thao tác với đối tượng NhanKhauDaThem trong cơ sở dữ liệu.
 */
public class NhanKhauDaThemDao implements DataAccessObject<NhanKhauDaThem, Integer> {
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng NhanKhauThemDao với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public NhanKhauDaThemDao(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NhanKhauDaThem> getAll() {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NhanKhauDaThem> get(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nhanKhauDaThem WHERE id = ?");
            statement.setLong(1, id);
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
    
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull NhanKhauDaThem nhanKhauDaThem) {
    
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull NhanKhauDaThem nhanKhauDaThem) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM nhanKhauDaThem WHERE id = ?");
            statement.setInt(1, nhanKhauDaThem.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    private static NhanKhauDaThem _get(ResultSet resultSet) throws SQLException {
        
        return new NhanKhauDaThem();
    }
}
