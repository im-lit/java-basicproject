/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import longntn.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class OrderDAO {

    public int insertOrder(OrderDTO dto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "insert into Orders(DateOrder,total,userName,phone,address,userID) values(?,?,?,?,?,?)";

                ps = con.prepareStatement(sql);
                ps.setTimestamp(1, new Timestamp(dto.getDateOrder().getTime()));
                ps.setFloat(2, dto.getTotal());
                ps.setString(3, dto.getUserName());
                ps.setString(4, dto.getPhone());
                ps.setString(5, dto.getAddress());
                ps.setString(6, dto.getUserID());
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

    public int getOrderID() throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select top 1 OrderID\n"
                        + "from Orders\n"
                        + "order by OrderID desc";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("OrderID");
                }
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
