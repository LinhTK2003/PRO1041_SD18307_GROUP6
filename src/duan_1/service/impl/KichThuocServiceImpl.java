/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.entity.KichThuoc;
import duan_1.service.KichThuocService;
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
public class KichThuocServiceImpl implements KichThuocService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public ArrayList<KichThuoc> getAllKichThuoc() {
        String sql = "SELECT [IdKichThuoc]\n"
                + "      ,[TenKichThuoc]\n"
                + "  FROM [dbo].[KichThuoc]";
        ArrayList<KichThuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idKichThuoc = rs.getInt(1);
                String tenKichThuoc = rs.getString(2);
                KichThuoc kt = new KichThuoc(idKichThuoc, tenKichThuoc);
                list.add(kt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertKichThuoc(KichThuoc kt) {
        String sql = "INSERT INTO [dbo].[KichThuoc]\n"
                + "           ([TenKichThuoc])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kt.getTenKichThuoc());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKichThuoc(int id, KichThuoc kt) {
        String sql = "UPDATE [dbo].[KichThuoc]\n"
                + "   SET [TenKichThuoc] = ?\n"
                + " WHERE IdKichThuoc = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kt.getTenKichThuoc());
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKichThuoc(int id) {
        String sql = "DELETE FROM [dbo].[KichThuoc]\n"
                + "      WHERE IdKichThuoc = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KichThuoc> searchKichThuoc(String searchCode) {
        String query = "SELECT [IdKichThuoc]\n"
                + "      ,[TenKichThuoc]\n"
                + "  FROM [dbo].[KichThuoc]\n"
                + "  where TenKichThuoc = ?";
        ArrayList<KichThuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, searchCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idKichThuoc = rs.getInt("IdKichThuoc");
                String tenKichThuoc = rs.getString("TenKichThuoc");
                KichThuoc kt = new KichThuoc(idKichThuoc, tenKichThuoc);
                list.add(kt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
