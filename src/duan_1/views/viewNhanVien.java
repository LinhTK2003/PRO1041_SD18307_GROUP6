/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan_1.views;


import duan_1.model.NhanVien;
import duan_1.service.impl.NhanVienDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LEGION
 */
public class viewNhanVien extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    NhanVienDao nvdao = new NhanVienDao();
    ArrayList<NhanVien> listnv = new ArrayList<>();
    int index = -1;

    public viewNhanVien() {
        initComponents();
        listnv = nvdao.finALL();
        loadTable(listnv);
    }

    private void loadTable(ArrayList<NhanVien> list) {
        dtm = (DefaultTableModel) tbHienThi.getModel();
        dtm.setRowCount(0);
        for (NhanVien nv : list) {
            dtm.addRow(
                    new Object[]{
                        nv.getIdNhanVien(),
                        nv.getIdChucVu(),
                        nv.getMaNhanVien(),
                        nv.getTenNhanVien(),
                        nv.isGioiTinh() == true ? "nam" : "nữ",
                        nv.getDiaChi(),
                        nv.getNgaySinh(),
                        nv.getNgayTao(),
                        nv.getTaiKhoan(),
                        nv.getMatKhau(),
                        nv.getLuong(),
                        nv.getTrangThai()});
        }
    }

    private void DetailTable(int index) {
        NhanVien nv = listnv.get(index);
        txtid.setText(nv.getIdNhanVien() + "");
        txtidCV.setText(nv.getIdChucVu() + "");
        txtMa.setText(nv.getMaNhanVien());
        txtTen.setText(nv.getTenNhanVien());
        Boolean GioiTinh = nv.isGioiTinh();
        if (GioiTinh == true) {
            rdNam.setSelected(true);
            rdNu.setSelected(false);
        } else if (GioiTinh == false) {
            rdNu.setSelected(true);
            rdNam.setSelected(false);
        } else {
            rdNam.setSelected(false);
            rdNu.setSelected(false);
        }
        txtDchi.setText(nv.getDiaChi());
        txtNsinh.setText(nv.getNgaySinh().toString());
        txtNtao.setText(nv.getNgayTao().toString());
        txtTaikhoan.setText(nv.getTaiKhoan());
        txtMatkhau.setText(nv.getMatKhau());
        txtLuong.setText(nv.getLuong() + "");
        txtTThai.setText(nv.getTrangThai());
    }

    public NhanVien finData() {
        int IdNhanVien = Integer.parseInt(txtid.getText());
        int IdChucVu = Integer.parseInt(txtidCV.getText());
        String MaNhanVien = txtMa.getText();
        String TenNhanVien = txtTen.getText();
        boolean GioiTinh = false;
        if (rdNam.isSelected()) {
            GioiTinh = true;
        } else if (rdNu.isSelected()) {
            GioiTinh = true;
        }
        String DiaChi = txtDchi.getText();
        String NgayText = txtNsinh.getText();
        Date ngayS = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngayS = dateFormat.parse(NgayText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date ngaySinh = new java.sql.Date(ngayS.getTime());
        //
        String ngayText1 = txtNtao.getText();
        Date ngayt = null;
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngayt = dateFormat1.parse(ngayText1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date NgayTao = new java.sql.Date(ngayt.getTime());
        String TaiKhoan = txtTaikhoan.getText();
        String MatKhau = txtMatkhau.getText();
        int Luong = Integer.parseInt(txtLuong.getText());
        String TrangThai = txtTThai.getText();
        NhanVien nhanVien = new NhanVien(IdNhanVien, IdChucVu, MaNhanVien, TenNhanVien, GioiTinh, DiaChi, ngayS, ngayt, TaiKhoan, MatKhau, Luong, TrangThai);
        return nhanVien;
    }

    private boolean checkTrong() {
        if (txtid.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống ");
            txtid.requestFocus();
            return false;
        }
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống ");
            txtMa.requestFocus();
            return false;
        }
        if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống ");
            txtTen.requestFocus();
            return false;
        }
        if (txtDchi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống");
            txtDchi.requestFocus();
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = new Date();
            Date inputDate = dateFormat.parse(txtNsinh.getText().trim());
            if (inputDate.after(date)) {
                JOptionPane.showMessageDialog(this, "khong duoc lon hon ngay hien tai");
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "ngay khong hop le");
            return false;
        }
        if (txtNsinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong");
            txtNsinh.requestFocus();
            return false;
        }
        //
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = new Date();
            Date inputDate = dateFormat.parse(txtNtao.getText().trim());
            if (inputDate.after(date1)) {
                JOptionPane.showMessageDialog(this, "khong duoc lon hon ngay hien tai");
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "ngay khong hop le");
            return false;
        }
        if (txtNtao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong");
            txtNtao.requestFocus();
            return false;
        }
        if (!rdNam.isSelected() && !rdNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "chon trang thai");
            return false;
        }
        if (txtTaikhoan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống");
            txtTaikhoan.requestFocus();
            return false;
        }
        if (txtMatkhau.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống");
            txtMatkhau.requestFocus();
            return false;
        }
        if (txtLuong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống");
            txtLuong.requestFocus();
            return false;
        }
        if (txtTThai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không để trống");
            txtTThai.requestFocus();
            return false;
        }

        return true;
    }

    private void loadTimKiem() {
        try {
            dtm.setRowCount(0);
            for (NhanVien nv : nvdao.timKiem(Integer.parseInt(txtTimKiem.getText()))) {
                dtm.addRow(new Object[]{
                    nv.getIdNhanVien(),
                    nv.getIdChucVu(),
                    nv.getMaNhanVien(),
                    nv.getTenNhanVien(),
                    nv.isGioiTinh(),
                    nv.getDiaChi(),
                    nv.getNgaySinh(),
                    nv.getNgayTao(),
                    nv.getTaiKhoan(),
                    nv.getMatKhau(),
                    nv.getLuong(),
                    nv.getTrangThai()});
                    
            }
        } catch (Exception e) {
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtDchi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXOa = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTaikhoan = new javax.swing.JTextField();
        txtMatkhau = new javax.swing.JTextField();
        txtNsinh = new javax.swing.JTextField();
        txtNtao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtidCV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTThai = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cbbLoc = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnChucVu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("ID Nhân Viên");

        jLabel3.setText("Mã Nhân Viên");

        jLabel4.setText("Tên Nhân Viên");

        jLabel5.setText("Giới Tính");

        jLabel6.setText("Địa Chỉ");

        jLabel7.setText("Ngày Sinh");

        jLabel8.setText("Ngày Tạo");

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXOa.setText("xoa");
        btnXOa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXOaActionPerformed(evt);
            }
        });

        jLabel9.setText("Tài Khoản");

        jLabel10.setText("Mật khẩu");

        jLabel11.setText("ID Chức vụ");

        txtidCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidCVActionPerformed(evt);
            }
        });

        jLabel12.setText("Lương");

        jLabel13.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid)
                            .addComponent(txtMa)
                            .addComponent(txtTen)
                            .addComponent(txtDchi)
                            .addComponent(txtTaikhoan)
                            .addComponent(txtMatkhau)
                            .addComponent(txtNsinh)
                            .addComponent(txtNtao)
                            .addComponent(txtidCV)
                            .addComponent(txtLuong)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(rdNu, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                            .addComponent(txtTThai)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXOa)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNam)
                    .addComponent(rdNu)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNtao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXOa))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Nhân Viên", "ID chức vụ", "Mã Nhân Viên", "Tên Nhân Viên", "Giới tính", "Địa chỉ", "Ngày Sinh", "Ngày tạo", "Tài khoản", "mật khẩu", "Lương", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHienThi);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setText("Lọc");

        cbbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nghỉ", "Làm" }));
        cbbLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(cbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnRefresh))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhân viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnChucVu.setText("Chức vụ");
        btnChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChucVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChucVu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        loadTimKiem();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        int row = tbHienThi.getSelectedRow();
        DetailTable(row);
    }//GEN-LAST:event_tbHienThiMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadTable(nvdao.finALL());
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnXOaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXOaActionPerformed
        index = tbHienThi.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "hãy chọn dòng muốn xóa");
        }
        int chon = JOptionPane.showConfirmDialog(this, "xác nhận xóa ?", "Hủy", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(tbHienThi.getValueAt(index, 0).toString());
            if (nvdao.delete(id)) {
                JOptionPane.showMessageDialog(this, "xóa thành công");
                listnv = nvdao.finALL();
                loadTable(listnv);
            }
        } else {
            JOptionPane.showMessageDialog(this, "xoá thất bại");
        }
    }//GEN-LAST:event_btnXOaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbHienThi.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chọn dòng để cập nhật");
            return;
        }
        int id = Integer.parseInt(tbHienThi.getValueAt(row, 0).toString());
        NhanVien nv = finData();
        if (nv == null) {
            return;
        }
        nv.setIdNhanVien(id);
        nvdao.update(nv);
        if (checkTrong()) {
            JOptionPane.showMessageDialog(this, "update thành công");
        }
        listnv = nvdao.finALL();
        loadTable(listnv);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "xác nhận thêm ?", "Hủy", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            if (checkTrong()) {
                if (nvdao.insert(finData())) {
                    JOptionPane.showMessageDialog(this, "thêm thành công");
                    listnv = nvdao.finALL();
                    loadTable(listnv);

                } else {
                    JOptionPane.showMessageDialog(this, "thêm thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChucVuActionPerformed
        viewChucVu chucVu = new viewChucVu();
        chucVu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        chucVu.setVisible(true);
    }//GEN-LAST:event_btnChucVuActionPerformed

    private void txtidCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidCVActionPerformed

    private void cbbLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocActionPerformed
        try {
            String condition = cbbLoc.getSelectedItem().toString();
            ArrayList<NhanVien> filteredList = nvdao.Loc(condition);
            loadTable(filteredList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbbLocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChucVu;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXOa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTextField txtDchi;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatkhau;
    private javax.swing.JTextField txtNsinh;
    private javax.swing.JTextField txtNtao;
    private javax.swing.JTextField txtTThai;
    private javax.swing.JTextField txtTaikhoan;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidCV;
    // End of variables declaration//GEN-END:variables

    private void viewChucVu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
