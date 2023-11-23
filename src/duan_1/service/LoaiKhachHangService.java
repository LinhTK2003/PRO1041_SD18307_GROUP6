
package duan_1.service;

import duan_1.entity.HangKhachHang;
import duan_1.repository.LoaiKhachHangReponsitory;
import java.util.ArrayList;



public class LoaiKhachHangService {
    private LoaiKhachHangReponsitory lkhrepon ;
    public LoaiKhachHangService() {
        this.lkhrepon = new LoaiKhachHangReponsitory();
    }
    public ArrayList<HangKhachHang> getall() {
        return this.lkhrepon.all();
    }
    
    
}
