/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.repository;

import duan_1.model.LoaiGiamGia;
import duan_1.model.MucGiamGia;
import duan_1.model.PhieuGiamGia;
import duan_1.utiliti.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Acer
 */
public class PhieuGiamGiaRepository {

    public List<PhieuGiamGia> getAll() {
        String query = """
                       SELECT dbo.PhieuGiamGia.IdPhieuGiamGia, dbo.PhieuGiamGia.MaPhieu, dbo.PhieuGiamGia.TenPhieu, dbo.PhieuGiamGia.NgayTao, dbo.PhieuGiamGia.NgayKetThuc, dbo.LoaiGiamGia.TenLoaiGiamGia, dbo.MucGiamGia.GiaTri, 
                                         dbo.PhieuGiamGia.TrangThai
                       FROM     dbo.PhieuGiamGia INNER JOIN
                                         dbo.LoaiGiamGia ON dbo.PhieuGiamGia.IdLoaiGiamGia = dbo.LoaiGiamGia.IdLoaiGiamGia INNER JOIN
                                         dbo.MucGiamGia ON dbo.PhieuGiamGia.IdMucGiamGia = dbo.MucGiamGia.IdMucGiamGia""";
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            List<PhieuGiamGia> listPhieu = new ArrayList<>();
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                LoaiGiamGia lgg = new LoaiGiamGia(rs.getString(6));
                MucGiamGia mgg = new MucGiamGia(rs.getFloat(7));
                PhieuGiamGia pgg = new PhieuGiamGia(rs.getInt(1), lgg, mgg, rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(8));
                listPhieu.add(pgg);
            }
            return listPhieu;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(PhieuGiamGia pgg) {
        String query = """
                       INSERT INTO [dbo].[PhieuGiamGia]           ([MaPhieu]           ,[TenPhieu]           ,[IdLoaiGiamGia]           ,[IdMucGiamGia]           ,[TrangThai]           ,[NgayTao]           ,[NgayKetThuc])     VALUES
                                  (?,?,?,?,?,?,?)""";
        int check = 0;
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, pgg.getMaPhieuGiamGia());
            pr.setObject(2, pgg.getTenPhieuGiamGia());
            pr.setObject(6, pgg.getNgayBatDau());
            pr.setObject(7, pgg.getNgayKetThuc());
            pr.setObject(3, pgg.getLGG().getTenLoaiGiamGia());
            pr.setObject(4, pgg.getMGG().getGiatri());
            pr.setObject(5, pgg.isTrangThai());
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(PhieuGiamGia pgg, String MaPhieu) {
        String query = "UPDATE [dbo].[PhieuGiamGia]"
                + "   SET [TenPhieu] = ?"
                + "      ,[IdLoaiGiamGia] = ?"
                + "      ,[IdMucGiamGia] = ?"
                + "      ,[TrangThai] = ?"
                + "      ,[NgayTao] = ?"
                + "      ,[NgayKetThuc] = ?"
                + " WHERE [MaPhieu] = ?";
        int check = 0;
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(7, MaPhieu);
            pr.setObject(1, pgg.getTenPhieuGiamGia());
            pr.setObject(5, pgg.getNgayBatDau());
            pr.setObject(6, pgg.getNgayKetThuc());
            pr.setObject(2, pgg.getLGG().getTenLoaiGiamGia());
            pr.setObject(3, pgg.getMGG().getGiatri());
            pr.setObject(4, pgg.isTrangThai());
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String MaPhieu) {
        String query = "DELETE FROM [dbo].[PhieuGiamGia]"
                + "      WHERE [MaPhieu]= ?";
        int check = 0;
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, MaPhieu);
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
