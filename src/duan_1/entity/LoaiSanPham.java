/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

/**
 *
 * @author admin
 */
public class LoaiSanPham {
    private int idLoaiSanPham;
    private String tenLoaiSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public LoaiSanPham(int idLoaiSanPham, String tenLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public int getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }
    
}
