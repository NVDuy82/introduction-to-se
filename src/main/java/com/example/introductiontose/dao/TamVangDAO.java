/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.introductiontose.dao;

import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.TamVang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author hokta
 */
public class TamVangDAO implements DataAccessObject<TamVang , int>{

//    
//    public enum TableType {
//        TamVang,
//        TamTru
//    }
    
    @Override
    public List<TamVang> getAll() {
        List<TamVang> list = new ArrayList();
        try{
            PreparedStatement st = SqlConnection.connect().prepareStatement("SELECT * FROM tamvang");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TamVang tamvang = get(rs);
                list.add(tamvang);
            }
        }   catch(SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        return list;
    }

    @Override
    public Optional<TamVang> get(<any> id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(TamVang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TamVang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TamVang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
