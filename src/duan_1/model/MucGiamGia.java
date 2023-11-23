/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.model;

/**
 *
 * @author Acer
 */
public class MucGiamGia {
    private int idMucGiamGia;
    private float Giatri; 

    public MucGiamGia() {
    }

    public MucGiamGia(float Giatri) {
        this.Giatri = Giatri;
    }

    public MucGiamGia(int idMucGiamGia, float Giatri) {
        this.idMucGiamGia = idMucGiamGia;
        this.Giatri = Giatri;
    }
    
    public int getIdMucGiamGia() {
        return idMucGiamGia;
    }

    public void setIdMucGiamGia(int idMucGiamGia) {
        this.idMucGiamGia = idMucGiamGia;
    }

    public float getGiatri() {
        return Giatri;
    }

    public void setGiatri(float Giatri) {
        this.Giatri = Giatri;
    }

    
}
