/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.entity;

/**
 *
 * @author admin
 */
public class KichThuoc {
    private int IdKichThuoc;
    private String tenKichThuoc;

    public KichThuoc() {
    }

    public KichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    public KichThuoc(int IdKichThuoc, String tenKichThuoc) {
        this.IdKichThuoc = IdKichThuoc;
        this.tenKichThuoc = tenKichThuoc;
    }

    public int getIdKichThuoc() {
        return IdKichThuoc;
    }

    public void setIdKichThuoc(int IdKichThuoc) {
        this.IdKichThuoc = IdKichThuoc;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }
    
}
