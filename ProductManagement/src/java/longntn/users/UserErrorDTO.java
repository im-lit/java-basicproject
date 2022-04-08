/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.users;

/**
 *
 * @author DELL
 */
public class UserErrorDTO {

    private String userIDError;
    private String fullNameError;
    private String emailError;
    private String passwordError;
    private String roleIDError;
    private String addressError, phoneError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String fullNameError, String emailError, String passwordError, String roleIDError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
    }

    public UserErrorDTO(String userIDError, String fullNameError, String emailError, String passwordError, String roleIDError, String addressError, String phoneError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.addressError = addressError;
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

}
