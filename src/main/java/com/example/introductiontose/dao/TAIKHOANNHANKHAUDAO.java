package com.example.introductiontose.dao;

import com.example.introductiontose.model.DONGPHI;
import org.jetbrains.annotations.NotNull;
import com.example.introductiontose.model.TAIKHOANNHANKHAU;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public abstract class TAIKHOANNHANKHAUDAO implements DataAccessObject<TAIKHOANNHANKHAU, Integer> {
    private final Connection connection;
    public TAIKHOANNHANKHAUDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<TAIKHOANNHANKHAU> getAll() {
        List<TAIKHOANNHANKHAU> danhSachTAIKHOANNHANKHAU = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM taikhoan");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TAIKHOANNHANKHAU taikhoannhankhau = _get(resultSet);
                danhSachTAIKHOANNHANKHAU.add(taikhoannhankhau);
            }
        } catch (SQLException e) {

        }
        return danhSachTAIKHOANNHANKHAU;
    }
    @Override
    public Optional<TAIKHOANNHANKHAU> get(Integer soCCCD) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM taikhoan WHERE soCCCD = ?");
            statement.setInt(1, soCCCD);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                TAIKHOANNHANKHAU taikhoannhankhau = _get(resultSet);
                return Optional.of(taikhoannhankhau);
            }
        } catch (SQLException e) {

        }
        return Optional.empty();

    }
    @Override
    public void save(@NotNull TAIKHOANNHANKHAU taikhoannhankhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO taikhoan" +
                    "(soCCCD, tenTaiKhoan, matKhau) " +
                    "VALUES (?, ?, ?)");
            _setValuesForStatement( taikhoannhankhau, statement, 1);
            statement.executeUpdate();
        } catch (SQLException e) {

        }

    }
    @Override
    public void update(@NotNull TAIKHOANNHANKHAU taikhoannhankhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE taikhoan SET" +
                    "tenTaiKhoan = ?, " +
                    "matKhau = ?, " +
                    "WHERE soCCCD = ?");
            int parameterIndex = _setValuesForStatement(taikhoannhankhau, statement, 1);
            statement.setInt(parameterIndex, taikhoannhankhau.getSoCCCD());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    @Override
    public void delete(@NotNull TAIKHOANNHANKHAU taikhoannhankhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM taikhoan WHERE soCCCD = ?");
            statement.setInt(1, taikhoannhankhau.getSoCCCD());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    private static TAIKHOANNHANKHAU _get(ResultSet resultSet) throws SQLException {
        int soCCCD = resultSet.getInt("soCCCD");
        String tenTaiKhoan = resultSet.getString("tenTaiKhoan");
        String matKhau = resultSet.getString("matKhau");

        return new TAIKHOANNHANKHAU(soCCCD, tenTaiKhoan, matKhau);
    }
    private int _setValuesForStatement(TAIKHOANNHANKHAU taikhoannhankhau, PreparedStatement statement, int index) throws SQLException {
        statement.setInt(index++, taikhoannhankhau.getSoCCCD());
        statement.setString(index++, taikhoannhankhau.getTentaikhoan());
        statement.setString(index++, taikhoannhankhau.getPass());

        return index;
    }


}
