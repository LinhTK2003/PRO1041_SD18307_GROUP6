package duan_1.service;

import duan_1.entity.KhachHang;
import duan_1.repository.KhachHangReponsitory;
import java.util.ArrayList;


public class KhachHangServices {
    
    private KhachHangReponsitory banrepos;
    
    public KhachHangServices() {
        this.banrepos = new KhachHangReponsitory();
    }

    public void insert(KhachHang ban) {
        this.banrepos.insert(ban);
    }

    public void update(String id, KhachHang ban) {
        this.banrepos.update(id, ban);
    }
public void delete(String id){
this.banrepos.delete(id);
}

    public ArrayList<KhachHang> getall() {
        return this.banrepos.all();
    }
     public ArrayList<KhachHang> search(String key) {
        return this.banrepos.search(key);
    }
    
}
