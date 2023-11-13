package com.example.introductiontose.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import com.example.introductiontose.model.DONGPHI;

import com.example.introductiontose.model.KHOANPHI;
import com.example.introductiontose.model.NhanKhauDaThem;
import org.jetbrains.annotations.NotNull;

public abstract class DONGPHIDAO implements DataAccessObject<DONGPHI, Integer>
    private final Connection connection;
    public DONGPHIDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<DONGPHI> getAll() {
        List<DONGPHI> danhSachDONGPHI = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM dongPhi");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DONGPHI dongphi = _get(resultSet);
                danhSachDONGPHI.add(dongphi);
            }
        } catch (SQLException e) {

        }
        return danhSachDONGPHI;
    }
    @Override
    public Optional<DONGPHI> get(Integer idPhi) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM dongPhi WHERE idPhi = ?");
            statement.setInt(1, idPhi);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                DONGPHI dongphi = _get(resultSet);
                return Optional.of(dongphi);
            }
        } catch (SQLException e) {

        }
        return Optional.empty();

    }
    @Override
    public void save(@NotNull DONGPHI dongphi) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO dongPhi" +
                    "(idPhi, idHoKhau,soTien, ngayDong) " +
                    "VALUES (?, ?, ?,?)");
            _setValuesForStatement( dongphi, statement, 1);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void update(@NotNull DONGPHI dongphi) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE dongPhi SET" +
                    "idNhanKhau = ?, " +
                    "soTien = ?, " +
                    "ngayDong = ?, " +
                    "WHERE idPhi = ?");
            int parameterIndex = _setValuesForStatement(dongphi, statement, 1);
            statement.setInt(parameterIndex, dongphi.getIdPhi());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void delete(@NotNull DONGPHI dongphi) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM dongPhi WHERE idPhi = ?");
            statement.setInt(1, dongphi.getIdPhi());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    private static DONGPHI _get(ResultSet resultSet) throws SQLException {
        int idPhi = resultSet.getInt("idPhi");
        int idHoKhau = resultSet.getInt("idHoKhau");
        int soTien = resultSet.getInt("soTien");
        LocalDateTime ngayDong = resultSet.getTimestamp("ngayDong").toLocalDateTime();

        return new DONGPHI(idPhi, idHoKhau,soTien, ngayDong);
    }
    private int _setValuesForStatement(DONGPHI dongphi, PreparedStatement statement, int index) throws SQLException {
        statement.setInt(index++, dongphi.getIdHoKhau());
        statement.setInt(index++, dongphi.getSoTien());
        statement.setTimestamp(index++, Timestamp.valueOf(dongphi.getNgayDong()));

        return index;
    }





}
