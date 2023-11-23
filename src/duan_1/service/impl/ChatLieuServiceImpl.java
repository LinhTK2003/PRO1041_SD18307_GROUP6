/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.service.impl;

import duan_1.entity.ChatLieu;
import duan_1.service.ChatLieuService;
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
public class ChatLieuServiceImpl implements ChatLieuService {

    private static Connection conn = Utilities.getConnection();

    @Override
    public ArrayList<ChatLieu> getAllChatLieu() {
        String sql = "SELECT [IdChatLieu]\n"
                + "      ,[TenChatLieu]\n"
                + "  FROM [dbo].[ChatLieu]";
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int idChatLieu = rs.getInt(1);
                String tenChatLieu = rs.getString(2);
                ChatLieu cl = new ChatLieu(idChatLieu, tenChatLieu);
                list.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertChatLieu(ChatLieu cl) {
        String sql = "INSERT INTO [dbo].[ChatLieu]\n"
                + "           ([TenChatLieu])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cl.getTenChatLieu());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateChatLieu(int id, ChatLieu cl) {
        String sql = "UPDATE [dbo].[ChatLieu]\n"
                + "   SET [TenChatLieu] = ?\n"
                + " WHERE IdChatLieu = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cl.getTenChatLieu());
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteChatLieu(int id) {
        String sql = "DELETE FROM [dbo].[ChatLieu]\n"
                + "      WHERE IdChatLieu = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ChatLieu> searchChatLieu(String searchCode) {
        String query = "SELECT [IdChatLieu]\n"
                + "      ,[TenChatLieu]\n"
                + "  FROM [dbo].[ChatLieu]\n"
                + "  where [TenChatLieu] = ?";
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, searchCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idChatLieu = rs.getInt("IdChatLieu");
                String tenChatLieu = rs.getString("TenChatLieu");
                ChatLieu cl = new ChatLieu(idChatLieu, tenChatLieu);
                list.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
