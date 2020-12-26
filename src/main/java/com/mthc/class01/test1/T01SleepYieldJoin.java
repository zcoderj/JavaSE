package com.mthc.class01.test1;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01SleepYieldJoin
 * @Description TODO
 * @Author CJ
 * @Date 2020/11/17 017 19:30
 * @Version 1.0
 **/
public class T01SleepYieldJoin {

	public static void main(String[] args) {
//		testSleep();
//		testYield();
		testJoin();
	}

	public static void testSleep() {
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("sleep " + i);
				try {
					Thread.sleep(500);
//					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public static void testYield() {
		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				System.out.println("A" + i);
				if (i % 10 == 0) {
					Thread.yield();
				}
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				System.out.println("B" + i);
				if (i % 10 == 0) {
					Thread.yield();
				}
			}
		}).start();
	}

	public static void testJoin() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("A" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {

			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < 10; i++) {
				System.out.println("B" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t2.start();
		t1.start();
	}
}
