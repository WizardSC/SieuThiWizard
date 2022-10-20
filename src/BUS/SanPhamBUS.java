/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SanPhamBUS {

    private ArrayList<SanPhamDTO> listSanPham = null;
    private SanPhamDAO spDAO = new SanPhamDAO();

    public void docDanhSach() {
        this.listSanPham = spDAO.getListSanPham();
    }

    public ArrayList<SanPhamDTO> getListSanPham() {
        if (listSanPham == null) {
            docDanhSach();
        }
        return listSanPham;
    }

    public void add(SanPhamDTO sp) {
        listSanPham.add(sp);
        SanPhamDAO spDAO = new SanPhamDAO();
        spDAO.insertSanPham(sp);
    }

    public void update(SanPhamDTO sp) {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getMaSP().equals(sp.getMaSP())) {
                listSanPham.set(i, sp);
                SanPhamDAO spDAO = new SanPhamDAO();
                spDAO.updateSanPham(sp);
                return;
            }
        }
    }

    public void delete(String MaSP) {
        for (SanPhamDTO sp : listSanPham) {
            if (sp.getMaSP().equals(MaSP)) {
                listSanPham.remove(sp);
                SanPhamDAO spDAO = new SanPhamDAO();
                spDAO.deleteSanPham(MaSP);
                return;
            }
        }
    }

    public ArrayList<SanPhamDTO> timKiemTheoMaSP(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        for (SanPhamDTO sp : listSanPham) {
            String MaSP = sp.getMaSP().toLowerCase();
            if (MaSP.contains(tuKhoa)) {
                dssp.add(sp);
            }

        }
        return dssp;
    }

    public ArrayList<SanPhamDTO> timKiemTheoTenSP(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        for (SanPhamDTO sp : listSanPham) {
            String TenSP = sp.getTenSP().toLowerCase();
            if (TenSP.contains(tuKhoa)) {
                dssp.add(sp);
            }
        }
        return dssp;
    }

    public ArrayList<SanPhamDTO> timKiemTheoMaLoai(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        for (SanPhamDTO sp : listSanPham) {
            String MaLoai = sp.getMaLoai().toLowerCase();
            if (MaLoai.contains(tuKhoa)) {
                dssp.add(sp);
            }
        }
        return dssp;
    }

    public ArrayList<SanPhamDTO> timKiemTheoMaNSX(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        for (SanPhamDTO sp : listSanPham) {
            String MaNSX = sp.getMaNSX().toLowerCase();
            if (MaNSX.contains(tuKhoa)) {
                dssp.add(sp);
            }
        }
        return dssp;
    }

    public ArrayList<SanPhamDTO> timKiemDonGiaNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        for(SanPhamDTO sp : listSanPham){
            int DonGia = sp.getDonGia();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if(DonGia>=min && DonGia <= max){
                dssp.add(sp);
            }
        }
        return dssp;
    }
    public ArrayList<SanPhamDTO> timKiemSoLuongNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        for(SanPhamDTO sp : listSanPham){
            int SoLuong = sp.getSoLuong();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if(SoLuong >= min && SoLuong <= max){
                dssp.add(sp);
            }
        }
        return dssp;
    }

    public void capNhatSoLuongHD(String MaSP, int SoLuongMua, int SoLuongTrongKho) {

        spDAO.capNhatSoLuongHD(MaSP, SoLuongMua, SoLuongTrongKho);

    }

    public void capNhatSoLuongPN(String MaSP, int SoLuongNhap, int SoLuongTrongKho){
        spDAO.capNhatSoLuongPN(MaSP, SoLuongNhap, SoLuongTrongKho);
    }

    
}
