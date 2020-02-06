package com.lezhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lezhi.service.AlarmService;


@RestController
public class TestController {
	@Autowired
	private AlarmService alarmService;

	@PostMapping(value="test")
	public String test (@RequestBody String params) {
		return alarmService.test();
	}

}
