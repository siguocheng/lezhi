package com.lezhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.lezhi.dto.ProductDto;
import com.lezhi.entity.Product;
import com.lezhi.entity.ResultBean;
import com.lezhi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/listProduct")
	public ResultBean<List<Product>> listProduct(@RequestBody String params) {
		ProductDto productDto = JSONObject.parseObject(params, ProductDto.class);

		Integer count = productService.countProduct(productDto);
		List<Product> list = null;
		if (count > 0) {
			list = productService.listProduct(productDto);
		}
		return new ResultBean<>(list, count);
	}

	@PostMapping("/productDetail")
	public ResultBean<Product> productDetail(@RequestBody String params) {
		ProductDto productDto = JSONObject.parseObject(params, ProductDto.class);

		Product product = productService.productDetail(productDto);

		return new ResultBean<>(product);
	}
	
	@PostMapping("/insertProduct")
	public ResultBean<Integer> insertProduct(@RequestBody String params) {
		System.out.print("insert:" + params);
		ProductDto productDto = JSONObject.parseObject(params, ProductDto.class);
		return new ResultBean<>(productService.insertProduct(productDto));
	}

	@PostMapping("/updateProduct")
	public ResultBean<Integer> updateProduct(@RequestBody String params) {
		System.out.print("updateProduct:" + params);
		ProductDto productDto = JSONObject.parseObject(params, ProductDto.class);
		return new ResultBean<>(productService.updateProduct(productDto));
	}

	@PostMapping("/deleteProduct")
	public ResultBean<Integer> deleteProduct(@RequestBody String params) {
		ProductDto productDto = JSONObject.parseObject(params, ProductDto.class);
		return new ResultBean<>(productService.deleteProduct(productDto));
	}
}
