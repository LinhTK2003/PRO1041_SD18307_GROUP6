/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan_1.utiliti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Utilities {

      private static Connection conn;
     
     
     public static Connection getConnection(){
         if (conn == null) {
             try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa" ,dbPass = "123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;"
                    +";databaseName=DuAn_1;encrypt=true;trustServerCertificate=true;";
                conn =  DriverManager
                    .getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
         
         return conn;
     }
}
