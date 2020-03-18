package com.lezhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezhi.dao.UserMapper;
import com.lezhi.dto.UserDto;
import com.lezhi.entity.User;
import com.lezhi.exception.CheckException;
import com.lezhi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public Integer login(UserDto userDto) {

		User user = userMapper.selectByUserName(userDto);
		
		if (user == null) {
			throw new CheckException("用户名或者密码错误");
		}
		return user.getId();
	}
}
