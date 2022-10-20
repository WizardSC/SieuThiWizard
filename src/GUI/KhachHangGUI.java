/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.IMG;

/**
 *
 * @author Administrator
 */
public class KhachHangGUI extends javax.swing.JPanel {

    private KhachHangBUS khBUS = new KhachHangBUS();
    private HoaDonBUS hdBUS = new HoaDonBUS();
    DefaultTableModel model;
    private ArrayList<KhachHangDTO> dskh = new ArrayList<>();
    private BufferedImage i = null;
    String imgName = "null"; //khởi tạo tên cho image ban đầu là null

    public KhachHangGUI() {
        initComponents();
        init();
        model = (DefaultTableModel) tblDSKH.getModel();

        loadData();
        
    }

    public void init() {
        tblDSKH.setFocusable(false);
        tblDSKH.setIntercellSpacing(new Dimension(0, 0));

        tblDSKH.setRowHeight(25);

        tblDSKH.getTableHeader().setOpaque(false);
        tblDSKH.setFillsViewportHeight(true);
        tblDSKH.getTableHeader().setBackground(new Color(138, 57, 225));
        tblDSKH.getTableHeader().setForeground(Color.WHITE);
        tblDSKH.setSelectionBackground(new Color(52, 152, 219));
        tblDSKH.setFont(new Font("Arial", Font.PLAIN, 13));
        //Không cho ng dùng nhập số hóa đơn
        txtSoHD.setEditable(false);

        //Enter thì sẽ tự xuống dòng
        txtMaKH.addKeyListener(new KeyAdapter() {
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
        
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        khBUS.docDanhSach();
        ArrayList<KhachHangDTO> dskh = khBUS.getListKhachHang();
        for(KhachHangDTO kh : dskh){
            khBUS.updateSoHDKhachHang(kh.getMaKH(), 0);
        }
        
        for(HoaDonDTO hd : dshd){
            khBUS.docDanhSach();
            ArrayList<KhachHangDTO> dskh1 = khBUS.getListKhachHang();
            for(KhachHangDTO kh : dskh1){
                if(kh.getMaKH().equals(hd.getMaKH())){
                    int count = kh.getSoHD();
                    count++;
                    khBUS.updateSoHDKhachHang(kh.getMaKH(), count);
                }
            }
        }

//        hdBUS.docDanhSach();
//        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
//        //Khi bắt đầu chạy thì set lại số hóa đơn = 0
//        khBUS.docDanhSach();
//        ArrayList<KhachHangDTO> dskh = khBUS.getListKhachHang();
//        for(KhachHangDTO kh : dskh){
//            System.out.println(kh.getMaKH());
//            khBUS.updateSoHDKhachHang(kh.getMaKH(), 0);
//        }
//        //bắt đầu duyệt để tìm số HD mà khách hàng đã mua
//        for (HoaDonDTO hd : dshd) {
//            
//            
//            khBUS.docDanhSach();
//            ArrayList<KhachHangDTO> dskh1 = khBUS.getListKhachHang();
//            for (KhachHangDTO kh : dskh1) {
//                
//                if (kh.getMaKH().equals(hd.getMaKH())) {
//                    int count = kh.getSoHD();
//                    
//                    count++;
//                    khBUS.updateSoHDKhachHang(hd.getMaKH(), count);
//
//                }
//            }
//
//        }
        

    }

    public void showAll(ArrayList<KhachHangDTO> dskh) {

        model.setRowCount(0);

        for (int i = 0; i < dskh.size(); i++) {
            model.addRow(new String[]{
                dskh.get(i).getMaKH(),
                dskh.get(i).getHo(),
                dskh.get(i).getTen(),
                dskh.get(i).getNgaySinh(),
                dskh.get(i).getGioiTinh(),
                dskh.get(i).getDiaChi(),
                dskh.get(i).getSoDT(),
                String.valueOf(dskh.get(i).getSoHD()),
                dskh.get(i).getIMG()
            });
        }

    }

    private void loadData() {
        khBUS.docDanhSach();
        ArrayList<KhachHangDTO> dskh = khBUS.getListKhachHang();

        showAll(dskh);
    }

    //Hàm saveIMG() giúp tải ảnh đã được thêm từ dữ liệu về có dạng là TenKH.jpg
    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/image/KhachHang/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(KhachHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSKH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
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
        txtSoHD = new javax.swing.JTextField();
        txtIMG = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnNhapLai = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnXuatExcel = new javax.swing.JLabel();
        btnNhapExcel = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        rdbMaKH = new javax.swing.JRadioButton();
        rdbTen = new javax.swing.JRadioButton();
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
        rdbNangCao = new javax.swing.JRadioButton();
        rdbHo = new javax.swing.JRadioButton();
        rdbThongThuong = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(1080, 690));

        jPanel1.setBackground(new java.awt.Color(233, 213, 218));

        tblDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số ĐT", "Số HĐ", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSKH);
        if (tblDSKH.getColumnModel().getColumnCount() > 0) {
            tblDSKH.getColumnModel().getColumn(0).setResizable(false);
            tblDSKH.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel2.setBackground(new java.awt.Color(233, 213, 218));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(130, 115, 151)), "QUẢN LÝ KHÁCH HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Mã KH");

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
        jLabel8.setText("Số HĐ");

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

        btnSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gear.png"))); // NOI18N
        btnSua.setText("Chỉnh sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
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
        btnNhapExcel.setAutoscrolls(true);
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
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
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
                            .addComponent(txtSoHD, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua)
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
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(txtSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatExcel)
                    .addComponent(btnNhapExcel)
                    .addComponent(btnNhapLai)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(233, 213, 218));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setToolTipText("");
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Nhập từ khóa");

        rdbMaKH.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbMaKH);
        rdbMaKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbMaKH.setText("Mã KH");

