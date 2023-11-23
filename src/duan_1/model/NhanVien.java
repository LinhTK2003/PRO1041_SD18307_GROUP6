/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.model;

import java.util.Date;

/**
 *
 * @author LEGION
 */
public class NhanVien {

    private int IdNhanVien;
    private int IdChucVu;
    private String MaNhanVien;
    private String TenNhanVien;
    private boolean GioiTinh;
    private String DiaChi;
    private Date NgaySinh;
    private Date NgayTao;
    private String TaiKhoan;
    private String MatKhau;
    private int Luong;
    private String TrangThai;

    public NhanVien() {
    }

    public NhanVien(int IdNhanVien, int IdChucVu, String MaNhanVien, String TenNhanVien, boolean GioiTinh, String DiaChi, Date NgaySinh, Date NgayTao, String TaiKhoan, String MatKhau, int Luong, String TrangThai) {
        this.IdNhanVien = IdNhanVien;
        this.IdChucVu = IdChucVu;
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.NgayTao = NgayTao;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.Luong = Luong;
        this.TrangThai = TrangThai;
    }

    public int getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(int IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    public int getIdChucVu() {
        return IdChucVu;
    }

    public void setIdChucVu(int IdChucVu) {
        this.IdChucVu = IdChucVu;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    
   
}
