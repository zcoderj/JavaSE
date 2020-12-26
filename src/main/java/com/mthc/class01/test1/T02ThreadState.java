package com.mthc.class01.test1;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T02ThreadState
 * @Description TODO
 * @Author CJ
 * @Date 2020/11/17 017 19:49
 * @Version 1.0
 **/
public class T02ThreadState {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		// NEW
		System.out.println(thread.getState());

		thread.start();

		// RUNNABLE
		System.out.println(thread.getState());

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// TERMINATED
		System.out.println(thread.getState());
	}
}
