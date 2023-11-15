package com.example.introductiontose.dao;

import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.KHOANPHI;
import com.example.introductiontose.model.TamTru;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TamTruDAO implements DataAccessObject<TamTru, Integer> {

    @Override
    public List<TamTru> getAll() {
        List<TamTru> list = new ArrayList<>();
        try {
            Connection connection = SqlConnection.connect();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tamvang");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idTamTru = rs.getInt("idTamTru");
                String soCccd = rs.getString("soCccd");
                LocalDateTime ngayBatDau = rs.getTimestamp("ngayBatDau").toLocalDateTime();
                LocalDateTime ngayKetThuc = rs.getTimestamp("ngayKetThuc").toLocalDateTime();
                String liDo = rs.getString("liDo");

                TamTru tamvang = new TamTru(idTamTru, soCccd, ngayBatDau, ngayKetThuc, liDo);
                list.add(tamvang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Error while retrieving data from the database.");
        }

        return list;
    }

    @Override
    public void save(TamTru t) {
        try {
            Connection connection = SqlConnection.connect();
            String sql = "INSERT INTO tamvang (soCccd, ngayBatDau, ngayKetThuc, liDo) VALUES (?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, t.getSoCccd());
            st.setTimestamp(2, Timestamp.valueOf(t.getNgayBatDau()));
            st.setTimestamp(3, Timestamp.valueOf(t.getNgayKetThuc()));
            st.setString(4, t.getLiDo());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Error while saving data to the database.");
        }
    }

    @Override
    public void update(TamTru t) {
        try {
            Connection connection = SqlConnection.connect();
            String sql = "UPDATE tamvang SET soCccd = ?, ngayBatDau = ?, ngayKetThuc = ?, liDo = ? WHERE idTamTru = ?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, t.getSoCccd());
            st.setTimestamp(2, Timestamp.valueOf(t.getNgayBatDau()));
            st.setTimestamp(3, Timestamp.valueOf(t.getNgayKetThuc()));
            st.setString(4, t.getLiDo());
            st.setInt(5, t.getIdTamTru());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Error while updating data in the database.");
        }
    }

    @Override
    public void delete(TamTru t) {
        try {
            Connection connection = SqlConnection.connect();
            String sql = "DELETE FROM tamvang WHERE idTamTru = ?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, t.getIdTamTru());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Error while deleting data from the database.");
        }
    }

    @Override
    public Optional<TamTru> get(Integer id) {
        try {
            Connection connection = SqlConnection.connect();
            String sql = "SELECT * FROM tamvang WHERE idTamTru = ?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int idTamTru = rs.getInt("idTamTru");
                String soCccd = rs.getString("soCccd");
                LocalDateTime ngayBatDau = rs.getTimestamp("ngayBatDau").toLocalDateTime();
                LocalDateTime ngayKetThuc = rs.getTimestamp("ngayKetThuc").toLocalDateTime();
                String liDo = rs.getString("liDo");

                TamTru tamvang = new TamTru(idTamTru, soCccd, ngayBatDau, ngayKetThuc, liDo);
                return Optional.of(tamvang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Error while retrieving data from the database.");
        }

        return Optional.empty();
    }

    @Override
    public Optional<TamTru> get(int idPhi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
