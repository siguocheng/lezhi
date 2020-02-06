/*
 * Copyright (C), 2018-2018, 杭州物源科技有限公司
 * FileName: AlarmController
 * Author:   Charlie
 * Date:     2018/11/8 12:05
 * Description:
 */
package com.lezhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lezhi.service.AlarmService;


@RestController
public class AlarmController {
	@Autowired
	private AlarmService alarmService;

	@PostMapping(value="test")
	public String test (@RequestBody String params) {
		return alarmService.test();
	}

}
