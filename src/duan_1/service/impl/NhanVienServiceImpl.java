/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.entity.NhanVien;
import duan_1.service.NhanVienService;
import java.util.ArrayList;
import duan_1.utiliti.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSI Laptop
 */
public class NhanVienServiceImpl implements NhanVienService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public ArrayList<NhanVien> getAllNhanVien() {
        String sql = "SELECT [IdNhanVien]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "  FROM [dbo].[NhanVien]";
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idNhanVien = rs.getInt(1);
                String maNhanVien = rs.getString(2);
                String tenNhanVien = rs.getString(3);
                NhanVien sp = new NhanVien(idNhanVien, maNhanVien, tenNhanVien);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
