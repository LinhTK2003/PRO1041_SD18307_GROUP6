/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.entity.ChatLieu;
import duan_1.entity.HoaDon;
import duan_1.entity.HoaDonChiTiet;
import duan_1.entity.KichThuoc;
import duan_1.entity.MauSac;
import duan_1.entity.NhanVien;
import duan_1.entity.PhieuDoi;
import duan_1.entity.SanPham;
import duan_1.entity.SanPhamChiTiet;

import duan_1.service.PhieuDoiService;
import duan_1.utiliti.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MSI Laptop
 */
public class PhieuDoiServiceImpl implements PhieuDoiService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public List<HoaDonChiTiet> searchHDCT(String ma) {
        String sql = "SELECT [IdHoaDonChiTiet]\n"
                + "	  ,HoaDonChiTiet.[IdSanPhamChiTiet]\n"
                + "	  ,HoaDon.MaHoaDon	\n"
                + "      ,[HoaDonChiTiet].SoLuong\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  join HoaDon on HoaDon.IdHoaDon = HoaDonChiTiet.IdHoaDon\n"
                + "  join SanPhamChiTiet on SanPhamChiTiet.IdSanPhamChiTiet = HoaDonChiTiet.IdSanPhamChiTiet"
                + "  WHERE          MaHoaDon = ?"
                + "                ";

        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, ma);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int idHoaDonChiTiet = rs.getInt("IdHoaDonChiTiet");
                int idChiTietSanPham = rs.getInt("IdSanPhamChiTiet");

                String maHoaDon = rs.getString("MaHoaDon");
                HoaDon hd = new HoaDon(maHoaDon);
                SanPhamChiTiet sp = new SanPhamChiTiet(idChiTietSanPham);

                int soLuong = rs.getInt("SoLuong");

                HoaDonChiTiet kt = new HoaDonChiTiet(idHoaDonChiTiet, sp, hd, soLuong);
                list.add(kt);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public ArrayList<HoaDonChiTiet> getAllHDCT() {
        String sql = "SELECT [IdHoaDonChiTiet]\n"
                + "	  ,[SanPhamChiTiet].IdSanPhamChiTiet\n"
                + "	  ,HoaDon.MaHoaDon	\n"
                + "      ,[HoaDonChiTiet].SoLuong\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  join HoaDon on HoaDon.IdHoaDon = HoaDonChiTiet.IdHoaDon\n"
                + "  join SanPhamChiTiet on SanPhamChiTiet.IdSanPhamChiTiet = HoaDonChiTiet.IdSanPhamChiTiet";

        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idHoaDonChiTiet = rs.getInt("IdHoaDonChiTiet");
                int idChiTietSanPham = rs.getInt("IdSanPhamChiTiet");

                String maHoaDon = rs.getString("MaHoaDon");
                HoaDon hd = new HoaDon(maHoaDon);
                SanPhamChiTiet sp = new SanPhamChiTiet(idChiTietSanPham);

                int soLuong = rs.getInt("SoLuong");
                HoaDonChiTiet hdct = new HoaDonChiTiet(idHoaDonChiTiet, sp, hd, soLuong);
                list.add(hdct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPhamChiTiet> getAllCTSP(String maSPCT) {

        String sql = "SELECT SanPhamChiTiet.[IdSanPhamChiTiet]\n"
                + "			,SanPham.TenSanPham \n"
                + "                     ,KichThuoc.[TenKichThuoc]\n"
                + "                     ,ChatLieu.[TenChatLieu]\n"
                + "                     ,MauSac.TenMau   \n"
                + "FROM [dbo].[SanPhamChiTiet]\n"
                + "             join KichThuoc on KichThuoc.IdKichThuoc = SanPhamChiTiet.IdKichThuoc\n"
                + "             join ChatLieu on ChatLieu.IdChatLieu = SanPhamChiTiet.IdChatLieu\n"
                + "             join MauSac on MauSac.IdMauSac = SanPhamChiTiet.IdMauSac\n"
                + "		join SanPham on SanPham.MaSanPham = SanPhamChiTiet.MaSanPham\n"
                + "where SanPhamChiTiet.IdSanPhamChiTiet =?";

        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSPCT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPhamCT = rs.getInt("IdSanPhamChiTiet");
                String tensp = rs.getString("TenSanPham");
                String tenKichThuoc = rs.getString("TenKichThuoc");
                String tenChatLieu = rs.getString("TenChatLieu");
                String tenMauSac = rs.getString("TenMau");

                SanPham sp = new SanPham(tenMauSac);
                KichThuoc kt = new KichThuoc(tenKichThuoc);
                ChatLieu cl = new ChatLieu(tenChatLieu);
                MauSac ms = new MauSac(tenMauSac);

                SanPhamChiTiet spct = new SanPhamChiTiet(idSanPhamCT, kt, cl, ms, sp, idSanPhamCT, idSanPhamCT);
                list.add(spct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public void add(PhieuDoi pd) {
        String query = "INSERT INTO [dbo].[PhieuDoi]\n"
                + "           ([MaPhieu]\n"
                + "           ,[IdNhanVien]\n"
                + "           ,[IdSanPhamChiTiet]\n"
                + "           ,[LyDoDoi]\n"
                + "           ,[NgayDoi]\n"
                + "           ,[SoLuong])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int check = 0;
        try (
                PreparedStatement pr = conn.prepareStatement(query);) {
            pr.setObject(1, pd.getMaPhieuDoi());
            pr.setObject(2, pd.getNhanVien().getIdNhanVien());
            pr.setObject(3, pd.getChiTietSanPham().getIdSanPhamChiTiet());
            pr.setObject(4, pd.getLyDoDoi());
            pr.setObject(5, pd.getNgayDoi());
            pr.setObject(6, pd.getSoLuong());
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void update(int id, PhieuDoi pd) {
        String query = "UPDATE [dbo].[PhieuDoi]\n"
                + "   SET [MaPhieu] = ?\n"
                + "      ,[IdNhanVien] = ?\n"
                + "      ,[IdSanPhamChiTiet] = ?\n"
                + "      ,[LyDoDoi] = ?\n"
                + "       ,[NgayDoi]\n"
                + "      ,[SoLuong] = ?\n"
                + " WHERE IdPhieuDoi = ?";

        try (PreparedStatement pr = conn.prepareStatement(query);) {
            pr.setObject(1, pd.getMaPhieuDoi());
            pr.setObject(2, pd.getNhanVien().getIdNhanVien());
            pr.setObject(3, pd.getChiTietSanPham().getIdSanPhamChiTiet());
            pr.setObject(4, pd.getLyDoDoi());
            pr.setObject(5, pd.getNgayDoi());
            pr.setObject(6, pd.getSoLuong());
            pr.setInt(7, id);
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void deleete(int id) {
        String sql = "DELETE FROM [dbo].[PhieuDoi]\n"
                + "      WHERE IdPhieuDoi = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PhieuDoi> getAllPD() {
        String sql = """
                     SELECT [IdPhieuDoi]
                           ,[MaPhieu]
                           ,NhanVien.[TenNhanVien]
                           ,SanPhamChiTiet.[IdSanPhamChiTiet]
                           ,[LyDoDoi]
                           ,NgayDoi
                           ,[PhieuDoi].SoLuong
                       FROM [dbo].[PhieuDoi]
                       join NhanVien on NhanVien.IdNhanVien = PhieuDoi.IdNhanVien
                       join SanPhamChiTiet on SanPhamChiTiet.IdSanPhamChiTiet = PhieuDoi.IdSanPhamChiTiet""";

        ArrayList<PhieuDoi> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idPhieuDoi = rs.getInt("IdPhieuDoi");
                String maPhieu = rs.getString("MaPhieu");
                String idNhanVien = rs.getString("TenNhanVien");
                int idSanPham = rs.getInt("IdSanPhamChiTiet");
                String lyDo = rs.getString("LyDoDoi");
                Date ngayDoi = rs.getDate("NgayDoi");
                int soLuong = rs.getInt("SoLuong");

                NhanVien nv = new NhanVien(idNhanVien);
                SanPhamChiTiet sp = new SanPhamChiTiet(idSanPham);

                PhieuDoi pd = new PhieuDoi(idPhieuDoi, maPhieu, sp, nv, lyDo, ngayDoi, soLuong);
                list.add(pd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static void main(String[] args) {
    }
}
