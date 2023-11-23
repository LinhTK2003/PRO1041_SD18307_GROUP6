/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

/**
 *
 * @author admin
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;

    public SanPham() {
    }
    
    
    public SanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public SanPham(String maSanPham, String tenSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    
}
