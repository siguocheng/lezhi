package com.lezhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezhi.dao.TestDao;
import com.lezhi.service.AlarmService;

@Service
public class AlarmServiceImpl implements AlarmService {

	@Autowired
	TestDao testDao;
	
	@Override
	public String test() {

		return testDao.test();
	}

}
