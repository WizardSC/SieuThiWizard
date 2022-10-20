/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class TaiKhoanBUS {
    private ArrayList<TaiKhoanDTO> listTaiKhoan;
    private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    public void docDanhSach(){
        this.listTaiKhoan = tkDAO.getListTaiKhoan();
    }
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return listTaiKhoan;
    }
    public void add(TaiKhoanDTO tk){
        listTaiKhoan.add(tk);
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        tkDAO.insertTaiKhoan(tk);
    }
    public void listTK(){
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        listTaiKhoan = new ArrayList<>();
        listTaiKhoan = tkDAO.getListTaiKhoan();
    }
    public TaiKhoanDTO check(String userName,char[] pass)
    {
        
        for(TaiKhoanDTO tk : listTaiKhoan)
        {   
            char[] correctPass = tk.getMatKhau().toCharArray();
            if( tk.getTenDangNhap().equals(userName) && Arrays.equals(pass, correctPass) && tk.getTrangThai()==1)
            {
                return tk;
            }
        }
        return null;
    }
}