        rdbTen.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbTen);
        rdbTen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbTen.setText("Tên KH");

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
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        rdbNangCao.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup2.add(rdbNangCao);

        rdbHo.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup1.add(rdbHo);
        rdbHo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbHo.setText("Họ");

        rdbThongThuong.setBackground(new java.awt.Color(233, 213, 218));
        buttonGroup2.add(rdbThongThuong);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdbThongThuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetSearch)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(rdbNangCao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdbNamSinh)
                                            .addComponent(rdbDiaChi)))
                                    .addComponent(rdbMaKH))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdbSoDT)
                                            .addComponent(rdbGioiTinh))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbHo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                        .addComponent(rdbTen)
                                        .addGap(41, 41, 41))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamBD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamKT, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(rdbThongThuong, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbMaKH)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbTen)
                        .addComponent(rdbHo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbNamSinh)
                    .addComponent(rdbGioiTinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbDiaChi)
                    .addComponent(rdbSoDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbNangCao)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtNamBD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtNamKT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseClicked
        //+++set Textfield thành rỗng+++
        txtMaKH.setEnabled(true);
        txtMaKH.setText("");
        txtHo.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtNgaySinh.setText("");
        txtSoDT.setText("");
        txtSoHD.setText("");
        cbxGioiTinh.setSelectedIndex(0); //set vị trí cho combobox trở về "Chọn giới tính"
        txtIMG.setIcon(null);
        txtIMG.setText("IMAGE");
        imgName = null;

        //+++++++++++++++++++++++++++++++++++++++++++++++
        tblDSKH.getSelectionModel().clearSelection(); //bỏ chọn Row trong JTable
    }//GEN-LAST:event_btnNhapLaiMouseClicked

    private void tblDSKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKHMouseClicked
        int k = tblDSKH.getSelectedRow();
        //+++set Font + In đậm chữ khi click chọn bảng+++
        txtMaKH.setFont(new Font("Arial", Font.BOLD, 12));
        txtHo.setFont(new Font("Arial", Font.BOLD, 12));
        txtTen.setFont(new Font("Arial", Font.BOLD, 12));
        txtDiaChi.setFont(new Font("Arial", Font.BOLD, 12));
        txtNgaySinh.setFont(new Font("Arial", Font.BOLD, 12));
        txtSoDT.setFont(new Font("Arial", Font.BOLD, 12));
        txtSoHD.setFont(new Font("Arial", Font.BOLD, 12));
        //+++++++++++++++++++++++++++++++++++++++++++++++
        txtMaKH.setText(tblDSKH.getModel().getValueAt(k, 0).toString());
        txtHo.setText(tblDSKH.getModel().getValueAt(k, 1).toString());
        txtTen.setText(tblDSKH.getModel().getValueAt(k, 2).toString());
        txtNgaySinh.setText(tblDSKH.getModel().getValueAt(k, 3).toString());
        cbxGioiTinh.setSelectedItem(tblDSKH.getModel().getValueAt(k, 4).toString());
        txtDiaChi.setText(tblDSKH.getModel().getValueAt(k, 5).toString());
        txtSoDT.setText(tblDSKH.getModel().getValueAt(k, 6).toString());
        txtSoHD.setText(tblDSKH.getModel().getValueAt(k, 7).toString());
        imgName = tblDSKH.getModel().getValueAt(k, 8).toString();
        Image newImage;

        newImage = new ImageIcon("./src/image/KhachHang/" + imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);

        txtIMG.setIcon(new ImageIcon(newImage));
