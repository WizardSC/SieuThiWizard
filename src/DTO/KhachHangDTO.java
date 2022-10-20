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
public class KhachHangDTO {
    private String MaKH;
    private String Ho;
    private String Ten;
    private String NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String SoDT;
    private int SoHD;
    private String IMG;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String MaKH, String Ho, String Ten, String NgaySinh, String GioiTinh, String DiaChi, String SoDT, int SoHD, String IMG) {
        this.MaKH = MaKH;
        this.Ho = Ho;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.SoHD = SoHD;
        this.IMG = IMG;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public int getSoHD() {
        return SoHD;
    }

    public void setSoHD(int SoHD) {
        this.SoHD = SoHD;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
    
}
