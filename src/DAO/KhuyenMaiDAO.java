/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class KhuyenMaiDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
        try {
            ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
            String sql = "SELECT * FROM khuyenmai";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString("MaKM"),
                        rs.getString("TenKM"),
                        rs.getInt("PhanTramKM"),
                        rs.getInt("DieuKien"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc")
                );
                dskm.add(km);
            }
            return dskm;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void insertKhuyenMai(KhuyenMaiDTO km){
        try {
            String sql = "INSERT INTO khuyenmai VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,km.getMaKM());
            statement.setString(2,km.getTenKM());
            statement.setInt(3,km.getPhanTramKM());
            statement.setInt(4,km.getDieuKien());
            statement.setTimestamp(5, new Timestamp(km.getNgayBatDau().getTime()));
            statement.setTimestamp(6, new Timestamp(km.getNgayKetThuc().getTime()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không được nhập trùng mã KM", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        } finally {
            mySQL.Disconnect();
        }
        
    }
//    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
//
//        try {
//            ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
//            String sql = "SELECT * FROM khuyenmai";
//            ResultSet rs = mySQL.executeQuery(sql);
//            while (rs.next()) {
//                KhuyenMaiDTO km = new KhuyenMaiDTO(
//                        rs.getString("MaKM"),
//                        rs.getString("TenKM"),
//                        rs.getInt("PhanTramKM"),
//                        rs.getInt("DieuKien"),
//                        rs.getDate("NgayBatDau"),
//                        rs.getDate("NgayKetThuc"));
//                dskm.add(km);
//
//            }
//            return dskm;
//        } catch (SQLException ex) {
//            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            mySQL.Disconnect();
//        }
//        return null;
//    }
//    public void insertKhuyenMai(KhuyenMaiDTO km){
//        try {
//            String sql = "INSERT INTO khuyenmai VALUES(?,?,?,?,?,?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1,km.getMaKM());
//            statement.setString(2,km.getTenKM());
//            statement.setInt(3,km.getPhanTramKM());
//            statement.setInt(4,km.getDieuKien());
//            statement.setTimestamp(5, new Timestamp(km.getNgayBatDau().getTime()));
//            statement.setTimestamp(6, new Timestamp(km.getNgayKetThuc().getTime()));
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Không được nhập trùng mã KM", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
//        
//        } finally {
//            mySQL.Disconnect();
//        }
//        
//    }
    public void deleteKhuyenMai(String MaKM){
        try {
            String sql = "DELETE FROM khuyenmai WHERE MaKM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, MaKM);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }
    public void updateKhuyenMai(KhuyenMaiDTO km){
        try {
            String sql = "UPDATE khuyenmai SET TenKM = ?, PhanTramKM = ?, DieuKien = ?, NgayBatDau = ?, NgayKetThuc = ? WHERE MaKM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, km.getTenKM());
            statement.setInt(2,km.getPhanTramKM());
            statement.setInt(3,km.getDieuKien());
            statement.setTimestamp(4, new Timestamp(km.getNgayBatDau().getTime()));
            statement.setTimestamp(5, new Timestamp(km.getNgayKetThuc().getTime()));
            statement.setString(6,km.getMaKM());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
}