//        txtIMG.setText(tblDSKH.getModel().getValueAt(k, 8).toString());

        //Tắt txt MaKH khi Click vào bảng++++++++++++++++
        txtMaKH.setEnabled(false);
        //+++++++++++++++++++++++++++++++++++++++++++++++
    }//GEN-LAST:event_tblDSKHMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/warning.png"));
        String MaKH = txtMaKH.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String DiaChi = txtDiaChi.getText();
        String NgaySinh = txtNgaySinh.getText();
        String SoDT = txtSoDT.getText();
        String SoHD = "0";

        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String IMG = imgName;
        if (!MaKH.matches("KH" + "[0-9]{1,2}")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE, icon);
        } else {
            KhachHangDTO khachhang = new KhachHangDTO(MaKH, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, Integer.parseInt(SoHD), IMG);
            khBUS.add(khachhang);

        }
        saveIMG();
        loadData();

    }//GEN-LAST:event_btnThemMouseClicked

    private void btnChonAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonAnhMouseClicked
        JFileChooser fc = new JFileChooser("./src/image/KhachHang");
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

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        String MaKH = txtMaKH.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String DiaChi = txtDiaChi.getText();
        String NgaySinh = txtNgaySinh.getText();
        String SoDT = txtSoDT.getText();
        String SoHD = txtSoHD.getText();

        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String IMG = imgName;
        KhachHangDTO kh = new KhachHangDTO(MaKH, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, Integer.parseInt(SoHD), IMG);
        khBUS.update(kh);
        saveIMG();
        loadData();
        
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        khBUS.delete(txtMaKH.getText());
        saveIMG();
        loadData();
        btnNhapLaiMouseClicked(evt);
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnXuatExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatExcelMouseClicked
        khBUS.ExportExcel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JOptionPane.showMessageDialog(null, "Đã xuất file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);
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
            khBUS.ImportExcel(file);
            khBUS.listKH();
            JOptionPane.showMessageDialog(null, "Đã nhập file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);

        }
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnNhapExcelMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        /* Trong trường hợp chọn tìm kiếm khi đang click vào 1 row trong Table, thì gọi làm hàm này để set rỗng 
        cho các TextField */
        btnNhapLaiMouseClicked(evt);
        //--------------------------
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/warning.png"));
        //Tìm kiếm thông thường
        if (rdbThongThuong.isSelected()) {
            if (txtTimKiem.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm kiếm", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE, icon);
            } else {
                if (rdbMaKH.isSelected()) {
                    dskh = khBUS.timKiemKhachHang(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
                if (rdbHo.isSelected()) {
                    dskh = khBUS.timKiemTheoHo(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
                if (rdbTen.isSelected()) {
                    dskh = khBUS.timKiemTheoTen(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
                if (rdbNamSinh.isSelected()) {
                    dskh = khBUS.timKiemTheoNamSinh(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
                if (rdbGioiTinh.isSelected()) {
                    dskh = khBUS.timKiemTheoGioiTinh(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
                if (rdbDiaChi.isSelected()) {
                    dskh = khBUS.timKiemTheoDiaChi(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
                if (rdbSoDT.isSelected()) {
                    dskh = khBUS.timKiemTheoSoDT(txtTimKiem.getText().toString());
                    showAll(dskh);
                }
            }
        }

        //Tìm kiếm nâng cao
        if (rdbNangCao.isSelected()) {
            buttonGroup1.clearSelection();
            if (txtNamBD.
                    getText().equals("") || txtNamKT.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống thông tin", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE, icon);

            } else {
                dskh = khBUS.timKiemNamSinhNangCao(txtNamBD.getText().toString(), txtNamKT.getText().toString());
                showAll(dskh);
            }
        }


    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetSearchMouseClicked
        txtTimKiem.setText("");
        txtNamBD.setText("");
        txtNamKT.setText("");
        saveIMG();
        loadData();
        //bỏ chọn các radio button
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_btnResetSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChonAnh;
    private javax.swing.JLabel btnNhapExcel;
    private javax.swing.JLabel btnNhapLai;
    private javax.swing.JLabel btnResetSearch;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btnXuatExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbDiaChi;
    private javax.swing.JRadioButton rdbGioiTinh;
    private javax.swing.JRadioButton rdbHo;
    private javax.swing.JRadioButton rdbMaKH;
    private javax.swing.JRadioButton rdbNamSinh;
    private javax.swing.JRadioButton rdbNangCao;
    private javax.swing.JRadioButton rdbSoDT;
    private javax.swing.JRadioButton rdbTen;
    private javax.swing.JRadioButton rdbThongThuong;
    private javax.swing.JTable tblDSKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNamBD;
    private javax.swing.JTextField txtNamKT;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtSoHD;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
