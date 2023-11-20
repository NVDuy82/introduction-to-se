package com.example.introductiontose.dao;

import com.example.introductiontose.model.HoKhau;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class HoKhauDAO triển khai interface DataAccessObject để thao tác với đối tượng HoKhau trong cơ sở dữ liệu.
 */
public class HoKhauDAO implements DataAccessObject<HoKhau, Integer> {
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng HoKhauDAO với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public HoKhauDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<HoKhau> getAll() {
        List<HoKhau> hoKhaus = new ArrayList<>();
        String sql = "SELECT * FROM hokhau";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                HoKhau hoKhau = new HoKhau(
                        resultSet.getInt("idHoKhau"),
                        resultSet.getString("tenChuHo"),
                        resultSet.getString("soCccdChuHo"),
                        resultSet.getString("diaChiNha"),
                        resultSet.getTimestamp("ngayTaoHK").toLocalDateTime());
                hoKhaus.add(hoKhau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoKhaus;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<HoKhau> get(Integer id) {
        String sql = "SELECT * FROM hokhau WHERE idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                HoKhau hoKhau = new HoKhau(
                        resultSet.getInt("idHoKhau"),
                        resultSet.getString("tenChuHo"),
                        resultSet.getString("soCccdChuHo"),
                        resultSet.getString("diaChiNha"),
                        resultSet.getTimestamp("ngayTaoHK").toLocalDateTime());
                return Optional.of(hoKhau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(@NotNull HoKhau hoKhau) {
        String sql = "INSERT INTO hokhau (idHoKhau, tenChuHo, soCccdChuHo, diaChiNha, ngayTaoHK) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoKhau.getIdHoKhau());
            statement.setString(2, hoKhau.getTenChuHo());
            statement.setString(3, hoKhau.getSoCccdChuHo());
            statement.setString(4, hoKhau.getDiaChiNha());
            statement.setObject(5, Timestamp.valueOf(hoKhau.getNgayTaoHK()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull HoKhau hoKhau) {
        String sql = "UPDATE hokhau SET idHoKhau = ?, tenChuHo = ?, soCccdChuHo = ?, diaChiNha = ?, ngayTaoHK = ? WHERE idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoKhau.getIdHoKhau());
            statement.setString(2, hoKhau.getTenChuHo());
            statement.setString(3, hoKhau.getSoCccdChuHo());
            statement.setString(4, hoKhau.getDiaChiNha());
            statement.setObject(5, Timestamp.valueOf(hoKhau.getNgayTaoHK()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull HoKhau hoKhau) {
        String sql = "DELETE FROM hokhau WHERE idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoKhau.getIdHoKhau());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
