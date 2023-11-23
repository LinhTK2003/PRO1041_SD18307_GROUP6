/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan_1.service;

import duan_1.model.MucGiamGia;
import java.util.List;


/**
 *
 * @author Acer
 */
public interface MucGiamGiaService {
    List<MucGiamGia> getAll();
    
    MucGiamGia getOne(String id);
}
