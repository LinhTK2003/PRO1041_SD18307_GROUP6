/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan_1.service;

import duan_1.entity.HoaDonChiTiet;
import duan_1.entity.PhieuDoi;
import duan_1.entity.SanPhamChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI Laptop
 */
public interface PhieuDoiService {
    public ArrayList<HoaDonChiTiet> getAllHDCT();
    public List<HoaDonChiTiet> searchHDCT(String  ma);
    public ArrayList<SanPhamChiTiet> getAllCTSP(String maSPCT);
    
    public  ArrayList<PhieuDoi> getAllPD();
    public void add(PhieuDoi pd);
    public void update(int id , PhieuDoi pd);
    public void deleete(int id);
}
