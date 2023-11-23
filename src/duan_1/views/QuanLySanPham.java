/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan_1.views;

import duan_1.entity.ChatLieu;
import duan_1.entity.KichThuoc;
import duan_1.entity.MauSac;
import duan_1.entity.SanPham;
import duan_1.entity.SanPhamChiTiet;
import duan_1.service.ChatLieuService;
import duan_1.service.KichThuocService;
import duan_1.service.MauSacService;
import duan_1.service.SanPhamChiTietService;
import duan_1.service.SanPhamService;
import duan_1.service.impl.ChatLieuServiceImpl;
import duan_1.service.impl.KichThuocServiceImpl;
import duan_1.service.impl.MauSacServiceImpl;
import duan_1.service.impl.SanPhamChiTietServiceImpl;
import duan_1.service.impl.SanPhamServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QuanLySanPham extends javax.swing.JFrame {

    private MauSacService serviceMauSac = new MauSacServiceImpl();
    private ChatLieuService serviceChatLieu = new ChatLieuServiceImpl();
    private KichThuocService serviceKichThuoc = new KichThuocServiceImpl();
    private SanPhamService serviceSanPham = new SanPhamServiceImpl();
    private SanPhamChiTietService serviceSanPhamChiTiet = new SanPhamChiTietServiceImpl();

    private DefaultComboBoxModel<String> defaultCBBKichThuoc = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> defaultCBBChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> defaultCBBMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> defaultCBBSanPham = new DefaultComboBoxModel<>();

    private ArrayList<KichThuoc> listcbbKichThuoc = serviceKichThuoc.getAllKichThuoc();
    private ArrayList<ChatLieu> listcbbChatLieu = serviceChatLieu.getAllChatLieu();
    private ArrayList<MauSac> listcbbMauSac = serviceMauSac.getAllMauSac();
    private ArrayList<SanPham> listcbbSanPham = serviceSanPham.getAllSanPham();

    /**
     * Creates new form QuanLySanPham
     */
    public QuanLySanPham() {
        initComponents();
        //LoadCBB
        loadCBBChatLieu();
        loadCBBMauSac();
        loadCBBKichThuoc();
        loadCBBSanPham();

        //Load table
        LoadTableMauSac();
        LoadTableChatLieu();
        LoadTableSanPham();
        LoadTableQLSPSanPham();
        LoadTableKichThuoc();
        loadTableQLSPCT();
        this.setLocationRelativeTo(this);
    }

    //ComboBoxChatLieu
    private void loadCBBChatLieu() {
        cbbChatLieuSP.setModel(defaultCBBChatLieu);
        for (int i = 0; i < listcbbChatLieu.size(); i++) {
            defaultCBBChatLieu.addElement(listcbbChatLieu.get(i).getTenChatLieu());
        }
    }

    private void loadCBBMauSac() {
        cbbMauSacSP.setModel(defaultCBBMauSac);
        for (int i = 0; i < listcbbMauSac.size(); i++) {
            defaultCBBMauSac.addElement(listcbbMauSac.get(i).getTenMauSac());
        }
    }

    private void loadCBBKichThuoc() {
        cbbKichThuocSP.setModel(defaultCBBKichThuoc);
        for (int i = 0; i < listcbbKichThuoc.size(); i++) {
            defaultCBBKichThuoc.addElement(listcbbKichThuoc.get(i).getTenKichThuoc());
        }
    }

    private void loadCBBSanPham() {
        cbbTenSP.setModel(defaultCBBSanPham);
        for (int i = 0; i < listcbbSanPham.size(); i++) {
            defaultCBBSanPham.addElement(listcbbSanPham.get(i).getTenSanPham());
        }
    }

    //Màu sắc
    public MauSac getDataMauSac() {
        try {
            int idMauSac = Integer.parseInt(txtIdMauSac.getText());
            String tenMauSac = txtTenMauSac.getText();
            MauSac ms = new MauSac(idMauSac, tenMauSac);
            return ms;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoadTableMauSac() {
        DefaultTableModel dtm = (DefaultTableModel) tblMauSac.getModel();
        dtm.setRowCount(0);
        for (MauSac ms : serviceMauSac.getAllMauSac()) {
            dtm.addRow(new Object[]{
                ms.getIdMauSac(), ms.getTenMauSac(),});
        }
    }

    public void LoadTableMauSac(List<MauSac> listMS) {
        DefaultTableModel dtm = (DefaultTableModel) tblMauSac.getModel();
        dtm.setRowCount(0);
        for (MauSac ms : listMS) {
            dtm.addRow(new Object[]{
                ms.getIdMauSac(), ms.getTenMauSac(),});
        }
    }

    public void searchMauSac() {
        String searchCode = txtSearchMauSac.getText();
        List<MauSac> listMS = serviceMauSac.searchMauSac(searchCode);
        LoadTableMauSac(listMS);
        if (searchCode.equals("")) {
            LoadTableMauSac();
        }
    }

    public void clearMauSac() {
        txtIdMauSac.setText("");
        txtTenMauSac.setText("");
    }

    //Chất liệu
    public ChatLieu getDataChatLieu() {
        try {
            int idChatLieu = Integer.parseInt(txtIdChatLieu.getText());
            String tenChatLieu = txtTenChatLieu.getText();
            ChatLieu cl = new ChatLieu(idChatLieu, tenChatLieu);
            return cl;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoadTableChatLieu() {
        DefaultTableModel dtm = (DefaultTableModel) tblChatLieu.getModel();
        dtm.setRowCount(0);
        for (ChatLieu cl : serviceChatLieu.getAllChatLieu()) {
            dtm.addRow(new Object[]{
                cl.getIdChatLieu(), cl.getTenChatLieu(),});
        }
    }

    public void LoadTableChatLieu(List<ChatLieu> listCL) {
        DefaultTableModel dtm = (DefaultTableModel) tblChatLieu.getModel();
        dtm.setRowCount(0);
        for (ChatLieu cl : listCL) {
            dtm.addRow(new Object[]{
                cl.getIdChatLieu(), cl.getTenChatLieu()});
        }
    }

    public void searchChatLieu() {
        String searchCode = txtSearchChatLieu.getText();
        List<ChatLieu> listCL = serviceChatLieu.searchChatLieu(searchCode);
        LoadTableChatLieu(listCL);
        if (searchCode.equals("")) {
            LoadTableChatLieu();
        }
    }

    public void clearChatLieu() {
        txtIdChatLieu.setText("");
        txtTenChatLieu.setText("");
    }

    //Kích thước
    public KichThuoc getDataKichThuoc() {
        try {
            int idKichThuoc = Integer.parseInt(txtIdKichThuoc.getText());
            String tenKichThuoc = txtTenKichThuoc.getText();
            KichThuoc kt = new KichThuoc(idKichThuoc, tenKichThuoc);
            return kt;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoadTableKichThuoc() {
        DefaultTableModel dtm = (DefaultTableModel) tblKichThuoc.getModel();
        dtm.setRowCount(0);
        for (KichThuoc kt : serviceKichThuoc.getAllKichThuoc()) {
            dtm.addRow(new Object[]{
                kt.getIdKichThuoc(), kt.getTenKichThuoc().trim(),});
        }
    }

    public void LoadTableKichThuoc(List<KichThuoc> listKT) {
        DefaultTableModel dtm = (DefaultTableModel) tblKichThuoc.getModel();
        dtm.setRowCount(0);
        for (KichThuoc kt : listKT) {
            dtm.addRow(new Object[]{
                kt.getIdKichThuoc(), kt.getTenKichThuoc()});
        }
    }

    public void searchKichThuoc() {
        String searchCode = txtSearchKichThuoc.getText();
        List<KichThuoc> listKT = serviceKichThuoc.searchKichThuoc(searchCode);
        LoadTableKichThuoc(listKT);
        if (searchCode.equals("")) {
            LoadTableKichThuoc();
        }
    }

    public void clearKichThuoc() {
        txtIdKichThuoc.setText("");
        txtTenKichThuoc.setText("");
    }

    //Sản phẩm
    public void LoadTableSanPham() {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : serviceSanPham.getAllSanPham()) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham(),});
        }
    }

    public void LoadTableSanPham(List<SanPham> listSP) {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : listSP) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham()});
        }
    }

    public void LoadTableQLSPSanPham() {
        DefaultTableModel dtm = (DefaultTableModel) tblQLSP.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : serviceSanPham.getAllSanPham()) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham(),});
        }
    }

    public void LoadTableQLSanPham(List<SanPham> listSP) {
        DefaultTableModel dtm = (DefaultTableModel) tblQLSP.getModel();
        dtm.setRowCount(0);
        for (SanPham ms : listSP) {
            dtm.addRow(new Object[]{
                ms.getMaSanPham(), ms.getTenSanPham()});
        }
    }

    public SanPham getDataSanPham() {
        try {
            String maSP = txtMaSPP.getText();
            String tenSP = txtTenSPP.getText();
            SanPham sp = new SanPham(maSP, tenSP);
            return sp;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void searchSanPham() {
        String searchCode = txtTimKiemSanPham.getText();
        List<SanPham> listSP = serviceSanPham.searchSanPham(searchCode);
        LoadTableSanPham(listSP);
        if (searchCode.equals("")) {
            LoadTableSanPham();
        }
    }

    public void searchQLSanPham() {
        String searchCode = jTextField1.getText();
        List<SanPham> listSP = serviceSanPham.searchSanPham(searchCode);
        LoadTableQLSanPham(listSP);
        if (searchCode.equals("")) {
            LoadTableQLSPSanPham();
        }
    }

    public void clearSanPham() {
        txtMaSPP.setText("");
        txtTenSPP.setText("");
        txtMaSPP.setEnabled(true);
    }

    //Chi tiết sản phẩm
    private SanPhamChiTiet getDataChiTietSanPham() {
        try {
            float giaBan = Float.parseFloat(txtGiaBanSP.getText());
            int soLuong = Integer.parseInt(txtSoLuongSP.getText());
            KichThuoc kichThuoc = listcbbKichThuoc.get(cbbKichThuocSP.getSelectedIndex());
            ChatLieu chatLieu = listcbbChatLieu.get(cbbChatLieuSP.getSelectedIndex());
            MauSac mauSac = listcbbMauSac.get(cbbMauSacSP.getSelectedIndex());
            SanPham sanPham = listcbbSanPham.get(cbbTenSP.getSelectedIndex());

            SanPhamChiTiet spct = new SanPhamChiTiet(kichThuoc, chatLieu, mauSac, sanPham, soLuong, giaBan);
            return spct;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

//========================================================================================================//
    public void LoadTableSanPhamChiTiet() {
        int rowSP = tblSanPham.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblCTSP.getModel();
        dtm.setRowCount(0);
        List<SanPhamChiTiet> listCtsp = serviceSanPhamChiTiet.getAllSanPhamCT(tblSanPham.getValueAt(rowSP, 0).toString());

        for (SanPhamChiTiet spct : listCtsp) {
            int duplicateRowIndex = findDuplicateRowSPCT(dtm, spct);
            if (duplicateRowIndex != -1) {
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + spct.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    spct.getIdSanPhamChiTiet(),
                    spct.getSanPham().getTenSanPham(),
                    spct.getKichThuoc().getTenKichThuoc(),
                    spct.getMauSac().getTenMauSac(),
                    spct.getChatLieu().getTenChatLieu(),
                    spct.getGiaBan(),
                    spct.getSoLuong()
                });
            }
        }
    }

// Phương thức tìm kiếm sản phẩm trùng trong bảng
    private int findDuplicateRowSPCT(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenChatLieu = (String) dtm.getValueAt(i, 3);
            String tenMauSac = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 5);
            
            // Kiểm tra null trước khi sử dụng equals
            if (tenSanPham != null
                    && tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc != null
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenChatLieu != null
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && tenMauSac != null
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && giaBan == spct.getGiaBan()) {
                return i;
            }
        }
        return -1;
    }
