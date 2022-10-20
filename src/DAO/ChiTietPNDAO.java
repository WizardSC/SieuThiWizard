/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPNDTO;
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
public class ChiTietPNDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<ChiTietPNDTO> getListChiTietPN() {
        try {
            ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
            String sql = "SELECT * FROM chitietpn";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                ChiTietPNDTO ctpn = new ChiTietPNDTO(
                        rs.getString("MaPN"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien"));
                dsctpn.add(ctpn);
            }
            return dsctpn;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPNDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public ArrayList<ChiTietPNDTO> getListChiTietPNTheoMaPN(String MaPN) {
        try {
            ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
            String sql = "SELECT * FROM chitietpn WHERE MaPN = " + MaPN;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                ChiTietPNDTO ctpn = new ChiTietPNDTO(
                        rs.getString("MaPN"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien")
                );
                dsctpn.add(ctpn);
            }
            return dsctpn;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPNDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;

    }


    public void insertCTPN(ChiTietPNDTO ctpn) {
        try {
            String sql = "INSERT INTO chitietpn VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ctpn.getMaPN());
            statement.setString(2, ctpn.getMaSP());
            statement.setString(3, ctpn.getTenSP());
            statement.setInt(4, ctpn.getSoLuong());
            statement.setInt(5, ctpn.getDonGia());
            statement.setInt(6, ctpn.getThanhTien());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPNDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }
}
