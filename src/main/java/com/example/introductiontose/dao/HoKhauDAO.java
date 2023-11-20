package com.example.introductiontose.dao;

import com.example.introductiontose.model.HoKhau;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoKhauDAO implements DataAccessObject<HoKhau, HoKhauKey> {

    private final Connection connection;

    public HoKhauDAO(Connection connection) {
        this.connection = connection;
    }

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

    @Override
    public Optional<HoKhau> get(HoKhauKey key) {
        String sql = "SELECT * FROM hokhau WHERE soCccdChuHo = ? AND idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, key.getSoCccdChuHo());
            statement.setInt(2, key.getIdHoKhau());
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

    @Override
    public void update(@NotNull HoKhau hoKhau) {
        String sql = "UPDATE hokhau SET idHoKhau = ?, tenChuHo = ?, diaChiNha = ?, ngayTaoHK = ? WHERE idHoKhau = ? AND soCccdChuHo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoKhau.getIdHoKhau());
            statement.setString(2, hoKhau.getTenChuHo());
            statement.setString(5, hoKhau.getSoCccdChuHo());
            statement.setString(3, hoKhau.getDiaChiNha());
            statement.setObject(4, Timestamp.valueOf(hoKhau.getNgayTaoHK()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(@NotNull HoKhau hoKhau) {
        String sql = "DELETE FROM hokhau WHERE idHoKhau = ? AND soCccdChuHo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoKhau.getIdHoKhau());
            statement.setString(2, hoKhau.getSoCccdChuHo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Class khóa chính
class HoKhauKey implements Serializable {
    private String soCccdChuHo;
    private int idHoKhau;

    public HoKhauKey(String soCccdChuHo, int idHoKhau) {
        this.soCccdChuHo = soCccdChuHo;
        this.idHoKhau = idHoKhau;
    }

    public String getSoCccdChuHo() {
        return soCccdChuHo;
    }

    public void setSoCccdChuHo(String soCccdChuHo) {
        this.soCccdChuHo = soCccdChuHo;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }
}