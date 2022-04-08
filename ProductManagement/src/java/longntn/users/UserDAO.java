/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import longntn.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, email, roleID "
                        + "FROM tblUsers "
                        + "WHERE userid =? AND password =? ";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userID);
                pstm.setString(2, password);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, email, "", roleID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

   
}
