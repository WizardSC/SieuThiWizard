/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuatDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhaSanXuatBUS {
    private NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
    private ArrayList<NhaSanXuatDTO> listNhaSanXuat;
    public void docDanhSach(){
        this.listNhaSanXuat = nsxDAO.getListNhaSanXuat();
    }
    public ArrayList<NhaSanXuatDTO> getListNhaSanXuat(){
        return listNhaSanXuat; 
    }
    public void add(NhaSanXuatDTO nsx){
        listNhaSanXuat.add(nsx);
        NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
        nsxDAO.insertNhaSanXuat(nsx);
    }
    public void delete(String MaNSX){
        for(NhaSanXuatDTO nsx : listNhaSanXuat){
            if(nsx.getMaNSX().equals(MaNSX)){
                listNhaSanXuat.remove(nsx);
                NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
                nsxDAO.deleteNhaSanXuat(MaNSX);
                return;
            }
        }
    }
    public void update(NhaSanXuatDTO nsx){
        for(int i=0;i<listNhaSanXuat.size();i++){
            if(listNhaSanXuat.get(i).getMaNSX().equals(nsx.getMaNSX())){
                listNhaSanXuat.set(i,nsx);
                NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
                nsxDAO.updateNhaSanXuat(nsx);
            }
        }
    }
    public ArrayList<NhaSanXuatDTO> timKiemTheoMaNSX(String tuKhoa){
        tuKhoa=tuKhoa.toLowerCase();
        ArrayList<NhaSanXuatDTO> dsnsx = new ArrayList<>();
        for(NhaSanXuatDTO nsx : listNhaSanXuat){
            String MaNSX = nsx.getMaNSX().toLowerCase();
            if(MaNSX.contains(tuKhoa)){
                dsnsx.add(nsx);
            }
        }
        return dsnsx;
    }
}
