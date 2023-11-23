/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.model.PhieuGiamGia;
import duan_1.repository.PhieuGiamGiaRepository;
import duan_1.service.PhieuGiamGiaService;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Acer
 */
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService{
    private PhieuGiamGiaRepository PhieuGiamGiaRepository = new PhieuGiamGiaRepository();
    @Override
    public List<PhieuGiamGia> getAll() {
        return PhieuGiamGiaRepository.getAll();
    }

    @Override
    public String add(PhieuGiamGia pgg) {
        if(pgg.getTenPhieuGiamGia().isEmpty()){
            return "Tên Phiếu Không Được Trống !";
        }
        if(pgg.getMaPhieuGiamGia().isEmpty()){
            return "Mã Phiếu Không Được Trống !";
        }
        if(pgg.getLGG().getTenLoaiGiamGia().isEmpty()){
            return "Loại Giảm Giá Không Được Trống !";
        }
        if(!pgg.isTrangThai()){
            return "Trạng thái không được trống !";
        }
       boolean add = PhieuGiamGiaRepository.add(pgg);
       if(add){
           return "Thêm Thành Công";
       }else{
           return "Thêm Thất Bại";
       }
    }

    @Override
    public List<PhieuGiamGia> searchBy(List<PhieuGiamGia> listpgg, String ma) {
        List<PhieuGiamGia> listSearch = new ArrayList<>();
        for(PhieuGiamGia pgg : listpgg){
            if(pgg.getMaPhieuGiamGia().contains(ma) || pgg.getTenPhieuGiamGia().contains(ma)){
                listSearch.add(pgg);
            }
        }
        return listSearch;
    }

    @Override
    public String delete(String MaPhieu) {
        boolean delete = PhieuGiamGiaRepository.delete(MaPhieu);
        return "Xóa Thành Công";
    }

    @Override
    public String update(PhieuGiamGia pgg, String MaPhieu) {
        boolean update = PhieuGiamGiaRepository.update(pgg, MaPhieu);
        if(update){
            return "Cập Nhật Thành Công";
        }else{
            return "Cập Nhật Thất Bại";
        }
    }
    
}
