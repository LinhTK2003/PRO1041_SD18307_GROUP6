package duan_1.service.impl;

import duan_1.entity.ChatLieu;
import duan_1.entity.KichThuoc;
import duan_1.entity.MauSac;
import duan_1.entity.SanPham;
import duan_1.entity.SanPhamChiTiet;
import duan_1.utiliti.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import duan_1.service.SanPhamChiTietService;
import java.util.List;

/**
 *
 * @author admin
 */
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public ArrayList<SanPhamChiTiet> getAllQLSanPhamCT() {
        String sql = "SELECT [IdSanPhamChiTiet]\n"
                + "      ,KichThuoc.TenKichThuoc\n"
                + "      ,ChatLieu.TenChatLieu\n"
                + "      ,MauSac.TenMau\n"
                + "      ,SanPham.TenSanPham\n"
                + "      ,[SoLuong]\n"
                + "      ,[GiaBan]\n"
                + "  FROM [dbo].[SanPhamChiTiet] \n"
                + "  join KichThuoc on KichThuoc.IdKichThuoc = SanPhamChiTiet.IdKichThuoc \n"
                + "  join ChatLieu on ChatLieu.IdChatLieu = SanPhamChiTiet.IdChatLieu \n"
                + "  join MauSac on MauSac.IdMauSac = SanPhamChiTiet.IdMauSac\n"
                + "  join SanPham on SanPham.MaSanPham = SanPhamChiTiet.MaSanPham order by SanPham.MaSanPham ASC, KichThuoc.TenKichThuoc ASC, GiaBan ASC";

        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPhamCT = rs.getInt("IdSanPhamChiTiet");

                String tenKichThuoc = rs.getString("TenKichThuoc");
                String tenChatLieu = rs.getString("TenChatLieu");
                String tenMauSac = rs.getString("TenMau");
                String tenSanPham = rs.getString("TenSanPham");

                KichThuoc kt = new KichThuoc(tenKichThuoc);
                ChatLieu cl = new ChatLieu(tenChatLieu);
                MauSac ms = new MauSac(tenMauSac);
                SanPham sp = new SanPham(tenSanPham);

                int soLuong = rs.getInt("SoLuong");
                float giaBan = rs.getFloat("GiaBan");

                SanPhamChiTiet spct = new SanPhamChiTiet(idSanPhamCT, kt, cl, ms, sp, soLuong, giaBan);
                list.add(spct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPhamChiTiet> getAllSanPhamCT(String maSP) {
        String sql = "SELECT [IdSanPhamChiTiet]\n"
                + "      ,KichThuoc.TenKichThuoc\n"
                + "      ,ChatLieu.TenChatLieu\n"
                + "      ,MauSac.TenMau\n"
                + "      ,SanPham.MaSanPham\n"
                + "      ,SanPham.TenSanPham\n"
                + "      ,[SoLuong]\n"
                + "      ,[GiaBan]\n"
                + "  FROM [dbo].[SanPhamChiTiet] \n"
                + "  join KichThuoc on KichThuoc.IdKichThuoc = SanPhamChiTiet.IdKichThuoc \n"
                + "  join ChatLieu on ChatLieu.IdChatLieu = SanPhamChiTiet.IdChatLieu \n"
                + "  join MauSac on MauSac.IdMauSac = SanPhamChiTiet.IdMauSac\n"
                + "  join SanPham on SanPham.MaSanPham = SanPhamChiTiet.MaSanPham where SanPhamChiTiet.MaSanPham = ? order by SanPham.MaSanPham ASC, KichThuoc.TenKichThuoc ASC, GiaBan ASC";

        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPhamCT = rs.getInt("IdSanPhamChiTiet");

                String tenKichThuoc = rs.getString("TenKichThuoc");
                String tenChatLieu = rs.getString("TenChatLieu");
                String tenMauSac = rs.getString("TenMau");
                String tenSanPham = rs.getString("TenSanPham");

                KichThuoc kt = new KichThuoc(tenKichThuoc);
                ChatLieu cl = new ChatLieu(tenChatLieu);
                MauSac ms = new MauSac(tenMauSac);
                SanPham sp = new SanPham(tenSanPham);

                String maSanPham = rs.getString("MaSanPham");
                int soLuong = rs.getInt("SoLuong");
                float giaBan = rs.getFloat("GiaBan");

                SanPhamChiTiet spct = new SanPhamChiTiet(idSanPhamCT, kt, cl, ms, sp, soLuong, giaBan);
                list.add(spct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertSanPhamCT(SanPhamChiTiet spct) {
        String query = "INSERT INTO [dbo].[SanPhamChiTiet]\n"
                + "           ([IdKichThuoc]\n"
                + "           ,[IdChatLieu]\n"
                + "           ,[IdMauSac]\n"
                + "           ,[MaSanPham]\n"
                + "           ,[SoLuong]\n"
                + "           ,[GiaBan])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?)";
        int check = 0;
        try (Connection con = Utilities.getConnection(); PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, spct.getKichThuoc().getIdKichThuoc());
            pr.setObject(2, spct.getChatLieu().getIdChatLieu());
            pr.setObject(3, spct.getMauSac().getIdMauSac());
            pr.setObject(4, spct.getSanPham().getMaSanPham());
            pr.setObject(5, spct.getSoLuong());
            pr.setObject(6, spct.getGiaBan());
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void updateSanPhamCT(int id, SanPhamChiTiet spct) {
        String sql = "UPDATE [dbo].[SanPhamChiTiet]\n"
                + "   SET [IdKichThuoc] = ?\n"
                + "      ,[IdChatLieu] = ?\n"
                + "      ,[IdMauSac] = ?\n"
                + "      ,[MaSanPham] = ?\n"
                + "      ,[SoLuong] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + " WHERE IdSanPhamChiTiet = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, spct.getKichThuoc().getIdKichThuoc());
            ps.setObject(2, spct.getChatLieu().getIdChatLieu());
            ps.setObject(3, spct.getMauSac().getIdMauSac());
            ps.setObject(4, spct.getSanPham().getMaSanPham());
            ps.setObject(5, spct.getSoLuong());
            ps.setObject(6, spct.getGiaBan());
            ps.setInt(7, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSanPhamCT(int id) {
        String sql = "DELETE FROM [dbo].[SanPhamChiTiet]\n"
                + "      WHERE IdSanPhamChiTiet = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SanPhamChiTiet> searchSanPhamChiTiet(String searchCode) {
        String query = "SELECT [IdSanPhamChiTiet]\n"
                + "      ,KichThuoc.TenKichThuoc\n"
                + "      ,ChatLieu.TenChatLieu\n"
                + "      ,MauSac.TenMau\n"
                + "      ,SanPham.MaSanPham\n"
                + "      ,SanPham.TenSanPham\n"
                + "      ,[SoLuong]\n"
                + "      ,[GiaBan]\n"
                + "  FROM [dbo].[SanPhamChiTiet] \n"
                + "     join KichThuoc on KichThuoc.IdKichThuoc = SanPhamChiTiet.IdKichThuoc \n"
                + "     join ChatLieu on ChatLieu.IdChatLieu = SanPhamChiTiet.IdChatLieu \n"
                + "     join MauSac on MauSac.IdMauSac = SanPhamChiTiet.IdMauSac\n"
                + "     join SanPham on SanPham.MaSanPham = SanPhamChiTiet.MaSanPham \n"
                + "  WHERE SanPhamChiTiet.MaSanPham = ? "
                + "                 or TenSanPham = ? "
                + "                 or MauSac.TenMau = ? "
                + "                 or ChatLieu.TenChatLieu = ? "
                + "                 or KichThuoc.TenKichThuoc = ? order by SanPham.MaSanPham ASC, KichThuoc.TenKichThuoc ASC, GiaBan ASC";
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, searchCode);
            ps.setString(2, searchCode);
            ps.setString(3, searchCode);
            ps.setString(4, searchCode);
            ps.setString(5, searchCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPhamCT = rs.getInt("IdSanPhamChiTiet");

                String tenKichThuoc = rs.getString("TenKichThuoc");
                String tenChatLieu = rs.getString("TenChatLieu");
                String tenMauSac = rs.getString("TenMau");
                String maSanPham = rs.getString("MaSanPham");
                String tenSanPham = rs.getString("TenSanPham");

                KichThuoc kt = new KichThuoc(tenKichThuoc);
                ChatLieu cl = new ChatLieu(tenChatLieu);
                MauSac ms = new MauSac(tenMauSac);
                SanPham sp = new SanPham(maSanPham, tenSanPham);

                int soLuong = rs.getInt("SoLuong");
                float giaBan = rs.getFloat("GiaBan");
                SanPhamChiTiet spct = new SanPhamChiTiet(idSanPhamCT, kt, cl, ms, sp, soLuong, giaBan);
                list.add(spct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
