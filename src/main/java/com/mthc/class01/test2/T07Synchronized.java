package com.mthc.class01.test2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T07Synchronized
 * @Description TODO 程序在执行过程中，若出现异常，默认情况下锁会被释放
 *                   所以，在处理并发的过程中，必须多注意异常的处理，否则可能发生不一致的情况
 *                   比如，在一个Web app处理过程中，多个Servlet线程共同访问一个资源，此时若异常处理不当
 *                   比如在第一个线程中抛出异常，其他线程就会进入同步代码区，就可能访问到异常发生时的数据。
 *                   因此，要非常小心的处理同步业务逻辑中的异常
 * @Author CJ
 * @Date 2020/11/17 017 22:25
 * @Version 1.0
 **/
public class T07Synchronized {
	private int count;

	public synchronized void m() {
		System.out.println(Thread.currentThread().getName() + " start...");
		while (true) {
			count++;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (count == 5) {
				int i = 1 / 0;
			}
		}
	}

	public static void main(String[] args) {
		T07Synchronized t = new T07Synchronized();
		new Thread(t::m, "A").start();
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(t::m, "B").start();
	}
}
