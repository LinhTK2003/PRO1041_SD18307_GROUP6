/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan_1.service;

import duan_1.entity.ChatLieu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ChatLieuService {
    public ArrayList<ChatLieu> getAllChatLieu();
    
    public void insertChatLieu(ChatLieu cl);

    public void updateChatLieu(int id, ChatLieu cl);

    public void deleteChatLieu(int id);
    
    public List<ChatLieu> searchChatLieu(String searchCode);
}
