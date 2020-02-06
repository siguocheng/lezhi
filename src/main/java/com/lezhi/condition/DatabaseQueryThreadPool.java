/**
 * 名称: DatabaseQueryThreadPool.java
 * 描述: 
 * @author shengling.guan
 * date: 2018年9月13日 下午12:05:29
 */
package com.lezhi.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lezhi.util.ThreadPoolUtil;

/**
 * @ClassName: DatabaseQueryThreadPool
 * @Description: TODO
 * @author: shengling.guan 
 * date: 2018年9月13日 下午12:05:29
 */
@Configuration
public class DatabaseQueryThreadPool {
	@Bean
	public ThreadPoolUtil getPool() {
		ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
		threadPoolUtil.init();
		return threadPoolUtil;
	}
}
