/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDTO {
    private String MaNV;
    private String TenDangNhap;
    private String MatKhau;
    private String Quyen;
    private int TrangThai;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String MaNV, String TenDangNhap, String MatKhau, String Quyen, int TrangThai) {
        this.MaNV = MaNV;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
