package com.example.introductiontose.dao;

import com.example.introductiontose.model.TachKhau;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TachKhauDAO implements DataAccessObject<TachKhau, TachKhauKey> {

    private final Connection connection;

    public TachKhauDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TachKhau> getAll() {
        List<TachKhau> danhSachTachKhau = new ArrayList<>();
        String sql = "SELECT * FROM tachkhau";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                List<String> danhSachNhanKhau = parseDanhSachNhanKhau(resultSet.getString("danhSachNhanKhau"));

                TachKhau tachKhau = new TachKhau(
                        resultSet.getString("soCccdChuHoMoi"),
                        resultSet.getInt("idHoKhau"),
                        danhSachNhanKhau,
                        resultSet.getString("trangThai"));
                danhSachTachKhau.add(tachKhau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachTachKhau;
    }

    @Override
    public Optional<TachKhau> get(TachKhauKey key) {
        String sql = "SELECT * FROM tachkhau WHERE soCccdChuHoMoi = ? AND idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, key.getSoCccdChuHoMoi());
            statement.setInt(2, key.getIdHoKhau());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                List<String> danhSachNhanKhau = parseDanhSachNhanKhau(resultSet.getString("danhSachNhanKhau"));

                TachKhau tachKhau = new TachKhau(
                        resultSet.getString("soCccdChuHoMoi"),
                        resultSet.getInt("idHoKhau"),
                        danhSachNhanKhau,
                        resultSet.getString("trangThai"));
                return Optional.of(tachKhau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(@NotNull TachKhau tachKhau) {
        String sql = "INSERT INTO tachkhau (soCccdChuHoMoi, idHoKhau, danhSachNhanKhau, trangThai) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tachKhau.getSoCccdChuHoMoi());
            statement.setInt(2, tachKhau.getIdHoKhau());
            statement.setString(3, String.join(",", tachKhau.getDanhSachNhanKhau()));
            statement.setString(4, tachKhau.getTrangThai());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(@NotNull TachKhau tachKhau) {
        String sql = "UPDATE tachkhau SET danhSachNhanKhau = ?, trangThai = ? WHERE soCccdChuHoMoi = ? AND idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, String.join(",", tachKhau.getDanhSachNhanKhau()));
            statement.setString(2, tachKhau.getTrangThai());
            statement.setString(3, tachKhau.getSoCccdChuHoMoi());
            statement.setInt(4, tachKhau.getIdHoKhau());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(@NotNull TachKhau tachKhau) {
        String sql = "DELETE FROM tachkhau WHERE soCccdChuHoMoi = ? AND idHoKhau = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tachKhau.getSoCccdChuHoMoi());
            statement.setInt(2, tachKhau.getIdHoKhau());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private List<String> parseDanhSachNhanKhau(String data) {
        return new ArrayList<>(Arrays.asList(data.split(",")));
    }
}

// Class khóa chính
class TachKhauKey implements Serializable {
    private String soCccdChuHoMoi;
    private int idHoKhau;

    public TachKhauKey(String soCccdChuHoMoi, int idHoKhau) {
        this.soCccdChuHoMoi = soCccdChuHoMoi;
        this.idHoKhau = idHoKhau;
    }

    public String getSoCccdChuHoMoi() {
        return soCccdChuHoMoi;
    }

    public void setSoCccdChuHoMoi(String soCccdChuHoMoi) {
        this.soCccdChuHoMoi = soCccdChuHoMoi;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }
}
