package com.lezhi.dao;

import java.util.List;

import com.lezhi.dto.ProductDto;
import com.lezhi.entity.Product;

public interface ProductMapper {
    /**
     *
     * @mbg.generated 2020-03-28
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-28
     */
    int insert(Product record);

    /**
     *
     * @mbg.generated 2020-03-28
     */
    int insertSelective(Product record);

    /**
     *
     * @mbg.generated 2020-03-28
     */
    Product selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-28
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     *
     * @mbg.generated 2020-03-28
     */
    int updateByPrimaryKey(Product record);
    
    List<Product> listProduct(ProductDto productDto);
    
    Integer countProduct(ProductDto productDto);
}