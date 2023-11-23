/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan_1.service;

import duan_1.entity.KichThuoc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public interface KichThuocService {
    public ArrayList<KichThuoc> getAllKichThuoc();
    
    public void insertKichThuoc(KichThuoc kt);
    
    public void updateKichThuoc(int id, KichThuoc kt);

    public void deleteKichThuoc(int id);
    
    public List<KichThuoc> searchKichThuoc(String searchCode);
}
