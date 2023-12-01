package com.example.introductiontose.dao;

import com.example.introductiontose.model.TamVang;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class TamVangDAO triển khai interface DataAccessObject để thao tác với đối tượng TamVang trong cơ sở dữ liệu.
 */
public class TamVangDAO implements DataAccessObject<TamVang, Integer> {
    private final Connection connection;
    
    /**
     * Khởi tạo một đối tượng TamVangDAO với kết nối cơ sở dữ liệu được cung cấp.
     *
     * @param connection Kết nối đến cơ sở dữ liệu.
     */
    public TamVangDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<TamVang> getAll() throws SQLException {
        List<TamVang> list = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM tamvang");
        
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int idTamVang = rs.getInt("idTamVang");
            String soCccd = rs.getString("soCccd");
            LocalDateTime ngayBatDau = rs.getTimestamp("ngayBatDau").toLocalDateTime();
            LocalDateTime ngayKetThuc = rs.getTimestamp("ngayKetThuc").toLocalDateTime();
            String liDo = rs.getString("liDo");
            
            TamVang tamvang = new TamVang(idTamVang, soCccd, ngayBatDau, ngayKetThuc, liDo);
            list.add(tamvang);
        }
        
        return list;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(@NotNull TamVang t) throws SQLException {
        String sql = "INSERT INTO tamvang (soCccd, ngayBatDau, ngayKetThuc, liDo) VALUES (?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(sql);
        
        st.setString(1, t.getSoCccd());
        st.setTimestamp(2, Timestamp.valueOf(t.getNgayBatDau()));
        st.setTimestamp(3, Timestamp.valueOf(t.getNgayKetThuc()));
        st.setString(4, t.getLiDo());
        
        st.executeUpdate();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@NotNull TamVang t) throws SQLException {
        String sql = "UPDATE tamvang SET soCccd = ?, ngayBatDau = ?, ngayKetThuc = ?, liDo = ? WHERE idTamVang = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        
        st.setString(1, t.getSoCccd());
        st.setTimestamp(2, Timestamp.valueOf(t.getNgayBatDau()));
        st.setTimestamp(3, Timestamp.valueOf(t.getNgayKetThuc()));
        st.setString(4, t.getLiDo());
        st.setInt(5, t.getIdTamVang());
        
        st.executeUpdate();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull TamVang t) throws SQLException {
        String sql = "DELETE FROM tamvang WHERE idTamVang = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        
        st.setInt(1, t.getIdTamVang());
        
        st.executeUpdate();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<TamVang> get(Integer id) throws SQLException {
        String sql = "SELECT * FROM tamvang WHERE idTamVang = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            int idTamVang = rs.getInt("idTamVang");
            String soCccd = rs.getString("soCccd");
            LocalDateTime ngayBatDau = rs.getTimestamp("ngayBatDau").toLocalDateTime();
            LocalDateTime ngayKetThuc = rs.getTimestamp("ngayKetThuc").toLocalDateTime();
            String liDo = rs.getString("liDo");
            
            TamVang tamvang = new TamVang(idTamVang, soCccd, ngayBatDau, ngayKetThuc, liDo);
            return Optional.of(tamvang);
        }
        
        return Optional.empty();
    }
}
