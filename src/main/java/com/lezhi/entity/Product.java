package com.lezhi.entity;

import java.util.Date;

public class Product {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer productType;

    /**
     * 
     */
    private String productName;

    /**
     * 
     */
    private String productTitle;

    /**
     * 
     */
    private String productPic;

    /**
     * 
     */
    private String productPic1;

    /**
     * 
     */
    private String productPic2;

    /**
     * 
     */
    private String productPic3;

    /**
     * 
     */
    private String productPic4;

    /**
     * 
     */
    private String productDetail;

    /**
     * 
     */
    private String isDeleted;

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
     * @return product_type 
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType 
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return product_name 
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 
     * @param productName 
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 
     * @return product_title 
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * 
     * @param productTitle 
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    /**
     * 
     * @return product_pic 
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * 
     * @param productPic 
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic == null ? null : productPic.trim();
    }

    /**
     * 
     * @return product_pic1 
     */
    public String getProductPic1() {
        return productPic1;
    }

    /**
     * 
     * @param productPic1 
     */
    public void setProductPic1(String productPic1) {
        this.productPic1 = productPic1 == null ? null : productPic1.trim();
    }

    /**
     * 
     * @return product_pic2 
     */
    public String getProductPic2() {
        return productPic2;
    }

    /**
     * 
     * @param productPic2 
     */
    public void setProductPic2(String productPic2) {
        this.productPic2 = productPic2 == null ? null : productPic2.trim();
    }

    /**
     * 
     * @return product_pic3 
     */
    public String getProductPic3() {
        return productPic3;
    }

    /**
     * 
     * @param productPic3 
     */
    public void setProductPic3(String productPic3) {
        this.productPic3 = productPic3 == null ? null : productPic3.trim();
    }

    /**
     * 
     * @return product_pic4 
     */
    public String getProductPic4() {
        return productPic4;
    }

    /**
     * 
     * @param productPic4 
     */
    public void setProductPic4(String productPic4) {
        this.productPic4 = productPic4 == null ? null : productPic4.trim();
    }

    /**
     * 
     * @return product_detail 
     */
    public String getProductDetail() {
        return productDetail;
    }

    /**
     * 
     * @param productDetail 
     */
    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail == null ? null : productDetail.trim();
    }

    /**
     * 
     * @return is_deleted 
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 
     * @param isDeleted 
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
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