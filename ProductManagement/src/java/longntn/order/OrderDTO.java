/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.order;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class OrderDTO {

    private int orderID;
    private String userID, userName, phone, address;
    private Date dateOrder;
    private float total;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String userID, String userName, String phone, String address, Date dateOrder, float total) {
        this.orderID = orderID;
        this.userID = userID;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.dateOrder = dateOrder;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
