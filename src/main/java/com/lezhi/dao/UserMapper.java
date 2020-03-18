package com.lezhi.dao;

import com.lezhi.dto.UserDto;
import com.lezhi.entity.User;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2020-03-18
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-18
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2020-03-18
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2020-03-18
     */
    User selectByPrimaryKey(Integer id);

    User selectByUserName(UserDto userDto);
    /**
     *
     * @mbg.generated 2020-03-18
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2020-03-18
     */
    int updateByPrimaryKey(User record);
}