//========================================================================================================//

    public void LoadTableSanPhamChiTiet(List<SanPhamChiTiet> listSPCT) {
        DefaultTableModel dtm = (DefaultTableModel) tblCTSP.getModel();
        dtm.setRowCount(0);

        for (SanPhamChiTiet sp : listSPCT) {
            int duplicateRowIndex = findDuplicateRowSPCTforSearch(dtm, sp);

            if (duplicateRowIndex != -1) {  
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + sp.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    sp.getIdSanPhamChiTiet(),
                    sp.getSanPham().getTenSanPham(),
                    sp.getKichThuoc().getTenKichThuoc(),
                    sp.getChatLieu().getTenChatLieu(),
                    sp.getMauSac().getTenMauSac(),
                    sp.getSoLuong(),
                    sp.getGiaBan()
                });
            }
        }
    }

    private int findDuplicateRowSPCTforSearch(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenMauSac = (String) dtm.getValueAt(i, 3);
            String tenChatLieu = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 6);

            if (tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && giaBan == spct.getGiaBan()) {
                return i; // Trả về chỉ số hàng nếu tìm thấy hàng trùng lặp
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy hàng trùng lặp
    }
//========================================================================================================//

    public void loadTableQLSPCT() {
        DefaultTableModel dtm = (DefaultTableModel) tblQuanLyCTSP.getModel();
        dtm.setRowCount(0);
        List<SanPhamChiTiet> allSPCT = serviceSanPhamChiTiet.getAllQLSanPhamCT();

        for (SanPhamChiTiet spct : allSPCT) {
            int duplicateRowIndex = findDuplicateRowQLSPCT(dtm, spct);

            if (duplicateRowIndex != -1) {
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + spct.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    spct.getIdSanPhamChiTiet(),
                    spct.getSanPham().getTenSanPham(),
                    spct.getKichThuoc().getTenKichThuoc(),
                    spct.getChatLieu().getTenChatLieu(),
                    spct.getMauSac().getTenMauSac(),
                    spct.getSoLuong(),
                    spct.getGiaBan()
                });
            }
        }
    }

    private int findDuplicateRowQLSPCT(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenChatLieu = (String) dtm.getValueAt(i, 3);
            String tenMauSac = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 6);
            if (tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && giaBan == spct.getGiaBan()) {
                return i;
            }
        }
        return -1;
    }
