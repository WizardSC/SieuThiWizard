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
public class NhaSanXuatDTO {
    private String MaNSX;
    private String TenNSX;

    public NhaSanXuatDTO() {
    }

    public NhaSanXuatDTO(String MaNSX, String TenNSX) {
        this.MaNSX = MaNSX;
        this.TenNSX = TenNSX;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }
    
}
