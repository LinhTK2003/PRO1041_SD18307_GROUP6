/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

/**
 *
 * @author MSI Laptop
 */
public class NhanVien {
    private int idNhanVien;
    private String maNhanVien;
    private String tenNhanVien;

    public NhanVien() {
    }

    public NhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public NhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public NhanVien(int idNhanVien, String maNhanVien, String tenNhanVien) {
        this.idNhanVien = idNhanVien;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    
    
}