//========================================================================================================//

    public void loadTableQLSPCT(List<SanPhamChiTiet> listSPCT) {
        DefaultTableModel dtm = (DefaultTableModel) tblQuanLyCTSP.getModel();
        dtm.setRowCount(0);
        for (SanPhamChiTiet spct : listSPCT) {
            int duplicateRowIndex = findDuplicateRowQLSPCTforSearch(dtm, spct);

            if (duplicateRowIndex != -1) {
                int currentSoLuong = (int) dtm.getValueAt(duplicateRowIndex, 5);
                int newSoLuong = currentSoLuong + spct.getSoLuong();
                dtm.setValueAt(newSoLuong, duplicateRowIndex, 5);
            } else {
                dtm.addRow(new Object[]{
                    spct.getIdSanPhamChiTiet(),
                    spct.getSanPham().getTenSanPham(),
                    spct.getKichThuoc().getTenKichThuoc(),
                    spct.getChatLieu().getTenChatLieu(),
                    spct.getMauSac().getTenMauSac(),
                    spct.getSoLuong(),
                    spct.getGiaBan()
                });
            }
        }
    }

    private int findDuplicateRowQLSPCTforSearch(DefaultTableModel dtm, SanPhamChiTiet spct) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tenSanPham = (String) dtm.getValueAt(i, 1);
            String tenKichThuoc = (String) dtm.getValueAt(i, 2);
            String tenChatLieu = (String) dtm.getValueAt(i, 3);
            String tenMauSac = (String) dtm.getValueAt(i, 4);
            float giaBan = (float) dtm.getValueAt(i, 6);
            if (tenSanPham.equals(spct.getSanPham().getTenSanPham())
                    && tenKichThuoc.equals(spct.getKichThuoc().getTenKichThuoc())
                    && tenChatLieu.equals(spct.getChatLieu().getTenChatLieu())
                    && tenMauSac.equals(spct.getMauSac().getTenMauSac())
                    && giaBan == spct.getGiaBan()) {
                return i;
            }
        }
        return -1;
    }
