/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHDDAO;
import DTO.ChiTietHDDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ChiTietHDBUS {
    private ArrayList<ChiTietHDDTO> listChiTietHoaDon;
    private ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
    public void listCTHD()
    {
        ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
        listChiTietHoaDon = new ArrayList<>();
        listChiTietHoaDon = cthdDAO.getListCTHoaDon();
    }
    public void docListCTHoaDon(){
        this.listChiTietHoaDon = cthdDAO.getListCTHoaDon();
    }
    public ArrayList<ChiTietHDDTO> getListCTHoaDon(){
        return listChiTietHoaDon;
    }
    public ArrayList<ChiTietHDDTO> getListCTHDTheoMaHD(String MaHD){
        ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
        for(ChiTietHDDTO cthd : listChiTietHoaDon){
            if(cthd.getMaHD().equals(MaHD)){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
    public void add(ChiTietHDDTO cthd){
        listChiTietHoaDon.add(cthd);
        ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
        cthdDAO.insertCTHD(cthd);
    }
    public ArrayList<ChiTietHDDTO> timKiemThanhTienNangCao(int tuKhoaA, int tuKhoaB){
        ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
        for(ChiTietHDDTO cthd : listChiTietHoaDon){
            int ThanhTien = cthd.getThanhTien();
            int min = tuKhoaA;
            int max = tuKhoaB;
            if( min <= ThanhTien && ThanhTien <= max){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
    public ArrayList<ChiTietHDDTO> timKiemSoLuongNangCao(int tuKhoaA, int tuKhoaB){
        ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
        for(ChiTietHDDTO cthd : listChiTietHoaDon){
            int SoLuong = cthd.getSoLuong();
            int min = tuKhoaA;
            int max = tuKhoaB;
            if ( min <= SoLuong && SoLuong <= max){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
    public ArrayList<ChiTietHDDTO> timKiemMaSP(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
        for(ChiTietHDDTO cthd : listChiTietHoaDon){
            String MaSP = cthd.getMaSP().toLowerCase();
            if(MaSP.contains(tuKhoa)){
                dscthd.add(cthd);
            }
            
        }
        return dscthd;
    }
    public ArrayList<ChiTietHDDTO> timKiemTenSP(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
        for(ChiTietHDDTO cthd : listChiTietHoaDon){
            String TenSP = cthd.getTenSP().toLowerCase();
            if(TenSP.contains(tuKhoa)){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
}
