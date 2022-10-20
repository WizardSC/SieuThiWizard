/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class NhanVienDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<NhanVienDTO> getListNhanVien() {

        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sql = "SELECT * FROM nhanvien";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getString("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoDT"),
                        rs.getInt("Luong"),
                        rs.getString("IMG"));
                dsnv.add(nv);
            }
            return dsnv;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;

    }

    public void insertNhanVien(NhanVienDTO nv) {

        try {
            String sql = "INSERT INTO nhanvien VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nv.getMaNV());
            statement.setString(2, nv.getHo());
            statement.setString(3, nv.getTen());
            statement.setString(4, nv.getNgaySinh());
            statement.setString(5, nv.getGioiTinh());
            statement.setString(6, nv.getDiaChi());
            statement.setString(7, nv.getSoDT());
            statement.setInt(8, nv.getLuong());
            statement.setString(9, nv.getIMG());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không được nhập trùng mã NV","Cảnh báo",JOptionPane.ERROR_MESSAGE);
        } finally {
            mySQL.Disconnect();
        }
    }

    public void deleteNhanVien(String MaNV) {

        try {
            String sql = "DELETE FROM nhanvien WHERE MaNV = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, MaNV);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }
    public void updateNhanVien(NhanVienDTO nv){
        try {
            String sql = "UPDATE nhanvien SET Ho = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, Luong = ?, IMG = ? WHERE MaNV = ?";      
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,nv.getHo());
            statement.setString(2,nv.getTen());
            statement.setString(3,nv.getNgaySinh());
            statement.setString(4,nv.getGioiTinh());
            statement.setString(5,nv.getDiaChi());
            statement.setString(6,nv.getSoDT());
            statement.setInt(7,nv.getLuong());
            statement.setString(8,nv.getIMG());
            statement.setString(9,nv.getMaNV());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
    public void updateLuongNhanVien(String MaNV, int Luong){
        try {
            String sql = "UPDATE nhanvien SET Luong = ? WHERE MaNV = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,Luong);
            statement.setString(2,MaNV);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }
    public void ExportExcel() {

        try {

            String sql = "SELECT * FROM nhanvien";
            ResultSet rs = mySQL.executeQuery(sql);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("NhanVien");

            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue("MaNV");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("Ho");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("Ten");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("NgaySinh");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("GioiTinh");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue("DiaChi");
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue("SoDT");
            cell.setCellStyle(style);
            cell = row.createCell(7);
            cell.setCellValue("Luong");
            cell.setCellStyle(style);
            cell = row.createCell(8);
            cell.setCellValue("IMG");
            cell.setCellStyle(style);
            int i = 1;

            while (rs.next()) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(rs.getString("MaNV"));
                cell = row.createCell(1);
                cell.setCellValue(rs.getString("Ho"));
                cell = row.createCell(2);
                cell.setCellValue(rs.getString("Ten"));
                cell = row.createCell(3);
                cell.setCellValue(rs.getString("NgaySinh"));
                cell = row.createCell(4);
                cell.setCellValue(rs.getString("GioiTinh"));
                cell = row.createCell(5);
                cell.setCellValue(rs.getString("DiaChi"));
                cell = row.createCell(6);
                cell.setCellValue(rs.getString("SoDT"));
                cell = row.createCell(7);
                cell.setCellValue(rs.getInt("Luong"));
                cell = row.createCell(8);
                cell.setCellValue(rs.getString("IMG"));
                i++;
            }
            for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
                sheet.autoSizeColumn((short) (colNum));
            }

            FileOutputStream out = new FileOutputStream(new File("./report/NhanVien.xlsx"));
            workbook.write(out);
            out.close();

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void ImportExcel(File file) {

        try {

            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                String MaNV = row.getCell(0).getStringCellValue();
                String Ho = row.getCell(1).getStringCellValue();
                String Ten = row.getCell(2).getStringCellValue();
                String NgaySinh = row.getCell(3).getStringCellValue();
                String GioiTinh = row.getCell(4).getStringCellValue();
                String DiaChi = row.getCell(5).getStringCellValue();
                String SoDT = row.getCell(6).getStringCellValue();
                int Luong = (int) row.getCell(7).getNumericCellValue();
                String IMG = row.getCell(8).getStringCellValue();

                String sql_check = "SELECT * FROM nhanvien WHERE MaNV='" + MaNV + "'";
                ResultSet rs = mySQL.executeQuery(sql_check);

                if (!rs.next()) {
                    String sql = "INSERT INTO nhanvien VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pstatement = connection.prepareStatement(sql);
                    pstatement.setString(1, MaNV);
                    pstatement.setString(2, Ho);
                    pstatement.setString(3, Ten);
                    pstatement.setString(4, NgaySinh);
                    pstatement.setString(5, GioiTinh);
                    pstatement.setString(6, DiaChi);
                    pstatement.setString(7, SoDT);
                    pstatement.setInt(8, Luong);
                    pstatement.setString(9, IMG);
                    pstatement.executeUpdate();

                    System.out.println(sql);

                } else {
                    String sql = "UPDATE nhanvien SET Ho = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, Luong = ?, IMG = ? WHERE MaNV = ?";
                    PreparedStatement pstatement = connection.prepareStatement(sql);

                    pstatement.setString(1, Ho);
                    pstatement.setString(2, Ten);
                    pstatement.setString(3, NgaySinh);
                    pstatement.setString(4, GioiTinh);
                    pstatement.setString(5, DiaChi);
                    pstatement.setString(6, SoDT);
                    pstatement.setInt(7, Luong);
                    pstatement.setString(8, IMG);
                    pstatement.setString(9, MaNV);
                    pstatement.executeUpdate();

                    System.out.println(sql);

                }
            }
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
