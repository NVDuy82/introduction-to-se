package com.example.introductiontose.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.introductiontose.model.KHOANPHI;

import org.jetbrains.annotations.NotNull;


public abstract class KHOANPHIDAO implements DataAccessObject<KHOANPHI, Integer> {
    private final Connection connection;
    private final String table_name;

    public enum TableType {
        KHOANPHI,
        KHOANPHICHUATHU
    }

    public KHOANPHIDAO(Connection connection, TableType tableType) {
        this.connection = connection;
        if (tableType == TableType.KHOANPHI) {
            table_name = "khoanphi";
        } else {
            table_name = "themkhoanphi";
        }
    }
    @Override
    public List<KHOANPHI> getAll() {
        List<KHOANPHI> danhSachKhoanPhi = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ?");
            statement.setString(1, table_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KHOANPHI khoanphi = _get(resultSet);
                danhSachKhoanPhi.add(khoanphi);
            }
        } catch (SQLException e) {

        }
        return danhSachKhoanPhi;
    }
    @Override
    public Optional<KHOANPHI> get(Integer idPhi) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ? WHERE idPhi = ?");
            statement.setString(1, table_name);
            statement.setInt(2, idPhi);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                KHOANPHI khoanphi = _get(resultSet);
                return Optional.of(khoanphi);
            }
        } catch (SQLException e) {

        }
        return Optional.empty();

    }
    @Override
    public void save(@NotNull KHOANPHI khoanphi) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ?" +
                    "(idPhi, kieuPhi, noiDungThuPhi, mucPhi, ngayTao, ngayKetThuc, tieuDeKhoanPhi " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, table_name);
            _setValuesForStatement(khoanphi, statement, 3);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void update(@NotNull KHOANPHI khoanphi) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE ? SET" +
                    "kieuPhi = ?, " +
                    "noiDungPhi = ?, " +
                    "mucPhi= ?, " +
                    "ngayTao = ?, " +
                    "ngayKetThuc = ?, " +
                    "tieuDeKhoanPhi = ?, "  +
                    "WHERE idPhi = ?");
            statement.setString(1, table_name);
            int parameterIndex = _setValuesForStatement(khoanphi, statement, 2);
            statement.setInt(parameterIndex, khoanphi.getIdPhi());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void delete(@NotNull KHOANPHI khoanphi) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM ? WHERE idPhi = ?");
            statement.setString(1, table_name);
            statement.setInt(2, khoanphi.getIdPhi());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    private static KHOANPHI _get(ResultSet resultSet) throws SQLException {
        KHOANPHI khoanphi = new KHOANPHI();
        khoanphi.setIdPhi(resultSet.getInt("idPhi"));
        khoanphi.setKieuphi(resultSet.getString("kieuPhi"));
        khoanphi.setNoidungphi(resultSet.getString("noiDungPhi"));
        khoanphi.setMucphi(resultSet.getInt("mucPhi"));
        khoanphi.setNgaytao(resultSet.getTimestamp("ngayTao").toLocalDateTime());
        khoanphi.setNgayketthuc(resultSet.getTimestamp("ngayKetThuc").toLocalDateTime());
        khoanphi.setTieudephi(resultSet.getString("tieuDeKhoanPhi"));
        return khoanphi;
    }
    private int _setValuesForStatement(KHOANPHI khoanphi, PreparedStatement statement, int index) throws SQLException {
        statement.setInt(index, khoanphi.getIdPhi());
        statement.setString(index + 1, khoanphi.getKieuphi());
        statement.setString(index + 2, khoanphi.getNoidungphi());
        statement.setInt(index + 3, khoanphi.getMucphi());
        statement.setTimestamp(index + 4, Timestamp.valueOf(khoanphi.getNgaytao()));
        statement.setTimestamp(index + 5, Timestamp.valueOf(khoanphi.getNgayketthuc()));
        statement.setString(index + 6, khoanphi.getTieudephi());
        return index + 7;


    }



}

