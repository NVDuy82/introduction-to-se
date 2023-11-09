package com.example.introductiontose.dao;

import com.example.introductiontose.model.CCCD;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.ThongTinNhanKhau;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NhanKhauDao implements DataAccessObject<NhanKhau, Integer>{
    private final Connection connection;
    
    public NhanKhauDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<NhanKhau> getAll() {
        List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM table_name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanKhau nhanKhau = _get(resultSet);
                danhSachNhanKhau.add(nhanKhau);
            }
        } catch (SQLException e) {
        
        }
        return danhSachNhanKhau;
    }
    
    @Override
    public Optional<NhanKhau> get(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM table_name WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanKhau nhanKhau = _get(resultSet);
                return Optional.of(nhanKhau);
            }
        } catch (SQLException e) {
        
        }
        return Optional.empty();
    }
    
    @Override
    public void save(@NotNull NhanKhau nhanKhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO table_name" +
                    "(idHoKhau, hoTen, biDanh, ngaySinh, noiSinh, nguyenQuan, danToc, tonGiao" +
                    "ngheNghiep, noiLamViec, soCccd, ngayCap, noiCap, ngayDKTT, diaChiCu, quanHe) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            _setValuesForStatement(nhanKhau, statement);
        } catch (SQLException e) {
        
        }
    }
    
    @Override
    public void update(@NotNull NhanKhau nhanKhau) {
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
            _setValuesForStatement(nhanKhau, statement);
        } catch (SQLException e) {
        
        }
    }
    
    @Override
    public void delete(@NotNull NhanKhau nhanKhau) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM table_name WHERE id = ?");
            statement.setLong(1, nhanKhau.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        
        }
    }
    
    private NhanKhau _get(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("column-name");
        int idHoKhau = resultSet.getInt("column-name");
        String hoTen = resultSet.getString("column-name");
        String biDanh = resultSet.getString("column-name");
        LocalDateTime ngaySinh = resultSet.getTimestamp("column-name").toLocalDateTime();
        String noiSinh = resultSet.getString("column-name");
        String nguyenQuan = resultSet.getString("column-name");
        String danToc = resultSet.getString("column-name");
        String tonGiao = resultSet.getString("column-name");
        String ngheNghiep = resultSet.getString("column-name");
        String noiLamViec = resultSet.getString("column-name");
        
        String soCccd = resultSet.getString("column-name");
        LocalDateTime ngayCap = resultSet.getTimestamp("column-name").toLocalDateTime();
        String noiCap = resultSet.getString("column-name");
        
        LocalDateTime ngayDKTT = resultSet.getTimestamp("column-name").toLocalDateTime();
        String diaChiCu = resultSet.getString("column-name");
        String quanHe = resultSet.getString("column-name");
        
        CCCD cccd = new CCCD(soCccd, ngayCap, noiCap);
        ThongTinNhanKhau thongTinNhanKhau = new ThongTinNhanKhau(idHoKhau, hoTen, biDanh,ngaySinh,
                noiSinh, nguyenQuan, danToc, tonGiao, ngheNghiep, noiLamViec, cccd, ngayDKTT,
                diaChiCu, quanHe);
        return new NhanKhau(id, thongTinNhanKhau);
    }
    
    private void _setValuesForStatement(NhanKhau nhanKhau, PreparedStatement statement) throws SQLException {
        statement.setInt(1, nhanKhau.getThongTinNhanKhau().getIdHoKhau());
        statement.setString(2, nhanKhau.getThongTinNhanKhau().getHoTen());
        statement.setString(3, nhanKhau.getThongTinNhanKhau().getBiDanh());
        statement.setObject(4, Timestamp.valueOf(nhanKhau.getThongTinNhanKhau().getNgaySinh()));
        statement.setString(5, nhanKhau.getThongTinNhanKhau().getNoiSinh());
        statement.setString(6, nhanKhau.getThongTinNhanKhau().getNguyenQuan());
        statement.setString(7, nhanKhau.getThongTinNhanKhau().getDanToc());
        statement.setString(8, nhanKhau.getThongTinNhanKhau().getTonGiao());
        statement.setString(9, nhanKhau.getThongTinNhanKhau().getNgheNghiep());
        statement.setString(10, nhanKhau.getThongTinNhanKhau().getNoiLamViec());
        statement.setString(11, nhanKhau.getThongTinNhanKhau().getCccd().getSoCccd());
        statement.setObject(12, Timestamp.valueOf(nhanKhau.getThongTinNhanKhau().getCccd().getNgayCap()));
        statement.setString(13, nhanKhau.getThongTinNhanKhau().getCccd().getNoiCap());
        statement.setObject(14, Timestamp.valueOf(nhanKhau.getThongTinNhanKhau().getNgayDKTT()));
        statement.setString(15, nhanKhau.getThongTinNhanKhau().getDiaChiCu());
        statement.setString(16, nhanKhau.getThongTinNhanKhau().getQuanHe());
        statement.executeUpdate();
    }
}
