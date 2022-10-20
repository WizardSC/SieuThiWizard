/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.NhanVienBUS;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import java.awt.image.BufferedImage;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class NhanVienGUI extends javax.swing.JPanel {

    private NhanVienBUS nvBUS = new NhanVienBUS();
    private HoaDonBUS hdBUS = new HoaDonBUS();

    private ArrayList<NhanVienDTO> dsnv = new ArrayList<>();

    DefaultTableModel model;
    private BufferedImage i = null;
    String imgName = "null";

    public NhanVienGUI() {
        initComponents();

        init();
        model = (DefaultTableModel) tblDSNV.getModel();
        loadData();
    }

    public void init() {
        tblDSNV.setFocusable(false);
        tblDSNV.setIntercellSpacing(new Dimension(0, 0));

        tblDSNV.setRowHeight(25);

        tblDSNV.getTableHeader().setOpaque(false);
        tblDSNV.setFillsViewportHeight(true);
        tblDSNV.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSNV.getTableHeader().setForeground(Color.WHITE);
        tblDSNV.setSelectionBackground(new Color(52, 152, 219));
        tblDSNV.setFont(new Font("Arial", Font.PLAIN, 13));
        //Cập nhật lương cho nhân viên
        
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        nvBUS.docDanhSach();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        for(NhanVienDTO nv : dsnv){
            System.out.println(nv.getMaNV());
            nvBUS.updateLuong(nv.getMaNV(), 0);
        }
        
        for(HoaDonDTO hd : dshd){
            nvBUS.docDanhSach();
            ArrayList<NhanVienDTO> dsnv1 = nvBUS.getListNhanVien();
            for(NhanVienDTO nv : dsnv1){
                if(nv.getMaNV().equals(hd.getMaNV())){
                    int luong = nv.getLuong();
                    luong=luong+500000;
                    nvBUS.updateLuong(nv.getMaNV(), luong);
                }
            }
        }
//        hdBUS.docDanhSach();
//        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
//        nvBUS.docDanhSach();
//        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
//        
//        for(NhanVienDTO nv : dsnv){ //vòng lặp for này đảm bảo mỗi lần chạy form thì sẽ cập nhật lại lương về 0
//            nvBUS.updateLuong(nv.getMaNV(), 0);
//        }
//        for(HoaDonDTO hd : dshd){
//            nvBUS.docDanhSach();
//            ArrayList<NhanVienDTO> dsnv1 = nvBUS.getListNhanVien();
//            for(NhanVienDTO nv : dsnv1){
//                if(hd.getMaNV().equals(nv.getMaNV())){
//                    int luong = nv.getLuong();
//                    luong=luong+500000;
//                    nvBUS.updateLuong(nv.getMaNV(), luong);
//                }
//            }
//        }
        /////

        txtMaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtHo.requestFocus();
                }
            }
        });
        txtHo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtTen.requestFocus();
                }
            }
        });
        txtTen.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNgaySinh.requestFocus();
                }
            }
        });
        txtNgaySinh.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtDiaChi.requestFocus();
                }
            }
        });
        txtDiaChi.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtSoDT.requestFocus();
                }
            }
        });
        txtSoDT.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtLuong.requestFocus();
                }
            }
        });
    }

    public void showAll(ArrayList<NhanVienDTO> dsnv) {
        model.setRowCount(0);
        for (int i = 0; i < dsnv.size(); i++) {
            model.addRow(new String[]{
                dsnv.get(i).getMaNV(),
                dsnv.get(i).getHo(),
                dsnv.get(i).getTen(),
                dsnv.get(i).getNgaySinh(),
                dsnv.get(i).getGioiTinh(),
                dsnv.get(i).getDiaChi(),
                dsnv.get(i).getSoDT(),
                String.valueOf(dsnv.get(i).getLuong()),
                dsnv.get(i).getIMG()
            });
        }

    }

    public void loadData() {
        nvBUS.docDanhSach();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        showAll(dsnv);
    }

    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/image/NhanVien/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(KhachHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        txtIMG = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnNhapLai = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JLabel();
        btnXuatExcel = new javax.swing.JLabel();
        btnNhapExcel = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTuKhoa = new javax.swing.JTextField();
        rdbMaNV = new javax.swing.JRadioButton();
        rdbTenNV = new javax.swing.JRadioButton();
        rdbNamSinh = new javax.swing.JRadioButton();
        rdbDiaChi = new javax.swing.JRadioButton();
        rdbSoDT = new javax.swing.JRadioButton();
        rdbGioiTinh = new javax.swing.JRadioButton();
        btnResetSearch = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNamBD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNamKT = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JLabel();
        rdbThongThuong = new javax.swing.JRadioButton();
        rdbNangCao = new javax.swing.JRadioButton();
        rdbHoNV = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMinLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMaxLuong = new javax.swing.JTextField();
        rdbNamSinhNC = new javax.swing.JRadioButton();
        rdbLuongNC = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();

        setBackground(new java.awt.Color(233, 213, 218));

        jPanel1.setBackground(new java.awt.Color(233, 213, 218));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 690));

        jPanel2.setBackground(new java.awt.Color(233, 213, 218));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(130, 115, 151)), "QUẢN LÝ NHÂN VIÊN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Mã NV");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Họ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn giới tính", "Nam", "Nữ" }));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Số ĐT");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Lương");

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnThem.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        btnNhapLai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnNhapLai.setText("Nhập lại");
        btnNhapLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhapLaiMouseClicked(evt);
            }
        });

        btnChinhSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gear.png"))); // NOI18N
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseClicked(evt);
            }
        });

        btnXuatExcel.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xls.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXuatExcelMouseClicked(evt);
            }
        });

        btnNhapExcel.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhapExcelMouseClicked(evt);
            }
        });

        btnChonAnh.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload.png"))); // NOI18N
        btnChonAnh.setText("Upload ảnh");
        btnChonAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChonAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txtHo)
                    .addComponent(txtDiaChi)
                    .addComponent(txtSoDT))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxGioiTinh, 0, 150, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtTen)
                            .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChinhSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatExcel)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatExcel)
                    .addComponent(btnNhapExcel)
                    .addComponent(btnNhapLai)
                    .addComponent(btnChinhSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(233, 213, 218));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Nhập từ khóa");

        rdbMaNV.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbMaNV);
        rdbMaNV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaNV.setText("Mã NV");

        rdbTenNV.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbTenNV);
        rdbTenNV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbTenNV.setText("Tên NV");

        rdbNamSinh.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbNamSinh);
        rdbNamSinh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbNamSinh.setText("Năm sinh");

        rdbDiaChi.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbDiaChi);
        rdbDiaChi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbDiaChi.setText("Địa chỉ");

        rdbSoDT.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbSoDT);
        rdbSoDT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbSoDT.setText("Số ĐT");

        rdbGioiTinh.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbGioiTinh);
        rdbGioiTinh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbGioiTinh.setText("Giới tính");

        btnResetSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-right.png"))); // NOI18N
        btnResetSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetSearchMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("đến");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Tìm kiếm năm sinh từ:");

        btnTimKiem.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        rdbThongThuong.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup2.add(rdbThongThuong);

        rdbNangCao.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup2.add(rdbNangCao);

        rdbHoNV.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbHoNV);
        rdbHoNV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbHoNV.setText("Họ NV");

        jLabel14.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(207, 0, 0));
        jLabel14.setText("Tìm kiếm nâng cao");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Tìm kiếm lương từ");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("đến");

        rdbNamSinhNC.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup3.add(rdbNamSinhNC);

        rdbLuongNC.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup3.add(rdbLuongNC);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(rdbHoNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdbTenNV)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbSoDT)
                    .addComponent(rdbGioiTinh))
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdbMaNV)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdbThongThuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbDiaChi)
                            .addComponent(rdbNamSinh))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdbNangCao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdbNamSinhNC)
                                    .addComponent(rdbLuongNC))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMinLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamBD, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNamKT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaxLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdbThongThuong))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbTenNV)
                        .addComponent(rdbHoNV))
                    .addComponent(rdbMaNV))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbNamSinh)
                    .addComponent(rdbGioiTinh))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbDiaChi)
                    .addComponent(rdbSoDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdbNangCao)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtNamBD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamKT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(rdbNamSinhNC, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtMinLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtMaxLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdbLuongNC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa Chỉ", "Số ĐT", "Lương", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSNV);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, Short.MAX_VALUE)
                        .addGap(11, 11, 11))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaNV = txtMaNV.getText().toUpperCase();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String NgaySinh = txtNgaySinh.getText();
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String DiaChi = txtDiaChi.getText();
        String SoDT = txtSoDT.getText();
        String Luong = txtLuong.getText();
        String IMG = imgName;
        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, Integer.parseInt(Luong), IMG);
        nvBUS.add(nv);
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnNhapLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseClicked
        txtMaNV.setText("");
        txtMaNV.setEnabled(true);
        txtHo.setText("");
        txtTen.setText("");
        txtNgaySinh.setText("");
        cbxGioiTinh.setSelectedIndex(0);
        txtDiaChi.setText("");
        txtLuong.setText("");
        txtIMG.setIcon(null);
        txtIMG.setText("IMAGE");
        imgName = null;
        txtSoDT.setText("");

    }//GEN-LAST:event_btnNhapLaiMouseClicked

    private void btnChonAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonAnhMouseClicked
        JFileChooser fc = new JFileChooser("./src/image/NhanVien");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, PNG & JPEG images", "jpg", "png", "jpeg");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile(); //Lấy URL hình
                i = ImageIO.read(file); // Lấy hình
                imgName = txtTen.getText().concat(".jpg"); //Tên hình
                // Thay đổi hình hiển thị
                txtIMG.setText("");
                txtIMG.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));

                revalidate();
                repaint();
            } catch (IOException ex) {
                Logger.getLogger(KhachHangGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnChonAnhMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        nvBUS.delete(txtMaNV.getText());
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnXoaMouseClicked

    private void tblDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVMouseClicked
        int k = tblDSNV.getSelectedRow();
        txtMaNV.setEnabled(false);
        txtLuong.setEnabled(false);
        txtMaNV.setText(tblDSNV.getModel().getValueAt(k, 0).toString());
        txtHo.setText(tblDSNV.getModel().getValueAt(k, 1).toString());
        txtTen.setText(tblDSNV.getModel().getValueAt(k, 2).toString());
        txtNgaySinh.setText(tblDSNV.getModel().getValueAt(k, 3).toString());
        cbxGioiTinh.setSelectedItem(tblDSNV.getModel().getValueAt(k, 4).toString());
        txtDiaChi.setText(tblDSNV.getModel().getValueAt(k, 5).toString());
        txtSoDT.setText(tblDSNV.getModel().getValueAt(k, 6).toString());
        txtLuong.setText(tblDSNV.getModel().getValueAt(k, 7).toString());
        imgName = tblDSNV.getModel().getValueAt(k, 8).toString();
        Image newImage;

        newImage = new ImageIcon("./src/image/NhanVien/" + imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);

        txtIMG.setIcon(new ImageIcon(newImage));
    }//GEN-LAST:event_tblDSNVMouseClicked

    private void btnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseClicked
        String MaNV = txtMaNV.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String NgaySinh = txtNgaySinh.getText();
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String DiaChi = txtDiaChi.getText();
        String SoDT = txtSoDT.getText();
        String Luong = txtLuong.getText();
        String IMG = imgName;
        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, Integer.parseInt(Luong), IMG);
        nvBUS.update(nv);
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnChinhSuaMouseClicked

    private void btnXuatExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatExcelMouseClicked
        nvBUS.ExportExcel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JOptionPane.showMessageDialog(this, "Đã xuất file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_btnXuatExcelMouseClicked

    private void btnNhapExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapExcelMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JFileChooser fc = new JFileChooser("./report");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Excel", "xlsx");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile(); //Lấy URL
            nvBUS.ImportExcel(file);
            nvBUS.listNV();
            JOptionPane.showMessageDialog(null, "Đã nhập file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);

        }
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnNhapExcelMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/warning.png"));
        if (rdbThongThuong.isSelected()) {
            if (txtTuKhoa.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm kiếm", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE, icon);

            } else {
                if (rdbMaNV.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoMaNV(txtTuKhoa.getText());
                    showAll(dsnv);
                }
                if (rdbTenNV.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoTenNV(txtTuKhoa.getText());
                    showAll(dsnv);
                }
                if (rdbHoNV.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoHoNV(txtTuKhoa.getText());
                    showAll(dsnv);
                }
                if (rdbNamSinh.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoNamSinh(txtTuKhoa.getText());
                    showAll(dsnv);
                }
                if (rdbGioiTinh.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoGioiTinh(txtTuKhoa.getText());
                    showAll(dsnv);
                }
                if (rdbDiaChi.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoDiaChi(txtTuKhoa.getText());
                    showAll(dsnv);
                }
                if (rdbSoDT.isSelected()) {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemTheoSoDT(txtTuKhoa.getText());
                    showAll(dsnv);
                }
            }
        }
        if (rdbNangCao.isSelected()) {
            if (rdbNamSinhNC.isSelected()) {
                if (txtNamBD.getText().equals("") && txtNamKT.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemNamSinhNangCao(txtNamBD.getText(), txtNamKT.getText());
                    showAll(dsnv);
                }
            }
            if (rdbLuongNC.isSelected()) {
                if (txtMinLuong.getText().equals("") && txtMaxLuong.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);

                } else {
                    ArrayList<NhanVienDTO> dsnv = nvBUS.timKiemLuongNangCao(txtMinLuong.getText(), txtMaxLuong.getText());
                    showAll(dsnv);
                }
            }

        }

    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetSearchMouseClicked
        txtTuKhoa.setText("");
        txtNamBD.setText("");
        txtNamKT.setText("");
        txtMinLuong.setText("");
        txtMaxLuong.setText("");
        saveIMG();
        loadData();
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
    }//GEN-LAST:event_btnResetSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChinhSua;
    private javax.swing.JLabel btnChonAnh;
    private javax.swing.JLabel btnNhapExcel;
    private javax.swing.JLabel btnNhapLai;
    private javax.swing.JLabel btnResetSearch;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btnXuatExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdbDiaChi;
    private javax.swing.JRadioButton rdbGioiTinh;
    private javax.swing.JRadioButton rdbHoNV;
    private javax.swing.JRadioButton rdbLuongNC;
    private javax.swing.JRadioButton rdbMaNV;
    private javax.swing.JRadioButton rdbNamSinh;
    private javax.swing.JRadioButton rdbNamSinhNC;
    private javax.swing.JRadioButton rdbNangCao;
    private javax.swing.JRadioButton rdbSoDT;
    private javax.swing.JRadioButton rdbTenNV;
    private javax.swing.JRadioButton rdbThongThuong;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaxLuong;
    private javax.swing.JTextField txtMinLuong;
    private javax.swing.JTextField txtNamBD;
    private javax.swing.JTextField txtNamKT;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
