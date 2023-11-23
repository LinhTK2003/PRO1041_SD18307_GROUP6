/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan_1.service;

import duan_1.model.LoaiGiamGia;
import java.util.List;


/**
 *
 * @author Acer
 */
public interface LoaiGiamGiaService {
    List<LoaiGiamGia> getAll();
    
    LoaiGiamGia getOne(String id);
    
    String add(LoaiGiamGia lgg);
    
    String update(LoaiGiamGia lgg, int id);
    
    String delete(String Ten);
    
    List<LoaiGiamGia> searchByName(List<LoaiGiamGia> lgg, String name);
}
