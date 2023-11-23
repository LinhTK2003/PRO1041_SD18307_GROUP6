/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.repository;

import duan_1.model.MucGiamGia;
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
public class MucGiamGiaRepository {

    public List<MucGiamGia> getAll() {
        String query = "SELECT [IdMucGiamGia]"
                + "      ,[GiaTri]"
                + "  FROM [dbo].[MucGiamGia]";
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            List<MucGiamGia> listMuc = new ArrayList<>();
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                listMuc.add(new MucGiamGia(rs.getInt(1),rs.getFloat(2)));
            }
            return listMuc;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public MucGiamGia getOne(String id) {
        String query = "SELECT [IdMucGiamGia]"
                + "      ,[GiaTri]"
                + "  FROM [dbo].[MucGiamGia] WHERE [IdMucGiamGia]=?";
        try ( Connection con = Utilities.getConnection();  PreparedStatement pr = con.prepareStatement(query);) {
            pr.setObject(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new MucGiamGia(rs.getInt(1),rs.getFloat(2));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
