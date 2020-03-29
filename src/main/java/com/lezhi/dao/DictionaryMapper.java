package com.lezhi.dao;

import com.lezhi.entity.Dictionary;

public interface DictionaryMapper {
    /**
     *
     * @mbg.generated 2020-03-29
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-29
     */
    int insert(Dictionary record);

    /**
     *
     * @mbg.generated 2020-03-29
     */
    int insertSelective(Dictionary record);

    /**
     *
     * @mbg.generated 2020-03-29
     */
    Dictionary selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-29
     */
    int updateByPrimaryKeySelective(Dictionary record);

    /**
     *
     * @mbg.generated 2020-03-29
     */
    int updateByPrimaryKey(Dictionary record);
    
    Dictionary selectByItemKey(Dictionary dictionary);
    
    int updateByItemKey(Dictionary dictionary);
}