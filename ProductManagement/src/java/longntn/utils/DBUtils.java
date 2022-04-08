/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils {
    public static Connection getConnection(){
    Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ASS_ProductManagement";
            conn = DriverManager.getConnection(url,"sa","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return conn;
    
}
}
