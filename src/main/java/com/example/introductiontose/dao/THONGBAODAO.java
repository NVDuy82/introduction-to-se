package com.example.introductiontose.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import com.example.introductiontose.model.DONGPHI;
import com.example.introductiontose.model.THONGBAO;
import org.jetbrains.annotations.NotNull;
public abstract class THONGBAODAO implements DataAccessObject<THONGBAO, Integer> {
    private final Connection connection;
    public THONGBAODAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<THONGBAO> getAll() {
        List<THONGBAO> danhSachTHONGBAO = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM thongbao");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                THONGBAO thongbao = _get(resultSet);
                danhSachTHONGBAO.add(thongbao);
            }
        } catch (SQLException e) {

        }
        return danhSachTHONGBAO;
    }
    @Override
    public Optional<THONGBAO> get(Integer idThongBao) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM thongbao WHERE idThongBao = ?");
            statement.setInt(1, idThongBao);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                THONGBAO thongbao = _get(resultSet);
                return Optional.of(thongbao);
            }
        } catch (SQLException e) {

        }
        return Optional.empty();

    }
    @Override
    public void save(@NotNull THONGBAO thongbao) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO thongbao" +
                    "(idThongBao, soCCCD,tieuDe,noiDung, ngayTao) " +
                    "VALUES (?, ?, ?,?,?)");
            _setValuesForStatement( thongbao, statement, 1);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void update(@NotNull THONGBAO thongbao) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE thongbao SET" +
                    "soCCCD = ?, " +
                    "tienDe = ?, " +
                    "noiDung = ?, " +
                    "ngayTao =?, " +
                    "WHERE idThongBao =?");
            int parameterIndex = _setValuesForStatement(thongbao, statement, 1);
            statement.setInt(parameterIndex, thongbao.getIdTHONGBAO());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void delete(@NotNull THONGBAO thongbao) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM thongbao WHERE idThongBao = ?");
            statement.setInt(1, thongbao.getIdTHONGBAO());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    private static THONGBAO _get(ResultSet resultSet) throws SQLException {
        int idThongBao = resultSet.getInt("idThongBao");
        int soCCCD = resultSet.getInt("soCCCD");
        String tieuDe = resultSet.getString("tieuDe");
        String noiDung = resultSet.getString("noiDung");
        LocalDateTime ngayTao = resultSet.getTimestamp("ngayTao").toLocalDateTime();

        return new THONGBAO(idThongBao,soCCCD,tieuDe,noiDung,ngayTao);
    }
    private int _setValuesForStatement(THONGBAO thongbao, PreparedStatement statement, int index) throws SQLException {
        statement.setInt(index++, thongbao.getSoCCCD());
        statement.setString(index++, thongbao.getTieuDe());
        statement.setString(index++, thongbao.getNoidung());
        statement.setTimestamp(index++, Timestamp.valueOf(thongbao.getNgaytao()));

        return index;
    }

}
