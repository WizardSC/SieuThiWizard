/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import DTO.NhaSanXuatDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NhaSanXuatDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<NhaSanXuatDTO> getListNhaSanXuat() {
        try {
            ArrayList<NhaSanXuatDTO> dsnsx = new ArrayList<>();
            
            String sql = "SELECT * FROM nhasanxuat";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NhaSanXuatDTO nsx = new NhaSanXuatDTO(
                        rs.getString("MaNSX"),
                        rs.getString("TenNSX")
                );

                dsnsx.add(nsx);
            }
            return dsnsx;
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertNhaSanXuat(NhaSanXuatDTO nsx) {
        try {
            String sql = "INSERT INTO nhasanxuat VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nsx.getMaNSX());
            statement.setString(2, nsx.getTenNSX());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }

    public void deleteNhaSanXuat(String MaNSX) {
        try {
            String sql = "DELETE FROM nhasanxuat WHERE MaNSX = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, MaNSX);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }

    public void updateNhaSanXuat(NhaSanXuatDTO nsx) {
        try {
            String sql = "UPDATE nhasanxuat SET TenNSX = ? WHERE MaNSX = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nsx.getTenNSX());
            statement.setString(2, nsx.getMaNSX());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }

}
