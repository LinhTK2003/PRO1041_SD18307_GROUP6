
package duan_1.entity;

public class MauSac {
    private int IdMauSac;
    private String TenMauSac;

    public MauSac() {
    }

    public MauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    public MauSac(int IdMauSac, String TenMauSac) {
        this.IdMauSac = IdMauSac;
        this.TenMauSac = TenMauSac;
    }

    public int getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(int IdMauSac) {
        this.IdMauSac = IdMauSac;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    
}
