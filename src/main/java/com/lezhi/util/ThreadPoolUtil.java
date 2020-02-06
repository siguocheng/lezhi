package com.lezhi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

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
