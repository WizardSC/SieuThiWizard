/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.MySQLConnect;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<TaiKhoanDTO> getListTaiKhoan() {
        try {
            ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
            String sql = "SELECT * FROM taikhoan";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("MaNV"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("Quyen"),
                        rs.getInt("TrangThai")
                );
                dstk.add(tk);
            }
            return dstk;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public void insertTaiKhoan(TaiKhoanDTO tk){
        try {
            String sql = "INSERT INTO taikhoan VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tk.getMaNV());
            statement.setString(2, tk.getTenDangNhap());
            statement.setString(3, tk.getMatKhau());
            statement.setString(4, tk.getQuyen());
            statement.setInt(5, tk.getTrangThai());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
    
}