//========================================================================================================//

    public void searchSanPhamChiTiet() {
        String searchCode = txtTimKiemCTSP.getText();
        List<SanPhamChiTiet> listSPCT = serviceSanPhamChiTiet.searchSanPhamChiTiet(searchCode);
        LoadTableSanPhamChiTiet(listSPCT);
        if (searchCode.equals("")) {
            LoadTableSanPhamChiTiet();
        }
    }

    public void searchQLSanPhamChiTiet() {
        String searchCode = txtseachQLCTSP.getText();
        List<SanPhamChiTiet> listSPCT = serviceSanPhamChiTiet.searchSanPhamChiTiet(searchCode);
        loadTableQLSPCT(listSPCT);
        if (searchCode.equals("")) {
            loadTableQLSPCT();
        }
    }

    public void clearQLSPCT() {
        txtIdQLSPCT.setText("");
        cbbTenSP.setSelectedIndex(0);
        txtSoLuongSP.setText("");
        txtGiaBanSP.setText("");
        cbbKichThuocSP.setSelectedIndex(0);
        cbbChatLieuSP.setSelectedIndex(0);
        cbbMauSacSP.setSelectedIndex(0);
        cbbTenSP.setEnabled(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdMauSac = new javax.swing.JTextField();
        txtTenMauSac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnThemMauSac = new javax.swing.JButton();
        btnSuaMauSac = new javax.swing.JButton();
        btnLamMoiMauSac = new javax.swing.JButton();
        txtSearchMauSac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtTenChatLieu = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIdChatLieu = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnThemChatLieu = new javax.swing.JButton();
        btnSuaChatLieu = new javax.swing.JButton();
        btnLamMoiChatLieu = new javax.swing.JButton();
        txtSearchChatLieu = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtTenKichThuoc = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtIdKichThuoc = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnThemKichThuoc = new javax.swing.JButton();
        btnSuaKichThuoc = new javax.swing.JButton();
        btnLamMoiKichThuoc = new javax.swing.JButton();
        txtSearchKichThuoc = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKichThuoc = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtMaSPP = new javax.swing.JTextField();
        txtTenSPP = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnThemKichThuoc1 = new javax.swing.JButton();
        btnSuaKichThuoc1 = new javax.swing.JButton();
        btnLamMoiKichThuoc1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblQLSP = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuongSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbKichThuocSP = new javax.swing.JComboBox<>();
        cbbChatLieuSP = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbbMauSacSP = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtGiaBanSP = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnLamMoiSP = new javax.swing.JButton();
        txtseachQLCTSP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanLyCTSP = new javax.swing.JTable();
        txtIdQLSPCT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbTenSP = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtTimKiemCTSP = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý sản phẩm");

        jLabel2.setText("Id màu sắc");

        txtIdMauSac.setEnabled(false);

        jLabel3.setText("Tên màu sắc");

        btnThemMauSac.setText("Thêm");
        btnThemMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauSacActionPerformed(evt);
            }
        });

        btnSuaMauSac.setText("Sửa");
        btnSuaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauSacActionPerformed(evt);
            }
        });

        btnLamMoiMauSac.setText("Làm mới");
        btnLamMoiMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiMauSacActionPerformed(evt);
            }
        });

        txtSearchMauSac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMauSacKeyReleased(evt);
            }
        });

        jLabel4.setText("Tìm kiếm");

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id màu sắc", "Tên màu sắc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMauSac);
        if (tblMauSac.getColumnModel().getColumnCount() > 0) {
            tblMauSac.getColumnModel().getColumn(0).setResizable(false);
            tblMauSac.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 619, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThemMauSac)
                        .addGap(100, 100, 100)
                        .addComponent(btnSuaMauSac)
                        .addGap(100, 100, 100)
                        .addComponent(btnLamMoiMauSac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMauSac)
                    .addComponent(btnSuaMauSac)
                    .addComponent(btnLamMoiMauSac)
                    .addComponent(txtSearchMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Màu sắc", jPanel2);

        jLabel16.setText("Tên chất liệu");

        txtIdChatLieu.setEnabled(false);

        jLabel17.setText("Id chất liệu");

        btnThemChatLieu.setText("Thêm");
        btnThemChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChatLieuActionPerformed(evt);
            }
        });

        btnSuaChatLieu.setText("Sửa");
        btnSuaChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChatLieuActionPerformed(evt);
            }
        });

        btnLamMoiChatLieu.setText("Làm mới");
        btnLamMoiChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiChatLieuActionPerformed(evt);
            }
        });

        txtSearchChatLieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchChatLieuKeyReleased(evt);
            }
        });

        jLabel18.setText("Tìm kiếm");

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id chất liệu", "Tên chất liệu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblChatLieu);
        if (tblChatLieu.getColumnModel().getColumnCount() > 0) {
            tblChatLieu.getColumnModel().getColumn(0).setResizable(false);
            tblChatLieu.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThemChatLieu)
                        .addGap(100, 100, 100)
                        .addComponent(btnSuaChatLieu)
                        .addGap(100, 100, 100)
                        .addComponent(btnLamMoiChatLieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 751, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtIdChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemChatLieu)
                    .addComponent(btnSuaChatLieu)
                    .addComponent(btnLamMoiChatLieu)
                    .addComponent(txtSearchChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chất liệu", jPanel3);

        jLabel22.setText("Id kích thước");

        txtIdKichThuoc.setEnabled(false);

        jLabel23.setText("Tên kích thước");

        btnThemKichThuoc.setText("Thêm");
        btnThemKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKichThuocActionPerformed(evt);
            }
        });

        btnSuaKichThuoc.setText("Sửa");
        btnSuaKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKichThuocActionPerformed(evt);
            }
        });

        btnLamMoiKichThuoc.setText("Làm mới");
        btnLamMoiKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKichThuocActionPerformed(evt);
            }
        });

        txtSearchKichThuoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKichThuocKeyReleased(evt);
            }
        });

        jLabel24.setText("Tìm kiếm");

        tblKichThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id kích thước", "Tên kích thước"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKichThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKichThuocMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKichThuoc);
        if (tblKichThuoc.getColumnModel().getColumnCount() > 0) {
            tblKichThuoc.getColumnModel().getColumn(0).setResizable(false);
            tblKichThuoc.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnThemKichThuoc)
                        .addGap(100, 100, 100)
                        .addComponent(btnSuaKichThuoc)
                        .addGap(100, 100, 100)
                        .addComponent(btnLamMoiKichThuoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 751, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtIdKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKichThuoc)
                    .addComponent(btnSuaKichThuoc)
                    .addComponent(btnLamMoiKichThuoc)
                    .addComponent(txtSearchKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kích thước", jPanel5);

        jLabel27.setText("Tên sản phẩm");

        jLabel28.setText("Mã sản phẩm");

        btnThemKichThuoc1.setText("Thêm");
        btnThemKichThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKichThuoc1ActionPerformed(evt);
            }
        });

        btnSuaKichThuoc1.setText("Sửa");
        btnSuaKichThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKichThuoc1ActionPerformed(evt);
            }
        });

        btnLamMoiKichThuoc1.setText("Làm mới");
        btnLamMoiKichThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKichThuoc1ActionPerformed(evt);
            }
        });

        tblQLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSPMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblQLSP);
        if (tblQLSP.getColumnModel().getColumnCount() > 0) {
            tblQLSP.getColumnModel().getColumn(0).setResizable(false);
            tblQLSP.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel5.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 597, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThemKichThuoc1)
                        .addGap(100, 100, 100)
                        .addComponent(btnSuaKichThuoc1)
                        .addGap(100, 100, 100)
                        .addComponent(btnLamMoiKichThuoc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane8)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(txtMaSPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKichThuoc1)
                    .addComponent(btnSuaKichThuoc1)
                    .addComponent(btnLamMoiKichThuoc1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel4);

        jLabel6.setText("Id sản phẩm chi tiết");

        jLabel8.setText("Số lượng");

        jLabel10.setText("Giá bán");

        jLabel11.setText("Màu sắc");

        cbbKichThuocSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbChatLieuSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Kích thước");

        cbbMauSacSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Chất liệu");

        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnLamMoiSP.setText("Làm mới");
        btnLamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPActionPerformed(evt);
            }
        });

        txtseachQLCTSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtseachQLCTSPKeyReleased(evt);
            }
        });

        jLabel15.setText("Tìm kiếm");

        tblQuanLyCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên sản phẩm", "Kích thước", "Chất liệu", "Màu sắc", "Số lượng", "Giá bán"
            }
        ));
        tblQuanLyCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanLyCTSP);

        txtIdQLSPCT.setEnabled(false);

        jLabel7.setText("Tên sản phẩm");

        cbbTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnThemSP))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaBanSP, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongSP, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                    .addComponent(txtIdQLSPCT)
                                    .addComponent(cbbTenSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbChatLieuSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbKichThuocSP, 0, 375, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(cbbMauSacSP, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnSuaSP)
                                .addGap(100, 100, 100)
                                .addComponent(btnXoaSP)
                                .addGap(100, 100, 100)
                                .addComponent(btnLamMoiSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 570, Short.MAX_VALUE)
                                .addComponent(txtseachQLCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1488, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbKichThuocSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtIdQLSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTenSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbChatLieuSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMauSacSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtGiaBanSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP)
                    .addComponent(btnSuaSP)
                    .addComponent(btnXoaSP)
                    .addComponent(btnLamMoiSP)
                    .addComponent(jLabel15)
                    .addComponent(txtseachQLCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(448, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(359, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Chi tiết sản phẩm", jPanel1);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setResizable(false);
            tblSanPham.getColumnModel().getColumn(1).setResizable(false);
        }

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên sản phẩm", "Kích thước", "Màu sắc", "Chất liệu", "Giá bán", "Số lượng tồn"
            }
        ));
        jScrollPane7.setViewportView(tblCTSP);

        jLabel25.setText("Tìm kiếm");

        txtTimKiemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemCTSPActionPerformed(evt);
            }
        });
        txtTimKiemCTSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemCTSPKeyReleased(evt);
            }
        });

        jLabel26.setText("Tìm kiếm");

        txtTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSanPhamActionPerformed(evt);
            }
        });
        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 1023, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý sản phẩm", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyReleased
        searchSanPham();
    }//GEN-LAST:event_txtTimKiemSanPhamKeyReleased

    private void txtTimKiemSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyPressed

    }//GEN-LAST:event_txtTimKiemSanPhamKeyPressed

    private void txtTimKiemCTSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemCTSPKeyReleased
        searchSanPhamChiTiet();
    }//GEN-LAST:event_txtTimKiemCTSPKeyReleased

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblKichThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKichThuocMouseClicked
        int row = tblKichThuoc.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdKichThuoc.setText(tblKichThuoc.getValueAt(row, 0).toString());
        txtTenKichThuoc.setText(tblKichThuoc.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblKichThuocMouseClicked

    private void btnLamMoiKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKichThuocActionPerformed
        clearKichThuoc();
    }//GEN-LAST:event_btnLamMoiKichThuocActionPerformed

    private void btnSuaKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKichThuocActionPerformed
        KichThuoc kt = getDataKichThuoc();
        if (kt == null) {
            return;
        }
        int row = tblKichThuoc.getSelectedRow();
        int id = Integer.parseInt(tblKichThuoc.getValueAt(row, 0).toString());
        serviceKichThuoc.updateKichThuoc(id, kt);
        LoadTableKichThuoc();
        clearKichThuoc();
    }//GEN-LAST:event_btnSuaKichThuocActionPerformed

    private void btnThemKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKichThuocActionPerformed
        String tenKichThuoc = txtTenKichThuoc.getText();
        KichThuoc kt = new KichThuoc(tenKichThuoc);
        if (kt == null) {
            return;
        }
        serviceKichThuoc.insertKichThuoc(kt);
        LoadTableKichThuoc();
        clearKichThuoc();
    }//GEN-LAST:event_btnThemKichThuocActionPerformed

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
        int row = tblChatLieu.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdChatLieu.setText(tblChatLieu.getValueAt(row, 0).toString());
        txtTenChatLieu.setText(tblChatLieu.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblChatLieuMouseClicked

    private void btnLamMoiChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiChatLieuActionPerformed
        clearChatLieu();
    }//GEN-LAST:event_btnLamMoiChatLieuActionPerformed

    private void btnSuaChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChatLieuActionPerformed
        ChatLieu cl = getDataChatLieu();
        if (cl == null) {
            return;
        }
        int row = tblChatLieu.getSelectedRow();
        int id = Integer.parseInt(tblChatLieu.getValueAt(row, 0).toString());
        serviceChatLieu.updateChatLieu(id, cl);
        LoadTableChatLieu();
        clearChatLieu();
    }//GEN-LAST:event_btnSuaChatLieuActionPerformed

    private void btnThemChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChatLieuActionPerformed
        String tenChatLieu = txtTenChatLieu.getText();
        ChatLieu cl = new ChatLieu(tenChatLieu);
        if (cl == null) {
            return;
        }
        serviceChatLieu.insertChatLieu(cl);
        LoadTableChatLieu();
        clearChatLieu();
    }//GEN-LAST:event_btnThemChatLieuActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdMauSac.setText(tblMauSac.getValueAt(row, 0).toString());
        txtTenMauSac.setText(tblMauSac.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void btnLamMoiMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiMauSacActionPerformed
        clearMauSac();
    }//GEN-LAST:event_btnLamMoiMauSacActionPerformed

    private void btnSuaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauSacActionPerformed
        MauSac ms = getDataMauSac();
        if (ms == null) {
            return;
        }
        int row = tblMauSac.getSelectedRow();
        int id = Integer.parseInt(tblMauSac.getValueAt(row, 0).toString());
        serviceMauSac.updateMauSac(id, ms);
        LoadTableMauSac();
        clearMauSac();
    }//GEN-LAST:event_btnSuaMauSacActionPerformed

    private void btnThemMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauSacActionPerformed
        String tenMauSac = txtTenMauSac.getText();
        MauSac ms = new MauSac(tenMauSac);
        if (ms == null) {
            return;
        }
        serviceMauSac.insertMauSac(ms);
        LoadTableMauSac();
        clearMauSac();
    }//GEN-LAST:event_btnThemMauSacActionPerformed

    private void btnLamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPActionPerformed
        clearQLSPCT();
    }//GEN-LAST:event_btnLamMoiSPActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        int row = tblQuanLyCTSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        int id = Integer.parseInt(tblQuanLyCTSP.getValueAt(row, 0).toString());
        serviceSanPhamChiTiet.deleteSanPhamCT(id);
        loadTableQLSPCT();
        clearQLSPCT();
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        int row = tblQuanLyCTSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        SanPhamChiTiet spct = getDataChiTietSanPham();
        int idSPCT = Integer.parseInt(tblQuanLyCTSP.getValueAt(row, 0).toString());
        serviceSanPhamChiTiet.updateSanPhamCT(idSPCT, spct);
        loadTableQLSPCT();
        clearQLSPCT();
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed

        float giaBan = Float.parseFloat(txtGiaBanSP.getText());
        int soLuong = Integer.parseInt(txtSoLuongSP.getText());
        KichThuoc kichThuoc = listcbbKichThuoc.get(cbbKichThuocSP.getSelectedIndex());
        ChatLieu chatLieu = listcbbChatLieu.get(cbbChatLieuSP.getSelectedIndex());
        MauSac mauSac = listcbbMauSac.get(cbbMauSacSP.getSelectedIndex());
        SanPham sanPham = listcbbSanPham.get(cbbTenSP.getSelectedIndex());

        SanPhamChiTiet spct = new SanPhamChiTiet(kichThuoc, chatLieu, mauSac, sanPham, soLuong, giaBan);
        if (spct != null) {
            serviceSanPhamChiTiet.insertSanPhamCT(spct);
            loadTableQLSPCT();
        }
        clearQLSPCT();
        LoadTableSanPhamChiTiet();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void txtSearchMauSacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMauSacKeyReleased
        searchMauSac();
    }//GEN-LAST:event_txtSearchMauSacKeyReleased

    private void txtTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemSanPhamActionPerformed

    private void txtTimKiemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemCTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemCTSPActionPerformed

    private void txtSearchKichThuocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKichThuocKeyReleased
        searchKichThuoc();
    }//GEN-LAST:event_txtSearchKichThuocKeyReleased

    private void txtSearchChatLieuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchChatLieuKeyReleased
        searchChatLieu();
    }//GEN-LAST:event_txtSearchChatLieuKeyReleased

    private void txtseachQLCTSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtseachQLCTSPKeyReleased
        searchQLSanPhamChiTiet();
    }//GEN-LAST:event_txtseachQLCTSPKeyReleased

    private void tblQuanLyCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyCTSPMouseClicked
        int row = tblQuanLyCTSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtIdQLSPCT.setText(tblQuanLyCTSP.getValueAt(row, 0).toString());
        cbbTenSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 1).toString());
        txtSoLuongSP.setText(tblQuanLyCTSP.getValueAt(row, 5).toString());
        txtGiaBanSP.setText(tblQuanLyCTSP.getValueAt(row, 6).toString());

        cbbKichThuocSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 2).toString());
        cbbChatLieuSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 3).toString());
        cbbMauSacSP.setSelectedItem(tblQuanLyCTSP.getValueAt(row, 4).toString());
        cbbTenSP.setEnabled(false);
    }//GEN-LAST:event_tblQuanLyCTSPMouseClicked

    private void btnThemKichThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKichThuoc1ActionPerformed
        String maSanPham = txtMaSPP.getText();
        String tenSanPham = txtTenSPP.getText();
        SanPham sp = new SanPham(maSanPham, tenSanPham);
        if (sp == null) {
            return;
        }
        serviceSanPham.insertSanPham(sp);
        LoadTableQLSPSanPham();
        clearSanPham();
        LoadTableSanPham();
    }//GEN-LAST:event_btnThemKichThuoc1ActionPerformed

    private void btnSuaKichThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKichThuoc1ActionPerformed
        SanPham sp = getDataSanPham();
        if (sp == null) {
            return;
        }
        int row = tblQLSP.getSelectedRow();
        String maSP = tblQLSP.getValueAt(row, 0).toString();
        serviceSanPham.updateSanPham(maSP, sp);
        LoadTableQLSPSanPham();
        clearSanPham();
        LoadTableSanPham();
    }//GEN-LAST:event_btnSuaKichThuoc1ActionPerformed

    private void btnLamMoiKichThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKichThuoc1ActionPerformed
        clearSanPham();
    }//GEN-LAST:event_btnLamMoiKichThuoc1ActionPerformed

    private void tblQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSPMouseClicked
        int row = tblQLSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaSPP.setText(tblQLSP.getValueAt(row, 0).toString());
        txtTenSPP.setText(tblQLSP.getValueAt(row, 1).toString());
        txtMaSPP.setEnabled(false);
    }//GEN-LAST:event_tblQLSPMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        searchQLSanPham();
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(QuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiChatLieu;
    private javax.swing.JButton btnLamMoiKichThuoc;
    private javax.swing.JButton btnLamMoiKichThuoc1;
    private javax.swing.JButton btnLamMoiMauSac;
    private javax.swing.JButton btnLamMoiSP;
    private javax.swing.JButton btnSuaChatLieu;
    private javax.swing.JButton btnSuaKichThuoc;
    private javax.swing.JButton btnSuaKichThuoc1;
    private javax.swing.JButton btnSuaMauSac;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnThemChatLieu;
    private javax.swing.JButton btnThemKichThuoc;
    private javax.swing.JButton btnThemKichThuoc1;
    private javax.swing.JButton btnThemMauSac;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cbbChatLieuSP;
    private javax.swing.JComboBox<String> cbbKichThuocSP;
    private javax.swing.JComboBox<String> cbbMauSacSP;
    private javax.swing.JComboBox<String> cbbTenSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblKichThuoc;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblQLSP;
    private javax.swing.JTable tblQuanLyCTSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBanSP;
    private javax.swing.JTextField txtIdChatLieu;
    private javax.swing.JTextField txtIdKichThuoc;
    private javax.swing.JTextField txtIdMauSac;
    private javax.swing.JTextField txtIdQLSPCT;
    private javax.swing.JTextField txtMaSPP;
    private javax.swing.JTextField txtSearchChatLieu;
    private javax.swing.JTextField txtSearchKichThuoc;
    private javax.swing.JTextField txtSearchMauSac;
    private javax.swing.JTextField txtSoLuongSP;
    private javax.swing.JTextField txtTenChatLieu;
    private javax.swing.JTextField txtTenKichThuoc;
    private javax.swing.JTextField txtTenMauSac;
    private javax.swing.JTextField txtTenSPP;
    private javax.swing.JTextField txtTimKiemCTSP;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtseachQLCTSP;
    // End of variables declaration//GEN-END:variables
}
