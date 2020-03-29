package com.lezhi.entity;

import java.util.Date;

public class Dictionary {
    /**
     * null
     */
    private Integer id;

    /**
     * null
     */
    private String itemKey;

    /**
     * null
     */
    private String itemValue;

    /**
     * null
     */
    private String itemType;

    /**
     * null
     */
    private Integer sortNum;

    /**
     * null
     */
    private Date gmtCreate;

    /**
     * null
     */
    private Date gmtModified;

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
     * @return item_key null
     */
    public String getItemKey() {
        return itemKey;
    }

    /**
     * null
     * @param itemKey null
     */
    public void setItemKey(String itemKey) {
        this.itemKey = itemKey == null ? null : itemKey.trim();
    }

    /**
     * null
     * @return item_value null
     */
    public String getItemValue() {
        return itemValue;
    }

    /**
     * null
     * @param itemValue null
     */
    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
    }

    /**
     * null
     * @return item_type null
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * null
     * @param itemType null
     */
    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    /**
     * null
     * @return sort_num null
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * null
     * @param sortNum null
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
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
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * null
     * @param gmtModified null
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}