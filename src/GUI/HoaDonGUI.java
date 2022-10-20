/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietHDBUS;
import BUS.HoaDonBUS;
import BUS.SanPhamBUS;
import BUS.XuatHoaDonBUS;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Administrator
 */
public class HoaDonGUI extends javax.swing.JPanel {

    HoaDonBUS hdBUS = new HoaDonBUS();
    ChiTietHDBUS cthdBUS = new ChiTietHDBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    private ArrayList<SanPhamDTO> dssp = new ArrayList<>();
    private ArrayList<ChiTietHDDTO> dscthd = new ArrayList<>();
    private ArrayList<HoaDonDTO> dshd = new ArrayList<>();
    DefaultTableModel dtmGioHang;
    DefaultTableModel dtmWareHouse;
    DefaultTableModel dtmDSTCHD;
    DefaultTableModel dtmDSHD;
    DefaultTableModel dtmHCHD;

    public HoaDonGUI() {
        initComponents();
        init();
        initRecentWareHouseGUI();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        dtmWareHouse = (DefaultTableModel) tblDSSP.getModel();
        dtmDSTCHD = (DefaultTableModel) tblDSCTHD.getModel();
        dtmDSHD = (DefaultTableModel) tblDSHD.getModel();

        loadDataWareHouse();

        loadDataDSHD();

    }

