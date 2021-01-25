package com.cj.threadpool.threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolExecutorTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 10:36
 * @Version 1.0
 **/
public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
//		testNewCachedThreadPool();
		testNewFixedThreadPool();
//		testNewSingleThreadExecutor();
	}

	public static void testNewCachedThreadPool() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					// 加与不加效果不一
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + " is running!");
				}
			});
		}
		executorService.shutdown();
	}

	public static void testNewFixedThreadPool() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " is running!");
			});
		}
		executorService.shutdown();
	}

	public static void testNewSingleThreadExecutor() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " is running!");
			});
		}
		executorService.shutdown();
	}
}
