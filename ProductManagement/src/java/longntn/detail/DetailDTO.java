/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.detail;

import longntn.vegetable.VegetableDTO;

/**
 *
 * @author DELL
 */
public class DetailDTO {

    private int detailID;
    private int orderID;
    private float price;
    private int quantity;
    private VegetableDTO veg;

    public DetailDTO() {
    }

    public DetailDTO(int detailID, int orderID, float price, int quantity, VegetableDTO veg) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.price = price;
        this.quantity = quantity;
        this.veg = veg;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public VegetableDTO getVeg() {
        return veg;
    }

    public void setVeg(VegetableDTO veg) {
        this.veg = veg;
    }

}
