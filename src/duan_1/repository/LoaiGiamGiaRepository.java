/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.repository;

import duan_1.model.LoaiGiamGia;
import duan_1.utiliti.Utilities;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class LoaiGiamGiaRepository {

    public List<LoaiGiamGia> getAll() {
        String query = "SELECT [IdLoaiGiamGia]"
                + "      ,[TenLoaiGiamGia]"
                + "      ,[MoTa]"
                + "  FROM [dbo].[LoaiGiamGia]";
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            List<LoaiGiamGia> listLoai = new ArrayList<>();
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                listLoai.add(new LoaiGiamGia(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return listLoai;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public LoaiGiamGia getOne(String id) {
        String query = "SELECT [IdLoaiGiamGia]"
                + "      ,[TenLoaiGiamGia]"
                + "      ,[MoTa]"
                + "  FROM [dbo].[LoaiGiamGia] WHERE [IdLoaiGiamGia]=?";
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new LoaiGiamGia(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(LoaiGiamGia lgg) {
        String query = "INSERT INTO [dbo].[LoaiGiamGia]"
                + "           ([TenLoaiGiamGia]"
                + "           ,[MoTa])"
                + "     VALUES"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, lgg.getTenLoaiGiamGia());
            pr.setObject(2, lgg.getMotaLoaiGiamGia());
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(LoaiGiamGia lgg, int id) {
        String query = "UPDATE [dbo].[LoaiGiamGia]\n"
                + "   SET [TenLoaiGiamGia] = ?"
                + "      ,[MoTa] = ?"
                + " WHERE [IdLoaiGiamGia]=?";
        int check = 0;
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(2, lgg.getMotaLoaiGiamGia());
            pr.setObject(1, lgg.getTenLoaiGiamGia());
            pr.setObject(3,id);
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ten) {
        String query = "DELETE FROM [dbo].[LoaiGiamGia]"
                + "      WHERE [TenLoaiGiamGia]=?";
        int check = 0;
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, Ten);
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
