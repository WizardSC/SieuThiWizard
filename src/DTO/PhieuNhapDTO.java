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
public class PhieuNhapDTO {
    private String MaPN;
    private String MaNCC;
    private String MaNV;
    private String NgayLap;
    private String TongTien;

    public PhieuNhapDTO(String MaPN, String MaNCC, String MaNV, String NgayLap, String TongTien) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public PhieuNhapDTO() {
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }
    
}
