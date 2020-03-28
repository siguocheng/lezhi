package com.lezhi.dao;

import java.util.List;

import com.lezhi.dto.ProductDto;
import com.lezhi.entity.Product;

public interface ProductMapper {
    /**
     *
     * @mbg.generated 2020-03-20
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-20
     */
    int insert(Product record);

    /**
     *
     * @mbg.generated 2020-03-20
     */
    int insertSelective(Product record);

    /**
     *
     * @mbg.generated 2020-03-20
     */
    Product selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-20
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     *
     * @mbg.generated 2020-03-20
     */
    int updateByPrimaryKey(Product record);
    
    List<Product> listProduct(ProductDto productDto);
    
    Integer countProduct(ProductDto productDto);
}