/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPNDAO;
import DTO.ChiTietPNDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ChiTietPNBUS {
    private ArrayList<ChiTietPNDTO> listChiTietPN;
    private ChiTietPNDAO ctpnDAO = new ChiTietPNDAO();
    public void listCTPN(){
        ChiTietPNDAO ctpnDAO = new ChiTietPNDAO();
        listChiTietPN = new ArrayList<>();
        listChiTietPN = ctpnDAO.getListChiTietPN();
    }
    public void docDanhSach(){
        this.listChiTietPN = ctpnDAO.getListChiTietPN();
    }
    public ArrayList<ChiTietPNDTO> getListChiTietPN(){
        return listChiTietPN;
    }
    public ArrayList<ChiTietPNDTO> getListCTPNTheoMaPN(String MaPN){
        ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
        for(ChiTietPNDTO ctpn : listChiTietPN){
            if(ctpn.getMaPN().equals(MaPN)){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    public void add(ChiTietPNDTO ctpn){
        listChiTietPN.add(ctpn);
        ChiTietPNDAO ctpnDAO = new ChiTietPNDAO();
        ctpnDAO.insertCTPN(ctpn);
    }
    public ArrayList<ChiTietPNDTO> timKiemTheoMaSP(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
        for(ChiTietPNDTO ctpn : listChiTietPN){
            String MaSP = ctpn.getMaSP().toLowerCase();
            if(MaSP.contains(tuKhoa)){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    public ArrayList<ChiTietPNDTO> timKiemTheoTenSP(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
        for(ChiTietPNDTO ctpn : listChiTietPN){
            String TenSP = ctpn.getTenSP().toLowerCase();
            if(TenSP.contains(tuKhoa)){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    public ArrayList<ChiTietPNDTO> timKiemThanhTienNangCao(int tuKhoaA, int tuKhoaB){
        ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
        for(ChiTietPNDTO ctpn : listChiTietPN){
            int ThanhTien = ctpn.getThanhTien();
            int min = tuKhoaA;
            int max = tuKhoaB;
            if( min <= ThanhTien && ThanhTien <= max){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    public ArrayList<ChiTietPNDTO> timKiemSoLuongNangCao(int tuKhoaA,int tuKhoaB){
        ArrayList<ChiTietPNDTO> dsctpn = new ArrayList<>();
        for(ChiTietPNDTO ctpn : listChiTietPN){
            int SoLuong = ctpn.getSoLuong();
            int min = tuKhoaA;
            int max = tuKhoaB;
            if( min <= SoLuong && SoLuong <= max){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
}
