/**
 * 名称: ThreadPool.java
 * 描述: 
 * @author shengling.guan
 * date: 2018年9月13日 下午12:07:59
 */
package com.lezhi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @ClassName: ThreadPool
 * @Description: TODO
 * @author: shengling.guan
 * date: 2018年9月13日 下午12:07:59
 */
public class ThreadPoolUtil {
	
	private ThreadFactory namedThreadFactory;
	private ExecutorService pool;
	
	public void init() {
		namedThreadFactory = new ThreadFactoryBuilder()
		        .setNameFormat("demo-pool-%d").build();
		pool = new ThreadPoolExecutor(5, 200,
		        0L, TimeUnit.MILLISECONDS,
		        new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
	}
	
	public ExecutorService getThread(){
		return pool;
	}
	
	public void shutdown() {
		this.pool.shutdown();
	}
}
