
package duan_1.entity;

public class KhachHang {
String IdKhachHang , MaKhachHang, TenKhachHang, DiaChi,SDT;
int GioiTinh;
private HangKhachHang loaiKhachHang;

    public KhachHang() {
    }


    public KhachHang(String IdKhachHang, String MaKhachHang, String TenKhachHang, String DiaChi, String SDT, int GioiTinh, HangKhachHang loaiKhachHang) {
        this.IdKhachHang = IdKhachHang;
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(String IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public HangKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(HangKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
  

  

    
}