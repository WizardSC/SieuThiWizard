/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.LoaiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class LoaiDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<LoaiDTO> dsloai = new ArrayList<>();
    private Connection connection = mySQL.getConnection();
    public ArrayList<LoaiDTO> getListLoai() {
        try {
            ArrayList<LoaiDTO> dsloai = new ArrayList<>();

            String sql = "SELECT * FROM loai";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                LoaiDTO loai = new LoaiDTO(
                        rs.getString("MaLoai"),
                        rs.getString("TenLoai"));
                        
                dsloai.add(loai);
                
            }
            
            return dsloai;
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            mySQL.Disconnect();
        }
        return null;
    }
    public void insertLoai(LoaiDTO loai){
        
        try {
            String sql = "INSERT INTO loai VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,loai.getMaLoai());
            statement.setString(2,loai.getTenLoai());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không được nhập trùng mã Loại", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        
        } finally {
            mySQL.Disconnect();
        }
    }
    public void deleteLoai(String MaLoai){
        try {
            String sql = "DELETE FROM loai WHERE MaLoai = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,MaLoai);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }
    public void updateLoai(LoaiDTO loai){
        try {
            String sql = "UPDATE loai SET TenLoai = ? WHERE MaLoai = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,loai.getTenLoai());
            statement.setString(2,loai.getMaLoai());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
}
