/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.entity.MauSac;
import duan_1.service.MauSacService;
import duan_1.utiliti.Utilities;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class MauSacServiceImpl implements MauSacService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public ArrayList<MauSac> getAllMauSac() {
        String sql = "SELECT [IdMauSac]\n"
                + "      ,[TenMau]\n"
                + "  FROM [dbo].[MauSac]";
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idMauSac = rs.getInt(1);
                String tenMauSac = rs.getString(2);
                MauSac ms = new MauSac(idMauSac, tenMauSac);
                list.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertMauSac(MauSac ms) {
        String sql = "INSERT INTO [dbo].[MauSac]\n"
                + "           ([TenMau])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getTenMauSac());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMauSac(int id, MauSac ms) {
        String sql = "UPDATE [dbo].[MauSac]\n"
                + "   SET [TenMau] = ?\n"
                + " WHERE IdMauSac = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getTenMauSac());
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMauSac(int id) {
        String sql = "DELETE FROM [dbo].[MauSac]\n"
                + "      WHERE IdMauSac = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MauSac> searchMauSac(String searchCode) {
        String query = "SELECT [IdMauSac]\n"
                + "      ,[TenMau]\n"
                + "  FROM [dbo].[MauSac]\n"
                + "  where TenMau = ?";
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, searchCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int idMau = rs.getInt("IdMauSac");
                String tenMau = rs.getString("TenMau");
                MauSac ms = new MauSac(idMau, tenMau);
                list.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
