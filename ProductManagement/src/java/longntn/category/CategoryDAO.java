/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import longntn.utils.DBUtils;

/**
 *
 * @author DELL
 */
public class CategoryDAO {

    public List<CategoryDTO> getAllCategory() throws Exception {
    Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoryDTO> result = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT categoryID,categoryName FROM tblCategory ";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new CategoryDTO(categoryID, categoryName));
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
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
