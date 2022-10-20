/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuNhapBUS {

    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPhieuNhap;

    public void docDanhSach() {
        this.listPhieuNhap = pnDAO.getListPhieuNhap();
    }

    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        return listPhieuNhap;
    }

    public void add(PhieuNhapDTO pn) {
        listPhieuNhap.add(pn);
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        pnDAO.insertPhieuNhap(pn);
    }

    public ArrayList<PhieuNhapDTO> timKiemTheoMaPN(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
        for (PhieuNhapDTO pn : listPhieuNhap) {
            String MaPN = pn.getMaPN().toLowerCase();
            if (MaPN.contains(tuKhoa)) {
                dspn.add(pn);
            }
        }
        return dspn;
    }

    public ArrayList<PhieuNhapDTO> timKiemTheoMaNCC(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
        for (PhieuNhapDTO pn : listPhieuNhap) {
            String MaNCC = pn.getMaNCC().toLowerCase();
            if (MaNCC.contains(tuKhoa)) {
                dspn.add(pn);
            }
        }
        return dspn;
    }

    public ArrayList<PhieuNhapDTO> timKiemTheoMaNV(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
        for (PhieuNhapDTO pn : listPhieuNhap) {
            String MaNV = pn.getMaNV().toLowerCase();
            if (MaNV.contains(tuKhoa)) {
                dspn.add(pn);
            }
        }
        return dspn;
    }

    public ArrayList<PhieuNhapDTO> timKiemTongTienNangCao(int tuKhoaA, int tuKhoaB) {
        ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
        for(PhieuNhapDTO pn : listPhieuNhap){
            int TongTien = Integer.parseInt(pn.getTongTien());
            int min = tuKhoaA;
            int max = tuKhoaB;
            if( min <= TongTien && TongTien <= max){
                dspn.add(pn);
            }
        }
        return dspn;
    }
}
