package com.lezhi.dto;

public class ProductDto {

	private String productName;
	private String productTitle;
	private Integer pageNum;
	private Integer pageSize;
	private Integer startRow;
	
	
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
	
    
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public String getProductPic1() {
		return productPic1;
	}

	public void setProductPic1(String productPic1) {
		this.productPic1 = productPic1;
	}

	public String getProductPic2() {
		return productPic2;
	}

	public void setProductPic2(String productPic2) {
		this.productPic2 = productPic2;
	}

	public String getProductPic3() {
		return productPic3;
	}

	public void setProductPic3(String productPic3) {
		this.productPic3 = productPic3;
	}

	public String getProductPic4() {
		return productPic4;
	}

	public void setProductPic4(String productPic4) {
		this.productPic4 = productPic4;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
