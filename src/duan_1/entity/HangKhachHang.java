/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

/**
 *
 * @author HP
 */
public class HangKhachHang {

    int IdHangKhachHang;
    String TenHangKhachHang;

    @Override
    public String toString() {
       return TenHangKhachHang;
    }
    

    public HangKhachHang() {
    }

    public HangKhachHang(int IdHangKhachHang, String TenHangKhachHang) {
        this.IdHangKhachHang = IdHangKhachHang;
        this.TenHangKhachHang = TenHangKhachHang;
    }

    public int getIdHangKhachHang() {
        return IdHangKhachHang;
    }

    public void setIdHangKhachHang(int IdHangKhachHang) {
        this.IdHangKhachHang = IdHangKhachHang;
    }

    public String getTenHangKhachHang() {
        return TenHangKhachHang;
    }

    public void setTenHangKhachHang(String TenHangKhachHang) {
        this.TenHangKhachHang = TenHangKhachHang;
    }

   


    

}
