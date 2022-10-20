/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class KhuyenMaiDTO {
    private String MaKM;
    private String TenKM;
    private int PhanTramKM;
    private int DieuKien;
    private Date NgayBatDau;
    private Date NgayKetThuc;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String MaKM, String TenKM, int PhanTramKM, int DieuKien, Date NgayBatDau, Date NgayKetThuc) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.PhanTramKM = PhanTramKM;
        this.DieuKien = DieuKien;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }

    
    

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public int getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(int PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public int getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(int DieuKien) {
        this.DieuKien = DieuKien;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    
    
}