    public void initRecentWareHouseGUI() {
        RecentWareHouseGUI.setModal(true);
        RecentWareHouseGUI.setResizable(false);
        tblDSSP.setFocusable(false);
        tblDSSP.setIntercellSpacing(new Dimension(0, 0));

        tblDSSP.setRowHeight(25);

        tblDSSP.getTableHeader().setOpaque(false);
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSSP.getTableHeader().setForeground(Color.WHITE);
        tblDSSP.setSelectionBackground(new Color(52, 152, 219));
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, -10, 100, 1);
        txtSoLuongWH.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuongWH.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(false);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        txtSpinner.setBackground(Color.white);
    }

    public void init() {

        //tinh chỉnh table Giỏ hàng bên tab HD
        tblGioHang.setFocusable(false);
        tblGioHang.setIntercellSpacing(new Dimension(0, 0));

        tblGioHang.setRowHeight(25);

        tblGioHang.getTableHeader().setOpaque(false);
        tblGioHang.setFillsViewportHeight(true);
        tblGioHang.getTableHeader().setBackground(new Color(138, 57, 225));
        tblGioHang.getTableHeader().setForeground(Color.WHITE);
        tblGioHang.setSelectionBackground(new Color(52, 152, 219));
//        tblGioHang.setFont(new Font("Arial",Font.PLAIN,13));
//tinh chỉnh table DSCTH bên tab CTHD
        tblDSCTHD.setFocusable(false);
        tblDSCTHD.setIntercellSpacing(new Dimension(0, 0));
        tblDSCTHD.setRowHeight(25);

        tblDSCTHD.getTableHeader().setOpaque(false);
        tblDSCTHD.setFillsViewportHeight(true);
        tblDSCTHD.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSCTHD.getTableHeader().setForeground(Color.WHITE);
        tblDSCTHD.setSelectionBackground(new Color(52, 152, 219));
        tblDSCTHD.setFont(new Font("Arial", Font.PLAIN, 13));

        tblDSHD.setFocusable(false);
        tblDSHD.setIntercellSpacing(new Dimension(0, 0));

        tblDSHD.setRowHeight(25);

        tblDSHD.getTableHeader().setOpaque(false);
        tblDSHD.setFillsViewportHeight(true);
        tblDSHD.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSHD.getTableHeader().setForeground(Color.WHITE);
        tblDSHD.setSelectionBackground(new Color(52, 152, 219));
        tblDSHD.setFont(new Font("Arial", Font.PLAIN, 13));

    }

    public void showAllWareHouse(ArrayList<SanPhamDTO> dssp) {
        dtmWareHouse.setRowCount(0);

        for (int i = 0; i < dssp.size(); i++) {
            dtmWareHouse.addRow(new String[]{
                dssp.get(i).getMaSP(),
                dssp.get(i).getTenSP(),
                dssp.get(i).getDonViTinh(),
                String.valueOf(dssp.get(i).getDonGia()),
                String.valueOf(dssp.get(i).getSoLuong())

            });
        }
    }

    public void loadDataWareHouse() {
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        showAllWareHouse(dssp);
    }

    private void loadDataTableSanPhamBan() {
        dtmWareHouse.setRowCount(0);
        ArrayList<SanPhamDTO> dssp = null;

        for (int i = 0; i < dssp.size(); i++) {
            dtmWareHouse.addRow(new String[]{
                dssp.get(i).getMaSP(),
                dssp.get(i).getTenSP(),
                dssp.get(i).getDonViTinh(),
                String.valueOf(dssp.get(i).getDonGia()),
                String.valueOf(dssp.get(i).getSoLuong())

            });
        }

    }

    public void showAllDSCTHD(ArrayList<ChiTietHDDTO> dscthd) {
        dtmDSTCHD.setRowCount(0);
        for (int i = 0; i < dscthd.size(); i++) {
            dtmDSTCHD.addRow(new String[]{
                dscthd.get(i).getMaSP(),
                dscthd.get(i).getTenSP(),
                String.valueOf(dscthd.get(i).getSoLuong()),
                String.valueOf(dscthd.get(i).getDonGia()),
                String.valueOf(dscthd.get(i).getThanhTien())
            });
        }
    }

    public void loadDataDSCTHD() {
        cthdBUS.docListCTHoaDon();
        ArrayList<ChiTietHDDTO> dscthd = cthdBUS.getListCTHoaDon();
        showAllDSCTHD(dscthd);
    }

    public void loadDataDSCTHDTheoMaHD(String MaHD) {
        if (cthdBUS.getListCTHoaDon() == null) {
            cthdBUS.listCTHD();
        }
        ArrayList<ChiTietHDDTO> dscthd = cthdBUS.getListCTHDTheoMaHD(MaHD);
        dtmDSTCHD.setRowCount(0);
        showAllDSCTHD(dscthd);
    }

    public void showAllDSHD(ArrayList<HoaDonDTO> dshd) {
        dtmDSHD.setRowCount(0);
        for (int i = 0; i < dshd.size(); i++) {
            dtmDSHD.addRow(new String[]{
                dshd.get(i).getMaHD(),
                dshd.get(i).getMaKH(),
                dshd.get(i).getMaNV(),
                dshd.get(i).getNgayLap(),
                dshd.get(i).getTongTien()
            });
        }
    }

    public void loadDataDSHD() {
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        showAllDSHD(dshd);
    }

    public void showAll(ArrayList<SanPhamDTO> dssp) {
        dtmGioHang.setRowCount(0);

        for (int i = 0; i < dssp.size(); i++) {
            dtmGioHang.addRow(new String[]{
                dssp.get(i).getMaSP(),
                dssp.get(i).getTenSP(),
                dssp.get(i).getDonViTinh(),
                String.valueOf(dssp.get(i).getDonGia()),
                String.valueOf(dssp.get(i).getSoLuong())

            });
        }
    }

    public void loadData() {
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        showAll(dssp);
    }

    public String getMaSPWH() {
        return txtMaSPWH.getText();
    }

    public String getTenSPWH() {
        return txtTenSPWH.getText();
    }

    public String getDonViTinhWH() {
        return txtDonViTinhWH.getText();
    }

    public String getDonGiaWH() {
        return txtDonGiaWH.getText();
    }

    public String getSoLuongWH() {
        return txtSoLuongWH.getValue().toString();
    }

    public String getSoLuongTrongKhoWH() {
        return txtSoLuongKhoWH.getText();
    }

    public void outModel(DefaultTableModel dtmGioHang, ArrayList<ChiTietHDDTO> dscthd) {
        Vector data;
        dtmGioHang.setRowCount(0);
        for (int i = 0; i < dscthd.size(); i++) {
            dtmGioHang.addRow(new String[]{
                dscthd.get(i).getMaSP(),
                dscthd.get(i).getTenSP(),
                String.valueOf(dscthd.get(i).getSoLuong()),
                String.valueOf(dscthd.get(i).getDonGia()),
                String.valueOf(dscthd.get(i).getThanhTien())
            });
        }
//        for (ChiTietHDDTO cthd : dscthd) {
//            data = new Vector();
//            data.add(cthd.getMaSP());
//            data.add(cthd.getTenSP());
//            data.add(cthd.getSoLuong());
//            data.add(cthd.getDonGia());
//            data.add(cthd.getThanhTien());
//            dtmGioHang.addRow(data);
//        }
//        tblGioHang.setModel(dtmGioHang);
    }

    public int sumHD() {
        int sum = 0;
        for (ChiTietHDDTO cthd : dscthd) {
            int SoLuong = cthd.getSoLuong();
            int DonGia = cthd.getDonGia();
            sum += SoLuong * DonGia;
        }
        return sum;
    }

    public String getTongTien() {
        return txtTongTien.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RecentWareHouseGUI = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        pnHeader2 = new javax.swing.JPanel();
        btnCloseWH = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtSoLuongKhoWH = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnChonLoai = new javax.swing.JLabel();
        txtMaSPWH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtTenSPWH = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtDonViTinhWH = new javax.swing.JTextField();
        txtDonGiaWH = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtSoLuongWH = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        tbpPhieuNhap = new javax.swing.JTabbedPane();
        pnPhieuNhap = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        btnChonNCC = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        btnChonNV = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JLabel();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnTaoHoaDon = new javax.swing.JLabel();
        txtPhanTramKM = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtTongTienSauKM = new javax.swing.JTextField();
        btnChonKM = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoa = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtMaSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxDonViTinh = new javax.swing.JComboBox<>();
        btnNhapLai = new javax.swing.JLabel();
        btnThemVaoGio = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        btnThongTinSP = new javax.swing.JButton();
        pnChiTietPhieuNhap = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSCTHD = new javax.swing.JTable();
        txtDonGiainDSCTHD = new javax.swing.JTextField();
        txtSoLuonginDSCTHD = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMaSPinDSCTHD = new javax.swing.JTextField();
        txtTenSPinDSCTHD = new javax.swing.JTextField();
        txtThanhTieninDSCTHD = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        btnResetSearchDSCTHD = new javax.swing.JLabel();
        txtTuKhoainDSCTHD = new javax.swing.JTextField();
        rdbMaSPinDSCTHD = new javax.swing.JRadioButton();
        rdbTenSPinDSCTHD = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtDonGiaBDinDSCTHD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDonGiaKTinDSCTHD = new javax.swing.JTextField();
        txtSoLuongKTinDSCTHD = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSoLuongBDinDSCTHD = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnTimKiemDSCTHD = new javax.swing.JLabel();
        rdbThongThuonginDSCTHD = new javax.swing.JRadioButton();
        rdbDonGiaNCinDSCTHD = new javax.swing.JRadioButton();
        rdbSoLuongNCinDSCTHD = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSHD = new javax.swing.JTable();
        txtMaHDinDSHD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMaKHinDSHD = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtMaNVinDSHD = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtNgayLapinDSHD = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTongTieninDSHD = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        rdbMaHD = new javax.swing.JRadioButton();
        txtTuKhoaDSHD = new javax.swing.JTextField();
        rdbMaNV = new javax.swing.JRadioButton();
        rdbMaKH = new javax.swing.JRadioButton();
        btnResetSearchDSHD = new javax.swing.JLabel();
        txtTongTienB = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTongTienA = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnTimKiemHD = new javax.swing.JLabel();
        rdbThongThuong = new javax.swing.JRadioButton();
        rdbTongTienNC = new javax.swing.JRadioButton();

        jPanel2.setBackground(new java.awt.Color(233, 213, 218));

        pnHeader2.setBackground(new java.awt.Color(54, 48, 98));
        pnHeader2.setPreferredSize(new java.awt.Dimension(102, 40));

        btnCloseWH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCloseWH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnCloseWH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseWHMouseClicked(evt);
            }
        });

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblSanPham 32x32.png"))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("SẢN PHẨM GẦN ĐÂY");

        javax.swing.GroupLayout pnHeader2Layout = new javax.swing.GroupLayout(pnHeader2);
        pnHeader2.setLayout(pnHeader2Layout);
        pnHeader2Layout.setHorizontalGroup(
            pnHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeader2Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCloseWH, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeader2Layout.setVerticalGroup(
            pnHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCloseWH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn vị tính", "Đơn giá", "Còn lại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDSSP);

        jPanel8.setBackground(new java.awt.Color(233, 213, 218));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel8.setToolTipText("");
        jPanel8.setPreferredSize(new java.awt.Dimension(368, 300));

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setText("Nhập từ khóa");

        jRadioButton7.setBackground(new java.awt.Color(233, 213, 218));
        jRadioButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton7.setText("Mã SP");

        jRadioButton8.setBackground(new java.awt.Color(233, 213, 218));
        jRadioButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton8.setText("Tên SP");

        jRadioButton9.setBackground(new java.awt.Color(233, 213, 218));
        jRadioButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton9.setText("Mã loại");

        jRadioButton12.setBackground(new java.awt.Color(233, 213, 218));
        jRadioButton12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton12.setText("Mã NSX");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-right.png"))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setText("đến");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setText("Tìm kiếm đơn giá từ:");

        jLabel45.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N
        jLabel45.setText("Tìm kiếm");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton9))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton12))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel45)
                        .addGap(35, 35, 35)
                        .addComponent(txtSoLuongKhoWH, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton12))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtSoLuongKhoWH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(233, 213, 218));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN LOẠI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("KIẾM TRA THÔNG TIN");

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnChonLoai.setText("Chọn loại");
        btnChonLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonLoaiMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Mã SP");

        jLabel46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel46.setText("Tên SP");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel47.setText("Số lượng");

        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setText("ĐVT");

        jLabel49.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel49.setText("Đơn giá");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSPWH, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSPWH, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDonGiaWH, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtDonViTinhWH, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtSoLuongWH))))
                .addGap(26, 26, 26)
                .addComponent(btnChonLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnChonLoai))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSPWH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtTenSPWH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonViTinhWH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtSoLuongWH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtDonGiaWH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout RecentWareHouseGUILayout = new javax.swing.GroupLayout(RecentWareHouseGUI.getContentPane());
        RecentWareHouseGUI.getContentPane().setLayout(RecentWareHouseGUILayout);
        RecentWareHouseGUILayout.setHorizontalGroup(
            RecentWareHouseGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RecentWareHouseGUILayout.setVerticalGroup(
            RecentWareHouseGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbpPhieuNhap.setBackground(new java.awt.Color(233, 213, 218));
        tbpPhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbpPhieuNhap.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 13)); // NOI18N
        tbpPhieuNhap.setInheritsPopupMenu(true);

        pnPhieuNhap.setBackground(new java.awt.Color(233, 213, 218));

        jPanel3.setBackground(new java.awt.Color(233, 213, 218));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TẠO HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mã NV");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Mã HĐ");

        txtMaHD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnChonNCC.setText("...");
        btnChonNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonNCCActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Ngày tạo");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel35.setText("Mã KH");

        btnChonNV.setText("...");
        btnChonNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonNVActionPerformed(evt);
            }
        });

        btnInHoaDon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseClicked(evt);
            }
        });

        txtNgayLap.setDateFormatString("dd/MM/yyyy");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setText("Tổng tiền");

        btnTaoHoaDon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });

        txtPhanTramKM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Khuyến mãi");

        jLabel36.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel36.setText("Tổng sau KM");

        btnChonKM.setText("...");
        btnChonKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnChonKM)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(btnChonNCC))
                                            .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnChonNV))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTienSauKM, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhanTramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnTaoHoaDon)
                        .addGap(34, 34, 34)
                        .addComponent(btnInHoaDon)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChonNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChonNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPhanTramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtTongTienSauKM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(btnInHoaDon))
                .addGap(304, 304, 304))
        );

        jPanel4.setBackground(new java.awt.Color(233, 213, 218));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GIỎ HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(25);
        }

        btnXoa.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(btnXoa))
        );

        jPanel5.setBackground(new java.awt.Color(233, 213, 218));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Mã SP");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Tên SP");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Đơn giá");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Đơn vị tính");

        cbxDonViTinh.setEditable(true);
        cbxDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn đơn vị tính", "Cái", "Lon", "Hộp", "Gói", "Thùng", "Tuýp", "Miếng", "Hũ", "Chai", "Cây" }));

        btnNhapLai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnNhapLai.setText("Nhập lại");
        btnNhapLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhapLaiMouseClicked(evt);
            }
        });

        btnThemVaoGio.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThemVaoGio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btnThemVaoGio.setText("Thêm vào giỏ");
        btnThemVaoGio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemVaoGio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemVaoGioMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Thành tiền");

        btnThongTinSP.setText("...");
        btnThongTinSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemVaoGio)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtTenSP)
                            .addComponent(txtSoLuong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThongTinSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(txtDonGia)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnNhapLai)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThongTinSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel10)
                        .addComponent(cbxDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapLai)
                    .addComponent(btnThemVaoGio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnPhieuNhapLayout = new javax.swing.GroupLayout(pnPhieuNhap);
        pnPhieuNhap.setLayout(pnPhieuNhapLayout);
        pnPhieuNhapLayout.setHorizontalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPhieuNhapLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnPhieuNhapLayout.setVerticalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhieuNhapLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(pnPhieuNhapLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tbpPhieuNhap.addTab("Hóa đơn", pnPhieuNhap);

        pnChiTietPhieuNhap.setBackground(new java.awt.Color(233, 213, 218));

        jPanel6.setBackground(new java.awt.Color(233, 213, 218));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        tblDSCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCTHD.getTableHeader().setReorderingAllowed(false);
        tblDSCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSCTHD);
        if (tblDSCTHD.getColumnModel().getColumnCount() > 0) {
            tblDSCTHD.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSCTHD.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblDSCTHD.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblDSCTHD.getColumnModel().getColumn(3).setPreferredWidth(20);
            tblDSCTHD.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Số lượng");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Đơn giá");

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Thành tiền");

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setText("Tên SP");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Mã SP");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Nhập từ khóa");

        btnResetSearchDSCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-right.png"))); // NOI18N
        btnResetSearchDSCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetSearchDSCTHDMouseClicked(evt);
            }
        });

        rdbMaSPinDSCTHD.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup4.add(rdbMaSPinDSCTHD);
        rdbMaSPinDSCTHD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaSPinDSCTHD.setText("Mã SP");

        rdbTenSPinDSCTHD.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup4.add(rdbTenSPinDSCTHD);
        rdbTenSPinDSCTHD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbTenSPinDSCTHD.setText("Tên SP");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Tìm kiếm thành tiền từ:");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("đến:");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("đến:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Tìm kiếm số lượng từ:");

        btnTimKiemDSCTHD.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTimKiemDSCTHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTimKiemDSCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N
        btnTimKiemDSCTHD.setText("Tìm kiếm");
        btnTimKiemDSCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemDSCTHDMouseClicked(evt);
            }
        });

        rdbThongThuonginDSCTHD.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup3.add(rdbThongThuonginDSCTHD);

        rdbDonGiaNCinDSCTHD.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup3.add(rdbDonGiaNCinDSCTHD);

        rdbSoLuongNCinDSCTHD.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup3.add(rdbSoLuongNCinDSCTHD);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSPinDSCTHD)
                                    .addComponent(txtMaSPinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoLuonginDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDonGiainDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtThanhTieninDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(rdbDonGiaNCinDSCTHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDonGiaKTinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbThongThuonginDSCTHD)
                                    .addComponent(rdbSoLuongNCinDSCTHD))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTuKhoainDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnResetSearchDSCTHD)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbMaSPinDSCTHD)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbTenSPinDSCTHD))
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(txtSoLuongBDinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel19))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(txtDonGiaBDinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17)))
                                        .addGap(36, 36, 36)
                                        .addComponent(txtSoLuongKTinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnTimKiemDSCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaSPinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtDonGiainDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtTenSPinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuonginDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtThanhTieninDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbMaSPinDSCTHD)
                        .addComponent(rdbTenSPinDSCTHD))
                    .addComponent(btnResetSearchDSCTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rdbThongThuonginDSCTHD)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtTuKhoainDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDonGiaKTinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDonGiaBDinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(rdbDonGiaNCinDSCTHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuongBDinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txtSoLuongKTinDSCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiemDSCTHD))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rdbSoLuongNCinDSCTHD)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel7.setBackground(new java.awt.Color(233, 213, 218));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã KH", "Mã NV", "Ngày tạo", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSHD.getTableHeader().setReorderingAllowed(false);
        tblDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSHDMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSHD);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Mã HD");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Mã KH");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Mã NV");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Ngày lập");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Tổng tiền");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Nhập từ khóa");

        rdbMaHD.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbMaHD);
        rdbMaHD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaHD.setText("Mã HĐ");

        rdbMaNV.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbMaNV);
        rdbMaNV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaNV.setText("Mã NV");

        rdbMaKH.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbMaKH);
        rdbMaKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaKH.setText("Mã KH");

        btnResetSearchDSHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-right.png"))); // NOI18N
        btnResetSearchDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetSearchDSHDMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("đến:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Tìm kiếm tổng tiền từ:");

        btnTimKiemHD.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTimKiemHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTimKiemHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N
        btnTimKiemHD.setText("Tìm kiếm");
        btnTimKiemHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiemHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemHDMouseClicked(evt);
            }
        });

        rdbThongThuong.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup2.add(rdbThongThuong);

        rdbTongTienNC.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup2.add(rdbTongTienNC);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaKHinDSHD, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(txtMaHDinDSHD))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtMaNVinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNgayLapinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(txtTongTieninDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbThongThuong, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdbTongTienNC, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTongTienA, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27)
                                        .addGap(15, 15, 15)
                                        .addComponent(txtTongTienB))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTuKhoaDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnResetSearchDSHD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbMaHD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbMaKH)
                                        .addGap(6, 6, 6)
                                        .addComponent(rdbMaNV)))))))
                .addContainerGap())
            .addComponent(btnTimKiemHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaHDinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtMaNVinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtMaKHinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayLapinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtTongTieninDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResetSearchDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(txtTuKhoaDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdbMaHD)
                                .addComponent(rdbMaNV)
                                .addComponent(rdbMaKH))
                            .addComponent(rdbThongThuong))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtTongTienA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(txtTongTienB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rdbTongTienNC))
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemHD)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnChiTietPhieuNhapLayout = new javax.swing.GroupLayout(pnChiTietPhieuNhap);
        pnChiTietPhieuNhap.setLayout(pnChiTietPhieuNhapLayout);
        pnChiTietPhieuNhapLayout.setHorizontalGroup(
            pnChiTietPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietPhieuNhapLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnChiTietPhieuNhapLayout.setVerticalGroup(
            pnChiTietPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietPhieuNhapLayout.createSequentialGroup()
                .addGroup(pnChiTietPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        tbpPhieuNhap.addTab("Chi tiết hóa đơn", pnChiTietPhieuNhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 690, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNCCActionPerformed
        RecentKhachHangGUI rkh = new RecentKhachHangGUI();
        rkh.setVisible(true);
        String s = rkh.getMaKH();
        txtMaKH.setText(s);

    }//GEN-LAST:event_btnChonNCCActionPerformed

    private void btnChonNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNVActionPerformed
        RecentNhanVienGUI rnv = new RecentNhanVienGUI();
        rnv.setVisible(true);
        String s = rnv.getMaNV();
        txtMaNV.setText(s);
    }//GEN-LAST:event_btnChonNVActionPerformed

    private void btnInHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMouseClicked
        //dành cho xuất excel
        String MaHD = txtMaHD.getText();
        String MaKH = txtMaKH.getText();
        String MaNV = txtMaNV.getText();
        String NgayLap = ((JTextField) txtNgayLap.getDateEditor().getUiComponent()).getText();
        String TongTien = txtTongTienSauKM.getText();
        HoaDonDTO hd = new HoaDonDTO(MaHD, MaKH, MaNV, NgayLap, String.valueOf(TongTien));
        ///
        for(ChiTietHDDTO cthd : dscthd){
            cthdBUS.add(cthd);
        }
        
        ///xuất excel
        XuatHoaDonBUS xuathoadon = new XuatHoaDonBUS(hd, dscthd);
        xuathoadon.print();
        ///
        dtmGioHang.setRowCount(0);
        dscthd.clear();
        

    }//GEN-LAST:event_btnInHoaDonMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int k = tblGioHang.getSelectedRow();

        txtMaSP.setText(tblGioHang.getModel().getValueAt(k, 0).toString());
        txtSoLuong.setText(tblGioHang.getModel().getValueAt(k, 2).toString());


    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnNhapLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseClicked
        txtMaSP.setEnabled(true);
        cbxDonViTinh.setEnabled(true);
        txtTenSP.setEnabled(true);
        txtDonGia.setEnabled(true);
        txtSoLuong.setEnabled(true);
        txtThanhTien.setEnabled(true);

        txtMaSP.setText("");
        cbxDonViTinh.setSelectedIndex(0);
        txtTenSP.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");

    }//GEN-LAST:event_btnNhapLaiMouseClicked

    private void btnThemVaoGioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVaoGioMouseClicked
        if(txtMaHD.getText().equals("")){
            JOptionPane.showMessageDialog(btnThemVaoGio, "Vui lòng nhập mã hóa đơn", "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
        } else {
            String MaHD = txtMaHD.getText();
            String MaSP = txtMaSP.getText();
            String TenSP = txtTenSP.getText();
            int SoLuong = Integer.parseInt(txtSoLuong.getText());
            int DonGia = Integer.parseInt(txtDonGia.getText());
            int k = tblDSSP.getSelectedRow();
            int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k,4).toString());
            spBUS.capNhatSoLuongHD(MaSP, -SoLuong, SoLuongConLai);
            spBUS.docDanhSach();
            boolean flag = true;
            for(ChiTietHDDTO cthd : dscthd){
                if(cthd.getMaSP().equals(MaSP)){
                    int old = cthd.getSoLuong();
                    cthd.setSoLuong(old+SoLuong);
                    int new1 = cthd.getSoLuong();
                    cthd.setThanhTien(new1*DonGia);
                    flag = false;
                    break;
                }
            }
            if(flag){
                dscthd.add(new ChiTietHDDTO(MaHD, MaSP, TenSP, SoLuong, DonGia, DonGia));
                
            }
            outModel(dtmGioHang, dscthd);
            txtTongTien.setText(String.valueOf(sumHD()));
            loadDataWareHouse();
            txtMaSP.setText("");
            txtTenSP.setText("");
            txtSoLuong.setText("");
            txtDonGia.setText("");
            txtThanhTien.setText("");
            cbxDonViTinh.setSelectedIndex(0);
        }

    }//GEN-LAST:event_btnThemVaoGioMouseClicked

    private void btnThongTinSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinSPActionPerformed
