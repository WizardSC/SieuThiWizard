/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class NhaCungCapGUI extends javax.swing.JPanel {

    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
    DefaultTableModel model;

    public NhaCungCapGUI() {
        initComponents();
        init();
        model = (DefaultTableModel) tblDSNCC.getModel();
        loadData();
//        timKiem();
    }

    public void init() {
        tblDSNCC.setFocusable(false);
        tblDSNCC.setIntercellSpacing(new Dimension(0, 0));

        tblDSNCC.setRowHeight(25);

        tblDSNCC.getTableHeader().setOpaque(false);
        tblDSNCC.setFillsViewportHeight(true);
        tblDSNCC.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSNCC.getTableHeader().setForeground(Color.WHITE);
        tblDSNCC.setSelectionBackground(new Color(52, 152, 219));
        tblDSNCC.setFont(new Font("Arial", Font.PLAIN, 13));
    }

    public void showAll(ArrayList<NhaCungCapDTO> dsncc) {
        model.setRowCount(0);
        for (int i = 0; i < dsncc.size(); i++) {
            model.addRow(new String[]{
                dsncc.get(i).getMaNCC(),
                dsncc.get(i).getTenNCC(),
                dsncc.get(i).getDiaChi(),
                dsncc.get(i).getSoDT(),
                dsncc.get(i).getSoFAX()
            });
        }

    }

    public void loadData() {
        nccBUS.docDanhSach();
        ArrayList<NhaCungCapDTO> dsncc = nccBUS.getListNhaCungCap();
        showAll(dsncc);
    }

    private void xuLyLiveSearch() {
        ArrayList<NhaCungCapDTO> dsncc = nccBUS.timKiemTheoSoDT(txtTimKiem.getText());
        showAll(dsncc);
    }
//    public void timKiem(){
//        
//            txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                xuLyLiveSearch();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                xuLyLiveSearch();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                xuLyLiveSearch();
//            }
//        });
//        
//        
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMaNCC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoFAX = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JLabel();
        btnNhapLai = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnXuatExcel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        rdbMaNCC = new javax.swing.JRadioButton();
        rdbTenNCC = new javax.swing.JRadioButton();
        rdbSoFAX = new javax.swing.JRadioButton();
        rdbSoDT = new javax.swing.JRadioButton();
        rdbDiaChi = new javax.swing.JRadioButton();
        btnResetSearch = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSNCC = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(233, 213, 218));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 690));

        jPanel2.setBackground(new java.awt.Color(233, 213, 218));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ NHÀ CUNG CẤP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mã NCC");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tên NCC");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Số ĐT");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Số FAX");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");

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

        btnChinhSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gear.png"))); // NOI18N
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseClicked(evt);
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

        jLabel20.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        jLabel20.setText("Nhập Excel");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnXuatExcel.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xls.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXuatExcelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addGap(18, 59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSoFAX, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 73, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChinhSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatExcel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoFAX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatExcel)
                    .addComponent(jLabel20)
                    .addComponent(btnNhapLai)
                    .addComponent(btnChinhSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        jPanel3.setBackground(new java.awt.Color(233, 213, 218));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Nhập từ khóa");

        rdbMaNCC.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbMaNCC);
        rdbMaNCC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaNCC.setText("Mã NCC");

        rdbTenNCC.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbTenNCC);
        rdbTenNCC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbTenNCC.setText("Tên NCC");

        rdbSoFAX.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbSoFAX);
        rdbSoFAX.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbSoFAX.setText("Số FAX");

        rdbSoDT.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbSoDT);
        rdbSoDT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbSoDT.setText("Số ĐT");

        rdbDiaChi.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbDiaChi);
        rdbDiaChi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbDiaChi.setText("Địa chỉ");

        btnResetSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-right.png"))); // NOI18N
        btnResetSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetSearchMouseClicked(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbMaNCC)
                                    .addComponent(rdbDiaChi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbTenNCC)
                                    .addComponent(rdbSoDT))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(btnTimKiem))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(rdbSoFAX)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbMaNCC)
                    .addComponent(rdbTenNCC))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbDiaChi)
                    .addComponent(rdbSoDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbSoFAX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );

        tblDSNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên NCC", "Địa chỉ", "Số ĐT", "Số FAX"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNCC.getTableHeader().setReorderingAllowed(false);
        tblDSNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSNCC);
        if (tblDSNCC.getColumnModel().getColumnCount() > 0) {
            tblDSNCC.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSNCC.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblDSNCC.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblDSNCC.getColumnModel().getColumn(3).setPreferredWidth(20);
            tblDSNCC.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaNCC = txtMaNCC.getText();
        String TenNCC = txtTenNCC.getText();
        String DiaChi = txtDiaChi.getText();
        String SoDT = txtSoDT.getText();
        String SoFAX = txtSoFAX.getText();
//        
//        if(nccBUS.check(MaNCC)){
//            JOptionPane.showMessageDialog(null, "Trung maNCC");
//            return;
//        }
        NhaCungCapDTO ncc = new NhaCungCapDTO(MaNCC, TenNCC, DiaChi, SoDT, SoFAX);
        nccBUS.add(ncc);
        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnNhapLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseClicked
        //+++set Textfield thành rỗng+++
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSoDT.setText("");
        txtSoFAX.setText("");
        //+++++++++++++++++++++++++++++++++++++++++++++++
        tblDSNCC.getSelectionModel().clearSelection();
        txtMaNCC.setEnabled(true);
        loadData();
        
    }//GEN-LAST:event_btnNhapLaiMouseClicked

    private void btnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseClicked
        String MaNCC = txtMaNCC.getText();
        String TenNCC = txtTenNCC.getText();
        String DiaChi = txtDiaChi.getText();
        String SoDT = txtSoDT.getText();
        String SoFAX = txtSoFAX.getText();

        NhaCungCapDTO ncc = new NhaCungCapDTO(MaNCC, TenNCC, DiaChi, SoDT, SoFAX);
        nccBUS.update(ncc);
        loadData();
        
    }//GEN-LAST:event_btnChinhSuaMouseClicked

    private void tblDSNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNCCMouseClicked
        int k = tblDSNCC.getSelectedRow();
        txtMaNCC.setText(tblDSNCC.getModel().getValueAt(k, 0).toString());
        txtTenNCC.setText(tblDSNCC.getModel().getValueAt(k, 1).toString());
        txtDiaChi.setText(tblDSNCC.getModel().getValueAt(k, 2).toString());
        txtSoDT.setText(tblDSNCC.getModel().getValueAt(k, 3).toString());
        txtSoFAX.setText(tblDSNCC.getModel().getValueAt(k, 4).toString());
        txtMaNCC.setEnabled(false);
    }//GEN-LAST:event_tblDSNCCMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        nccBUS.delete(txtMaNCC.getText());
        loadData();
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        btnNhapLaiMouseClicked(evt);
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/warning.png"));
        String tuKhoa = txtTimKiem.getText();
        if (txtTimKiem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống thông tin", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE, icon);
        } else {
            if (rdbMaNCC.isSelected()) {
                NhaCungCapDTO ncc1 = nccBUS.timKiemTheoMaNCC1(tuKhoa);
                dsncc.add(ncc1);
                showAll(dsncc);
            }
            if(rdbTenNCC.isSelected()){
                dsncc = nccBUS.timKiemTheoTenNCC(tuKhoa);
                showAll(dsncc);
            }
            if(rdbDiaChi.isSelected()){
                dsncc = nccBUS.timKiemTheoDiaChi(tuKhoa);
                showAll(dsncc);
            }
            if(rdbSoDT.isSelected()){
                dsncc = nccBUS.timKiemTheoSoDT(tuKhoa);
                showAll(dsncc);
            }
            if(rdbSoFAX.isSelected()){
                dsncc = nccBUS.timKiemTheoSoFAX(tuKhoa);
                showAll(dsncc);
            }

        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetSearchMouseClicked
        btnNhapLaiMouseClicked(evt);
        txtTimKiem.setText("");
        buttonGroup1.clearSelection();
        loadData();
    }//GEN-LAST:event_btnResetSearchMouseClicked

    private void btnXuatExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatExcelMouseClicked
        nccBUS.ExportExcel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JOptionPane.showMessageDialog(null, "Đã xuất file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);
    
    }//GEN-LAST:event_btnXuatExcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChinhSua;
    private javax.swing.JLabel btnNhapLai;
    private javax.swing.JLabel btnResetSearch;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btnXuatExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdbDiaChi;
    private javax.swing.JRadioButton rdbMaNCC;
    private javax.swing.JRadioButton rdbSoDT;
    private javax.swing.JRadioButton rdbSoFAX;
    private javax.swing.JRadioButton rdbTenNCC;
    private javax.swing.JTable tblDSNCC;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtSoFAX;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
