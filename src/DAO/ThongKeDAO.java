/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKeDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    public int getSoLuongKhachHang(){
        try {
            String sql = "SELECT COUNT(*) FROM khachhang";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
        
    }
    public int getSoLuongKhachHangNam(String GioiTinh){
        try {
            String sql = "SELECT COUNT(*) FROM khachhang WHERE GioiTinh = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,GioiTinh);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
                    } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
    public int getSoLuongKhachHangNu(String GioiTinh){
        try {
            String sql = "SELECT COUNT(*) FROM khachhang WHERE GioiTinh = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,GioiTinh);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
        
    }
    public int getSoLuongNhanVien(){
        try {
            String sql = "SELECT COUNT(*) FROM nhanvien";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
    public int getSoLuongNhanVienNam(String GioiTinh){
        try {
            String sql = "SELECT COUNT(*) FROM nhanvien WHERE GioiTinh = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,GioiTinh);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        } 
        return 0;
    }
    public int getSoLuongNhanVienNu(String GioiTinh){
        try {
            String sql = "SELECT COUNT(*) FROM nhanvien WHERE GioiTinh = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,GioiTinh);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
           return -1;
        }
        return 0;
        
    }
    public int getTongDoanhThu(){
        try {
            String sql = "SELECT SUM(TongTien) FROM hoadon";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
    public int getTongChiTieu(){
        try {
            String sql = "SELECT SUM(TongTien) FROM phieunhap";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
    
    
    
    
    
    


}
