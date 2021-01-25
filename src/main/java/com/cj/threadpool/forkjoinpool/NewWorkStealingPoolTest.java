package com.cj.threadpool.forkjoinpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName NewWorkStealingPoolTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 14:18
 * @Version 1.0
 **/
public class NewWorkStealingPoolTest {
	public static void main(String[] args) {
		testNewWorkStealingPool();
		while (true) {

		}
	}

	public static void testNewWorkStealingPool() {
		ExecutorService executorService = Executors.newWorkStealingPool();

		for (int i = 0; i < 10; i++) {
			final int count = i;
			executorService.submit(() -> {
				System.out.println("线程：" + Thread.currentThread().getName() +
						"，完成任务：" + count + "，时间为：" + System.currentTimeMillis());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
