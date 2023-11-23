/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

import java.util.Date;

/**
 *
 * @author MSI Laptop
 */
public class PhieuDoi {
    private int idPhieuDoi;
    private String maPhieuDoi;
    private SanPhamChiTiet chiTietSanPham;
    private NhanVien nhanVien;
    private String lyDoDoi;
    private Date ngayDoi;
    private int soLuong ;
    

    public PhieuDoi() {
    }

    public PhieuDoi(int idPhieuDoi, String maPhieuDoi, SanPhamChiTiet chiTietSanPham, NhanVien nhanVien, String lyDoDoi, Date ngayDoi, int soLuong) {
        this.idPhieuDoi = idPhieuDoi;
        this.maPhieuDoi = maPhieuDoi;
        this.chiTietSanPham = chiTietSanPham;
        this.nhanVien = nhanVien;
        this.lyDoDoi = lyDoDoi;
        this.ngayDoi = ngayDoi;
        this.soLuong = soLuong;
    }

   

    

    public int getIdPhieuDoi() {
        return idPhieuDoi;
    }

    public void setIdPhieuDoi(int idPhieuDoi) {
        this.idPhieuDoi = idPhieuDoi;
    }

    public String getMaPhieuDoi() {
        return maPhieuDoi;
    }

    public void setMaPhieuDoi(String maPhieuDoi) {
        this.maPhieuDoi = maPhieuDoi;
    }

    public SanPhamChiTiet getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(SanPhamChiTiet chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getLyDoDoi() {
        return lyDoDoi;
    }

    public void setLyDoDoi(String lyDoDoi) {
        this.lyDoDoi = lyDoDoi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayDoi() {
        return ngayDoi;
    }

    public void setNgayDoi(Date ngayDoi) {
        this.ngayDoi = ngayDoi;
    }

 

   
    
    
    
}
