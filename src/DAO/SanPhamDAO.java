/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPhamDTO;
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
public class SanPhamDAO {

    private ArrayList<SanPhamDTO> dssp = new ArrayList<>();
    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<SanPhamDTO> getListSanPham() {

        try {
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "SELECT * FROM sanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("MaNSX"),
                        rs.getString("IMG"));

                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertSanPham(SanPhamDTO sp) {

        try {
            String sql = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sp.getMaSP());
            statement.setString(2, sp.getTenSP());
            statement.setInt(3, sp.getSoLuong());
            statement.setInt(4, sp.getDonGia());
            statement.setString(5, sp.getDonViTinh());
            statement.setString(6, sp.getMaLoai());
            statement.setString(7, sp.getMaNSX());
            statement.setString(8, sp.getIMG());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không được nhập trùng Mã SP", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        } finally {
            mySQL.Disconnect();
        }
    }

    public void deleteSanPham(String MaSP) {

        try {
            String sql = "DELETE FROM sanpham WHERE MaSP = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, MaSP);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }

    public void updateSanPham(SanPhamDTO sp) {
        try {
            String sql = "UPDATE sanpham set TenSP = ?, SoLuong = ?, DonGia = ?, DonViTinh = ?, MaLoai = ?, MaNSX = ?, IMG = ? WHERE MaSP = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sp.getTenSP());
            statement.setInt(2, sp.getSoLuong());
            statement.setInt(3, sp.getDonGia());
            statement.setString(4, sp.getDonViTinh());
            statement.setString(5, sp.getMaLoai());
            statement.setString(6, sp.getMaNSX());
            statement.setString(7, sp.getIMG());
            statement.setString(8, sp.getMaSP());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }

   
    //Hàm này dùng cho trường hợp sau khi thêm sản phẩm vào giỏ hàng thì sản phẩm tự giảm đúng số lượng đã thêm
    public void capNhatSoLuongHD(String MaSP, int SoLuongMua, int SoLuongTrongKho) {
        try {
            String sql = "UPDATE sanpham SET SoLuong=? WHERE MaSP= ?" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (SoLuongMua+SoLuongTrongKho));
            statement.setString(2,MaSP);
            statement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            mySQL.Disconnect();
        }

    }
    public void capNhatSoLuongPN(String MaSP, int SoLuongNhap, int SoLuongTrongKho) {
        try {
            String sql = "UPDATE sanpham SET SoLuong=? WHERE MaSP= ?" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (SoLuongNhap+SoLuongTrongKho));
            statement.setString(2,MaSP);
            statement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            mySQL.Disconnect();
        }

    }
}
