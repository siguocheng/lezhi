package com.lezhi.entity;

import java.util.Date;

public class Picture {
    /**
     * null
     */
    private Integer id;

    /**
     * null
     */
    private String name;

    /**
     * null
     */
    private String url;

    /**
     * null
     */
    private Integer type;

    /**
     * null
     */
    private Date gmtCreate;

    /**
     * null
     */
    private String gmtModified;

    /**
     * null
     * @return id null
     */
    public Integer getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * null
     * @return name null
     */
    public String getName() {
        return name;
    }

    /**
     * null
     * @param name null
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * null
     * @return url null
     */
    public String getUrl() {
        return url;
    }

    /**
     * null
     * @param url null
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * null
     * @return type null
     */
    public Integer getType() {
        return type;
    }

    /**
     * null
     * @param type null
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * null
     * @return gmt_create null
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * null
     * @param gmtCreate null
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * null
     * @return gmt_modified null
     */
    public String getGmtModified() {
        return gmtModified;
    }

    /**
     * null
     * @param gmtModified null
     */
    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified == null ? null : gmtModified.trim();
    }
}