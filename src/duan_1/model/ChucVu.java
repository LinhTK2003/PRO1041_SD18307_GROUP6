/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.model;

/**
 *
 * @author LEGION
 */
public class ChucVu {
    private int IdChucVu;
    private String TenChucVu;

    public ChucVu(int IdChucVu, String TenChucVu) {
        this.IdChucVu = IdChucVu;
        this.TenChucVu = TenChucVu;
    }

    public int getIdChucVu() {
        return IdChucVu;
    }

    public void setIdChucVu(int IdChucVu) {
        this.IdChucVu = IdChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
}
