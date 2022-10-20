/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.Date;
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
public class HoaDonDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    private ArrayList<HoaDonDTO> dshd = new ArrayList<>();
    public ArrayList<HoaDonDTO> getListHoaDon(){
        try {
            ArrayList<HoaDonDTO> dshd = new ArrayList<>();
            String sql = "SELECT * FROM hoadon";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next()){
                HoaDonDTO hd = new HoaDonDTO(
                        rs.getString("MaHD"),
                        rs.getString("MaKH"),
                        rs.getString("MaNV"),
                        rs.getString("NgayLap"),
                        rs.getString("TongTien")
                );
                dshd.add(hd);
                        }
            return dshd;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public void insertHoaDon(HoaDonDTO hd){
        try {
            String sql = "INSERT INTO hoadon VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,hd.getMaHD());
            statement.setString(2,hd.getMaKH());
            statement.setString(3,hd.getMaNV());
            statement.setString(4,hd.getNgayLap());
            statement.setString(5,hd.getTongTien());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Trùng mã hóa đơn, vui lòng nhập lại!","CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        } finally {
            mySQL.Disconnect();
        }
        
    }
    
    
}
