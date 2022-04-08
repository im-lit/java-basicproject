/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.vegetable;

/**
 *
 * @author DELL
 */
public class VegetableDTO {
    private String vegetableID;
    private String vegetableName;
    private String status;
    private String image;
    private String categoryID;
    private int quantity;
    private float price;

    public VegetableDTO() {
    }

    public VegetableDTO(String vegetableID, String vegetableName, String status, String image, String categoryID, int quantity, float price) {
        this.vegetableID = vegetableID;
        this.vegetableName = vegetableName;
        this.status = status;
        this.image = image;
        this.categoryID = categoryID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getVegetableID() {
        return vegetableID;
    }

    public void setVegetableID(String vegetableID) {
        this.vegetableID = vegetableID;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
}
