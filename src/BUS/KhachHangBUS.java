/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class KhachHangBUS {

    private ArrayList<KhachHangDTO> listKhachHang = null;
    private KhachHangDAO khDAO = new KhachHangDAO();

    public void listKH() {
        KhachHangDAO khDAO = new KhachHangDAO();
        listKhachHang = new ArrayList<>();
        listKhachHang = khDAO.getListKhachHang();
    }

    public void docDanhSach() {
        this.listKhachHang = khDAO.getListKhachHang();

    }

    public ArrayList<KhachHangDTO> getListKhachHang() {
        
        return listKhachHang;
    }

    public void add(KhachHangDTO kh) {
        listKhachHang.add(kh);
        KhachHangDAO khDAO = new KhachHangDAO();
        khDAO.insertKhachHang(kh);
    }

    public void update(KhachHangDTO kh) {
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getMaKH().equals(kh.getMaKH())) {
                listKhachHang.set(i, kh);
                KhachHangDAO khDAO = new KhachHangDAO();
                khDAO.updateKhachHang(kh);
                return;
            }
        }
    }
    public int tongtien(){
        int sum=0;
        for(KhachHangDTO kh : listKhachHang){
            sum=sum+kh.getSoHD();
        }
        return sum;
    }

    public void updateSoHDKhachHang(String MaKH, int SoHD) {
        khDAO.updateSoHDKhachHang(MaKH, SoHD);
    }

    public void delete(String MaKH) {
        for (KhachHangDTO kh : listKhachHang) {
            if (kh.getMaKH().equals(MaKH)) {
                listKhachHang.remove(kh);
                KhachHangDAO khDAO = new KhachHangDAO();
                khDAO.deleteKhachHang(MaKH);
                return;
            }
        }
    }

    public ArrayList<KhachHangDTO> timKiemKhachHang(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String MaKH = kh.getMaKH().toLowerCase();

            if (MaKH.contains(tuKhoa)) {
                dskh.add(kh);
            }

        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemTheoHo(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String Ho = kh.getHo().toLowerCase();
            if (Ho.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemTheoTen(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String Ten = kh.getTen().toLowerCase();
            if (Ten.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemTheoNamSinh(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String NamSinh = kh.getNgaySinh().toLowerCase();
            if (NamSinh.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemTheoGioiTinh(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String GioiTinh = kh.getGioiTinh().toLowerCase();
            if (GioiTinh.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemTheoDiaChi(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String DiaChi = kh.getDiaChi().toLowerCase();
            if (DiaChi.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemTheoSoDT(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            String SoDT = kh.getSoDT();
            if (SoDT.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public ArrayList<KhachHangDTO> timKiemNamSinhNangCao(String tuKhoaA, String tuKhoaB) {
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKhachHang) {
            int NamSinh = Integer.parseInt(kh.getNgaySinh().substring(6));
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if (min <= NamSinh && NamSinh <= max) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public void ExportExcel() {
        KhachHangDAO khDAO = new KhachHangDAO();
        khDAO.ExportExcel();
    }

    public void ImportExcel(File file) {
        KhachHangDAO khDAO = new KhachHangDAO();
        khDAO.ImportExcel(file);
    }

}
