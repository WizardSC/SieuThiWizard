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
public class NhaCungCapDTO {
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String SoDT;
    private String SoFAX;

    public NhaCungCapDTO() {
    }

    public NhaCungCapDTO(String MaNCC, String TenNCC, String DiaChi, String SoDT, String SoFAX) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.SoFAX = SoFAX;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
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

    public String getSoFAX() {
        return SoFAX;
    }

    public void setSoFAX(String SoFAX) {
        this.SoFAX = SoFAX;
    }
    
}
