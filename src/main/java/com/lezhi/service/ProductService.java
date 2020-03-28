package com.lezhi.service;

import java.util.List;

import com.lezhi.dto.ProductDto;
import com.lezhi.entity.Product;

public interface ProductService {

	Integer countProduct(ProductDto productDto);
	
	List<Product> listProduct(ProductDto productDto);
	
	Product productDetail(ProductDto productDto);
	
	Integer insertProduct(ProductDto productDto);
	
	Integer updateProduct(ProductDto productDto);
	
	Integer deleteProduct(ProductDto productDto);
}
