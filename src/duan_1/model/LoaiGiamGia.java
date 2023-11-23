/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.model;

/**
 *
 * @author Acer
 */
public class LoaiGiamGia {
    private int idLoaiGiamGia;
    private String TenLoaiGiamGia;
    private String MotaLoaiGiamGia;

    public LoaiGiamGia() {
    }

    public LoaiGiamGia(String TenLoaiGiamGia) {
        this.TenLoaiGiamGia = TenLoaiGiamGia;
    }

    public LoaiGiamGia(int idLoaiGiamGia, String TenLoaiGiamGia, String MotaLoaiGiamGia) {
        this.idLoaiGiamGia = idLoaiGiamGia;
        this.TenLoaiGiamGia = TenLoaiGiamGia;
        this.MotaLoaiGiamGia = MotaLoaiGiamGia;
    }
    
    public int getIdLoaiGiamGia() {
        return idLoaiGiamGia;
    }

    public void setIdLoaiGiamGia(int idLoaiGiamGia) {
        this.idLoaiGiamGia = idLoaiGiamGia;
    }

    public LoaiGiamGia(String TenLoaiGiamGia, String MotaLoaiGiamGia) {
        this.TenLoaiGiamGia = TenLoaiGiamGia;
        this.MotaLoaiGiamGia = MotaLoaiGiamGia;
    }
    
    public String getTenLoaiGiamGia() {
        return TenLoaiGiamGia;
    }

    public void setTenLoaiGiamGia(String TenLoaiGiamGia) {
        this.TenLoaiGiamGia = TenLoaiGiamGia;
    }

    public String getMotaLoaiGiamGia() {
        return MotaLoaiGiamGia;
    }

    public void setMotaLoaiGiamGia(String MotaLoaiGiamGia) {
        this.MotaLoaiGiamGia = MotaLoaiGiamGia;
    }
    public Object[] todataRow(){
        return new Object[]{idLoaiGiamGia,TenLoaiGiamGia,MotaLoaiGiamGia};
    }
    
}
