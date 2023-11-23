/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.repository;

import duan_1.entity.HangKhachHang;
import duan_1.utiliti.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class LoaiKhachHangReponsitory {

    public ArrayList<HangKhachHang> all() {
        ArrayList<HangKhachHang> dslkh = new ArrayList<>();

        try {
            Connection conn = Utilities.getConnection();
            String query = "Select IdHangKhachHang ,TenHangKhachHang from HangKhachHang ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                 int id = rs.getInt("IdHangKhachHang");

                String tenKhachHang = rs.getString("TenHangKhachHang");

                HangKhachHang lkh = new HangKhachHang();
                lkh.setIdHangKhachHang(id);
                lkh.setTenHangKhachHang(tenKhachHang);

                dslkh.add(lkh);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return dslkh;
    }
}
