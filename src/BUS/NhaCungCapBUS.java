/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NhaCungCapBUS {

    private ArrayList<NhaCungCapDTO> listNhaCungCap = null;
    private NhaCungCapDAO nccDAO = new NhaCungCapDAO();

    public void docDanhSach() {
        this.listNhaCungCap = nccDAO.getListNhaCungCap();
    }

    public ArrayList<NhaCungCapDTO> getListNhaCungCap() {

        return listNhaCungCap;
    }

    public void add(NhaCungCapDTO ncc) {
        listNhaCungCap.add(ncc);
        NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        if (check(ncc.getMaNCC())) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp đă tồn tại !!!");
            return;
        }
        nccDAO.insertNhaCungCap(ncc);
    }
    
    public void update(NhaCungCapDTO ncc) {
        for (int i = 0; i < listNhaCungCap.size(); i++) {
            if (listNhaCungCap.get(i).getMaNCC().equals(ncc.getMaNCC())) {
                listNhaCungCap.set(i, ncc);
                NhaCungCapDAO nccDAO = new NhaCungCapDAO();
                nccDAO.updateNhaCungCap(ncc);
                return;
            }
        }
    }

    public void delete(String MaNCC) {
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            listNhaCungCap.remove(ncc);
            NhaCungCapDAO nccDAO = new NhaCungCapDAO();
            nccDAO.deleteNhaCungCap(MaNCC);
            return;
        }
    }

    public boolean check(String MaNCC) {
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            if (ncc.getMaNCC().equals(MaNCC)) {
                return true;
            }
        }
        return false;
    }
    public NhaCungCapDTO timKiemTheoMaNCC1(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String MaNCC = ncc.getMaNCC().toLowerCase();
            if (MaNCC.contains(tuKhoa)) {
                return ncc;
                
            }
        }
        return null;
    }
    public ArrayList<NhaCungCapDTO> timKiemTheoMaNCC(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String MaNCC = ncc.getMaNCC().toLowerCase();
            if (MaNCC.contains(tuKhoa)) {
                dsncc.add(ncc);
            }
        }
        return dsncc;
    }

    public ArrayList<NhaCungCapDTO> timKiemTheoTenNCC(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String TenNCC = ncc.getTenNCC().toLowerCase();
            if (TenNCC.contains(tuKhoa)) {
                dsncc.add(ncc);
            }
        }
        return dsncc;
    }

    public ArrayList<NhaCungCapDTO> timKiemTheoDiaChi(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String DiaChi = ncc.getDiaChi().toLowerCase();
            if (DiaChi.contains(tuKhoa)) {
                dsncc.add(ncc);
            }
        }
        return dsncc;
    }

    public ArrayList<NhaCungCapDTO> timKiemTheoSoFAX(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String SoFAX = ncc.getSoFAX().toLowerCase();
            if (SoFAX.contains(tuKhoa)) {
                dsncc.add(ncc);
            }
        }
        return dsncc;
    }

    public ArrayList<NhaCungCapDTO> timKiemTheoSoDT(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String SoDT = ncc.getSoDT().toLowerCase();
            if (SoDT.contains(tuKhoa)) {
                dsncc.add(ncc);
            }
        }
        return dsncc;
    }

    public void ExportExcel() {
        nccDAO.ExportExcel();
    }
}
