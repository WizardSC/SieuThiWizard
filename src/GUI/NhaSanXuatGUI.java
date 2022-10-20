/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhaSanXuatBUS;
import DTO.NhaSanXuatDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class NhaSanXuatGUI extends javax.swing.JDialog {

    private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
    DefaultTableModel model;

    public NhaSanXuatGUI() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(true);
        init();
        model = (DefaultTableModel) tblDSNSX.getModel();
        loadData();
    }

    public void init() {

        tblDSNSX.setFocusable(false);
        tblDSNSX.setIntercellSpacing(new Dimension(0, 0));

        tblDSNSX.setRowHeight(25);

        tblDSNSX.getTableHeader().setOpaque(false);
        tblDSNSX.setFillsViewportHeight(true);
        tblDSNSX.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSNSX.getTableHeader().setForeground(Color.WHITE);
        tblDSNSX.setSelectionBackground(new Color(52, 152, 219));

        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                xuLyLiveSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                xuLyLiveSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                xuLyLiveSearch();
            }
        });

    }

    public void xuLyLiveSearch() {
        ArrayList<NhaSanXuatDTO> dsnsx = nsxBUS.timKiemTheoMaNSX(txtTimKiem.getText());
        showAll(dsnsx);
    }

    public void showAll(ArrayList<NhaSanXuatDTO> dsnsx) {
        model.setRowCount(0);
        for (int i = 0; i < dsnsx.size(); i++) {
            model.addRow(new String[]{
                dsnsx.get(i).getMaNSX(),
                dsnsx.get(i).getTenNSX()
            });
        }
    }

    public void loadData() {
        nsxBUS.docDanhSach();
        ArrayList<NhaSanXuatDTO> dsnsx = nsxBUS.getListNhaSanXuat();
        showAll(dsnsx);
    }

    public String getMaNSX() {
        return txtMaNSX.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHeader1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMaNSX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenNSX = new javax.swing.JTextField();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnNhapLai = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSNSX = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSelectMaNSX = new javax.swing.JTextField();
        txtSelectTenNSX = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnChonNSX = new javax.swing.JLabel();
        btnBoChonNSX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnHeader1.setBackground(new java.awt.Color(54, 48, 98));
        pnHeader1.setPreferredSize(new java.awt.Dimension(102, 40));

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tag.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("QUẢN LÝ MÃ NHÀ SẢN XUẤT");

        javax.swing.GroupLayout pnHeader1Layout = new javax.swing.GroupLayout(pnHeader1);
        pnHeader1.setLayout(pnHeader1Layout);
        pnHeader1Layout.setHorizontalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeader1Layout.setVerticalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(233, 213, 218));

        jPanel2.setBackground(new java.awt.Color(233, 213, 218));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ NHÀ SẢN XUẤT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Mã NSX");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Tên NSX");

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

        btnSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gear.png"))); // NOI18N
        btnSua.setText("Chỉnh sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
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

        jLabel19.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xls.png"))); // NOI18N
        jLabel19.setText("Xuất Excel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua)
                            .addComponent(btnThem))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNhapLai)
                            .addComponent(btnXoa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTenNSX))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnNhapLai)
                    .addComponent(jLabel19)))
        );

        jPanel3.setBackground(new java.awt.Color(233, 213, 218));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-right.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NSX" }));
        jComboBox1.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        tblDSNSX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã nhà sản xuất", "Tên nhà sản xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNSXMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSNSX);

        jPanel6.setBackground(new java.awt.Color(233, 213, 218));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN NHÀ SẢN XUẤT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("KIẾM TRA THÔNG TIN");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Mã NSX");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Tên NSX");

        btnChonNSX.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonNSX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnChonNSX.setText("Chọn nhà sản xuất");
        btnChonNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonNSXMouseClicked(evt);
            }
        });

        btnBoChonNSX.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnBoChonNSX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBoChonNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        btnBoChonNSX.setText("Bỏ chọn");
        btnBoChonNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoChonNSXMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSelectMaNSX, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSelectTenNSX, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnChonNSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBoChonNSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtSelectMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtSelectTenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnChonNSX)
                .addGap(28, 28, 28)
                .addComponent(btnBoChonNSX)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaNSX = txtMaNSX.getText();
        String TenNSX = txtTenNSX.getText();
        NhaSanXuatDTO nsx = new NhaSanXuatDTO(MaNSX, TenNSX);
        nsxBUS.add(nsx);
        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnNhapLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseClicked
        txtMaNSX.setText("");
        txtTenNSX.setText("");
        txtSelectMaNSX.setText("");
        txtSelectTenNSX.setText("");
        txtMaNSX.setEnabled(true);
        txtSelectMaNSX.setEnabled(true);
        tblDSNSX.clearSelection();
    }//GEN-LAST:event_btnNhapLaiMouseClicked

    private void tblDSNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNSXMouseClicked
        int k = tblDSNSX.getSelectedRow();
        txtMaNSX.setText(tblDSNSX.getModel().getValueAt(k, 0).toString());
        txtTenNSX.setText(tblDSNSX.getModel().getValueAt(k, 1).toString());
        txtSelectMaNSX.setText(tblDSNSX.getModel().getValueAt(k, 0).toString());
        txtSelectTenNSX.setText(tblDSNSX.getModel().getValueAt(k, 1).toString());
        txtMaNSX.setEnabled(false);
        txtSelectMaNSX.setEnabled(false);
    }//GEN-LAST:event_tblDSNSXMouseClicked

    private void btnChonNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonNSXMouseClicked
        dispose();
    }//GEN-LAST:event_btnChonNSXMouseClicked

    private void btnBoChonNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonNSXMouseClicked
        dispose();
        txtSelectMaNSX.setText("");
        txtSelectTenNSX.setText("");
    }//GEN-LAST:event_btnBoChonNSXMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        String MaNSX = txtMaNSX.getText();
        nsxBUS.delete(MaNSX);
        loadData();
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        String MaNSX = txtMaNSX.getText();
        String TenNSX = txtTenNSX.getText();
        NhaSanXuatDTO nsx = new NhaSanXuatDTO(MaNSX, TenNSX);
        nsxBUS.update(nsx);
        loadData();
    }//GEN-LAST:event_btnSuaMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        txtTimKiem.setText("");
        loadData();
    }//GEN-LAST:event_jLabel12MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBoChonNSX;
    private javax.swing.JLabel btnChonNSX;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnNhapLai;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnHeader1;
    private javax.swing.JTable tblDSNSX;
    private javax.swing.JTextField txtMaNSX;
    private javax.swing.JTextField txtSelectMaNSX;
    private javax.swing.JTextField txtSelectTenNSX;
    private javax.swing.JTextField txtTenNSX;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
