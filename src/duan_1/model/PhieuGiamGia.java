/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.model;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class PhieuGiamGia {
    private int IdPhieuGiamGia;
    private LoaiGiamGia LGG;
    private MucGiamGia MGG;
    private String MaPhieuGiamGia;
    private String TenPhieuGiamGia;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private int soLuong;
    private String Mota;
    private boolean TrangThai;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(int IdPhieuGiamGia, LoaiGiamGia LGG, MucGiamGia MGG, String MaPhieuGiamGia, String TenPhieuGiamGia, Date NgayBatDau, Date NgayKetThuc, int soLuong, String Mota, boolean TrangThai) {
        this.IdPhieuGiamGia = IdPhieuGiamGia;
        this.LGG = LGG;
        this.MGG = MGG;
        this.MaPhieuGiamGia = MaPhieuGiamGia;
        this.TenPhieuGiamGia = TenPhieuGiamGia;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.soLuong = soLuong;
        this.Mota = Mota;
        this.TrangThai = TrangThai;
    }

    public PhieuGiamGia(int IdPhieuGiamGia, LoaiGiamGia LGG, MucGiamGia MGG, String MaPhieuGiamGia, String TenPhieuGiamGia, Date NgayBatDau, Date NgayKetThuc, boolean TrangThai) {
        this.IdPhieuGiamGia = IdPhieuGiamGia;
        this.LGG = LGG;
        this.MGG = MGG;
        this.MaPhieuGiamGia = MaPhieuGiamGia;
        this.TenPhieuGiamGia = TenPhieuGiamGia;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
    }

    public PhieuGiamGia(LoaiGiamGia LGG, MucGiamGia MGG, String MaPhieuGiamGia, String TenPhieuGiamGia, Date NgayBatDau, Date NgayKetThuc, boolean TrangThai) {
        this.LGG = LGG;
        this.MGG = MGG;
        this.MaPhieuGiamGia = MaPhieuGiamGia;
        this.TenPhieuGiamGia = TenPhieuGiamGia;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
    }
 
    public int getIdPhieuGiamGia() {
        return IdPhieuGiamGia;
    }

    public void setIdPhieuGiamGia(int IdPhieuGiamGia) {
        this.IdPhieuGiamGia = IdPhieuGiamGia;
    }

    public LoaiGiamGia getLGG() {
        return LGG;
    }

    public void setLGG(LoaiGiamGia LGG) {
        this.LGG = LGG;
    }

    public MucGiamGia getMGG() {
        return MGG;
    }

    public void setMGG(MucGiamGia MGG) {
        this.MGG = MGG;
    }

    public String getMaPhieuGiamGia() {
        return MaPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String MaPhieuGiamGia) {
        this.MaPhieuGiamGia = MaPhieuGiamGia;
    }

    public String getTenPhieuGiamGia() {
        return TenPhieuGiamGia;
    }

    public void setTenPhieuGiamGia(String TenPhieuGiamGia) {
        this.TenPhieuGiamGia = TenPhieuGiamGia;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
   
    
    public Object[] todataRow(){
        return new Object[]{MaPhieuGiamGia,TenPhieuGiamGia,NgayBatDau,NgayKetThuc,LGG.getTenLoaiGiamGia(),MGG.getGiatri()+"%",TrangThai==true?"Hoạt Động" :"Ngừng Hoạt Động"};
    }
}
