package com.cj.threadpool.schedulethreadpooexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ScheduledThreadPoolExecutor
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 13:07
 * @Version 1.0
 **/
public class ScheduledThreadPoolExecutor {
	public static void main(String[] args) {
//		testNewScheduledThreadPool1();
//		testNewScheduledThreadPool2();
//		testNewScheduledThreadPool3();
//		testNewSingleScheduledThreadPool();
	}

	public static void testNewScheduledThreadPool1() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 5; i++) {
			scheduledExecutorService.schedule(()->{
				System.out.println(System.currentTimeMillis() + " >延迟三秒执行 " + Thread.currentThread().getName());
			}, 1, TimeUnit.SECONDS);
		}
		scheduledExecutorService.shutdown();
	}

	/**
	 * scheduleAtFixedRate(Runnable, initialDelay, period, TimeUnit)：
	 * 以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕，
	 * 若上一个任务已执行完毕，则当前任务立即执行，
	 * 若上一个任务还未执行完毕，需等到它执行完毕之后当前任务再执行。
	 */
	public static void testNewScheduledThreadPool2() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 5; i++) {
			scheduledExecutorService.scheduleAtFixedRate(()->{
				System.out.println(System.currentTimeMillis() + " >延迟三秒执行，一秒执行一次 " + Thread.currentThread().getName());
			}, 3,1, TimeUnit.SECONDS);
		}
//		scheduledExecutorService.shutdown();
	}

	/**
	 * scheduleWithFixedDelay(Runnable, initialDelay, delay, TimeUnit)：
	 * 以上一个任务结束时开始计时，delay时间过去后，立即执行
	 */
	public static void testNewScheduledThreadPool3() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 5; i++) {
			scheduledExecutorService.scheduleWithFixedDelay(()->{

				System.out.println(System.currentTimeMillis() + " >延迟三秒执行，一秒执行一次 " + Thread.currentThread().getName());
			}, 3,1, TimeUnit.SECONDS);
		}
//		scheduledExecutorService.shutdown();
	}

	public static void testNewSingleScheduledThreadPool() {
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 3; i++) {
			scheduledExecutorService.schedule(()->{
				System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + " >延迟三秒执行");
			}, 3, TimeUnit.SECONDS);
		}
		scheduledExecutorService.shutdown();
	}
}
