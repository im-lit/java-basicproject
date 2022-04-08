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
public class VegetableErrorDTO {
    private String vegetableIDError;
    private String vegetableNameError;
    private String statusError;
    private String imageError;
    private String categoryIDError;
    private String quantityError;
    private String priceError;

    public VegetableErrorDTO() {
    }

    public VegetableErrorDTO(String vegetableIDError, String vegetableNameError, String statusError, String imageError, String categoryIDError, String quantityError, String priceError) {
        this.vegetableIDError = vegetableIDError;
        this.vegetableNameError = vegetableNameError;
        this.statusError = statusError;
        this.imageError = imageError;
        this.categoryIDError = categoryIDError;
        this.quantityError = quantityError;
        this.priceError = priceError;
    }

    public String getVegetableIDError() {
        return vegetableIDError;
    }

    public void setVegetableIDError(String vegetableIDError) {
        this.vegetableIDError = vegetableIDError;
    }

    public String getVegetableNameError() {
        return vegetableNameError;
    }

    public void setVegetableNameError(String vegetableNameError) {
        this.vegetableNameError = vegetableNameError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

  
}
