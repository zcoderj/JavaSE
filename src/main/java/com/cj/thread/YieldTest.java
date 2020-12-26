package com.cj.thread;

/**
 * @ClassName YieldTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 13:33
 * @Version 1.0
 **/
public class YieldTest {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "==>" + i);
			}
		}, "yield").start();

		for (int i = 1; i <= 100; i++) {
			if (i % 10 == 0) {
				// 让步，进入就绪状态
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName() + "==>" + i);
		}
	}
}
