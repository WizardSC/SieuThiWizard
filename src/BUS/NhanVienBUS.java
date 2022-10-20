/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhanVienBUS {

    private ArrayList<NhanVienDTO> listNhanVien = null;
    private NhanVienDAO nvDAO = new NhanVienDAO();

    public void docDanhSach() {
        this.listNhanVien = nvDAO.getListNhanVien();
    }

    public ArrayList<NhanVienDTO> getListNhanVien() {
        
        return listNhanVien;
    }

    public void add(NhanVienDTO nv) {
        listNhanVien.add(nv);
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.insertNhanVien(nv);
    }

    public void delete(String MaNV) {
        for (NhanVienDTO nv : listNhanVien) {
            if (nv.getMaNV().equals(MaNV)) {
                listNhanVien.remove(nv);
                NhanVienDAO nvDAO = new NhanVienDAO();
                nvDAO.deleteNhanVien(MaNV);
                return;
            }

        }
    }

    public void update(NhanVienDTO nv) {
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (listNhanVien.get(i).getMaNV().equals(nv.getMaNV())) {
                listNhanVien.set(i, nv);
                NhanVienDAO nvDAO = new NhanVienDAO();
                nvDAO.updateNhanVien(nv);
                return;
            }
        }
    }

    public void updateLuong(String MaNV, int Luong) {
        nvDAO.updateLuongNhanVien(MaNV, Luong);
    }

    public ArrayList<NhanVienDTO> timKiemTheoMaNV(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String MaNV = nv.getMaNV().toLowerCase();
            if (MaNV.contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> timKiemTheoTenNV(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList();
        for (NhanVienDTO nv : listNhanVien) {
            String Ten = nv.getTen().toLowerCase();
            if (Ten.contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> timKiemTheoHoNV(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String Ho = nv.getHo().toLowerCase();
            if (Ho.contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> timKiemTheoNamSinh(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String NamSinh = nv.getNgaySinh().toLowerCase();
            if (NamSinh.contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> timKiemTheoGioiTinh(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String GioiTinh = nv.getGioiTinh().toLowerCase();
            if (GioiTinh.contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> timKiemTheoDiaChi(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String DiaChi = nv.getDiaChi().toLowerCase();
            if (DiaChi.contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> timKiemNamSinhNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for(NhanVienDTO nv : listNhanVien){
            int NamSinh = Integer.parseInt(nv.getNgaySinh().substring(6));
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= NamSinh && NamSinh <= max){
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    public ArrayList<NhanVienDTO> timKiemLuongNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for(NhanVienDTO nv : listNhanVien){
            int Luong = nv.getLuong();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= Luong && Luong <= max){
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    public ArrayList<NhanVienDTO> timKiemTheoSoDT(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for(NhanVienDTO nv : listNhanVien){
            String SoDT = nv.getSoDT().toLowerCase();
            if(SoDT.contains(tuKhoa)){
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    


    public void ExportExcel() {
        nvDAO.ExportExcel();
    }

    public void ImportExcel(File file) {
        nvDAO.ImportExcel(file);
    }

    public void listNV() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        listNhanVien = new ArrayList<>();
        listNhanVien = nvDAO.getListNhanVien();
    }

}
