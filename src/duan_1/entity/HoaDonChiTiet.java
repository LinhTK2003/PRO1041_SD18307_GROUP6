/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

import java.util.UUID;

/**
 *
 * @author MSI Laptop
 */
public class HoaDonChiTiet {
    
    
    
    private  int IdHoaDonChiTiet;
    private SanPhamChiTiet sanPhamChiTiet;
    private HoaDon hoaDon;
    private NhanVien nhanVien;
    private int SoLuong;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int IdHoaDonChiTiet, SanPhamChiTiet sanPhamChiTiet, HoaDon hoaDon, int SoLuong) {
        this.IdHoaDonChiTiet = IdHoaDonChiTiet;
        this.sanPhamChiTiet = sanPhamChiTiet;
        this.hoaDon = hoaDon;
        this.SoLuong = SoLuong;
    }

    public int getIdHoaDonChiTiet() {
        return IdHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(int IdHoaDonChiTiet) {
        this.IdHoaDonChiTiet = IdHoaDonChiTiet;
    }

    public SanPhamChiTiet getSanPhamChiTiet() {
        return sanPhamChiTiet;
    }

    public void setSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        this.sanPhamChiTiet = sanPhamChiTiet;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }


    

    
}
