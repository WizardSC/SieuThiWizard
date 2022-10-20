/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ThongKeDAO;

/**
 *
 * @author Administrator
 */
public class ThongKeBUS {
    private ThongKeDAO tkDAO = new ThongKeDAO();
    public int getSoLuongKhachHang(){
        return tkDAO.getSoLuongKhachHang();
    }
    public int getSoLuongKhachHangNam(String GioiTinh){
        return tkDAO.getSoLuongKhachHangNam(GioiTinh);
    }
    public int getSoLuongKhachHangNu(String GioiTinh){
        return tkDAO.getSoLuongKhachHangNu(GioiTinh);
    }
    public int getSoLuongNhanVien(){
        return tkDAO.getSoLuongNhanVien();
    }
    public int getTongDoanhThu(){
        return tkDAO.getTongDoanhThu();
    }
    public int getTongChiTieu(){
        return tkDAO.getTongChiTieu();
    }
    public int getSoLuongNhanVienNu(String GioiTinh){
        return tkDAO.getSoLuongNhanVienNu(GioiTinh);
    }
    public int getSoLuongNhanVienNam(String GioiTinh){
        return tkDAO.getSoLuongNhanVienNam(GioiTinh);
    }
    
   
    
}
