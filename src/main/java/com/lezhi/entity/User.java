/*
* Copyright (C), 2018-2020, 杭州物源科技有限公司
* FileName: User.java
* Author:   Charlie
* Date: 2018/10/24 16:43:54
*/
package com.lezhi.entity;

import java.util.Date;

/**
 * 用户表的实体类
 * 
 * @author Charlie
 * @date 2018/10/24 16:43:54
 */
public class User {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 第三方用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 
     */
    private Integer domain;

    /**
     * 用户号码
     */
    private String userNumber;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}