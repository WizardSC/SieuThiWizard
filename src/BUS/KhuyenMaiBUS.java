/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> listKhuyenMai;
    private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    public void docDanhSach(){
        this.listKhuyenMai = kmDAO.getListKhuyenMai();
    }
    public ArrayList<KhuyenMaiDTO> getListKhuyenMai(){
        return listKhuyenMai;
    }
    public void add(KhuyenMaiDTO km){
        listKhuyenMai.add(km);
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        kmDAO.insertKhuyenMai(km);
        
    }
    public void delete(String MaKM){
        for(KhuyenMaiDTO km : listKhuyenMai){
            if(km.getMaKM().equals(MaKM)){
                listKhuyenMai.remove(km);
                KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
                kmDAO.deleteKhuyenMai(MaKM);
                return;
            }
        }
    }
    public void update(KhuyenMaiDTO km){
        for(int i=0;i<listKhuyenMai.size();i++){
            if(listKhuyenMai.get(i).getMaKM().equals(km.getMaKM())){
                listKhuyenMai.set(i, km);
                KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
                kmDAO.updateKhuyenMai(km);
                return;
            }
        }
    }
    public ArrayList<KhuyenMaiDTO> timKiemTheoMaKM(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
        for(KhuyenMaiDTO km : listKhuyenMai){
            String MaKM = km.getMaKM().toLowerCase();
            if(MaKM.contains(tuKhoa)){
                dskm.add(km);
            }
        }
        return dskm;
    }
}
