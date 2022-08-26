package com.tiktok.pojo;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.sql.Date;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 13:07
 * @Discriptioon
 */
public class UserInformation {

    private String userName;

    private Integer userAge;

    private String userGender;

    private String userHome;

    private String userSchool;

    private String userPhone;

    private String  userIntroduction;

    private Date userBirthday;

    private Integer userId;

    public UserInformation() {
    }

    public UserInformation(String userName, Integer userAge, String userGender, String userHome, String userSchool, String userPhone, String userIntroduction, Date userBirthday, Integer userId) {
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userHome = userHome;
        this.userSchool = userSchool;
        this.userPhone = userPhone;
        this.userIntroduction = userIntroduction;
        this.userBirthday = userBirthday;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userGender='" + userGender + '\'' +
                ", userHome='" + userHome + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", userBirthday=" + userBirthday +
                ", userId=" + userId +
                '}';
    }
}
