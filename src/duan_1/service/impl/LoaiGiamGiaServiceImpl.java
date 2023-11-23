/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.model.LoaiGiamGia;
import duan_1.repository.LoaiGiamGiaRepository;
import duan_1.service.LoaiGiamGiaService;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Acer
 */
public class LoaiGiamGiaServiceImpl implements LoaiGiamGiaService{
    private LoaiGiamGiaRepository loaiGiamGiaRepository = new LoaiGiamGiaRepository();
    @Override
    public List<LoaiGiamGia> getAll() {
         return loaiGiamGiaRepository.getAll();
    }

    @Override
    public LoaiGiamGia getOne(String id) {
        return loaiGiamGiaRepository.getOne(id);
    }

    @Override
    public String add(LoaiGiamGia lgg) {
        boolean add = loaiGiamGiaRepository.add(lgg);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(LoaiGiamGia lgg, int id) {
        boolean update = loaiGiamGiaRepository.update(lgg,id);
        if(update){
            return "Cập Nhật Thành Công";
        }else{
            return "Cập Nhật Thất Bại";
        }
    }

    @Override
    public String delete(String Ten) {
        boolean delete = loaiGiamGiaRepository.delete(Ten);
        if(delete){
            return "Xóa Thành Công";
        }else{
            return "Xóa Thất Bại";
        }
    }

    @Override
    public List<LoaiGiamGia> searchByName(List<LoaiGiamGia> lgg, String name) {
        List<LoaiGiamGia> listsearch = new ArrayList<>();
        for(LoaiGiamGia x : lgg){
            if(x.getTenLoaiGiamGia().contains(name) || x.getMotaLoaiGiamGia().contains(name)){
                listsearch.add(x);
            }
        }
        return listsearch;
    }
    
}
