package com.lezhi.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lezhi.util.ThreadPoolUtil;

@Configuration
public class DatabaseQueryThreadPool {
	@Bean
	public ThreadPoolUtil getPool() {
		ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
		threadPoolUtil.init();
		return threadPoolUtil;
	}
}
