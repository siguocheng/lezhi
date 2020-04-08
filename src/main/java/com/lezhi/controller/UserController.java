package com.lezhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.lezhi.dto.UserDto;
import com.lezhi.entity.ResultBean;
import com.lezhi.entity.User;
import com.lezhi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResultBean<Integer> login(@RequestBody String params, HttpServletRequest request) {
		UserDto userDto = JSONObject.parseObject(params, UserDto.class);
		
		Integer ret = userService.login(userDto);
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setUserName(userDto.getUserName());
		session.setAttribute("user", user);
		session.setMaxInactiveInterval(3600);
		
		return new ResultBean<>(ret);
	}
}