//        RecentWareHouseGUI wh = new RecentWareHouseGUI();
//        wh.setVisible(true);
        RecentWareHouseGUI.setUndecorated(true);
        RecentWareHouseGUI.pack();
        RecentWareHouseGUI.setLocationRelativeTo(null);
        RecentWareHouseGUI.setVisible(true);

        String MaSP = getMaSPWH();
        String TenSP = getTenSPWH();
        String DonViTinh = getDonViTinhWH();
        String DonGia = getDonGiaWH();
        String SoLuong = getSoLuongWH();
        int ThanhTien = Integer.parseInt(DonGia) * Integer.parseInt(SoLuong);
        String SoLuongTrongKho = getSoLuongTrongKhoWH();

        txtMaSP.setText(MaSP);
        txtTenSP.setText(TenSP);
        cbxDonViTinh.setSelectedItem(DonViTinh);
        txtDonGia.setText(DonGia);
        txtSoLuong.setText(SoLuong);
        txtThanhTien.setText(String.valueOf(ThanhTien));

        txtMaSP.setEnabled(false);
        cbxDonViTinh.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtDonGia.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtThanhTien.setEnabled(false);

    }//GEN-LAST:event_btnThongTinSPActionPerformed

    private void btnCloseWHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseWHMouseClicked
        RecentWareHouseGUI.dispose();

    }//GEN-LAST:event_btnCloseWHMouseClicked

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        int k = tblDSSP.getSelectedRow();

        int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 4).toString());
        if (SoLuongConLai < 1) {
            JOptionPane.showMessageDialog(RecentWareHouseGUI, "Sản phẩm đã hết hàng", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, -10, SoLuongConLai, 1);
        txtSoLuongWH.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuongWH.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(false);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);

        txtMaSPWH.setText(tblDSSP.getModel().getValueAt(k, 0).toString());
        txtTenSPWH.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
        txtDonViTinhWH.setText(tblDSSP.getModel().getValueAt(k, 2).toString());
        txtDonGiaWH.setText(tblDSSP.getModel().getValueAt(k, 3).toString());
        txtSoLuongKhoWH.setText(tblDSSP.getModel().getValueAt(k, 4).toString());
        txtMaSPWH.setEnabled(false);
        txtTenSPWH.setEnabled(false);
        txtDonViTinhWH.setEnabled(false);
        txtDonGiaWH.setEnabled(false);
        txtSoLuongKhoWH.setEnabled(false);

    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnChonLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonLoaiMouseClicked
        RecentWareHouseGUI.dispose();
    }//GEN-LAST:event_btnChonLoaiMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        int k = tblGioHang.getSelectedRow();
        dscthd.remove(k);
        dtmGioHang.removeRow(k);
        txtTongTien.setText(String.valueOf(sumHD()));
        loadDataWareHouse();
        btnNhapLaiMouseClicked(evt);

    }//GEN-LAST:event_btnXoaMouseClicked

    private void tblDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSHDMouseClicked
        int k = tblDSHD.getSelectedRow();
        txtMaHDinDSHD.setEnabled(false);
        txtMaKHinDSHD.setEnabled(false);
        txtMaNVinDSHD.setEnabled(false);
        txtNgayLapinDSHD.setEnabled(false);
        txtTongTieninDSHD.setEnabled(false);
        txtMaHDinDSHD.setText(tblDSHD.getModel().getValueAt(k, 0).toString());
        txtMaKHinDSHD.setText(tblDSHD.getModel().getValueAt(k, 1).toString());
        txtMaNVinDSHD.setText(tblDSHD.getModel().getValueAt(k, 2).toString());
        txtNgayLapinDSHD.setText(tblDSHD.getModel().getValueAt(k, 3).toString());
        txtTongTieninDSHD.setText(tblDSHD.getModel().getValueAt(k, 4).toString());
        String MaHD = txtMaHDinDSHD.getText();

        loadDataDSCTHDTheoMaHD(MaHD);
    }//GEN-LAST:event_tblDSHDMouseClicked

    private void tblDSCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTHDMouseClicked
        int k = tblDSCTHD.getSelectedRow();
        txtMaSPinDSCTHD.setText(tblDSCTHD.getModel().getValueAt(k, 0).toString());
        txtTenSPinDSCTHD.setText(tblDSCTHD.getModel().getValueAt(k, 1).toString());
        txtSoLuonginDSCTHD.setText(tblDSCTHD.getModel().getValueAt(k, 2).toString());
        txtDonGiainDSCTHD.setText(tblDSCTHD.getModel().getValueAt(k, 3).toString());
        txtThanhTieninDSCTHD.setText(tblDSCTHD.getModel().getValueAt(k, 4).toString());

        txtMaSPinDSCTHD.setEnabled(false);
        txtTenSPinDSCTHD.setEnabled(false);
        txtSoLuonginDSCTHD.setEnabled(false);
        txtDonGiainDSCTHD.setEnabled(false);
        txtThanhTieninDSCTHD.setEnabled(false);

    }//GEN-LAST:event_tblDSCTHDMouseClicked

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        String MaHD = txtMaHD.getText();
        String MaKH = txtMaKH.getText();
        String MaNV = txtMaNV.getText();
        String NgayLap = ((JTextField) txtNgayLap.getDateEditor().getUiComponent()).getText();
        String TongTien = txtTongTienSauKM.getText();
        HoaDonDTO hd = new HoaDonDTO(MaHD, MaKH, MaNV, NgayLap, TongTien);
        hdBUS.add(hd);
        loadDataDSHD();


    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void btnTimKiemHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemHDMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/warning.png"));
        if (rdbThongThuong.isSelected()) {
            if (txtTuKhoaDSHD.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm kiếm", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE, icon);
            }
            if (rdbMaHD.isSelected()) {
                dshd = hdBUS.timKiemTheoMaHD(txtTuKhoaDSHD.getText().toString());
                showAllDSHD(dshd);
            }
            if (rdbMaNV.isSelected()) {
                dshd = hdBUS.timKiemTheoMaNV(txtTuKhoaDSHD.getText().toString());
                showAllDSHD(dshd);
            }
            if (rdbMaKH.isSelected()) {
                dshd = hdBUS.timKiemTheoMaKH(txtTuKhoaDSHD.getText().toString());
                showAllDSHD(dshd);
            }

        }
        if (rdbTongTienNC.isSelected()) {
            buttonGroup1.clearSelection();
            if (txtTongTienA.getText().equals("") || txtTongTienB.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu cần tìm kiếm", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE, icon);
            } else {
                int x = Integer.parseInt(txtTongTienA.getText());
                int y = Integer.parseInt(txtTongTienB.getText());
                dshd = hdBUS.timKiemTongTienNangCao(x, y);
                showAllDSHD(dshd);
            }
        }

    }//GEN-LAST:event_btnTimKiemHDMouseClicked

    private void btnResetSearchDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetSearchDSHDMouseClicked
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        txtTuKhoaDSHD.setText("");
        txtTongTienA.setText("");
        txtTongTienB.setText("");
        loadDataDSHD();
    }//GEN-LAST:event_btnResetSearchDSHDMouseClicked

    private void btnResetSearchDSCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetSearchDSCTHDMouseClicked
        txtTuKhoainDSCTHD.setText("");
        txtDonGiaBDinDSCTHD.setText("");
        txtDonGiaKTinDSCTHD.setText("");
        txtSoLuongBDinDSCTHD.setText("");
        txtSoLuongKTinDSCTHD.setText("");
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();
        loadDataDSCTHD();

    }//GEN-LAST:event_btnResetSearchDSCTHDMouseClicked

    private void btnChonKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKMActionPerformed

        double TongTien = Double.parseDouble(txtTongTien.getText());
        RecentKhuyenMaiGUI rkm = new RecentKhuyenMaiGUI(TongTien);
        rkm.setVisible(true);

        double KM = Double.parseDouble(rkm.getPhanTramKM());
        txtPhanTramKM.setText(String.valueOf(KM));
        double TongTienSauKM = TongTien - TongTien * (KM / 100);
        txtTongTienSauKM.setText(String.valueOf(TongTienSauKM));
