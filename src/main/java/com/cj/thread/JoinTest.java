package com.cj.thread;

/**
 * @ClassName JoinTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 13:52
 * @Version 1.0
 **/
public class JoinTest {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "==>" + i);
			}
		}, "join");
		thread.start();

		for (int i = 0; i < 100; i++) {
			if (i == 50) {
				// 插队（thread插入到main前面，main被阻塞直到thread执行完成）
				thread.join();
			}
			System.out.println(Thread.currentThread().getName() + "==>" + i);
		}
	}
}
