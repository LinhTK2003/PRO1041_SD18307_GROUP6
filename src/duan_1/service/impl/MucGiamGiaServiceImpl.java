/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.model.MucGiamGia;
import duan_1.repository.MucGiamGiaRepository;
import duan_1.service.MucGiamGiaService;
import java.util.List;


/**
 *
 * @author Acer
 */
public class MucGiamGiaServiceImpl implements MucGiamGiaService{
    private MucGiamGiaRepository MucGiamGiaRepository = new MucGiamGiaRepository();
    @Override
    public List<MucGiamGia> getAll() {
        return MucGiamGiaRepository.getAll();
    }

    @Override
    public MucGiamGia getOne(String id) {
        return MucGiamGiaRepository.getOne(id);
    }
    
}