//       

    }//GEN-LAST:event_btnChonKMActionPerformed

    private void btnTimKiemDSCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemDSCTHDMouseClicked
        if (rdbThongThuonginDSCTHD.isSelected()) {
            if (txtTuKhoainDSCTHD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                if (rdbMaSPinDSCTHD.isSelected()) {
                    ArrayList<ChiTietHDDTO> dscthd = cthdBUS.timKiemMaSP(txtTuKhoainDSCTHD.getText());
                    showAllDSCTHD(dscthd);
                }
                if (rdbTenSPinDSCTHD.isSelected()) {
                    ArrayList<ChiTietHDDTO> dscthd = cthdBUS.timKiemTenSP(txtTuKhoainDSCTHD.getText());
                    showAllDSCTHD(dscthd);
                }
            }
        }

        if (rdbDonGiaNCinDSCTHD.isSelected()) {
            if (txtDonGiaBDinDSCTHD.getText().equals("") || txtDonGiaKTinDSCTHD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                ArrayList<ChiTietHDDTO> dscthd = cthdBUS.timKiemThanhTienNangCao(Integer.parseInt(txtDonGiaBDinDSCTHD.getText()), Integer.parseInt(txtDonGiaKTinDSCTHD.getText()));
                showAllDSCTHD(dscthd);
            }
        }
        if (rdbSoLuongNCinDSCTHD.isSelected()) {
            if (txtSoLuongBDinDSCTHD.getText().equals("") || txtSoLuongKTinDSCTHD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm", "Thông báo", JOptionPane.WARNING_MESSAGE);

            } else {
                ArrayList<ChiTietHDDTO> dscthd = cthdBUS.timKiemSoLuongNangCao(Integer.parseInt(txtSoLuongBDinDSCTHD.getText()), Integer.parseInt(txtSoLuongKTinDSCTHD.getText()));
                showAllDSCTHD(dscthd);
            }
        }
    }//GEN-LAST:event_btnTimKiemDSCTHDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog RecentWareHouseGUI;
    private javax.swing.JButton btnChonKM;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JButton btnChonNCC;
    private javax.swing.JButton btnChonNV;
    private javax.swing.JLabel btnCloseWH;
    private javax.swing.JLabel btnInHoaDon;
    private javax.swing.JLabel btnNhapLai;
    private javax.swing.JLabel btnResetSearchDSCTHD;
    private javax.swing.JLabel btnResetSearchDSHD;
    private javax.swing.JLabel btnTaoHoaDon;
    private javax.swing.JLabel btnThemVaoGio;
    private javax.swing.JButton btnThongTinSP;
    private javax.swing.JLabel btnTimKiemDSCTHD;
    private javax.swing.JLabel btnTimKiemHD;
    private javax.swing.JLabel btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbxDonViTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JPanel pnChiTietPhieuNhap;
    private javax.swing.JPanel pnHeader2;
    private javax.swing.JPanel pnPhieuNhap;
    private javax.swing.JRadioButton rdbDonGiaNCinDSCTHD;
    private javax.swing.JRadioButton rdbMaHD;
    private javax.swing.JRadioButton rdbMaKH;
    private javax.swing.JRadioButton rdbMaNV;
    private javax.swing.JRadioButton rdbMaSPinDSCTHD;
    private javax.swing.JRadioButton rdbSoLuongNCinDSCTHD;
    private javax.swing.JRadioButton rdbTenSPinDSCTHD;
    private javax.swing.JRadioButton rdbThongThuong;
    private javax.swing.JRadioButton rdbThongThuonginDSCTHD;
    private javax.swing.JRadioButton rdbTongTienNC;
    private javax.swing.JTable tblDSCTHD;
    private javax.swing.JTable tblDSHD;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTabbedPane tbpPhieuNhap;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonGiaBDinDSCTHD;
    private javax.swing.JTextField txtDonGiaKTinDSCTHD;
    private javax.swing.JTextField txtDonGiaWH;
    private javax.swing.JTextField txtDonGiainDSCTHD;
    private javax.swing.JTextField txtDonViTinhWH;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDinDSHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKHinDSHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNVinDSHD;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSPWH;
    private javax.swing.JTextField txtMaSPinDSCTHD;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtNgayLapinDSHD;
    private javax.swing.JTextField txtPhanTramKM;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongBDinDSCTHD;
    private javax.swing.JTextField txtSoLuongKTinDSCTHD;
    private javax.swing.JTextField txtSoLuongKhoWH;
    private javax.swing.JSpinner txtSoLuongWH;
    private javax.swing.JTextField txtSoLuonginDSCTHD;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSPWH;
    private javax.swing.JTextField txtTenSPinDSCTHD;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtThanhTieninDSCTHD;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTienA;
    private javax.swing.JTextField txtTongTienB;
    private javax.swing.JTextField txtTongTienSauKM;
    private javax.swing.JTextField txtTongTieninDSHD;
    private javax.swing.JTextField txtTuKhoaDSHD;
    private javax.swing.JTextField txtTuKhoainDSCTHD;
    // End of variables declaration//GEN-END:variables
}
