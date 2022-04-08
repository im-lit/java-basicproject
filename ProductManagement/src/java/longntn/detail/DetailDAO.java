/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import longntn.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class DetailDAO {

    public int insertDetail(DetailDTO dto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "insert into Details(price,quantity,OrderID,vegetableID) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setFloat(1, dto.getPrice());
                ps.setInt(2, dto.getQuantity());
                ps.setInt(3, dto.getOrderID());
                ps.setString(4, dto.getVeg().getVegetableID());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                 if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return -1;
    }
}
