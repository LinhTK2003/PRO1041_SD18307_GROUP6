/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan_1.service;

import duan_1.entity.MauSac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public interface MauSacService {
    
    public ArrayList<MauSac> getAllMauSac();
    
    public void insertMauSac(MauSac ms);

    public void updateMauSac(int id, MauSac ms);

    public void deleteMauSac(int id);
    
    public List<MauSac> searchMauSac(String searchCode);
}
