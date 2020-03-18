package com.lezhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.lezhi.dto.UserDto;
import com.lezhi.entity.ResultBean;
import com.lezhi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@PostMapping("/login")
	public ResultBean<Integer> login(@RequestBody String params){
		UserDto userDto = JSONObject.parseObject(params, UserDto.class);
		 return new ResultBean<>(UserService.login(userDto));
	}
}
