/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ThongKeDTO {
    public int soKhachHang;
    public int soNhanVien;
    public int soSanPham;
    public int soKhachHangNam;
    public int soKhachHangNu;
    public ArrayList<SanPhamDTO> topSanPhamBanChay;
    public ThongKeDTO() {
    }

    public ThongKeDTO(int soKhachHang, int soNhanVien, int soSanPham, int soKhachHangNam, int soKhachHangNu, ArrayList<SanPhamDTO> topSanPhamBanChay) {
        this.soKhachHang = soKhachHang;
        this.soNhanVien = soNhanVien;
        this.soSanPham = soSanPham;
        this.soKhachHangNam = soKhachHangNam;
        this.soKhachHangNu = soKhachHangNu;
        this.topSanPhamBanChay = topSanPhamBanChay;
    }

    

    public int getSoNhanVien() {
        return soNhanVien;
    }

    public void setSoNhanVien(int soNhanVien) {
        this.soNhanVien = soNhanVien;
    }

    public int getSoSanPham() {
        return soSanPham;
    }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }

    public ArrayList<SanPhamDTO> getTopSanPhamBanChay() {
        return topSanPhamBanChay;
    }

    public void setTopSanPhamBanChay(ArrayList<SanPhamDTO> topSanPhamBanChay) {
        this.topSanPhamBanChay = topSanPhamBanChay;
    }

    public int getSoKhachHang() {
        return soKhachHang;
    }

    public void setSoKhachHang(int soKhachHang) {
        this.soKhachHang = soKhachHang;
    }

    public int getSoKhachHangNam() {
        return soKhachHangNam;
    }

    public void setSoKhachHangNam(int soKhachHangNam) {
        this.soKhachHangNam = soKhachHangNam;
    }

    public int getSoKhachHangNu() {
        return soKhachHangNu;
    }

    public void setSoKhachHangNu(int soKhachHangNu) {
        this.soKhachHangNu = soKhachHangNu;
    }
    
    
}
