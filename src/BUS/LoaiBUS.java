/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiDAO;
import DTO.LoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class LoaiBUS {

    private ArrayList<LoaiDTO> listLoai = null;
    private LoaiDAO loaiDAO = new LoaiDAO();

    public void docDanhSach() {
        this.listLoai = loaiDAO.getListLoai();
    }

    public ArrayList<LoaiDTO> getListLoai() {
        if (listLoai == null) {
            docDanhSach();
        }
        return listLoai;
    }

    public void add(LoaiDTO loai) {
        listLoai.add(loai);
        LoaiDAO loaiDAO = new LoaiDAO();
        loaiDAO.insertLoai(loai);
    }
    public void update(LoaiDTO loai){
        for(int i=0;i<listLoai.size();i++){
            if(listLoai.get(i).getMaLoai().equals(loai.getMaLoai())){
                listLoai.set(i, loai);
                LoaiDAO loaiDAO = new LoaiDAO();
                loaiDAO.updateLoai(loai);
                return;
            }
        }
    }

    public void delete(String MaLoai) {
        for (LoaiDTO loai : listLoai) {
            if (loai.getMaLoai().equals(MaLoai)) {
                listLoai.remove(loai);
                LoaiDAO loaiDAO = new LoaiDAO();
                loaiDAO.deleteLoai(MaLoai);
                return;
            }
        }
    }
}
