package com.cj.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolExecutorDemo
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 17:34
 * @Version 1.0
 **/
public class ThreadPoolExecutorDemo {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(5));
		threadPoolExecutor.execute(() -> System.out.println("running..."));
		threadPoolExecutor.shutdown();
	}
}
