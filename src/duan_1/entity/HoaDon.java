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
public class HoaDon {
    private int idhoaDon;
    private NhanVien nhanVien;
    private int idKhachHang;
    private String maHoaDon;
    private Date ngayTao;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public HoaDon(int idhoaDon, NhanVien nhanVien, int idKhachHang, String maHoaDon, Date ngayTao) {
        this.idhoaDon = idhoaDon;
        this.nhanVien = nhanVien;
        this.idKhachHang = idKhachHang;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
    }
    
    

    public int getIdhoaDon() {
        return idhoaDon;
    }

    public void setIdhoaDon(int idhoaDon) {
        this.idhoaDon = idhoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

   

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
}
