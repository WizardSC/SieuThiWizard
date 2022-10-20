/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.io.File;
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
public class NhaCungCapDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<NhaCungCapDTO> getListNhaCungCap() {

        try {
            ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
            String sql = "SELECT * FROM nhacungcap";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO(
                        rs.getString("MaNCC"),
                        rs.getString("TenNCC"),
                        rs.getString("DiaChi"),
                        rs.getString("SoDT"),
                        rs.getString("SoFAX"));
                dsncc.add(ncc);
            }
            return dsncc;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertNhaCungCap(NhaCungCapDTO ncc) {

        try {
            String sql = "INSERT INTO nhacungcap VALUES(?,?,?,?,?)";
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            statement.setString(1, ncc.getMaNCC());
            statement.setString(2, ncc.getTenNCC());
            statement.setString(3, ncc.getDiaChi());
            statement.setString(4, ncc.getSoDT());
            statement.setString(5, ncc.getSoFAX());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Không được nhập trùng Mã NCC", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
        } finally {
            mySQL.Disconnect();
        }

    }

    public void updateNhaCungCap(NhaCungCapDTO ncc) {

        try {
            String sql = "UPDATE nhacungcap SET TenNCC = ?, DiaChi = ?, SoDT = ?, SoFAX = ? WHERE MaNCC = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ncc.getTenNCC());
            statement.setString(2, ncc.getDiaChi());
            statement.setString(3, ncc.getSoDT());
            statement.setString(4, ncc.getSoFAX());
            statement.setString(5, ncc.getMaNCC());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }

    public void deleteNhaCungCap(String MaNCC) {

        try {
            String sql = "DELETE FROM nhacungcap WHERE MaNCC = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, MaNCC);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }

    public void ExportExcel() {

        try {

            String sql = "SELECT * FROM nhacungcap";
            ResultSet rs = mySQL.executeQuery(sql);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("NhaCungCap");

            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue("MaNCC");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("TenNCC");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("DiaChi");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("SoDT");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("SoFAX");
            cell.setCellStyle(style);

            int i = 1;

            while (rs.next()) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(rs.getString("MaNCC"));
                cell = row.createCell(1);
                cell.setCellValue(rs.getString("TenNCC"));
                cell = row.createCell(2);
                cell.setCellValue(rs.getString("DiaChi"));
                cell = row.createCell(3);
                cell.setCellValue(rs.getString("SoDT"));
                cell = row.createCell(4);
                cell.setCellValue(rs.getString("SoFAX"));

                i++;
            }
            for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
                sheet.autoSizeColumn((short) (colNum));
            }

            FileOutputStream out = new FileOutputStream(new File("./report/NhaCungCap.xlsx"));
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
}
