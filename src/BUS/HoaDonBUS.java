/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class HoaDonBUS {
    private ArrayList<HoaDonDTO> listHoaDon;
    private HoaDonDAO hdDAO = new HoaDonDAO();
    public void docDanhSach(){
        this.listHoaDon = hdDAO.getListHoaDon();
    }
    public ArrayList<HoaDonDTO> getListHoaDon(){
        return listHoaDon;
    }
    public void add(HoaDonDTO hd){
        listHoaDon.add(hd);
        HoaDonDAO hdDAO = new HoaDonDAO();
        hdDAO.insertHoaDon(hd);
    }
    public ArrayList<HoaDonDTO> timKiemTheoMaHD(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            String MaPN = hd.getMaHD().toLowerCase();
            if(MaPN.contains(tuKhoa)){
                dshd.add(hd);
            }
        }
        return dshd;
    }
    
    public ArrayList<HoaDonDTO> timKiemTongTienNangCao(int tuKhoaA, int tuKhoaB){
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            int TongTien = Integer.parseInt(hd.getTongTien());
            int min = tuKhoaA;
            int max = tuKhoaB;
            if( min <= TongTien & TongTien <= max){
                dshd.add(hd);
            }
        }
        return dshd;
        
    }
    public ArrayList<HoaDonDTO> timKiemTheoMaNV(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            String MaNV = hd.getMaNV().toLowerCase();
            if(MaNV.contains(tuKhoa)){
                dshd.add(hd);
            }
        }
        return dshd;
    }
    public ArrayList<HoaDonDTO> timKiemTheoMaKH(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            String MaKH = hd.getMaKH().toLowerCase();
            if(MaKH.contains(tuKhoa)){
                dshd.add(hd);
            }
        }
        return dshd;
    }
    
}
