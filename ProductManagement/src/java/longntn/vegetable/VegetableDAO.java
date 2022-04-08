/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.vegetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import longntn.users.UserDTO;

import longntn.utils.DBUtils;

public class VegetableDAO {

    public List<VegetableDTO> getListVegetable(String search) throws SQLException {
        List<VegetableDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT vegetableID, vegetableName, price, quantity, Status, Image, categoryID "
                        + "FROM tblVegetable "
                        + "WHERE vegetableName LIKE ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String vegetableID = rs.getString("vegetableID");
                    String vegetableName = rs.getString("vegetableName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    String categoryID = rs.getString("categoryID");
                    VegetableDTO veget = new VegetableDTO(vegetableID, vegetableName, status, image, categoryID, quantity, price);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(veget);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<VegetableDTO> getListVegetableUser() throws SQLException {
        List<VegetableDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT vegetableID, vegetableName, price, quantity, Status, Image, categoryID "
                        + "FROM tblVegetable "
                        + "WHERE Status='Active' and quantity>0";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String vegetableID = rs.getString("vegetableID");
                    String vegetableName = rs.getString("vegetableName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    String categoryID = rs.getString("categoryID");
                    VegetableDTO veget = new VegetableDTO(vegetableID, vegetableName, status, image, categoryID, quantity, price);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(veget);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean deleteVegetable(String vegID) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBUtils().getConnection();
            if (conn != null) {
                String sql = "UPDATE tblVegetable set status=? "
                        + "WHERE vegetableID=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "InActive");
                ps.setString(2, vegID);
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<VegetableDTO> getAllVegetable() throws SQLException {
        List<VegetableDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT vegetableID, vegetableName, price, quantity, Status, Image, categoryID "
                        + "FROM tblVegetable ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String vegetableID = rs.getString("vegetableID");
                    String vegetableName = rs.getString("vegetableName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    String categoryID = rs.getString("categoryID");
                    VegetableDTO veg = new VegetableDTO(vegetableID, vegetableName, status, image, categoryID, quantity, price);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(veg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<VegetableDTO> getVegetableByCateID(String cateID) throws Exception {

        List<VegetableDTO> result = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT vegetableID, vegetableName, price, quantity, Status, Image, categoryID  "
                        + "FROM tblVegetable "
                        + "WHERE categoryID=?";

                ps = conn.prepareStatement(sql);
                ps.setString(1, cateID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String vegetableID = rs.getString("vegetableID");
                    String vegetableName = rs.getString("vegetableName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    String categoryID = rs.getString("categoryID");
                    VegetableDTO veg = new VegetableDTO(vegetableID, vegetableName, status, image, categoryID, quantity, price);
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(veg);
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

    public boolean updateVegetable(VegetableDTO veg) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblVegetable set vegetableName=?,price=?,quantity=?,Status=?,Image=?,categoryID=? where vegetableID=? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, veg.getVegetableName());
                ps.setFloat(2, (float) veg.getPrice());
                ps.setInt(3, veg.getQuantity());
                ps.setString(4, veg.getStatus());
                ps.setString(5, veg.getImage());
                ps.setString(6, veg.getCategoryID());
                ps.setString(7, veg.getVegetableID());
                check = ps.executeUpdate() > 0;
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
        return check;
    }

    public boolean createVegetable(VegetableDTO veg) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblVegetable(vegetableID, vegetableName, price, quantity, Status, Image, categoryID) "
                        + "VALUES(?,?,?,?,?,?,?) ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, veg.getVegetableID());
                stm.setString(2, veg.getVegetableName());
                stm.setFloat(3, (float) veg.getPrice());
                stm.setInt(4, veg.getQuantity());
                stm.setString(5, veg.getStatus());
                stm.setString(6, veg.getImage());
                stm.setString(7, veg.getCategoryID());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public VegetableDTO getVegetableByID(String vetgetableID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        VegetableDTO result = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT vegetableID, vegetableName, price, quantity, Status, Image, categoryID FROM tblVegetable WHERE vegetableID=? ";

                ps = conn.prepareStatement(sql);
                ps.setString(1, vetgetableID);
                rs = ps.executeQuery();
                while (rs.next()) {

                    String vegetableID = rs.getString("vegetableID");
                    String vegetableName = rs.getString("vegetableName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String status = rs.getString("Status");
                    String image = rs.getString("Image");
                    String categoryID = rs.getString("categoryID");
                    result = new VegetableDTO(vegetableID, vegetableName, status, image, categoryID, quantity, price);
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

    public int getQuantityByID(String productID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int quantity = 0;
        String sql = "SELECT quantity FROM tblVegetable WHERE vegetableID=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
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
        return quantity;
    }

    public boolean updateQuantity(String vegetableID, int quantity) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblVegetable SET quantity=? WHERE vegetableID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, quantity);
                ps.setString(2, vegetableID);
                check = ps.executeUpdate() > 0;
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
        return check;
    }

}
