package com.tiktok.pojo;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 13:07
 * @Discriptioon
 */
public class User {

    private Integer userId;

    private String userEmail;

    private String userPassword;

    private UserInformation userInformation;

    public User() {
    }

    public User(Integer userId, String userEmail, String userPassword, UserInformation userInformation) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userInformation = userInformation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userInformation=" + userInformation +
                '}';
    }
}
