package com.lezhi.entity;

import java.util.Date;

public class User {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String userPassword;

    /**
     * 
     */
    private Integer userType;

    /**
     * 
     */
    private Date gmtCreate;

    /**
     * 
     */
    private Date gmtModified;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return user_password 
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 
     * @param userPassword 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 
     * @return user_type 
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType 
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 
     * @return gmt_create 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 
     * @param gmtCreate 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 
     * @return gmt_modified 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 
     * @param gmtModified 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}