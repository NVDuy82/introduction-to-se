package com.example.introductiontose.dao;

import com.example.introductiontose.model.CCCD;
import com.example.introductiontose.model.ThongTinNhanKhau;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Class Helper cung cấp các phương thức hỗ trợ cho các class khác trong package dao
 */
public class Helper {
    /**
     * @param resultSet ResultSet chứa dữ liệu cần trích xuất.
     * @return Thông tin của nhân khẩu
     * @throws SQLException Nếu có lỗi khi truy cập dữ liệu từ ResultSet.
     */
    static ThongTinNhanKhau get(ResultSet resultSet) throws SQLException {
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
        return new ThongTinNhanKhau(idHoKhau, hoTen, biDanh,ngaySinh,
                noiSinh, nguyenQuan, danToc, tonGiao, ngheNghiep, noiLamViec, cccd, ngayDKTT,
                diaChiCu, quanHe);
    }
    
    /**
     *
     * @param thongTinNhanKhau Thông tin nhân khẩu để đưa vào truy vấn.
     * @param statement PreparedStatement đang được chuẩn bị.
     * @param index Index bắt đầu để thiết lập giá trị trong PreparedStatement.
     * @return Index tiếp theo sẽ được sử dụng cho các giá trị khác nếu cần.
     * @throws SQLException Nếu có lỗi khi thiết lập giá trị trong PreparedStatement.
     */
    static int setValuesForStatement(ThongTinNhanKhau thongTinNhanKhau, PreparedStatement statement, int index) throws SQLException {
        statement.setInt(index++, thongTinNhanKhau.getIdHoKhau());
        statement.setString(index++, thongTinNhanKhau.getHoTen());
        statement.setString(index++, thongTinNhanKhau.getBiDanh());
        statement.setObject(index++, Timestamp.valueOf(thongTinNhanKhau.getNgaySinh()));
        statement.setString(index++, thongTinNhanKhau.getNoiSinh());
        statement.setString(index++, thongTinNhanKhau.getNguyenQuan());
        statement.setString(index++, thongTinNhanKhau.getDanToc());
        statement.setString(index++, thongTinNhanKhau.getTonGiao());
        statement.setString(index++, thongTinNhanKhau.getNgheNghiep());
        statement.setString(index++, thongTinNhanKhau.getNoiLamViec());
        statement.setString(index++, thongTinNhanKhau.getCccd().getSoCccd());
        statement.setObject(index++, Timestamp.valueOf(thongTinNhanKhau.getCccd().getNgayCap()));
        statement.setString(index++, thongTinNhanKhau.getCccd().getNoiCap());
        statement.setObject(index++, Timestamp.valueOf(thongTinNhanKhau.getNgayDKTT()));
        statement.setString(index++, thongTinNhanKhau.getDiaChiCu());
        statement.setString(index++, thongTinNhanKhau.getQuanHe());
        return index;
    }
}
