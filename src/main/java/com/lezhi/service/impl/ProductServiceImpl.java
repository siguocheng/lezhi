package com.lezhi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezhi.dao.ProductMapper;
import com.lezhi.dto.ProductDto;
import com.lezhi.entity.Product;
import com.lezhi.service.ProductService;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductMapper productMapper;

	@Override
	public Integer countProduct(ProductDto productDto) {

		return productMapper.countProduct(productDto);
	}

	@Override
	public List<Product> listProduct(ProductDto productDto) {

		if (productDto.getPageNum() != null && productDto.getPageSize() != null) {
			productDto.setStartRow((productDto.getPageNum() - 1) * productDto.getPageSize());
		}
		
		return productMapper.listProduct(productDto);
	}

	@Override
	public Integer insertProduct(ProductDto productDto) {
		Product product=  new Product();
		BeanUtils.copyProperties(productDto, product);
		product.setIsDeleted(1);
		Date date =new Date();
		product.setGmtCreate(date);
		product.setGmtCreate(date);
		return productMapper.insertSelective(product);
	}

	@Override
	public Integer updateProduct(ProductDto productDto) {
		Product product=  new Product();
		BeanUtils.copyProperties(productDto, product);
		product.setGmtModified(new Date());
		return productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public Integer deleteProduct(ProductDto productDto) {
		Product product=  new Product();
		product.setId(productDto.getId());
		product.setIsDeleted(0);

		return productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public Product productDetail(ProductDto productDto) {

		return productMapper.selectByPrimaryKey(productDto.getId());
	}
}
