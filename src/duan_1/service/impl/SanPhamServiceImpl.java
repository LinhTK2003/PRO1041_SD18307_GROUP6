/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.entity.SanPham;
import duan_1.service.SanPhamService;
import duan_1.utiliti.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SanPhamServiceImpl implements SanPhamService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public ArrayList<SanPham> getAllSanPham() {
        String sql = "SELECT [MaSanPham]\n"
                + "      ,[TenSanPham]\n"
                + "  FROM [dbo].[SanPham] order by MaSanPham ASC";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maSanPham = rs.getString(1);
                String tenSanPham = rs.getString(2);
                SanPham sp = new SanPham(maSanPham, tenSanPham);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPham> searchSanPham(String code) {
        List<SanPham> listSP = new ArrayList<>();
        String query = "SELECT [MaSanPham]\n"
                + "      ,[TenSanPham]\n"
                + "  FROM [dbo].[SanPham]\n"
                + "  where MaSanPham like ? or TenSanPham like ? order by MaSanPham ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, code);
            ps.setString(2, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham")
                );
                listSP.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }

    @Override
    public void insertSanPham(SanPham sp) {
        String sql = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([MaSanPham]\n"
                + "           ,[TenSanPham])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanPham());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSanPham(String id, SanPham sp) {
        String sql = "UPDATE [dbo].[SanPham]\n"
                + "   SET [TenSanPham] = ?\n"
                + " WHERE MaSanPham = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSanPham());
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteSanPham(String id) {
        String sql = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE MaSanPham = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
